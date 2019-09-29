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
			while (isNewGame || (!proposedPlayer.isWinner() && !proposedPlayer.isLoser())) {
				isNewGame = false;
				secretPlayer.prepare();
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
			String optionInput = "";
			Scanner scanner;
			while (!optionInput.equals(YES) && !optionInput.equals(NO)) {
				System.out.print("Do you want to continue? (s/n): ");
				scanner = new Scanner(System.in);
				optionInput = scanner.nextLine();
			}
			isNewGame = optionInput.equals(YES);
		}
	}

}
