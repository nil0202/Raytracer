
public class Material{
			private final MyColor ambientconstant;
			private final MyColor diffuseconstant;
			private final MyColor specularconstant;
			private final double shininessfactor;
			private final MyColor reflectivity;

			public Material(MyColor ambientconstant, MyColor diffuseconstant, MyColor specularconstant, double shininessfactor, MyColor reflectivity){
				this.ambientconstant = ambientconstant;
				this.diffuseconstant = diffuseconstant;
				this.specularconstant = specularconstant;
				this.shininessfactor = shininessfactor;
				this.reflectivity = reflectivity;

			}

			public MyColor getAmbientConstant() {
					return ambientconstant;
			}

			public MyColor getDiffuseConstant() {
				return diffuseconstant;
			}

			public MyColor getSpecularConstant() {
				return specularconstant;
			}

			public double getShininessFactor() {
				return shininessfactor;
			}

			public MyColor getReflectivity() {
				return reflectivity;
			}

}
