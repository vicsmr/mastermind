package classes;

import java.util.Scanner;

public class Mastermind {
	
	private SecretPlayer secretPlayer;
	private ProposedPlayer proposedPlayer;
	private final String YES = "s";
	private final String NO = "n";
	
	public void play() {
		boolean isNewGame = true;
		while (isNewGame) {
			System.out.println("----- MASTERMIND -----");
			proposedPlayer = new ProposedPlayer();
			secretPlayer = new SecretPlayer(proposedPlayer);
			secretPlayer.prepare();
			while (isNewGame || (!proposedPlayer.isWinner() && !proposedPlayer.isLoser())) {
				isNewGame = false;
				secretPlayer.write();
				secretPlayer.answer();
				proposedPlayer.writeAttempts();
				proposedPlayer.writeProposedCombinations();
			}
			if (proposedPlayer.isWinner()) {
				System.out.println("You've won!!! ;-)");
			}
			if (proposedPlayer.isLoser()) {
				System.out.println("You've lost!!! :-(");
			}
			isNewGame = checkIsNewGame();
		}
	}
	
	private boolean checkIsNewGame() {
		String optionInput = "";
		Scanner scanner;
		while (!optionInput.equals(YES) && !optionInput.equals(NO)) {
			System.out.print("Do you want to continue? (s/n): ");
			scanner = new Scanner(System.in);
			optionInput = scanner.nextLine();
		}
		return optionInput.equals(YES);
	}

}
