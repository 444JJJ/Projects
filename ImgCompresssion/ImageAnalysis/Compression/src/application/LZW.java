package application;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LZW {
	public void compress(PaletteData pD, String location ) throws IOException {
		//ArrayList<String> Dictionary = new ArrayList<String>();
		int maxDictionarySize = 4096;
		String[] Dictionary = new String[4096];
		int DictionarySize = 0;
		String hexVals = "0123456789abcdef";
		for(int i = 0;i<hexVals.length();i++) {//preload dictionary with all possible hex values
			Dictionary[i] = Character.toString(hexVals.charAt(i)); //stores the relevant hex value from the string
			DictionarySize++;
		}
		
		int imgHeight = pD.imgHeight;
		int imgWidth = pD.imgWidth;
		
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		String s = "";//new int[height*width*3];
		
		s = Img2Str(pD.pixelData,imgHeight,imgWidth);
		System.out.println("Now starting process!");
		

		
		
		int stringLength = s.length();
		for(int index = 0;index<stringLength;index++) {//for each character in the image to hex string
			System.out.println("Encoding index: "+index);
			String val =Character.toString(s.charAt(index));//get the character at the next index
			String runningVal = val;//set the runningVal to contain just the current character
			if(ArrayContains(Dictionary,(runningVal),DictionarySize) >= 0) {//does the Dictionary contain this char
				for(int i = index+1;i<stringLength;i++) {//for each remaining character in the image string
//does the dictionary contain the runningVal+ next character in the image string
					if(ArrayContains(Dictionary,(runningVal+s.charAt(i)),DictionarySize) == -1) {//Doesn't contain
						if(DictionarySize<maxDictionarySize) {//if we haven't reached max dictionary size
							Dictionary[DictionarySize] = runningVal+s.charAt(i);//add the runningVal+next char to dictionary
							DictionarySize++;//increment the variable holding the size of the dictionary
							output.add(ArrayContains(Dictionary,(runningVal),DictionarySize));//add the runningVal (without next char)'s index in dictionary to output
							index+=runningVal.length()-1;//increment index of main loop by the size of the match -1 as we are on the first character anyway
							runningVal = "";//reset runningVal just in case
							break;//break out of this for loop
						}
						else {// the dictionary is full so don't add it, still output it, increment index & reset runningVal
							output.add(ArrayContains(Dictionary,(runningVal),DictionarySize));
							index+=runningVal.length()-1;
							runningVal = "";
							break;//break out of this for loop back to the main one
						}
					}
					else {// the runningVal+next character is already in the dictionary, just add it to running val
						runningVal+=s.charAt(i);//add the 
					}
				}
				if(runningVal.length()>0) {//if we reach the end and still haven't found a sequence not in the dictionary
					output.add(ArrayContains(Dictionary,(runningVal),DictionarySize));//add its dictionary index to output anyway
					index+=runningVal.length()-1;//increment index by its length
				}
			}
			else {//here just in case we encounter anything strange that isn't in the initialise dictionary
				output.add(ArrayContains(Dictionary,(val),DictionarySize));
			}
		}

		System.out.println("Encoding: "+output.size()+" original size: "+s.length());
		writeToFile(output,pD,location);
	}
	private void writeToFile(ArrayList<Integer> arr,PaletteData pd,String location) {
		String filename = location;//+".bin";
	    try {
	    	DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(location)));
	      dos.writeInt(pd.imgHeight);
	      dos.writeInt(pd.imgWidth);
	      dos.writeInt((int)(Math.round(arr.size()*1.5)));
	      dos.writeInt(pd.paletteSize);
	      System.out.println("Writing: "+pd.imgHeight+" , "+pd.imgWidth);
	      for(int i = 0;i<pd.paletteSize;i++) {
	    	  dos.writeByte((((int)(pd.palette[i].getRed()*255)))& 0xFF);
	    	  dos.writeByte((((int)(pd.palette[i].getGreen()*255)))& 0xFF);
	    	  dos.writeByte((((int)(pd.palette[i].getBlue()*255)))& 0xFF);
	      }
	      for(int i = 0;i<arr.size()-(arr.size()%2);i+=2) {//for the even set of them
	    	  byte a = (byte) (arr.get(i) >> 4);//encode the last 8 bits of i into a byte
	    	  byte b = (byte) (((arr.get(i) & 0x0f) << 4) | (arr.get(i+1) >> 8));//combine the first 4 bits of i with the last 4 bits of i+1
    		  byte c = (byte) (arr.get(i+1) & 0xff);//store the first 8 bits of i+1 by applying 8 bit mask

    		  dos.writeByte(a);
    		  dos.writeByte(b);
    		  dos.writeByte(c);
	      }
	      if(arr.size()%2 == 1) {
	    	  int lastInt = arr.get(arr.size()-1);
	    	  dos.writeInt(lastInt);
	      }

	      System.out.println("Wrote "+(int)(Math.round(arr.size()*1.5))+" values");
	      dos.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	private LZWFileData readFromFile(String location){
		 String filename = location;

		    ArrayList<Integer> arr = new ArrayList<Integer>();
		   //read from the file in the same way that we wrote the file (in the same order)
		    int height = 0;
		    int width = 0;
		    int dataCount = 0;
		    int paletteSize = 0;
		    Color[] palette = new Color[0];
		    try {
		    	DataInputStream dos = new DataInputStream(new BufferedInputStream(new FileInputStream(location)));
		      height = dos.readInt();
		      width = dos.readInt();
		      dataCount = dos.readInt();
		      paletteSize = dos.readInt();
		      palette = new Color[paletteSize];
		      System.out.println("Decoded: "+height+","+width);
		      for(int i =0;i<paletteSize;i++) {//read the RGB values for the colours in the palette
		    	  int red = (dos.readByte())& 0xFF;
		    	  int green = (dos.readByte())& 0xFF;
		    	  int blue = (dos.readByte())& 0xFF;
		    	  palette[i] = Color.rgb(red, green, blue);
		      }
		      for (int i = 0; i < dataCount - (dataCount%3); i+=3) {
		        byte a = dos.readByte();
		        byte b = dos.readByte();
		        byte c = dos.readByte();
		        
		        int m1 = ((a & 0xff) << 4) | ((b & 0xff) >> 4);//shift the last 8 bits over 4, shift the first 4 bits back to being in the right place, combine
		        int m2 = ((b & 0x0f) << 8) | (c & 0xff);//shift  last 4 bits of the second int over 8, combine with the first 8 bits

		        
		        arr.add(m1);
		        arr.add(m2);
		        
		      }
		      if(dataCount%3 != 0) {
		    	  int remaining = dos.readInt();
		    	  arr.add(remaining);
		      }
		      dos.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		    System.out.println("read "+dataCount+" values. got: "+arr.size());
		    return new LZWFileData(height,width,palette,arr);
	}
	

	public WritableImage decompress(String loc) {
		
		LZWFileData lzwData = readFromFile(loc);
		int maxDictionarySize = 4096;
		System.out.println("DECODING");
		
		ArrayList<Integer> Data = lzwData.rawData;
		
		String hexVals = "0123456789abcdef";
		ArrayList<String> Dictionary = new ArrayList<String>();
		for(int i = 0;i<hexVals.length();i++) {//preload dictionary with all possible values
			Dictionary.add(Character.toString(hexVals.charAt(i)));
		}
		
		String Output = "";
		for(int index = 0;index<Data.size();index++) {//for each element in the data array
			String currentRun = ""+Dictionary.get(Data.get(index));//preload currentRun with the value of the current data dictionary index
			for(int  i = index;i<Data.size()-1;i++) {//for each remaining data value in the array after the "index" index
				if(!Dictionary.contains(currentRun)) {//if the dictionary doesnt contain the currentRun
					if(Dictionary.size() <maxDictionarySize) {//if dictionary hasnt reached max capacity
						Dictionary.add(currentRun);//add the run to the dictionary
						i = Data.size();
						currentRun = "";
						break;//break out of the for loop, we will next iterate "index"
					}
					else {//otherwise break (not likely to ever be called)
						i = Data.size();
						currentRun = "";
						break;
					}
				}
				else {// the dicitionary already contains the currentRun string
					if((Dictionary.size()-1)<Data.get(i+1)) {//if the next data index is requesting a dictionary index that is outside the dictionary range
						Output+= currentRun;//add the current run to the output string
						if(Dictionary.size() <maxDictionarySize) {//if the dictionary isn't full
							Dictionary.add(currentRun+currentRun.charAt(0));//add the currentRun+its first character to the dictionary
							i = Data.size();
							currentRun = "";
							break;//break out back to the original for loop, move onto the next index in the data array
						}
						else {//in theory shouldnt be called because the indexes cannot reference an index outside the dictionary they were compressed with
							i = Data.size();
							currentRun = "";
							break;
						}
						
					}
					else {//the currentRun is already within the dictionary and the next index is also refering to an already existing index
						Output+=Dictionary.get(Data.get(i));//add the current dictionary value
						currentRun +=(Dictionary.get(Data.get(i+1)).charAt(0));//add the next string from the dictionaries first character to the current run
					}
				}
			}
			if(index == Data.size()-1) {//when on last index just output the last index from the directory (it may not trigger anything above)
				Output+=Dictionary.get(Data.get(Data.size()-1));//update output
			}
		}
		
		System.out.println("Decoded: "+Output);
	//	System.out.println("Decoded Dictionary: "+Dictionary);
		System.out.println("Dictionary length: "+(Dictionary.size()-128));
		System.out.println("Data length: "+Data.size());
		System.out.println("Text length: "+Output.length());
		return string2img(Output,lzwData);
	}
	
	
	
	private int ArrayContains(String[] arr, String val,int arrSize) {;
		for(int i = 0;i<arrSize;i++) {
			if(arr[i].equals(val)) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	private String Img2Str(int[][] arr,int imgHeight,int imgWidth) {//could change to do row by row for saftey
		String asHex = "";
		for(int y = 0;y<imgHeight;y++) {
			for(int x = 0;x<imgWidth;x++) {//for each pixel in the 2d array
				int val = arr[y][x];//extract the integer value (the index in the colour palette)
				String ValasHex= Integer.toHexString(val);//convert this integer to hex
				if(ValasHex.length()<2) {//if the value is <16 it will only output 1 hex digit
					ValasHex = "0"+ValasHex;//so we add a 0 in case to standardise all to 2 hex values
				}
				asHex+=ValasHex;//add hex values to string holding all hex
			}
		}
		return asHex;
	}
	private WritableImage string2img(String s,LZWFileData data) {
		
		int imgHeight = data.imgHeight;
		int imgWidth = data.imgWidth;
		
		WritableImage Outimg = new WritableImage(imgWidth,imgHeight);
		PixelWriter pw = Outimg.getPixelWriter();
		
	//	System.out.println("Image height: "+imgHeight+", Img Width: "+imgWidth);
		
	
		Color[] palette = data.palette;
		
		int StringLength = s.length();
		for(int i = 0;i<imgHeight*imgWidth*2;i+=2) {
			int val = Integer.parseInt(s.substring(i,i+2),16);

			int xPos = (i/2)%imgWidth;
			int yPos = (i/2)/imgWidth;

		//	System.out.println("Trying to write to "+xPos+" , "+yPos+" value: "+val+" at i: "+i+"String length: "+StringLength);
			pw.setColor(xPos, yPos, palette[val]);
			
		}
		
		//ImageView iv = new ImageView(Outimg);
		return Outimg;
	}
	
	public float calcMSE(Image a, Image b) {
		PixelReader ap = a.getPixelReader();
		PixelReader bp = b.getPixelReader();
		float sum = 0;
		for(int y = 0;y<a.getHeight();y++) {
			for(int x = 0;x<a.getWidth();x++) {
				Color ac = ap.getColor(x, y);
				Color bc = bp.getColor(x, y);
				int rDif = (int) ((ac.getRed()*255)-(bc.getRed()*255));
				int gDif =  (int) ((ac.getGreen()*255)-(bc.getGreen()*255));
				int bDif =  (int) ((ac.getBlue()*255)-(bc.getBlue()*255));
				sum += rDif*rDif;
				sum += gDif*gDif;
				sum += bDif*bDif;
			}
		}
		return (float) (sum/(a.getHeight()*a.getWidth()*3));
		
	}
	
	
}
