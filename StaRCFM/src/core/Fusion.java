package core;

public class Fusion {

	public static double getFusionRate(double temperature, Nucleus x1, Nucleus x2, double density1, double density2){
		double fusionRate = 0;
		int z1 = x1.atomicNumber, z2 = x2.atomicNumber;
		double a1 = x1.massNumber, a2 = x2.massNumber, reducedMass = (a1 * a2) / (a1 + a2);
		double kineticEnergy = 5.678 * Math.cbrt(reducedMass * z1 * z2 * Math.pow(temperature, 2));
		double s = 0, ds = 0, d2s = 0;
		int kroneckerDelta = 0;

		if (z1 == 1 && z2 == 1) { //p(p,e+v)d
			s = 4.01E-22;
			ds = 4.49E-24;
			d2s = 0;
			kroneckerDelta = 1;
		}
		else if (z1 == 2 && z2 == 1 || z1 == 1 && z2 == 2){ //d(p,y)3-He
			s = 2.14E-4;
			ds = 5.56E-6;
			d2s = 9.3E-9;
		}
		else if (z1 == 3 && z2 == 3){ //3-He(3-He,2p)4-He
			s = 5.21E6;
			ds = -4.9;
			d2s = 2.2E-2;
			kroneckerDelta = 1;
		}

		double sTotal = (s * (1 + ((5 * temperature) / (36 * kineticEnergy)))) + 
				(ds * (1 + ((35  * temperature) / (36 * kineticEnergy)))) + 
				(d2s * (1 + ((89 * temperature) / (36 * kineticEnergy))));

		double ratio = Math.sqrt(2 / (reducedMass * temperature)) *
				((4 / 3) * Math.sqrt(kineticEnergy / (3 * temperature))) *
				sTotal * Math.exp((-3 * kineticEnergy) / (2 * temperature * 10E7));

		fusionRate = (density1 * density2 * ratio) / (1 + kroneckerDelta);
		return fusionRate;
	} 

}
