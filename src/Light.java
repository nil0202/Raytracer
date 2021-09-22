
public class Light {

	private final Vector3d location;
	private final MyColor diffuseintensity;
	private final MyColor specularintensity;

	public Light(Vector3d location, MyColor diffuseintensity, MyColor specularintensity) {
		this.location = location;
		this.diffuseintensity = diffuseintensity;
		this.specularintensity = specularintensity;
	}

	public Vector3d location() {
		return this.location;
	}

	public MyColor diffuseintensity() {
		return this.diffuseintensity;
	}

	public MyColor specularintensity() {
		return this.specularintensity;
	}
}
