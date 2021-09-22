
public class Vector3d {
 
	private double x;
	private double y;
	private double z;
	
	public Vector3d() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}
	
	public Vector3d(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double x() {
		return this.x;
	}
	
	public double y() {
		return this.y;
	}
	
	public double z() {
		return this.z;
	}
	
	public Vector3d set(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}
	
	public static Vector3d add(Vector3d v, Vector3d w) {
		Vector3d result = new Vector3d();
		result.set(v.x() + w.x(), v.y() + w.y(), v.z() + w.z());
		return result;
	}
	
	public static Vector3d subtract(Vector3d v, Vector3d w) {
		Vector3d result = new Vector3d();
		result.set(v.x() - w.x(), v.y() - w.y(), v.z() - w.z());
		return result;
	}
	
	public static Vector3d multiply(double s, Vector3d v) {
		Vector3d result = new Vector3d();
		result.set(v.x() * s, v.y() * s, v.z() * s);
		return result;
	}
	
	public static Vector3d divide(Vector3d v, double s) {
		Vector3d result = new Vector3d();
		result.set(v.x() / s, v.y() / s, v.z() / s);
		return result;
	}
	
	public static double magnitude(Vector3d v) {
		return Math.sqrt(v.x() * v.x() + v.y() * v.y() + v.z() * v.z());
	}
	
	public static double dotproduct(Vector3d v, Vector3d w) {
		return((v.x() * w.x() + v.y() * w.y() + v.z() * w.z()));
	}
	
	public Vector3d normalize() {
		return Vector3d.divide(new Vector3d(this.x, this.y, this.z), Vector3d.magnitude(new Vector3d(this.x, this.y, this.z)));
	}
	 
	
}
