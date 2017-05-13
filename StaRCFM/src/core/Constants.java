package core;

public enum Constants {
	ELEMENTARY_CHARGE(1.602217662E-19), //proton and electron charge in Coulombs
	BOLTZMANN_CONSTANT(1.38064852E-23);



	double value;

	Constants(double value){ this.value = value; }
	public double getValue(){ return value; }
}
