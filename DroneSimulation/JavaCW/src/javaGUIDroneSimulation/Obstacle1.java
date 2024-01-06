package javaGUIDroneSimulation;
import javafx.scene.image.Image;

public class Obstacle1 extends Object {
	
	Image obs; 
	
	public Obstacle1() {	
	}

	/**
	 * TR
	 * @param xPosObs TR x position
	 * @param yPosObs TR y position
	 * @param radObs TR radius
	 */
	public Obstacle1(double xPosObs, double yPosObs, double radObs) {
		super(xPosObs, yPosObs, radObs);

		obs = new Image(getClass().getResourceAsStream("obj3.png")); //gets the image of the obstacle
		
	}	

	/**
	 * drawing TR
	 * calling drTR
	 */
	@Override
	public void drObj(MCanvas C) {
		drTur(C);
	}
	
	/**
	 * drawing TR
	 * @param C canvas
	 */
	public void drTur(MCanvas C) {
		C.draw(obs, x/C.getCanvasX(), y/C.getCanvasY(), radi); //draws the obstacle in the x and y position with size
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
		return ("Obstacle at: " + x + " , "+ y);
	}

	/**
	 * getStr
	 * string define drone type
	 */
	protected String getStr() {
		return "Turbine ";
	}	
}


