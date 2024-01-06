package application;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.paint.Color;

public class LZWFileData implements Serializable {
	int imgHeight;
	int imgWidth;
	Color[] palette;
	ArrayList<Integer> rawData;
	public LZWFileData(int h,int w, Color[] c, ArrayList<Integer> r) {
		imgHeight = h;
		imgWidth = w;
		palette = c;
		rawData = r;
	}
}