package gmcevoy.wordchallenge.dictionary;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DictionaryRepositoryTextFileTest {

	private DictionaryRepositoryTextFile repo;
	
	@Before
	public void setUp() {
		this.repo = new DictionaryRepositoryTextFile("resources/dictionary_example.txt");
	}
	
	@Test
	public void testReadFile() {
		List<String> words = repo.read();
		assertEquals(10, words.size());
		assertTrue(words.contains("example"));
		assertTrue(words.contains("different"));
		assertFalse(words.contains("missing"));
	}

}
