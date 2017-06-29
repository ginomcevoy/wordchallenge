package gmcevoy.wordchallenge.dictionary;

import gmcevoy.wordchallenge.word.WordsBySize;

public interface WordDictionary {

	void initialize();
	
	boolean hasWord(String word);
	
	WordsBySize findWordsWithLettersInWord(String word);
}
