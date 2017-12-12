package org.yaichenia.ua;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import ua.org.yaichenia.application.Model;

public class TestModel {

	private static Model model;
	private static Map<Integer, List<Integer[]>> testInputAndCombinations;
	
	@BeforeClass
	public static void initInputAndCombinations() {
		testInputAndCombinations = new HashMap<>();
		
		Integer testInput = 13;
		List<Integer[]> testCombinations = new ArrayList<>();
		
		testCombinations.add(new Integer[] {1, 0, 1, 1});
		testCombinations.add(new Integer[] {1, 0, 0, 3});
		testCombinations.add(new Integer[] {0, 2, 1, 1});
		testCombinations.add(new Integer[] {0, 2, 0, 3});
		testCombinations.add(new Integer[] {0, 1, 4, 0});
		testCombinations.add(new Integer[] {0, 1, 3, 2});
		testCombinations.add(new Integer[] {0, 1, 2, 4});
		testCombinations.add(new Integer[] {0, 1, 1, 6});
		testCombinations.add(new Integer[] {0, 1, 0, 8});
		testCombinations.add(new Integer[] {0, 0, 6, 1});
		testCombinations.add(new Integer[] {0, 0, 5, 3});
		testCombinations.add(new Integer[] {0, 0, 4, 5});
		testCombinations.add(new Integer[] {0, 0, 3, 7});
		testCombinations.add(new Integer[] {0, 0, 2, 9});
		testCombinations.add(new Integer[] {0, 0, 1, 11});
		testCombinations.add(new Integer[] {0, 0, 0, 13});
		
		testInputAndCombinations.put(testInput, testCombinations);
	}
	
	@BeforeClass
	public static void initModel(){
		model = new Model();
	}
	
	@Test
	public void testCalculatePossibleCombinations() {
		int testInputVolume = 13;
		model.setInputVolume(testInputVolume);
		model.calculatePossibleCombinations();
		
		List<Integer[]> modelCombinations = model.getPossibleCombinations();
		List<Integer[]> testCombinations = testInputAndCombinations.get(testInputVolume);
		int modelCombiantionListSize = modelCombinations.size();
		
		Integer[] modelArray;
		Integer[] testArray;
		
		for (int i = 0; i < modelCombiantionListSize; i++) {
			modelArray = modelCombinations.get(i);
			testArray = testCombinations.get(i);
			for (int j = 0; j < modelArray.length; j++) {
				assertEquals(modelArray[j], testArray[j]);
			}
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputVolumeOnUpperLimit() throws IllegalArgumentException { 
		int testInputGreaterThanUpperLimit = 220;
		model.setInputVolume(testInputGreaterThanUpperLimit);
		model.calculatePossibleCombinations();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputVolumeOnLowerLimit() throws IllegalArgumentException {
		int testInputLessThanLowerLimit = 2;
		model.setInputVolume(testInputLessThanLowerLimit);
		model.calculatePossibleCombinations();
	}
}