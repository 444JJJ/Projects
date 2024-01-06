package javaGUIDroneSimulation;
import java.util.ArrayList;

public class Arena {	
	double szeX;
	double szeY;
	double randX;
	double randY;
	double randAngle;
	double randSpeed;					
	private ArrayList<Object> allObjs;	
	
	/**
	 * creating an arena
	 */
	Arena() {
		this(1200, 600);			
		// default size
	}
	
	/**
	 * Creating arena
	 * @param xA arena size in x
	 * @param yA arena size in y
	 */
	
	Arena(double xA, double yA){
		szeX = xA;
		szeY = yA;
		allObjs = new ArrayList<Object>();					
		//empty list of all objects
	}
		
	/**
	 * range: return a range between min and max
	 * @param mn is the minimum value
	 * @param mx is the maximum value
	 */
	public static double range(double mn, double mx) {
		double x = (Math.random()*((mx-mn)+1))+mn;
		return x;
	}
	
	/**
	 * getSzeX: return arena size in x
	 */
	public double getSzeX() {
		return szeX;
	}
		
	/**
	 * getSzeY: returns arena size in y
	 */
	public double getSzeY() {
		return szeY;
	}
		
	/**
	 * drawArena: drawing all objects to canvas
	 */
	public void drArena(MCanvas C) {
		for (Object ob : allObjs) ob.drObj(C);		
		//drawing all objects
	}
		
	/**
	 * checking all object: to determine if a change of angle is needed
	 */
	public void checkingObject() {
		for (Object ob : allObjs) ob.checkObject(this);	// check all balls
	}
	/**
	 * adjusting objects: 
	 */
			
	public void adjustingObject() {
		for (Object ob : allObjs) ob.adjustObject();
	}
	
	/**
	 * describe: returns list of string for all objects
	 */	
	public ArrayList<String> describe() {
		ArrayList<String> answer = new ArrayList<String>();		// set up empty arraylist
		for (Object ob : allObjs) answer.add(ob.toString());			// add string defining each object
		return answer;												// return string list
	}
	
	/**
	 * saveIT: returns string with saved information on all objects in the arena
	 */
	public String saveIt() {
		String sve = "";
		for (Object ob: allObjs) {
			sve += ob.saveIt() + "\n";
		}
		return sve;
	}
		
	/** 
	 * checking drone angle: if drone hits wall, rebound, else if other drone change angle
	 * @param x				drone x position
	 * @param y				drone y position
	 * @param rad			drone size
	 * @param ang			translation angle
	 * @param notID			object id not being checked
	 * @return				returns the new angle 
	 */
		
	public double ChkDrAng(double x, double y, double rad, double angle, int ntID) {
		double answer = angle;
		if (x < rad || x > szeX - rad) answer = 180 - answer;
		// on collision with vertical borders, setting mirror angle, as 180degrees - angle
		
		if (y < rad || y > szeY - rad) answer = - answer;
		// on collision with horizontal borders, set mirror angle
		
		for (Object ob : allObjs) 
			if (ob.getID() != ntID && ob.hitting(x, y, rad*550)) answer = 180*Math.atan2(y-ob.getY(), x-ob.getX())/Math.PI;
		// check all drone except one with given id
		// if collision has occurred, return angle between the current and other drone
		
		return answer;		// return the angle
	}
	
	/**
	 * ChkHit: checking, if the target object t, is collided with other object
	 * @return 	1 collision occurred
	 */
	public boolean ChkHit(Object t) {
		boolean ans = false;
		for (Object ob : allObjs)
			if (ob instanceof Drone && ob.hitting(t)) 
				ans = true;
		//test all drones, if it has hit target
			
		return ans;
	}
		
	/**
	 * addObs: adds an obstacle in a random position
	 */
	public void addObs() {
		randX = range(0, getSzeX());
		randY = range(0, getSzeY());
		
		allObjs.add(new Obstacle1(randX, randY, 0.15));
	}
		
	public void addSecObs() {
		randX = range(0, getSzeX());
		randY = range(0, getSzeY());
		
		allObjs.add(new Obstacle2(randX, randY, 0.05));
		
	}
		
	/**
	 * addDrone: add drone in random position
	 */
	public void addDrone() {
		randX = range(0, getSzeX());
		randY = range(0, getSzeY());
		randAngle = range(0,360);
		randSpeed = range(1,3);
		allObjs.add(new Drone(randX, randY, 0.1, randAngle, randSpeed));
	}
		
	/**
	 * addEnemyDrone: add drone in random position
	 */	
	public void addEnemyDrone() {
		randX = range(0, getSzeX());
		randY = range(0, getSzeY());
		randAngle = range(0,360);
		randSpeed = range(1,3);
		allObjs.add(new EnemyDrone(randX, randY, 0.1, randAngle, randSpeed));
	}
	
	
		// include code: Collision between enemydrone and drone, drone is removed from scene.
	
	
}





