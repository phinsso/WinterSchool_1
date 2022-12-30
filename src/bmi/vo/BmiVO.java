package bmi.vo;

public class BmiVO {

	double height;
	double weight;
	double bmi;
	
	public BmiVO() {
		
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi() {
		this.bmi = height / Math.pow(weight / 100, 2);
	}
	
	
}
