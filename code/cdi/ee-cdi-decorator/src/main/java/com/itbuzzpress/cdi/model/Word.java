package com.itbuzzpress.cdi.model;

import java.io.Serializable;

public class Word  implements Serializable{
private String solution;
private String anagram;
public Word(String original, String anagram){
	 
	this.solution = original;
	this.anagram = anagram;
}
public String getSolution() {
	return solution;
}
public void setSolution(String original) {
	this.solution = original;
}
public String getAnagram() {
	return anagram;
}
public void setAnagram(String anagram) {
	this.anagram = anagram;
}

}
