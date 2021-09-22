
public class Discriminant {

	private final double discriminant;
	private final double a;
	private final double b;
	
	public Discriminant(Ray ray, Sphere sphere) {
		double a = (Vector3d.magnitude(ray.getDirection()) * Vector3d.magnitude(ray.getDirection()));
		double b = 2 * (Vector3d.dotproduct(Vector3d.subtract(ray.getOrigin(), sphere.getCenter()), ray.getDirection()));
		double c = (Math.pow(Vector3d.magnitude(Vector3d.subtract(ray.getOrigin(), sphere.getCenter())), 2) - (sphere.getRadius() * sphere.getRadius()));
		
		this.discriminant = b * b - 4 * a * c;
		this.a = a;
		this.b = b;
	}
	
	public double getDiscriminant() {
		return this.discriminant;
	}
	
	public double getA() {
		return this.a;
	}
	
	public double getB() {
		return this.b;
	}
}
