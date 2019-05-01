package com.itbuzzpress.cdi.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import com.itbuzzpress.cdi.model.Word;

@ApplicationScoped
public class WordInventory {

	private List<Word> listWords = new ArrayList();

	public void addWord(@Observes Word word) {
		System.out.println("Added new anagram " + word.getAnagram());
 
		listWords.add(word);

	}
	
}