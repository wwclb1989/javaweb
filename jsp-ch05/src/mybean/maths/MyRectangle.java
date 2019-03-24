package mybean.maths;

public class MyRectangle {

	private double length;
	private double width;
	private double area;
	
	public MyRectangle(){
		length=0;
		width=0;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getArea(){
		double faceArea=length*width;
		return faceArea;
	}
}
