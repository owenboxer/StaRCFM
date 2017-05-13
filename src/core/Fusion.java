package core;

public class Fusion {

	public static double getFusionRate(double temperature, Nucleus x1, Nucleus x2, double density1, double density2){
		double fusionRate = 0;
		int z1 = x1.atomicNumber, z2 = x2.atomicNumber;
		double a1 = x1.massNumber, a2 = x2.massNumber, combinedMass = (a1 * a2) / (a1 + a2);
		double kineticEnergy = 
				Math.cbrt(Math.pow(0.25 * Math.pow(Math.E, 2) * z1 * z2 * Constants.BOLTZMANN_CONSTANT.getValue() * temperature, 2)) *
				Math.cbrt(combinedMass * 0.5);
		double s = 0, ds = 0, d2s = 0;
		int kroneckerDelta = 0;

		if (z1 == 1 && z2 == 1) {
			s = 4.01E-22;
			ds = 4.49E-24;
			d2s = 0;
			kroneckerDelta = 1;
		}
		if (z1 == 2 && z2 == 1 || z1 == 1 && z2 == 2){
			s = 2.14E-4;
			ds = 5.56E-6;
			d2s = 9.3E-9;
		}
		if (z1 == 3 && z2 == 3){
			s = 5.21E3;
			ds = -4.9;
			d2s = 2.2E-2;
			kroneckerDelta = 1;
		}

		double sTotal = (s * (1 + ((5 * Constants.BOLTZMANN_CONSTANT.getValue() * temperature) / (36 * kineticEnergy)))) + 
				(ds * (1 + ((35 * Constants.BOLTZMANN_CONSTANT.getValue() * temperature) / (36 * kineticEnergy)))) + 
				(d2s * (1 + ((89 * Constants.BOLTZMANN_CONSTANT.getValue() * temperature) / (36 * kineticEnergy))));

		double ratio = Math.sqrt(2 / (combinedMass * Constants.BOLTZMANN_CONSTANT.getValue() * temperature)) *
				((4 / 3) * Math.sqrt(kineticEnergy / (3 * Constants.BOLTZMANN_CONSTANT.getValue() * temperature))) *
				sTotal * Math.pow(Math.E, ((-3 * kineticEnergy) / (Constants.BOLTZMANN_CONSTANT.getValue() * temperature)));
		System.out.println(Constants.BOLTZMANN_CONSTANT.getValue());

		fusionRate = (density1 * density2 * ratio) / (1 * kroneckerDelta);
		return fusionRate;
	}

}
