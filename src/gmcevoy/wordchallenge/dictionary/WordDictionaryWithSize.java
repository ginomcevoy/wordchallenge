package gmcevoy.wordchallenge.dictionary;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import gmcevoy.wordchallenge.word.ILetterPermutations;
import gmcevoy.wordchallenge.word.LetterPermutationsFixedLength;
import gmcevoy.wordchallenge.word.LetterPermutationsVariableLength;
import gmcevoy.wordchallenge.word.WordsBySize;

public class WordDictionaryWithSize implements WordDictionary {

	private final DictionaryRepository repo;
	TreeMap<String, Integer> treeDictByWord;
	TreeMap<Integer, List<String>> treeDictBySize;
	
	public WordDictionaryWithSize(DictionaryRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public void initialize() {
		this.treeDictByWord = new TreeMap<>();
		List<String> words = this.repo.read();
		for (String word : words) {
			this.treeDictByWord.put(word, word.length());
		}
	}
	
	@Override
	public boolean hasWord(String word) {
		return treeDictByWord.containsKey(word);
	}

	@Override
	public WordsBySize findWordsWithLettersInWord(String word) {
		// we find all possible words in the dictionary, and let WordsBySize sort
		// the words by size
		Set<String> allPossibleCombinations = 
				new LetterPermutationsVariableLength().permuteLetters(word);
		
		List<String> wordsInDictionary = 
				allPossibleCombinations.stream()
				.filter(aWord -> this.hasWord(aWord))
				.collect(Collectors.toList());
		
		return new WordsBySize(wordsInDictionary);
	}
	
}
