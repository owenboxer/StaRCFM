package core;

public class StarLayer {
	double temperature = 0.15;
	double relativeDensity[] = new double[4];
	double rate[] = new double[3]; //rate of 
	double totalPressure, gasPressure, radiationPressure; 
	/* gas pressure associated with ideal gas laws
	 * radiation pressure associated with outward pressure from fusion
	 */

	public StarLayer(){
		relativeDensity[0] = 1;
		relativeDensity[1] = 0;
		relativeDensity[2] = 0;
		relativeDensity[3] = 0;
	}

	public void getRates(){
		rate[0] = Fusion.getFusionRate(temperature, StaRCFM_Test.nucleus[2], StaRCFM_Test.nucleus[2], relativeDensity[0], relativeDensity[0]);
		rate[1] = Fusion.getFusionRate(temperature, StaRCFM_Test.nucleus[2], StaRCFM_Test.nucleus[3], relativeDensity[0], relativeDensity[1]);
		rate[2] = Fusion.getFusionRate(temperature, StaRCFM_Test.nucleus[4], StaRCFM_Test.nucleus[4], relativeDensity[2], relativeDensity[2]);
	}
	public void calcRelativeDensity(){
		relativeDensity[0] -= 2 * rate[0] * StaRCFM_Test.timeInterval * StaRCFM_Test.nucleus[2].massNumber;
		relativeDensity[1] += rate[0] * StaRCFM_Test.timeInterval * StaRCFM_Test.nucleus[3].massNumber;
		relativeDensity[0] -= rate[1] * StaRCFM_Test.timeInterval * StaRCFM_Test.nucleus[2].massNumber;
		relativeDensity[1] -= rate[1] * StaRCFM_Test.timeInterval * StaRCFM_Test.nucleus[3].massNumber;
		relativeDensity[2] += rate[1] * StaRCFM_Test.timeInterval * StaRCFM_Test.nucleus[4].massNumber;
		relativeDensity[0] += 2 * rate[2] * StaRCFM_Test.timeInterval * StaRCFM_Test.nucleus[2].massNumber;
		relativeDensity[2] -= 2 * rate[2] * StaRCFM_Test.timeInterval * StaRCFM_Test.nucleus[4].massNumber;
		relativeDensity[3] += rate[2] * StaRCFM_Test.timeInterval * StaRCFM_Test.nucleus[5].massNumber;

		if (StaRCFM_Test.time % 10000 == 0) System.out.println(relativeDensity[2]);
	}
	public void calcEnergy(){
		double energy = ((2 * StaRCFM_Test.nucleus[0].massNumber) + (2 * StaRCFM_Test.nucleus[1].massNumber)
				- (StaRCFM_Test.nucleus[5].massNumber)) * rate[2] * StaRCFM_Test.timeInterval * 9E16;
		//if (StaRCFM_Test.time % 3000 == 0) System.out.println(energy);
	}

	public void calcPressure(){
		
	}
}
