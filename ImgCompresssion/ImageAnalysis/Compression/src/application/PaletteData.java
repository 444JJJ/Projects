package application;

import javafx.scene.paint.Color;

public class PaletteData {
	int imgHeight;
	int imgWidth;
	int paletteSize;
	Color[] palette;
	int[][] pixelData;
	public PaletteData(int h,int w, int paletteSze,Color[] PaletteData, int[][] pixelDat) {
		imgHeight = h;
		imgWidth = w;
		paletteSize = paletteSze;
		palette = PaletteData;
		pixelData = pixelDat;
	}
}