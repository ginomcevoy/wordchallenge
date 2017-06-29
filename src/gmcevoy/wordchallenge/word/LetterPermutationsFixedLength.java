package gmcevoy.wordchallenge.word;

import java.util.Set;
import java.util.TreeSet;

public class LetterPermutationsFixedLength implements ILetterPermutations {

	@Override
	public Set<String> permuteLetters(String word) {
		Set<String> permutations = new TreeSet<>();
		permutationsFixedSize("", word, permutations);
		return permutations;
	}

	// adapted from http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
	private void permutationsFixedSize(String prefix, String str, Set<String> result) {
	    int n = str.length();
	    if (n == 0) {
	    	result.add(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++)
	        	permutationsFixedSize(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), result);
	    }
	}
	
	

}
