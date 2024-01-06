package javaGUIDroneSimulation;
import javaGUIDroneSimulation.Object;

public abstract class Object {
	protected double x;
	protected double y;
	protected double radi;						
	static int counter = 0;							// unique identifier for each object
	protected int objID;							// unique identifier for item

	Object() {
		this(90, 200, 8);
	}
	
	/**
	 * Object
	 * constructing object
	 * @param objx object x position
	 * @param objy object y position
	 * @param objradi object size
	 */
	Object (double objx, double objy, double objradi) {
		x = objx;
		y = objy;
		radi = objradi;
		objID = counter++;			
	}

	/**
	 * getX: returns x position
	 */
	public double getX() {
		return x; 
	}
	
	/**
	 * getY: returns y position
	 */
	public double getY() {
		return y; 
	}
	
	/**
	 * getRad: returns object size
	 */
	public double getRad() {
		return radi; 
	}
	
	/** 
	 * setXY: setting object
	 */
	public void setXY(double newX, double newY) {
		x = newX;
		y = newY;
	}
	
	/**
	 * getID: returns Object ID
	 */
	public int getID() {
		return objID; 
	}
	
	/**
	 * drawing object
	 * @param C canvas
	 */
	public void drObj(MCanvas C) {
		
	}
	
	/**
	 * getStr
	 * @return type 
	 */
	protected String getStr() {
		return "Drone";
	}

	/** 
	 * toString
	 * string describing object
	 */
	public String toString() {
		return getStr()+" is at "+Math.round(x)+", "+Math.round(y);
	}
		
	/**
	 * checking object
	 * checking a Object in arena dAr
	 * @param dAR drone arena
	 */
	protected void checkObject(Arena dAr) {
		
	}
	
	/**
	 * adjusting Object
	 * method adjusting a Object
	 */
	protected void adjustObject() {
		
	}
	
	/**
	 * hitting
	 * is Object at px,py size or hitting this Object
	 * @param px previous x 
	 * @param py previous y
	 * @param pr previous radius
	 * @return 1 hitting occurred
	 */
	public boolean hitting(double px, double py, double pr) {
		return (px-x)*(px-x) + (py-y)*(py-y) < (pr+radi)*(pr+radi);
	}		

	/** 
	 * Are objects colliding 
	 * 
	 * @param Obj is the other object
	 * @return 1 if collision occurred
	 */
	public boolean hitting (Object obj) {
		return hitting(obj.getX(), obj.getY(), obj.getRad());
	}
	
	/**
	 * save 
	 * @return an empty string
	 */
	public String saveIt() {
		return "";
	}
}