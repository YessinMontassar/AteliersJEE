package classes;

public class IMC {
	private double taille;
	private double poids;
	public IMC(double taille, double poids) {
		this.taille = taille;
		this.poids = poids;
	}
	public double calcule() {
		return poids/(taille*taille);
	}
	

}
