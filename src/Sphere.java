
public class Sphere {
	
	private final Vector3d center;
	private final double radius;
	private final Material material;
	
	public Sphere(Vector3d center, double radius, Material material) {
		this.center = center;
		this.radius = radius;
		this.material = material;

	}
	
	public Vector3d getCenter() {
		return this.center;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public Material getMaterial() {
		return this.material;
	}
		
}
