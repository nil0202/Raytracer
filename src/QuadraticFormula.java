
public class QuadraticFormula {
	
	private final double root1;
	private final double root2;
	
	public QuadraticFormula(Discriminant discriminant) {
		this.root1 = (-discriminant.getB() + Math.sqrt(discriminant.getDiscriminant())) / (2 * discriminant.getA());
		this.root2 = (-discriminant.getB() - Math.sqrt(discriminant.getDiscriminant())) / (2 * discriminant.getA());
	}
	
	public double getRoot1() {
		return this.root1;
	}
	
	public double getRoot2() {
		return this.root2;
	}
}
