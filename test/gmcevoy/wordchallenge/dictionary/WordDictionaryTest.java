package gmcevoy.wordchallenge.dictionary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gmcevoy.wordchallenge.word.WordsBySize;

public class WordDictionaryTest {
	
	private WordDictionary dict;
	
	@Before
	public void setUp() {
		this.dict = new WordDictionaryWithSize(
				new DictionaryRepositoryTextFile("resources/dictionary_example.txt"));
		this.dict.initialize();
	}
	
	@Test
	public void testWordInDictionary() {
		String word = "ample";
		assertTrue(this.dict.hasWord(word));
	}
	
	@Test
	public void testWordNotInDictionary() {
		String word = "missing";
		assertFalse(this.dict.hasWord(word));
	}

	@Test
	public void testFindSingleWordWithLettersInWord() {
		String word = "max";
		WordsBySize words = this.dict.findWordsWithLettersInWord(word);
		assertNotNull(words);
		assertEquals(1, words.totalSize());
	}
	
	@Test
	public void testAlllWordsWithLettersInWord() {
		String word = "plea";
		WordsBySize words = this.dict.findWordsWithLettersInWord(word);
		assertNotNull(words);
		assertEquals(4, words.totalSize());
		assertTrue(words.hasWord("ape"));
		assertTrue(words.hasWord("pea"));
		assertTrue(words.hasWord("plea"));
		assertTrue(words.hasWord("leap"));
		
		assertEquals(2, words.wordsInGroup(3).size());
		assertEquals(2, words.wordsInGroup(4).size());
	}
}
