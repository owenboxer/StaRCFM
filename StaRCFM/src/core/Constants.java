package core;

public enum Constants {
	GRAVITATIONAL_CONSTANT(6.67E-11),
	HYDROGEN_MASS(1.67E-27),
	BOLTZMANN_CONSTANT(1.38064852E-23);



	double value;

	Constants(double value){ this.value = value; }
	public double getValue(){ return value; }
}