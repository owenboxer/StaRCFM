package core;

public class Fusion {

	public static double getFusionRate(double temperature, Nucleus x1, Nucleus x2){
		double fusionRate = 0;
		int z1 = x1.atomicNumber, z2 = x2.atomicNumber;
		double a1 = x1.massNumber, a2 = x2.massNumber, combinedMass = (a1 * a2) / (a1 + a2);
		double kineticEnergy = //finds kinetic energy of gas before reaction
				Math.pow(0.25 * Math.pow(Math.E, 2) * z1 * z2 * Constants.BOLTZMANN_CONSTANT.getValue() * temperature, (2/3)) *
				Math.pow(combinedMass * 0.5, (1/3));
		double 


		return fusionRate;
	}

	
}
