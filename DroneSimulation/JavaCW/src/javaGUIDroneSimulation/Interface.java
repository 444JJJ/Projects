package javaGUIDroneSimulation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interface extends Application {
	private MCanvas C;
	private AnimationTimer tm;								// animation timer
	private VBox vB;										// vertical box for object information
	private Arena dA;
	JFileChooser ch = new JFileChooser(); 					// file chooser
	
	/**
	 * info: shows information
	 * function to show in a box ABout the programme
	 */
	private void info() {
	    Alert al = new Alert(AlertType.INFORMATION);				
	    al.setTitle("Infomation");									
	    al.setHeaderText(null);
		al.setContentText("GUI Drone Simulation"); 				// Information in the info box
	    al.showAndWait();										// shows information in a box, until user closes box
	}
		
	/**
	 * saveFile: function, for save location
	 */	
	private void saveFile() {
		JFrame parentFrame = new JFrame(); 						//New JFrame
		ch.setDialogTitle("Choose file to save");   			//Output to user
			int uS = ch.showSaveDialog(parentFrame);
			if (uS == JFileChooser.APPROVE_OPTION) {
				File fleSve = ch.getSelectedFile();
				System.out.println("Save as file: " + fleSve.getAbsolutePath()); 	//File path
				try {
					PrintWriter fl = new PrintWriter(new File(fleSve.getAbsolutePath()));
					fl.write(dA.saveIt());    					//writes to file	        					    
					fl.close(); 								//closes file
					System.out.println("Saved");
				} catch (FileNotFoundException e) {
					System.out.println("Error");
				}
			}
	}
	
	/**
	 * setMenut: menus for GUI
	 * @return the menu bar
	 */
	MenuBar setMenu() {
		MenuBar mB = new MenuBar();								//creates main menu

		Menu mBFile = new Menu("File");							// add File main menu	
		MenuItem mBExt = new MenuItem("Exit");					// With sub-menu Exit
		mBExt.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent t) {					// action on exit is
		    	tm.stop();										// stops timer
		        System.exit(0);									// exits program
		    }
		});
				
		MenuItem mBSve = new MenuItem("Save"); 					
		mBSve.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				tm.stop();
				saveFile(); 									//calls save file
			}
		});

		mBFile.getItems().addAll(mBSve, mBExt);					// add exit save, to File menu
		
		
		Menu mBHlp = new Menu("Information");					// create Help/Info menu
		MenuItem mInfo = new MenuItem("Information");			// add About sub men item
		mInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actEv) {
            	info();											// and its action to print about
            }	
		});														// add About to Help main item
		mBHlp.getItems().addAll(mInfo);	

		mB.getMenus().addAll(mBFile, mBHlp);					// set main menu with File, Help
		return mB;												// return the menu
	}

	/**
	 * setButtons: horizontal box for the bottom with relevant buttons
	 * @return The HBox
	 */
	private HBox selectOptions() {
	
		Button startButton = new Button("Start Drone Simulation");					
	    startButton.setOnAction(new EventHandler<ActionEvent>() {					
	        @Override
	        public void handle(ActionEvent ev) {
	        	tm.start();															
	       }
	    });   
	    
	    Button stopButton = new Button("Pause Drone Simulation");					
	    stopButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent ev) {
	        	tm.stop();												
	       }
	    });
	    
	    Button addDroneButton = new Button("Add Drone");				
	    addDroneButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent ev) {
	        	dA.addDrone();											//add drone
	           	simuScene();
	       }
	    });

	    Button addObsButton = new Button("Add Obstacle");				
	    addObsButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent ev) {
	        	dA.addObs();											//add obstacle
	        	simuScene();
	       }
	    });
	    
	    
	    
	    Button addSecButton = new Button("Add Second Obstacle");		
	    addSecButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent ev) {
	        	dA.addSecObs();											//add obstacle
	        	simuScene();
	       }
	    });

	    Button addEnemyDroneButton = new Button("Add Enemy Drone");				
	    addEnemyDroneButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent ev) {
	        	dA.addEnemyDrone();										// add enemyDrone
	        	simuScene();
	       }
	    });
	    			
	    return new HBox(startButton, stopButton, addDroneButton, addEnemyDroneButton, addObsButton, addSecButton);
	}
	
	/** 
	 * simuScene: simulation scene
	 */
	public void simuScene () {
	 	C.clrcCnvs();						
	 	dA.drArena(C);
	}
	
	/**
	 * drStts: shows where drone is
	 */
	public void drStts() {
		vB.getChildren().clear();					// clear vB
		ArrayList<String> alb = dA.describe();
		for (String s : alb) {
			Label lbl = new Label(s); 				// turns description into a label
			vB.getChildren().add(lbl);				// add label	
		}	
	}

	/**
	 *
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Drone Simulation");
	    BorderPane bp = new BorderPane();
	    bp.setPadding(new Insets(10, 20, 10, 20));
	    
	    bp.setTop(setMenu());											

	    Group root = new Group();										//creates group with canvas
	    Canvas canvas = new Canvas( 1200, 600 );
	    root.getChildren().add( canvas );
	    bp.setLeft(root);												//load canvas to left area
	
	    C = new MCanvas(canvas.getGraphicsContext2D(), 1200, 600);
	    	    
	    StackPane holder = new StackPane();
	    holder.getChildren().add(canvas);
	    root.getChildren().add(holder);
	    holder.setStyle("-fx-background-color: white");  			

	    dA = new Arena(1200, 600);										// setting  arena
	    simuScene();
	    	    
	    tm = new AnimationTimer() {										// setting timer
	        public void handle(long currentNanoTime) {					// its action
	        	dA.checkingObject();									// check the angle of all object
	        	dA.adjustingObject();									// move all movable objects
	        	simuScene();											// redraw the world
	        	drStts();												// indicate where the objects are
	        }
	    };
   
	    vB = new VBox();												// set vBox on right to list items
	    vB.setAlignment(Pos.TOP_LEFT);									// set alignment
		vB.setPadding(new Insets(5, 75, 75, 5));						// padding
 		bp.setRight(vB);												// add rtPane to borderpane right
		  
	    bp.setBottom(selectOptions());									// set bottom pane with buttons

	    Scene scene = new Scene(bp, 1200, 600);							// set overall scene
        bp.prefHeightProperty().bind(scene.heightProperty());
        bp.prefWidthProperty().bind(scene.widthProperty());

        primaryStage.setScene(scene);
        primaryStage.show();
	}

	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
	    Application.launch(args);	

	}

}