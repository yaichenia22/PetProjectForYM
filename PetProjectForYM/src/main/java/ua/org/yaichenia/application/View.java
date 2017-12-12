package ua.org.yaichenia.application;

import java.util.List;

public class View {
	
	public static final String INPUT_VOLUME = "Введите объем: ";
	public static final String WRONG_INPUT = "Неверный ввод! Объем должен быть в диапазоне от "+ Model.LOWER_LIMIT_OF_INPUT_VOLUME
												+ " до " + Model.UPPER_LIMIT_OF_INPUT_VOLUME + " литров.";
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public void printError(String errorMessage) {
		System.err.println(errorMessage);
	}
	
	public void printResults(int inputVolume, List<Integer[]> possibleCombinations, int totalCountOfPossibleCombinations) {
		printInputVolume(inputVolume);
		System.out.println();
		printPossibleCombinations(possibleCombinations);
		System.out.println();
		printTotalCountOfPossibleCombinations(inputVolume, totalCountOfPossibleCombinations);
	}
	
	private void printInputVolume(int inputVolume) {
		System.out.println("Объем (n) = " + inputVolume);
	}
	
	private void printPossibleCombinations(List<Integer[]> possibleCombinations) {
		int numberOfCombination = 0;
		for (Integer[] localCombination : possibleCombinations) {
			numberOfCombination++;
			StringBuilder output = new StringBuilder(numberOfCombination + ") ");
			for (int i = 0; i < localCombination.length; i++) {
				String temp = localCombination[i] != 0 ? (localCombination[i]) + " по " + Model.RESERVOIR_VOLUMES[i] + "л": "";
				output.append(temp);
				if(i != localCombination.length - 1 && localCombination[i] != 0) {
					output.append(", ");
				}
			}
			System.out.println(output);
		}
	}
	
	private void printTotalCountOfPossibleCombinations(int inputVolume, int totalCountOfPossibleCombinations) {
		System.out.println("Итого, для объема (n) " + inputVolume + "л наш результат будет " + totalCountOfPossibleCombinations);
	}
}