package gofish_assn;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> book = new ArrayList<Card>();
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void addCardToHand(Card c) {
		hand.add(c);
	}
	
	public Card removeCardFromHand(Card c) {
		hand.remove(c);
		return c;
	}
	
	public String getName() {
		return name;
	}
	
	public String handToString() {
		String s = new String();
		for(int i =0; i< hand.size(); i++) {
		s += " " + hand.get(i).toString();
		}
		return s;
	}
	
	public String bookToString() {
		String s = new String();
		for(int i =0; i< book.size(); i++) {
			s += " " + book.get(i).toString();
		}
		return s;
	}
	
	public int getHandSize() {
		return hand.size();
	}
	
	
	public int getBookSize() {
		return book.size();
	}
	
	
	//Here are some ideas for additional functionality that you may want/need
	//OPTIONAL
    // comment out if you decide to not use it
    //this function will check a players hand for a pair. 
    //If a pair is found, it moves the cards to the book and returns true

    public boolean checkHandForBook() {
	    	for(int i =0; i<hand.size() - 1; i++) {
	    		int j = i+1;
	    		while(j < hand.size()) {
		    		if(hand.get(i).getRank() == hand.get(j).getRank()) {
		    			book.add(hand.get(i));
		    			book.add(hand.get(j));
		    			String s = getName() + " books the " + hand.get(i).letterRank() ;//hand.get(i).getRank();
		    			System.out.println(s);
		    			hand.remove(j);
		    			hand.remove(i);
		    			return true; 
		    		}
		    	  j++;
	    		}
	    	}
	    	return false;
    }

    //OPTIONAL
    // comment out if you decide to not use it    
    //Does the player have a card with the same rank as c in her hand?
    public boolean rankInHand(Card c) {
	    for(int i =0; i < hand.size(); i++) {
	    		if(hand.get(i).getRank() == c.getRank()) {
	    			return true;
	    		}
	    }
	    return false;
    }
    
    //returns card of same rank that is in other player's hand, removes from OG player's hand 
    public Card findRankCard(Card c) {
    		Card move = new Card();
    		for(int i=0; i<hand.size(); i++) {
    			if(hand.get(i).getRank() == c.getRank()) {
    				move = hand.get(i);
    				hand.remove(i);
    			}
    		}
    		return move; 
    }
    
    //uses some strategy to choose one card from the player's
    //hand so they can say "Do you have a 4?"
    public Card chooseCardFromHand() {
	    	int nextTurn = (int) (Math.random() * hand.size()); //new index to change to 
	    	String s = getName() + " asks - Do you have a " + hand.get(nextTurn).getRank() + "?";
	    	System.out.println(s);
	    	return hand.get(nextTurn);
    }
    
    //Does the player have the card c in her hand?
    public boolean cardInHand(Card c) {
	    	for(int i=0; i< hand.size(); i++) {
	    		if(hand.get(i) == c) {
	    			return true;
	    		}
	    	}
    		return false; 
    }
    

    //OPTIONAL
    // comment out if you decide to not use it    
    //Does the player have a card with the same rank as c in her hand?
    //e.g. will return true if the player has a 7d and the parameter is 7c
    
    public boolean sameRankInHand(Card c) { //same as rankInHand??
    	return false; //stubbed
    }

}
