package core;

public class StaRCFM_Test {

	public static Nucleus nucleus[] = new Nucleus[6]; //change to number of rows
	public static double timeInterval = 1;

	public static void main(String[] args) {
		String[] packedNucleus;

		packedNucleus = util.FileHandler.readFile("StaRCFM/res/nuclei.txt"); //create nuclei
		for (int line = 0; line < packedNucleus.length - 1; line++)
			nucleus[line] = new Nucleus(packedNucleus[line + 1]);

		runSimulation();
	}
	public static void runSimulation(){
		Star star = new Star();
		for (int i = 0; i < 100; i++){
			star.getRates();
			star.calcProportion();
		}
	}
}

