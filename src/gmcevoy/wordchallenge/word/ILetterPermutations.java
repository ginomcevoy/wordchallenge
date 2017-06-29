package gmcevoy.wordchallenge.word;

import java.util.Set;

@FunctionalInterface
public interface ILetterPermutations {

	Set<String> permuteLetters(String word);
}
