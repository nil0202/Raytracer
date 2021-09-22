import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

public class RayTracer {
	
	private final MyColor color;
	
	public RayTracer(Ray ray, Scene scene, int recursionDepth) {
		Map<Sphere, Double> spheres = new HashMap<>();

		for(Sphere sphere : scene.getSpheres()) {
			Discriminant discriminant = new Discriminant(ray, sphere);
    		if (discriminant.getDiscriminant() >= 0) {
    			QuadraticFormula roots = new QuadraticFormula(discriminant);
				double minRoot = Math.min(roots.getRoot1(), roots.getRoot2());
				if (minRoot >= 0){
					spheres.put(sphere, minRoot);
				}
    		}
		}     		      		
		
		if(spheres.isEmpty()) {
			this.color = new MyColor(0,0,0);
		}
		else {
			Entry<Sphere, Double> min  = null;
			for (Entry<Sphere, Double> entry : spheres.entrySet()) {
			    if (min == null || min.getValue() > entry.getValue()) {
			    	min = entry;
			    }
			}
			
			Sphere sphere = min.getKey();
			Vector3d pointOfIntersection = Vector3d.add(ray.getOrigin(), Vector3d.multiply(min.getValue(), ray.getDirection()));
			Vector3d surfaceNormal = Vector3d.subtract(pointOfIntersection, sphere.getCenter()).normalize();
			MyColor Color = MyColor.multiply(scene.getIA(), sphere.getMaterial().getAmbientConstant());

			for(Light light : scene.getLights()) {
				Ray shadowRays = new Ray(pointOfIntersection, Vector3d.subtract(light.location(), pointOfIntersection));
				ArrayList<Sphere> otherSpheres = new ArrayList<>(scene.getSpheres());
				otherSpheres.remove(scene.getSpheres().indexOf(sphere));
				boolean shadowRay = false;

				for (Sphere otherSphere : otherSpheres) {
					Discriminant d = new Discriminant(shadowRays, otherSphere);
            		if (d.getDiscriminant() >= 0) {
            			QuadraticFormula roots = new QuadraticFormula(d);
						double minRoot = Math.min(roots.getRoot1(), roots.getRoot2());
                		if(0 < minRoot && minRoot < 1){
                			shadowRay = true;
                			break;
                		}
            		}
				}

				Vector3d lightVector = Vector3d.subtract(light.location(), pointOfIntersection).normalize();
				if (Vector3d.dotproduct(surfaceNormal, lightVector) >= 0 && !shadowRay) {
					MyColor diffuseComponent = MyColor.multiply(MyColor.multiply(sphere.getMaterial().getDiffuseConstant(),
							light.diffuseintensity()), Vector3d.dotproduct(surfaceNormal, lightVector));
					Color = MyColor.add(Color, diffuseComponent);
					Vector3d reflectanceVector = Vector3d.subtract(Vector3d.multiply((2 * Vector3d.dotproduct(surfaceNormal, lightVector)), surfaceNormal), lightVector);
					Vector3d viewVector = Vector3d.subtract(pointOfIntersection, Camera.getCamera()).normalize();
					double tmp =  Math.pow(Vector3d.dotproduct(viewVector, reflectanceVector), sphere.getMaterial().getShininessFactor());
					MyColor specularComponent = MyColor.multiply(MyColor.multiply(sphere.getMaterial().getSpecularConstant(), light.specularintensity()), tmp);
					Color.add(specularComponent);
				}
			}

			if (recursionDepth > 0) {
				Vector3d reversedDirection = Vector3d.multiply(-1, ray.getDirection()).normalize();
				Vector3d reflectanceVector = Vector3d.subtract(Vector3d.multiply((2 * Vector3d.dotproduct(surfaceNormal, reversedDirection)), surfaceNormal), reversedDirection);
				Ray ref = new Ray(Vector3d.add(ray.getOrigin(), Vector3d.multiply(min.getValue(), ray.getDirection())) , reflectanceVector);
				MyColor reflection = new RayTracer(ref, scene, (recursionDepth - 1)).getColor();
				Color = MyColor.add(Color, (MyColor.multiply(reflection, sphere.getMaterial().getReflectivity())));
			}
			
			this.color = Color;
		}
	}

	public MyColor getColor() {
		return this.color;
	}
}
