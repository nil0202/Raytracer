import java.awt.Color;

public class MyColor { 
		
	private double r; 
	private double g;
	private double b; 
	
	public MyColor(double r, double g, double b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public double getR() {
		return this.r;
	}
	
	public double getG() {
		return this.g;
	}
	
	public double getB() {
		return this.b;
	}
	
	public static MyColor multiply(MyColor a, MyColor b) {
		return new MyColor(a.getR() * b.getR(), a.getG() * b.getG(), a.getB() * b.getB());
	}
	
	public static MyColor multiply(MyColor a, double b) {
		return new MyColor(a.getR() * b, a.getG() * b, a.getB() * b);
	}
	
	public static MyColor add(MyColor a, MyColor b) {
		return new MyColor(a.getR() + b.getR(), a.getG() + b.getG(), a.getB() + b.getB());
	}

	public MyColor add(MyColor c) {
		this.r += c.getR();
		this.g += c.getG();
		this.b += c.getB();
		return this;
	}
	
	public Color realColor() {
		
		if (this.r > 1) {
			this.r = 1;
		}
		
		if (this.r < 0) {
			this.r = 0;
		}
		
		if (this.g > 1) {
			this.g = 1;
		}
		
		if (this.g < 0) {
			this.g = 0;
		}
		
		if (this.b > 1) {
			this.b = 1;
		}
		
		if (this.b < 0) {
			this.b = 0;
		}
		
		return new Color((int)(this.r * 255), (int)(this.g * 255), (int)(this.b * 255));
	}
	
}