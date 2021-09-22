import java.util.ArrayList;

public class Scene {

	private final ImagePlane imageplane;
	private final Camera camera;
	private final ArrayList<Sphere> spheres;
	private final ArrayList<Light> lights;
	private final MyColor IA;

	public Scene(ImagePlane imageplane, Camera camera, ArrayList<Sphere> spheres, ArrayList<Light> lights, MyColor ia) {

		this.imageplane = imageplane;
		this.camera = camera;
		this.spheres = spheres;
		this.lights = lights;
		this.IA = ia;
	}

	public ArrayList<Sphere> getSpheres() {
		return this.spheres;
	}

	public ArrayList<Light> getLights() {
		return this.lights;
	}

	public MyColor getIA() {
		return this.IA;
	}

}