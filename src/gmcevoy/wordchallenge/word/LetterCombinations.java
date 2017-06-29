package gmcevoy.wordchallenge.word;

import java.util.Set;
import java.util.TreeSet;

public class LetterCombinations {

	public Set<String> findCombinationsGivenLength(String word, int length) {
		Set<String> result = new TreeSet<>();
		letterCombinations("", word, length, result);
		return result;
	}
	
	private void letterCombinations(String prefix, String str, int remainingLetters, Set<String> result) {
		if (remainingLetters == 0) {
			result.add(prefix);
		} else if (str.length() == remainingLetters) {
			result.add(prefix + str);
		} else {
			for (int i = 0; i <= str.length() - remainingLetters; i++) {
				letterCombinations(prefix + str.charAt(i), str.substring(i+1, str.length()), remainingLetters - 1, result);
			}
		}
	}
}
