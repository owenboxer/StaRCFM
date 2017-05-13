package core;

public enum Constants {
	ELEMENTARY_CHARGE(1.602217662E-19), //proton and electron charge in Coulombs
	BOLTZMANN_CONSTANT(1.38064852E-23), 
	FINE_STRUCTURAL_CONSTANT(Math.pow(Math.E, 2) / (4 * Math.PI));



	double value;

	Constants(double value){ this.value = value; }
	public double getValue(){ return value; }
}
