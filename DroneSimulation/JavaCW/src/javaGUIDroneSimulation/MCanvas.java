package javaGUIDroneSimulation;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MCanvas {
	int szeX = 1200;				
	int szeY = 600;
    GraphicsContext grphCtx; 

    /**
     * MCanvas
     * constructor sets up relevant Graphics context and size of canvas
     * @param gC is graphics context
     * @param xC canvas size in x
     * @param yC canvas size in y
     */
    public MCanvas(GraphicsContext gC, int xC, int yC) {
    	grphCtx = gC;
    	szeX = xC;
    	szeY = yC;
    }
    
    /**
     * getCanvasX: returns szeX
     */
    public int getCanvasX() {
    	return szeX;
    }
    
    /**
     * getCanvasY: returns szeY
     */
    public int getCanvasY() {
    	return szeY;
    }

    /**
     * clearing canvas
     */
    public void clrcCnvs() {
    	grphCtx.clearRect(0,  0,  szeX,  szeY);		
    	// clear canvas
    }
        
	/**
	 * draw
     * draw: includes object
     * @param img is the image
     * @param x		x position	with range 0..1
     * @param y     y position 
     * @param sz	sz is the size
     */
	public void draw (Image img, double x, double y, double sz) {
			// to draw centred at x,y, give top left position and x,y size
			// sizes/position in range 0..1, so scale to canvas size 
		grphCtx.drawImage(img, szeX * (x - sz/2), szeY*(y - sz/2), szeX*sz, szeY*sz);
	}

}