package javaGUIDroneSimulation;
import javafx.scene.image.Image;

public class EnemyDrone extends Object {	
	double enmAngle;		//drone translation angle
	double enSpeed;			//drone translation speed
	Image enDrone; 						
	
	/** 
	 * EnemyDrone
	 * @param enx drone x position
	 * @param eny drone y position
	 * @param enradi drone size
	 * @param enangle translation angle
	 * @param enspeed translation speed
	 */
	public EnemyDrone(double enx, double eny, double enradi, double enangle, double enspeed) {
		super(enx, eny, enradi);
		enmAngle = enangle;
		enSpeed = enspeed;
		radi = enradi;
		enDrone = new Image(getClass().getResourceAsStream("Enemy2.png")); 
	}
	
	/**
	 * drawing object
	 * calling drEnDrone
	 */
	@Override
	public void drObj(MCanvas C) {
		drEnDrone(C);
	}
	
	/**
	 * @param C canvas: drone to canvas C
	 */
	public void drEnDrone(MCanvas C) {
		C.draw(enDrone, x/C.getCanvasX(), y/C.getCanvasY(), radi); //draws the image in the position and size
	}

	/**
	 * checking drone: changes angle on collision
	 * @param b   droneArena
	 */
	@Override
	protected void checkObject(Arena b) {;
	enmAngle = b.ChkDrAng(x, y, radi*2, enmAngle, objID);
	}

	/**
	 * adjusting drone: move drone, in relation to speed and angle
	 */
	@Override
	protected void adjustObject() {
		double radAngle = enmAngle*Math.PI/180;		// put angle in radians
		x += enSpeed * Math.cos(radAngle);			// new X position
		y += enSpeed * Math.sin(radAngle);			// new Y position
	}
	
	/**
	 * save: a string, where data will be stored
	 */
	@Override
	public String saveIt() {
		return (" Enemy Drone is at: " + x + " , "+ y + " Angle " + enmAngle + " Speed " + enSpeed);
	}
	
	/**
	 * getStr: string, representing drone type
	 */
	protected String getStr() {
		return "Enemy Drone ";
	}
	
}