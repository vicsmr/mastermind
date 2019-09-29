package classes;

import java.util.ArrayList;
import java.util.List;

public class ProposedPlayer {
	
	private int attempts;
	private List<ProposedCombination> proposedCombinationList;
	
	private final int MAX_ATTEMPTS = 10;
	
	ProposedPlayer() {
		attempts = 0;
		proposedCombinationList = new ArrayList<ProposedCombination>();
	}
	
	public ProposedCombination getLastProposedCombination() {
		ProposedCombination proposedCombination = new ProposedCombination();
		proposedCombination.read();
		proposedCombinationList.add(proposedCombination);
		attempts++;
		return proposedCombination;
	}
	
	public void writeAttempts () {
		System.out.println(attempts + " attempt(s): ");
	}
	
	public void writeProposedCombinations() {
		for (ProposedCombination proposedCombination:proposedCombinationList) {
			proposedCombination.write();
		}
	}
	
	public boolean isWinner() {
		return proposedCombinationList.get(attempts - 1).isWinner();
	}
	
	public boolean isLoser() {
		return !proposedCombinationList.get(attempts - 1).isWinner() && attempts == MAX_ATTEMPTS;
	}
}
