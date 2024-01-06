package javaGUIDroneSimulation;
import javafx.scene.image.Image;

public class Obstacle2 extends Object {
	
	Image obs; 
	public Obstacle2() {	
	}
	
	/**
	 * TR
	 * @param xPosObs TR x position
	 * @param yPosObs TR y position
	 * @param radObs TR radius
	 */
	public Obstacle2(double xPosObs, double yPosObs, double radObs) {
		super(xPosObs, yPosObs, radObs);

		obs = new Image(getClass().getResourceAsStream("TenRac3.png")); 
	}	
	
	/**
	 * drawing TR
	 * calling drTR
	 */
	@Override
	public void drObj(MCanvas C) {
		drTR(C);
	}
	
	/**
	 * drawing TR
	 * @param C canvas
	 */
	public void drTR(MCanvas C) {
		C.draw(obs, x/C.getCanvasX(), y/C.getCanvasY(), radi); 
		//drawing TR with x,y and size
	}


	/**
	 * checking Object
	 */
	@Override
	protected void checkObject(Arena obs_) {
		
	}	
	/**
	 * adjusting Object
	 */
	@Override
	protected void adjustObject() {
		
	}

	/**
	 * save
	 */
	@Override
	public String saveIt() {
		return ("Obstacle 2 at: " + x + " , "+ y);
	}
	
	/**
	 * getStr
	 * string define drone type
	 */
	protected String getStr() {
		return "Tennis Racket ";
	}	
}


