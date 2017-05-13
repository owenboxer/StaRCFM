package core;

public class Star {
	double temperature = 15.5E6;
	double proportion[] = new double[4], totalDensity = 153;
	double rate[] = new double[3];
	double starMass = 1.989E30;

	public Star(){
		proportion[0] = 1;
		proportion[1] = 0;
		proportion[2] = 0;
		proportion[3] = 0;
	}

	public void getRates(){
		rate[0] = Fusion.getFusionRate(temperature, StaRCFM_Test.nucleus[2], StaRCFM_Test.nucleus[2]);
		rate[1] = Fusion.getFusionRate(temperature, StaRCFM_Test.nucleus[2], StaRCFM_Test.nucleus[3]);
		rate[2] = Fusion.getFusionRate(temperature, StaRCFM_Test.nucleus[4], StaRCFM_Test.nucleus[4]);
	}

	public void calcProportion(){
		
	}
}
