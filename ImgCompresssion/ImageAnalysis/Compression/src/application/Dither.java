package application;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Dither {
	public PaletteData Dither(Image img) {
		Color[] Palette = new Color[256];//for storing the pallet
		int imgHeight = (int) img.getHeight();//get the image height & width
		int imgWidth = (int) img.getWidth();
		Color[][] pixels = new Color[imgHeight][imgWidth];//declare new 2d array for holding all the pixel values
		PixelReader pr = img.getPixelReader(); // new pixelreader that will allow us to read pixels
		
		Palette = generatePalette(img); // quantise the image using a simple quantiser
		
		for(int x = 0;x<imgWidth;x++) {//load the pixel 2d array that will hold all the pixel values with their current colours
			for(int y = 0;y<imgHeight;y++) {
				pixels[y][x] = pr.getColor(x, y);
			}
		}
		
		//declare new array for holding onto the new pixel colours which are indexes in the palette.
		int[][] palettePixel = new int[imgHeight][imgWidth];
		
		//apply floyd steinberg algorithm
		for(int x = 0;x<imgWidth;x++) {
			for(int y = 0;y<imgHeight;y++) {//for each pixel in the image, find its closest match in the palette
				Color oldPixel = pixels[y][x];
				PaletteColourPair newPixelColourandIndex = findClosestPaletteColour(Palette,oldPixel);
				palettePixel[y][x] = newPixelColourandIndex.paletteIndex; // set the value in the palette pixel array to the colours index in the palette
				Color newPixel = newPixelColourandIndex.colour;//set the colour in the current pixel array to the new colour from the palette
				//System.out.println("old vs new: "+oldPixel+" , "+newPixel);
				pixels[y][x] = newPixel;//set the pixel to the current value
				int[] error = calcError(oldPixel,newPixel);//compare the new palette pixel value to old pixel value to get the error
				if((x != 0 && x!=imgWidth-1)&&(y!=0 && y!=imgHeight-1)) {//only set other pixels if they are not on boundary (otherwise it isnt possible to spread the error around easily)
					Color c0 = pixels[y][x+1];
					Color newc0 = Color.rgb((int)(c0.getRed()*255)+(error[0]*(7/16)), (int)(c0.getGreen()*255)+(error[1]*(7/16)), (int)(c0.getBlue()*255)+(error[2]*(7/16)));
					Color c1 = pixels[y+1][x-1];
					Color newc1 = Color.rgb((int)(c1.getRed()*255)+(error[0]*(3/16)), (int)(c1.getGreen()*255)+(error[1]*(3/16)), (int)(c1.getBlue()*255)+(error[2]*(3/16)));
					Color c2 = pixels[y+1][x];
					Color newc2 = Color.rgb((int)(c2.getRed()*255)+(error[0]*(5/16)), (int)(c2.getGreen()*255)+(error[1]*(5/16)), (int)(c2.getBlue()*255)+(error[2]*(5/16)));
					Color c3 = pixels[y+1][x+1];
					Color newc3 = Color.rgb((int)(c3.getRed()*255)+(error[0]*(1/16)), (int)(c3.getGreen()*255)+(error[1]*(1/16)), (int)(c3.getBlue()*255)+(error[2]*(1/16)));
					
					//the code above spreads the error into each channel of the image in the surrounding neighbours. It passes the error most strongly to the left pixel (7/16 the error goes there)
					
					//set the new colour values
					pixels[y][x+1] = newc0;
					pixels[y+1][x-1] = newc1;
					pixels[y+1][x] = newc2;
					pixels[y+1][x+1] = newc3;
				}
				
				
			}
		}
		
		return new PaletteData(imgHeight,imgWidth,Palette.length,Palette,palettePixel);//return custom palette data type which includes data on the images height, width as well as the colours in the palette, the palette size etc
		
	}
	PaletteColourPair findClosestPaletteColour(Color[] palette,Color val) {//find the closest colour in the palette using euclidean distance by using pythagoras between each of the colours (plotting red against green against blue)
		double minDist = calcDistance(palette[0],val); 
		Color minColour = palette[0];
		int minPaletteIndex = 0;
		for(int  i = 1;i<palette.length;i++) {//go through all unique pixels
			double newDistance = calcDistance(palette[i],val);//calculate their distance
			if(newDistance<minDist) {//if it is the new closest update the variable holding the closest colour
				minDist = newDistance;
				minColour = palette[i];
				minPaletteIndex = i;
			}
		}
		
		return new PaletteColourPair(minColour,minPaletteIndex);//return the closest palette colour
	}
	int[] calcError(Color o, Color n) {//calculate the error across the three channels
		int oldRed = (int)(o.getRed() * 255);
		int oldGreen = (int)(o.getGreen() * 255);
		int oldBlue = (int)(o.getBlue() * 255);
		int newRed = (int)(n.getRed() * 255);
		int newGreen = (int)(n.getGreen() * 255);
		int newBlue = (int)(n.getBlue() * 255);
		//return the error from the three channels as three separate arrays of error
		return new int[] {oldRed-newRed,oldGreen-newGreen,oldBlue-newBlue};
	}
	
	
	double calcDistance(Color c, Color test) {//use pythagorean theorum to find the distance between the colours c and test
		double redDiff =  (c.getRed()-test.getRed());
		double greenDiff = (c.getGreen() - test.getGreen());
		double blueDiff = (c.getBlue() - test.getBlue());
		double distance =  Math.sqrt(Math.pow(redDiff, 2)+Math.pow(greenDiff, 2)+Math.pow(blueDiff, 2));
		return distance;
	}
	
	

	Color[] generatePalette(Image img) {//initialises the palette
		Color[] palette = new Color[256];//size of colour palette
		int height = (int) img.getHeight();
		int width = (int) img.getWidth();
		
		PixelReader pr = img.getPixelReader();
		
		Color[] pixels = new Color[height*width];//for storing all pixel values
		
		int addedCount = 0;
		for(int y =0;y<height;y++) {//add all the pixels to a flat array so we can easily sort them.
			for(int x = 0;x<width;x++) {
				pixels[addedCount] = pr.getColor(x, y);
				addedCount++;
			}
		}
		ArrayList<Color> uniqueColours = new ArrayList<Color>();//new arraylist for holding unique colour values

		
		for(int i = 0;i<pixels.length;i++) {//for each pixel see if the colour is new
			if(uniqueColours.contains(pixels[i])==false) {//if we havent seen the colour before add it to the uniqueColours arraylist
				uniqueColours.add(pixels[i]);
			}
		}
		System.out.println("Starting kmeans");

		if(uniqueColours.size()>256) {//if there are more than 256 colours
			Color[] colours = KmeansCluster(uniqueColours);//apply kmeans clustering to whole image
			for(int  i =0;i<256;i++) {
				palette[i] = colours[i];
			}
			return palette;
		}
		else if(uniqueColours.size()<256 && uniqueColours.size()>127) {//if there are less than 256 but more than 127 colours we reduce to 128 colour palette
			palette = new Color[128];
			for(int i = 0;i<128;i++) {
				palette[i] = uniqueColours.get(i*(uniqueColours.size()/128));
			}
			
		}
		else  {//(ColourSize<128 && ColourSize>64)
			palette = new Color[64];
			for(int i = 0;i<64;i++) {
				palette[i] = uniqueColours.get(i);
			}
			
		}
		return palette;
	}

    Color[] KmeansCluster(ArrayList<Color> uniqueColours) {
		int colourCount = uniqueColours.size();//number of unique colours
		Color[] centroids = new Color[256];
		for(int i = 0;i<256;i++) {//initialise the centroids to evenly spreadout pixels across input stream
			Color c = uniqueColours.get(i*(colourCount/256));
			centroids[i] = c;
		}
		ArrayList<ArrayList<Color>> centroidClusters = new ArrayList<>();//2d arraylist for holding colours assigned to each cluster
        for (int i = 0; i < 256; i++) {//initialise each sub array within cluster arraylist
        	centroidClusters.add(new ArrayList<>());
        }
		for(int iteration = 0;iteration<100;iteration++) {//iterate the kmeans algorithm
			for(int i = 0;i<colourCount;i++) {//for each colour find the nearest centroid
				double minDist = calcDistance(uniqueColours.get(i),centroids[0]);//initialise with the distance to the first centroid
				int minClass = 0;//initialise class designation to 0 (first centroid class)
				for(int centroidCounter = 1;centroidCounter<256;centroidCounter++) { //go through and find the closest centroid
					double dist = calcDistance(uniqueColours.get(i),centroids[centroidCounter]);
					if(dist<minDist) {//if this centroid has a lower distance make it the new minDist/class
						minDist = dist;
						minClass = centroidCounter;
					}
				}
				centroidClusters.get(minClass).add(uniqueColours.get(i));//add the unique colour to its respective centroid cluster arraylist
			}
			for(int i = 0;i<centroidClusters.size();i++) {//for every cluster
				centroids[i] = getMeanColour(centroidClusters.get(i));//calculate the mean colour of that centroid
			}	
		}
		return centroids;
		
	}
    
    Color getMeanColour(ArrayList<Color> colours) {
    	double r = 0;
    	double b = 0;
    	double g = 0;
    	for(int i = 0;i<colours.size();i++) {//add all the red green and blue components together
    		r+=colours.get(i).getRed();
    		g+=colours.get(i).getGreen();
    		b+=colours.get(i).getBlue();
    	}
    	//divide them by the number of colours to get average
    	 r /= colours.size();
         g /= colours.size();
         b /= colours.size();
         return Color.color(r, g, b);
    }
}


