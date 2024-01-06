package javaGUIDroneSimulation;
import javafx.scene.image.Image;

public class Drone extends Object {
	double angle;			//drone angle
	double speed;			//drone speed
	Image drone; 			//drone image
	
	/** 
	 * Creating drone
	 * @param drx drone x position
	 * @param dry drone y position
	 * @param drad drone radius
	 * @param dra drone translation angle
	 * @param drs drone translation speed
	 */
	public Drone(double drx, double dry, double drad, double dra, double drs) {
		super(drx, dry, drad);
		angle = dra;
		speed = drs;
		radi = drad;
		drone = new Image(getClass().getResourceAsStream("Drone2.png"));
	}
	
	/**
	 * drawing object 
	 * @param C canvas
	 */
	@Override
	public void drObj(MCanvas C) {
		drDrn(C);
	}
	
	/**
	 * drawing drone
	 * @param C canvas
	 */	
	public void drDrn(MCanvas C) {
		C.draw(drone, x/C.getCanvasX(), y/C.getCanvasY(), radi); 
		//drone to canvas
	}
	
	/**
	 * checking object
	 * @param dr Arena
	 */
	@Override
	protected void checkObject(Arena dr) {;
	angle = dr.ChkDrAng(x, y, radi, angle, objID); 
	//changes angle of drone
	}

	@Override
	protected void adjustObject() {
		double rdnAngle = angle*Math.PI/180;	//convert degrees to radians
		x += speed * Math.cos(rdnAngle);		//calculating the new x position
		y += speed * Math.sin(rdnAngle);		//calculating the new y position
	}
	
	/**
	 * save: a string, where data will be stored
	 */
	@Override
	public String saveIt() {
		return ("Drone is at: " + x + " , "+ y + " Angle " + angle + " Speed " + speed);
	}
	
	/**
	 * getStr: string, representing drone type
	 */
	protected String getStrType() {
		return "Drone ";
	}
	
}
