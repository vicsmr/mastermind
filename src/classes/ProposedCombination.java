package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.Color;

public class ProposedCombination extends Combination {

	private Result result;
	
	ProposedCombination() {
		super();
		result = new Result(0, 0);
	}
	
	public void read() {
		boolean combinationIsWrong = true;
		String textInput = "";
		Scanner scanner;
		while(combinationIsWrong) {
			colors = new ArrayList<Color>();
			combinationIsWrong = false;
			System.out.print("Propose a combination: ");
			scanner = new Scanner(System.in);
			textInput = scanner.nextLine();
			String[] colorsListInput = textInput.split("");
			combinationIsWrong = checkAndLoadValidCombination(colorsListInput, combinationIsWrong);
		}
	}
	
	private boolean checkAndLoadValidCombination(String[] colorsListInput, boolean combinationIsWrong) {
		if (colorsListInput.length != COMBINATION_LENGTH) {
			System.out.println("Wrong proposed combination length");
			return true;
		} else {
			Color actualColor;
			for (int i = 0; i < colorsListInput.length; i++) {
				actualColor = Color.valueOfLabel(colorsListInput[i]);
				colors.add(actualColor);
				if (actualColor == null) {
					System.out.println("Wrong colors, they must be: rbygop");
					return true;
				}
			}
			if (!combinationIsWrong && repeatedColors(colors, 0)) {
				System.out.println("Repeated colors");
				return true;
			}
			return false;
		}
	}
	
	private boolean repeatedColors(List<Color> combinationToGuessColors, int positionToReview) {
		for (int i = positionToReview + 1; i < combinationToGuessColors.size(); i++) {
			if (combinationToGuessColors.get(positionToReview) == combinationToGuessColors.get(i)) {
				return true;
			}
		}
		if (positionToReview == combinationToGuessColors.size() - 1) {
			return false;
		} else {
			return repeatedColors(combinationToGuessColors, positionToReview + 1);
		} 
	}
	
	public boolean contains(Color secretColor, int secretPosition) {
		return colors.get(secretPosition) == secretColor;
	}
	
	public boolean contains(Color secretColor) {
		return colors.contains(secretColor);
	}
	
	public void set(Result result) {
		this.result = result;
	}
	
	public void write() {
		for (Color color:colors) {
			System.out.print(color.toString());
		}
		System.out.print(" --> ");
		result.write();
	}
	
	public boolean isWinner() {
		return result.isWinner();
	}
}
