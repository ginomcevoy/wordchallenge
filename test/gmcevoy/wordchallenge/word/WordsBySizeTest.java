package gmcevoy.wordchallenge.word;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class WordsBySizeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSingleWord() {
		WordsBySize words = new WordsBySize(Arrays.asList("single"));
		assertEquals(1, words.totalSize());
	}
	
	@Test
	public void testTwoWordsInSingleGroup() {
		WordsBySize words = new WordsBySize(Arrays.asList("one", "two"));
		assertEquals(2, words.totalSize());
		assertEquals(2, words.wordsInGroup(3).size());
		assertTrue(words.wordsInGroup(3).contains("one"));
		assertTrue(words.wordsInGroup(3).contains("two"));
	}
	
	@Test
	public void testTwoWordsInTwoGroups() {
		WordsBySize words = new WordsBySize(Arrays.asList("first", "second"));
		assertEquals(2, words.totalSize());
		assertEquals(1, words.wordsInGroup(5).size());
		assertEquals(1, words.wordsInGroup(6).size());
	}
	
	@Test
	public void testLotsOfWords() {
		WordsBySize words = new WordsBySize(Arrays.asList("one", "two", "three", "four", "five"));
		assertEquals(5, words.totalSize());
		assertTrue(words.wordsInGroup(1).isEmpty());
		assertTrue(words.wordsInGroup(2).isEmpty());
		
		assertEquals(2, words.wordsInGroup(3).size());
		assertTrue(words.wordsInGroup(3).contains("one"));
		assertTrue(words.wordsInGroup(3).contains("two"));
		
		assertEquals(2, words.wordsInGroup(4).size());
		assertTrue(words.wordsInGroup(4).contains("four"));
		assertTrue(words.wordsInGroup(4).contains("five"));
		
		assertEquals(1, words.wordsInGroup(5).size());
		assertTrue(words.wordsInGroup(5).contains("three"));
		
		assertTrue(words.wordsInGroup(6).isEmpty());
	}
	
	@Test
	public void testWordAvailability() {
		WordsBySize words = new WordsBySize(Arrays.asList("first", "second"));
		assertTrue(words.hasWord("first"));
		assertTrue(words.hasWord("second"));
		assertFalse(words.hasWord("nope"));
		assertFalse(words.hasWord("maybe"));
	}
}
