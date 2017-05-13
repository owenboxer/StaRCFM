package core;

public enum Constants {
	ELEMENTARY_CHARGE(1.602217662E-19); //proton and electron charge in Coulombs



	double value;

	Constants(double value){ this.value = value; }
	public double getValue(){ return value; }
}
