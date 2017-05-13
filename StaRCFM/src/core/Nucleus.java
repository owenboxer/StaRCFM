package core;

public class Nucleus {

	public double massNumber;
	public int atomicNumber;
	public String element;
	public Nucleus(String packedNucleus){
		String subString = "";

		for (int clause = 0; clause < 2; clause++) {
			subString = packedNucleus.substring(0, packedNucleus.indexOf('\t'));
			subString.trim();
			
			switch(clause){
			case 0:
				element = subString;
				break;
			case 1:
				atomicNumber = Integer.parseInt(subString);
				break;
			case 2:
				massNumber = Double.parseDouble(subString);
			}

			packedNucleus = packedNucleus.substring(packedNucleus.indexOf('\t') + 1);
		}
	}
}
