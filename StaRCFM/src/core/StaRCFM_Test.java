package core;

public class StaRCFM_Test {

	public static Nucleus nucleus[] = new Nucleus[6]; //change to number of rows
	public static double timeInterval = 1, time;

	public static double starMass = 1.989E30;
	public static double starRadius = 6.957E8;
	public static double coreTemperature = 1.5E7;

	public static int resolution = 100; //defines number of layers
	public static StarLayer starLayer = new StarLayer(); // layers are defined such that kg/m^2 is constant

	public static void main(String[] args) {
		runSimulation();
	}
	public static void runSimulation(){
		for (int t = 0; t < 3000000; t++){
			starLayer.getRates();
			starLayer.calcRelativeDensity();
			starLayer.calcEnergy();
		}
			
	}

	/*public static void calcPressure(){
		/* Calculates "initial conditions" pressure based on density, first assuming the star has a uniform density. Then densities are 
		 * recalculated using previously calculated pressures. This process is repeated until the pressure gradient is at equilibrium with 
		 * the density gradient.
		 *
		double corePressure = (3 * Constants.GRAVITATIONAL_CONSTANT.value * Math.pow(starMass, 2)) / (8 * Math.PI * Math.pow(starRadius, 4));
		double uniformTemp = 3000;
		double gravitationalAcceleration[] = new double[resolution];
		double meanMolarMass = 0.5;

		for (int l = 0; l < resolution; l++) {
			starLayer[l].temperature = uniformTemp;
			starLayer[l].gasPressure = corePressure * Math.exp((-1 * Math.pow(starLayer[l].height, 2) * meanMolarMass * 
					Constants.HYDROGEN_MASS.value * Constants.GRAVITATIONAL_CONSTANT.value * starMass) / (Math.pow(starRadius, 2) * 
					Constants.BOLTZMANN_CONSTANT.value * starLayer[l].temperature));
		}

		for (int t = 0; t < 1000; t++) {
			for (int l = 0; l < resolution; l++){
				gravitationalAcceleration[l] = (Constants.GRAVITATIONAL_CONSTANT.value * starLayer[l].height * starLayer[l].gasPressure *
						meanMolarMass * Constants.HYDROGEN_MASS.value) / (3 * Constants.BOLTZMANN_CONSTANT.value * starLayer[l].temperature);
				starLayer[l].gasPressure = starLayer[0].gasPressure * Math.exp((-1 * starLayer[l].height * meanMolarMass * 
						Constants.HYDROGEN_MASS.value * gravitationalAcceleration[l]) / (Constants.BOLTZMANN_CONSTANT.value
						 * starLayer[l].temperature));
			}
			//System.out.println(gravitationalAcceleration[5]);
		}
	}*/
}

