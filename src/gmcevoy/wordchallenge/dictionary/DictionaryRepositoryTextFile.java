package gmcevoy.wordchallenge.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryRepositoryTextFile implements DictionaryRepository {

	private final String filename;
	private List<String> words;
	
	DictionaryRepositoryTextFile(String filename) {
		this.filename = filename;
	}
	
	@Override
	public List<String> read() {
		if (words == null) {
			words = readFile();
		}
		return words;
	}

	private List<String> readFile() {
		List<String> contents = new ArrayList<>();
		Scanner s;
		try {
			s = new Scanner(new File(this.filename));
			while (s.hasNextLine()) {
				contents.add(s.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return contents;
	}
}
