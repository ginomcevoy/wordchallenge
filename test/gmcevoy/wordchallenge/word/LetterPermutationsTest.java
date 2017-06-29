package gmcevoy.wordchallenge.word;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class LetterPermutationsTest {

	private LetterPermutationsFixedLength permutations;

	@Before
	public void setUp() {
		this.permutations = new LetterPermutationsFixedLength();
	}

	@Test
	public void testSingleLetterMakesSetWithSameLetter() {
		String singleLetter = "a";
		Set<String> result = permutations.permuteLetters(singleLetter);
		assertEquals(1, result.size());
		assertTrue(result.contains("a"));
	}

	@Test
	public void testTwoLettersMakesSetThatContainsTwoWordsWithTwoLetters() {
		String twoLetters = "ab";
		Set<String> result = permutations.permuteLetters(twoLetters);
		assertTrue(result.contains("ab"));
		assertTrue(result.contains("ba"));
	}

	@Test
	public void testThreeLettersMakesSetThatContainsSixWordsWithThreeLetters() {
		String twoLetters = "abc";
		Set<String> result = permutations.permuteLetters(twoLetters);
		assertTrue(result.contains("abc"));
		assertTrue(result.contains("acb"));
		assertTrue(result.contains("bca"));
		assertTrue(result.contains("bac"));
		assertTrue(result.contains("cab"));
		assertTrue(result.contains("cba"));
	}
	
	
}
