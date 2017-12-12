package ua.org.yaichenia.application;

import java.util.ArrayList;
import java.util.List;

/* The class encapsulates model of task solution. The model is independent from controller an view layers.
 * After creating of its instance you should set input volume in predetermined range. After that you have to call
 * method calculatePossibleCombinations() whereupon you can get possible combinations from field possibleCombinations
 * by calling method getPossibleCombinations(). If you go beyond the limits of input volume then IllegalArgumentException
 * in method calculatePossibleCombinations() will be thrown. Also you can get total count of possible combination through corresponding
 * getter after calling calculatePossibleCombinations().
 */
public class Model {
	
	public final static int[] RESERVOIR_VOLUMES = {10, 5, 2, 1};
	public final static int LOWER_LIMIT_OF_INPUT_VOLUME = 10;
	public final static int UPPER_LIMIT_OF_INPUT_VOLUME = 200;
	private int inputVolume;
	private int totalCountOfPossibleCombinations;
	
	/* Every possible combination stores as array of Integer, number of ten liters
	 * reservoir in array[0], five liters in array[1], two liters in array[2] and one liter in array[3].
	 */
	private List<Integer[]> possibleCombinations = new ArrayList<Integer[]>(); 
	
	public Model() {
		
	}
	
	public Model(int inputVolume) {
		this.inputVolume = inputVolume;
	}
	
	public List<Integer[]> getPossibleCombinations() {
		return possibleCombinations;
	}
	
	public int getTotalCountOfPossibleCombinations() {
		return totalCountOfPossibleCombinations;
	}
	
	public void setInputVolume(int inputVolume) {
		this.inputVolume = inputVolume;
	}
	
	public int getInputVolume() {
		return inputVolume;
	}
	
	public void calculatePossibleCombinations() {
		if (inputVolume < LOWER_LIMIT_OF_INPUT_VOLUME || inputVolume > UPPER_LIMIT_OF_INPUT_VOLUME) {
			throw new IllegalArgumentException();
		}
		this.possibleCombinations.clear();
		int copyOfInputVolume = inputVolume;
		int resultOfTotalCount = 0;
		int changeForFiveLitresReservoir, changeForTwoLitresReservoir, changeForOneLitreReservoir;
		
		for (int numberOfTenLitresReservoirsInResult = copyOfInputVolume / RESERVOIR_VOLUMES[0];
				numberOfTenLitresReservoirsInResult >= 0; numberOfTenLitresReservoirsInResult--) {
			changeForFiveLitresReservoir = copyOfInputVolume - numberOfTenLitresReservoirsInResult * RESERVOIR_VOLUMES[0];
			for (int numberOfFiveLitresReservoirsInResult = changeForFiveLitresReservoir / RESERVOIR_VOLUMES[1];
					numberOfFiveLitresReservoirsInResult >= 0; numberOfFiveLitresReservoirsInResult--) {
				changeForTwoLitresReservoir = changeForFiveLitresReservoir 
						- numberOfFiveLitresReservoirsInResult * RESERVOIR_VOLUMES[1];
				for (int numberOfTwoLitresReservoirsInResult = changeForTwoLitresReservoir / RESERVOIR_VOLUMES[2];
						numberOfTwoLitresReservoirsInResult >= 0; numberOfTwoLitresReservoirsInResult--) {
					changeForOneLitreReservoir = changeForTwoLitresReservoir
							- numberOfTwoLitresReservoirsInResult * RESERVOIR_VOLUMES[2];
					int numberOfOneLitreReservoirsInResult = changeForOneLitreReservoir;
					Integer[] aPossibleCombination = {numberOfTenLitresReservoirsInResult, 
														numberOfFiveLitresReservoirsInResult,
														numberOfTwoLitresReservoirsInResult,
														numberOfOneLitreReservoirsInResult};
					this.possibleCombinations.add(aPossibleCombination);
					resultOfTotalCount++;
				}
			}
		}
		this.totalCountOfPossibleCombinations = resultOfTotalCount;
	}
}