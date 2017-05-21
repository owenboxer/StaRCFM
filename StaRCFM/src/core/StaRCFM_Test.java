package core;

public class StaRCFM_Test {

	public static Nucleus nucleus[] = new Nucleus[6]; //change to number of rows
	public static double timeInterval = 1, time;

	public static double starMass = 1.989E30;
	public static double starRadius = 6.957E8;
	public static double coreTemperature = 1.5E7;

	public static int resolution = 100; //defines number of layers
	public static StarLayer[] starLayer = new StarLayer[resolution]; // layers are defined such that kg/m^2 is constant

	public static void main(String[] args) {
		String[] packedNucleus;

		packedNucleus = util.FileHandler.readFile("res/nuclei.txt"); //create nuclei
		for (int line = 0; line < packedNucleus.length - 1; line++)
			nucleus[line] = new Nucleus(packedNucleus[line + 1]);

		for (int l = 0; l < resolution; l++){
			starLayer[l] = new StarLayer()
		}
		runSimulation();
	}
	public static void runSimulation(){
		StarLayer star = new StarLayer();
		for (time = 0; time < 10000000; time++){
			star.getRates();
			star.calcRelativeDensity();
			star.calcEnergy();
		}
	}

	public void calcPressure(){
		/* Calculates "initial conditions" pressure based on density, first assuming the star has a uniform density. Then densities are 
		 * recalculated using previously calculated pressures. This process is repeated until the pressure gradient is at equilibrium with 
		 * the density gradient.
		 */
		double corePressure = (3 * Constants.GRAVITATIONAL_CONSTANT.value * Math.pow(starMass, 2)) / (8 * Math.PI * Math.pow(starRadius, 4));

		double pressure[] = new double[resolution];
		for (int l = 0; l < resolution; l++)
			pressure[l] = corePressure * Math.exp()
	}
}

