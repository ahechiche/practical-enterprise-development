package com.itbuzzpress.cdi.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.itbuzzpress.cdi.model.Word;
import com.itbuzzpress.cdi.qualifier.Anagram;

@SessionScoped
@Named
public class Player implements Serializable {

	@Inject @Anagram Word word;
	
	@Inject private Event<Word> wordEvent;	
	int attempt = 1;
	int maxAttempts = 5;
	private String guess;
	private boolean endgame;

	@PostConstruct
	public void init() {
		wordEvent.fire(word);
	}

	public void check() {
		if (guess.equals(word.getSolution())) {
			endgame = true;
			printMessage("You guessed! Click Restart");
		} else {
			printMessage("Wrong guess!");
			attempt++;
		}
		if (attempt == maxAttempts) {
			printMessage("You lost! Click Restart");
			endgame = true;
		}

	}

	private void printMessage(String string) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, string, string));

	}

	public void restart() {
		ExternalContext ec = FacesContext.getCurrentInstance()
				.getExternalContext();
		ec.invalidateSession();
		try {
			ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean isEndgame() {
		return endgame;
	}

	public Word getWord() {
		return word;
	}

	public int getAttempt() {
		return attempt;
	}

	public int getMaxAttempts() {
		return maxAttempts;
	}

	public String getGuess() {
		return guess;
	}

	public void setGuess(String guess) {
		this.guess = guess;
	}
}