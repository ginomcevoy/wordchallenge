package gmcevoy.wordchallenge.word;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class LetterPermutationsVariableLengthTest {

	private ILetterPermutations permutations;
	
	@Before
	public void setUp() throws Exception {
		permutations = new LetterPermutationsVariableLength();
	}

	@Test
	public void testThreeLettersMakesSetThatContainsFifteenWords() {
		String threeLetters = "abc";
		Set<String> result = permutations.permuteLetters(threeLetters);
		assertEquals(15, result.size());
		assertTrue(result.contains("a"));
		assertTrue(result.contains("b"));
		assertTrue(result.contains("c"));
		assertTrue(result.contains("ab"));
		assertTrue(result.contains("ba"));
		assertTrue(result.contains("bc"));
		assertTrue(result.contains("cb"));
		assertTrue(result.contains("ac"));
		assertTrue(result.contains("ca"));
		assertTrue(result.contains("abc"));
		assertTrue(result.contains("acb"));
		assertTrue(result.contains("bca"));
		assertTrue(result.contains("bac"));
		assertTrue(result.contains("cab"));
		assertTrue(result.contains("cba"));
	}
}
