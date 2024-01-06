package application;
	
import java.awt.TextArea;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private JFileChooser j;//object used for the saving and loading menu
	Image startImage;
	Image currentImage;
	LZW lzw;
	Dither d;
	ImageView iv;
	
	long ImportedImageSize = 0;
	long newImageSize = 0;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			lzw = new LZW();
			d = new Dither();
			Text txt = new Text();
			
			
			Button LoadImage = new Button("Select Image");
			LoadImage.setOnAction(event -> {
	            FileChooser fileChooser = new FileChooser();
	            fileChooser.setTitle("Select Image");
	            File file = fileChooser.showOpenDialog(primaryStage);
	            if (file != null) {
	                Image image = new Image(file.toURI().toString());
	                ImportedImageSize = file.length();
	                currentImage = image;
	                startImage = image;
	                iv.setImage(image);
	            }
	        });
	        
	        Button SaveCompressed = new Button("SaveCompressed");
	        SaveCompressed.setOnAction(event -> {
	        	j = new JFileChooser(); // create new instance of jfile chooser
	    		int r = j.showSaveDialog(null);
	    		 if (r == JFileChooser.APPROVE_OPTION) {
	                if(currentImage != null) {
	                	try {
							lzw.compress(d.Dither(currentImage), j.getSelectedFile().getAbsolutePath()+".bin");
							System.out.println("Saving in: "+(j.getSelectedFile().getAbsolutePath()+".bin"));
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
	            }
	        });
	        
	        Button LoadCompressedImage = new Button("Select Compressed Image");
	        LoadCompressedImage.setOnAction(event -> {
	        	j = new JFileChooser(); // create new instance of jfile chooser
	    		int r = j.showSaveDialog(null);
	    		 if (r == JFileChooser.APPROVE_OPTION) {
	    			 	currentImage = lzw.decompress((j.getSelectedFile().getAbsolutePath()));
	    				iv.setImage(currentImage);
						newImageSize = j.getSelectedFile().getAbsoluteFile().length();
						
						txt.setText("  Compression ratio is: "+(ImportedImageSize/newImageSize+"\n"+"  MSE is: "+lzw.calcMSE(startImage,currentImage)));
						System.out.println("Compression ratio is: "+ImportedImageSize/newImageSize);
						System.out.println("Success!");
	    		 }
	        });
	        
	        iv = new ImageView();
	        iv.setPreserveRatio(true);


	        HBox hb = new HBox();
	        hb.getChildren().addAll(LoadImage,SaveCompressed,LoadCompressedImage,txt);
	        
	        BorderPane root = new BorderPane();
	        root.setTop(hb);
	        root.setCenter(iv);

	        Scene scene = new Scene(root, 600, 600);

	        primaryStage.setTitle("Image Compressor/Decompressor");
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
