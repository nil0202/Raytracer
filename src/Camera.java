
public class Camera {

	private static Vector3d camera;

	public Camera(Vector3d camera) {
		Camera.camera = camera;
	}
	public static Vector3d getCamera() {
		return camera;
	}
}
