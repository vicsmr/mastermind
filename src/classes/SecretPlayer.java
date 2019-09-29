package classes;

public class SecretPlayer {
	
	SecretCombination secretCombination;
	ProposedPlayer proposedPlayer;
	
	SecretPlayer(ProposedPlayer proposedPlayer) {
		this.proposedPlayer = proposedPlayer;
	}
	
	public void prepare() {
		secretCombination = new SecretCombination();
	}
	
	public void answer() {
		secretCombination.calculateResult(proposedPlayer.getLastProposedCombination());
	}
	
	public void write() {
		secretCombination.write();
	}

}
