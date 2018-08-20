package gofish_assn;

public class Card {
	
	public enum Suits {club, diamond, heart, spade};
	
	final static int TOP_RANK = 13; //King
	final static int LOW_RANK = 1; //Ace
	
	private int rank;  //1 is an Ace
	private Suits suit;
	
	public Card() { //default constructor 
		rank = 1;
		suit = Suits.spade;
	}
	
	public Card(int r, char s) {
		rank = r;
		suit = toSuit(s);
	}
	
	public Card(int r, Suits s) {
		rank = r;
		suit = s;
	}
	
	private Suits toSuit(char c) {
		if(c == 's') {
			return Suits.spade; 
		}
		else if(c == 'd') {
			return Suits.diamond; 
		}
		else if(c == 'h') {
			return Suits.heart; 
		}
		
	    return Suits.club; 
	}
	
	private String suitToString(Suits s)
	{
		if(s == Suits.spade) {
				return "s"; //dummy
		}
		else if(s == Suits.diamond) {
			return "d"; //dummy
		}
		else if(s == Suits.heart) {
			return "h"; //dummy
		}
		return "c";
	}
	
	private String rankToString(int r)
	{	
		if(r<= 10 && r>= 2) {
			return "" + r;
		}
		else if(r==1) {
		return "A"; //dummy
		}
		else if(r==13) {
			return "K";
		}
		else if(r==12) {
			return "Q";
		}
		else return "J";
	}
		
	
	public int getRank() {
		return rank;
	}
	
	public Suits getSuit() {
		return suit;
	}
	
	public String toString() {
		String s = "";
		
		s = s + rankToString(getRank()) + suitToString(getSuit());
		
		return s;
	}
	
	public String letterRank() {
		String s = "";
		
		s = s + rankToString(getRank());
		
		return s;
	}
	
}
