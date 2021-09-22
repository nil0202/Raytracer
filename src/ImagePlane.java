
public class ImagePlane {
	
	private static Vector3d x1;
	private static Vector3d x2;
	private static Vector3d x3;
	private static Vector3d x4;
	 
	public ImagePlane(Vector3d x1, Vector3d x2, Vector3d x3, Vector3d x4) {
		ImagePlane.x1 = x1;
		ImagePlane.x2 = x2;
		ImagePlane.x3 = x3;
		ImagePlane.x4 = x4;
	}
	
	public static Vector3d getX1() {
		return x1;
	}
	
	public static Vector3d getX2() {
		return x2;
	}
	
	public static Vector3d getX3() {
		return x3;
	}
	
	public static Vector3d getX4() {
		return x4;
	}
}
