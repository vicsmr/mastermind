package classes;

import java.util.Random;

import enums.Color;

public class SecretCombination extends Combination {
	
	private final String AVAILABLE_COLORS = "rbygop";

	SecretCombination() {
		super();
		
		String alphabet = AVAILABLE_COLORS;
	    int alphabetLength = alphabet.length();

	    Random r = new Random();

	    for (int i = 0; i < COMBINATION_LENGTH; i++) {
	    	int randomNumber = r.nextInt(alphabetLength);
	    	String randomValue = String.valueOf(alphabet.charAt(randomNumber));
	    	colors.add(Color.valueOfLabel(randomValue));
	    	StringBuilder alphabetBuilder = new StringBuilder(alphabet);
	    	alphabetBuilder.deleteCharAt(randomNumber);
	    	alphabet = alphabetBuilder.toString();
	    	alphabetLength--;
	    }
	}
	
	public void calculateResult(ProposedCombination proposedCombination) {
		int deads = 0;
		int damaged = 0;
		for (int colorPosition = 0; colorPosition < colors.size(); colorPosition++) {
			deads += proposedCombination.contains(colors.get(colorPosition), colorPosition) ? 1 : 0;
			damaged += !proposedCombination.contains(colors.get(colorPosition), colorPosition) && 
						proposedCombination.contains(colors.get(colorPosition)) ? 1 : 0;
		}
		Result result = new Result(deads, damaged);
		proposedCombination.set(result);
	}
	
	public void write() {
		System.out.println("****");
	}
}
