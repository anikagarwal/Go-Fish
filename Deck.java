package gofish_assn;

import java.util.ArrayList;


import gofish_assn.Card.Suits;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card> ();
	final int NUM_CARDS = 52;  //for this kind of deck
	
	//creates a new sorted deck
	public Deck() {
		for(int i=1; i<14; i++) {
			deck.add(new Card(i, 's'));
		}
		for(int i=1; i<14; i++) {
			deck.add(new Card(i, 'd'));
		}
		for(int i=1; i<14; i++) {
			deck.add(new Card(i, 'h'));
		}
		for(int i=1; i<14; i++) {
			deck.add(new Card(i, 'c'));
		}
	}
	
	public void shuffle() { //shuffles deck
		for(int i=0; i<51; i++) {
			int newIndex = (int) (Math.random() * 51); //new index to change to 
			Card hold1 = deck.get(i); //hold previous card
			Card hold2 = deck.get(newIndex);
			deck.set(i, hold2); //swap locations of cards 
			deck.set(newIndex, hold1);
		}
	}
	
	
	public void printDeck() {
		for(int i=0; i<52; i++) {
			System.out.println(deck.get(i).toString());
		}
	}
	
	public int getSize() { //returns number of cards in deck
		int i;
		for(i=0; i<deck.size(); i++) {}
		return i;
	}
	
	public Card dealCard() { //deals (removes) top card of deck
		Card c = deck.get(0);
		deck.remove(0);
		return c;
	}
	
}
