package ua.org.yaichenia.application;

import java.util.Scanner;

public class Controller {
	
	private Model model;
	private View view;
	private Scanner scanner = new Scanner(System.in);
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public void processUser() {
		view.printMessage(View.INPUT_VOLUME);
		model.setInputVolume(inputIntegerValue());
		
		try {
			model.calculatePossibleCombinations();
			view.printResults(model.getInputVolume(), model.getPossibleCombinations(), model.getTotalCountOfPossibleCombinations());
		} catch (IllegalArgumentException e) {
			view.printError(View.WRONG_INPUT);
		} finally {
			scanner.close();
		}
	}
	
	private int inputIntegerValue() {
		return scanner.nextInt();
	}
}