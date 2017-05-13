package core;

public class Fusion {

	public static double getFusionRate(double temperature, Nucleus x1, Nucleus x2){
		double fusionRate = 0;
		int z1 = x1.atomicNumber, z2 = x2.atomicNumber;
		double a1 = x1.massNumber, a2 = x2.massNumber, combinedMass = (a1 * a2) / (a1 + a2);
		double kineticEnergy = 
				Math.pow(0.25 * Math.pow(Math.E, 2) * z1 * z2 * Constants.BOLTZMANN_CONSTANT.getValue() * temperature, (2/3)) *
				Math.pow(combinedMass * 0.5, (1/3));
		double s, ds, d2s;

		if (z1 == 1 && z2 == 1) {
			s = 4.01E-22;
			ds = 4.49E−24;
		}
		if (z1 == 2 && z2 == 1 || z1 == 1 && z2 == 2){
			s = 2.14E−4;
			ds = 5.56E−6;
			d2s = 9.3E−9;
		}
		if (z1 == 3 && z2 == 3){
			s = 5.21E3;
			ds = −4.9;
			d2s = 2.2E−2;
		}

		double sTotal = s * (1 + (5 * Constants.BOLTZMANN_CONSTANT.getValue() * temperature / (36 * kineticEnergy)))


		return fusionRate;
	}

}
