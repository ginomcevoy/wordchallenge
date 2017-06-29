package gmcevoy.wordchallenge.word;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Represents groupings of words. The words are grouped by size.
 * Instances are immutable.
 * 	
 * @author Giacomo
 *
 */
public class WordsBySize {

	private final TreeMap<Integer, Set<String>> groupedWords;
	
	public WordsBySize(List<String> words) {
		this.groupedWords = new TreeMap<>();
		initializeFromList(words);
	}
	
	public WordsBySize(TreeMap<Integer, Set<String>> groupedWords) {
		this.groupedWords = groupedWords;
	}
	
	private void initializeFromList(List<String> words) {
		for (String word : words) {
			int wordLength = word.length();
			if (!this.groupedWords.containsKey(wordLength)) {
				this.groupedWords.put(wordLength, new TreeSet<>());
			}
			this.groupedWords.get(wordLength).add(word);
		}
	}
	
	public int totalSize() {
		int totalSize = 0;
		for (Set<String> wordsInGroup : this.groupedWords.values()) {
			totalSize += wordsInGroup.size();
		}
		return totalSize;
	}

	public Set<String> wordsInGroup(int wordLength) {
		if (!this.groupedWords.containsKey(wordLength)) {
			return Collections.emptySet();
		}
		return Collections.unmodifiableSet(this.groupedWords.get(wordLength));
	}
	
	public boolean hasWord(String word) {
		if (!this.groupedWords.containsKey(word.length())) {
			return false;
		}
		return this.groupedWords.get(word.length()).contains(word);
	}
}
