package gmcevoy.wordchallenge.word;

import java.util.Set;
import java.util.TreeSet;

public class LetterPermutationsVariableLength implements ILetterPermutations {

	@Override
	public Set<String> permuteLetters(String word) {
		Set<String> allPermutations = new TreeSet<>();
		Set<String> combinationsForEachSize; 
		for (int i = 1; i <= word.length(); i++) {
			// combine i letters in word
			combinationsForEachSize = new LetterCombinations().findCombinationsGivenLength(word, i);
			
			// find all permutations for each combination
			for (String combo : combinationsForEachSize) {
				Set<String> permutationsForCombination = 
						new LetterPermutationsFixedLength().permuteLetters(combo);
				allPermutations.addAll(permutationsForCombination);
			}
		}
		
		return allPermutations;
	}

}
