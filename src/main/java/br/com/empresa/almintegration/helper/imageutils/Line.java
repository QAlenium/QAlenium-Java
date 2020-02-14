package br.com.empresa.almintegration.helper.imageutils;

import java.util.ArrayList;


public class Line {
	private ArrayList<ImageSpecifications> imagesToPrint = new ArrayList<ImageSpecifications>();
	private int xOffset;
	public ArrayList<ImageSpecifications> getImagesToPrint() {
		return imagesToPrint;
	}
	
	public Line() {
		setxOffset(0);
	}
	
	public int getxOffset() {
		return xOffset;
	}
	public void setxOffset(int xOffset) {
		this.xOffset = xOffset;
	}		 
}