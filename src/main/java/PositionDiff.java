package main.java;

public class PositionDiff {
	private int horizontalDiff;
	private int verticalDiff;
	
	public PositionDiff(int horizontalDiff, int verticalDiff) {
		this.horizontalDiff = horizontalDiff;
		this.verticalDiff = verticalDiff;
	}
	
	public int getHorizontalDiff() {
		return horizontalDiff;
	}
	public void setHorizontalDiff(int horizontalDiff) {
		this.horizontalDiff = horizontalDiff;
	}
	public int getVerticalDiff() {
		return verticalDiff;
	}
	public void setVerticalDiff(int verticalDiff) {
		this.verticalDiff = verticalDiff;
	}
	
	
}
