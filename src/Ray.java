
public class Ray {
	private final Vector3d origin;
	private final Vector3d direction;
	
	public Ray(double x, double y) {
	    double alpha = x/(double) RendererMain.width;
	    double beta = y/(double) RendererMain.height;
		
	    Vector3d t = Vector3d.add((Vector3d.multiply((1 - alpha), ImagePlane.getX1())), (Vector3d.multiply((alpha), ImagePlane.getX2())));
	    Vector3d b = Vector3d.add((Vector3d.multiply((1 - alpha), ImagePlane.getX3())), (Vector3d.multiply((alpha), ImagePlane.getX4())));

	    this.origin = Vector3d.add((Vector3d.multiply((1 - beta), t)), (Vector3d.multiply((beta), b)));
	    this.direction = Vector3d.subtract(this.origin, Camera.getCamera());
	}
	
	public Ray(Vector3d origin, Vector3d direction) {
	    this.origin = origin;
	    this.direction = direction;
	}
	
	public Vector3d getOrigin() {
		return this.origin;
	}
	
	public Vector3d getDirection() {
		return this.direction;
	}
}
