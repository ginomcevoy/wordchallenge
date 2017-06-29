package gmcevoy.wordchallenge.word;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class LetterCombinationsTest {

	private LetterCombinations combinations;

	@Before
	public void setUp() {
		this.combinations = new LetterCombinations();
	}

	@Test
	public void testCombinationsOfTwoLettersWithLength1() {
		String twoLetters = "ab";
		Set<String> result = combinations.findCombinationsGivenLength(twoLetters, 1);
		assertEquals(2, result.size());
		assertTrue(result.contains("a"));
		assertTrue(result.contains("b"));
	}

	@Test
	public void testCombinationsOfTwoLettersWithLength2() {
		String twoLetters = "ab";
		Set<String> result = combinations.findCombinationsGivenLength(twoLetters, 2);
		assertEquals(1, result.size());
		assertTrue(result.contains("ab"));
	}

	@Test
	public void testCombinationsOfThreeLettersWithLength2() {
		String threeLetters = "abc";
		Set<String> result = combinations.findCombinationsGivenLength(threeLetters,  2);
		assertEquals(3, result.size());
		assertTrue(result.contains("ab"));
		assertTrue(result.contains("bc"));
		assertTrue(result.contains("ac"));
	}
	
	@Test
	public void testCombinationsOfFourLettersWithLength2() {
		String fourLetters = "abcd";
		Set<String> result = combinations.findCombinationsGivenLength(fourLetters,  2);
		assertEquals(6, result.size());
		assertTrue(result.contains("ab"));
		assertTrue(result.contains("ac"));
		assertTrue(result.contains("ad"));
		assertTrue(result.contains("bc"));
		assertTrue(result.contains("bd"));
		assertTrue(result.contains("cd"));
	}

}
