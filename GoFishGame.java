package gofish_assn;

public class GoFishGame {
	Deck deck = new Deck(); //create new deck
	
	Player player1 = new Player("P1"); //add two players, P1 goes first 
	Player player2 = new Player("P2");
	
	boolean turn = true; //tracks which player's turn it is, t= p1, f=p2
	public GoFishGame() {
		deck.shuffle(); //shuffle deck 
		
		for(int i=0; i<7; i++) { //each player draws 7 cards
			player1.addCardToHand(deck.dealCard());
			player2.addCardToHand(deck.dealCard());
		}
		
		while(/*(player1.getBookSize() + player2.getBookSize() < 53) && */ deck.getSize() > 0){ //play until all 26 books made 
			
			if(turn == true) {
				while(player1.checkHandForBook()) { //P1 book all present pairs 
				player1.checkHandForBook();
				}
				
				if(player1.getHandSize()>0) { //if P1 has cards in their hand
				    	Card next = new Card();  //next move 
					next = player1.chooseCardFromHand();
					
						if(player2.rankInHand(next)) { //if player2 has card 
							String s = "P2 says - Yes. I have a " + next.getRank();
							System.out.println(s);	
							player1.addCardToHand(player2.findRankCard(next));
							player1.checkHandForBook(); //check for book
							turn = true; //if p1 gets card from p2 p1 goes again
						}
						
						else { //go fish 
							if(deck.getSize() > 0) {
							String s = "P2 says - Go Fish";
						 	System.out.println(s);	
						 	Card goFish = new Card();
						 	goFish = deck.dealCard();
							player1.addCardToHand(goFish);
							s = "P1 draws " + goFish.toString();
							System.out.println(s);	
							turn = false;
								if(player1.checkHandForBook()) { //if book made, P1 goes again
								player1.checkHandForBook(); 
								turn = true;
								}
								else {
									turn = false;  
								}
							}
						}
				}
				else {									//if P1 has no cards in their hand, draw card
						if(deck.getSize() > 0) {
							String s = "P2 says - Go Fish";
						 	System.out.println(s);	
						 	Card goFish = new Card();
						 	goFish = deck.dealCard();
							player1.addCardToHand(goFish);
							s = "P1 draws" + goFish.toString();
							System.out.println(s);	
								if(player1.checkHandForBook()) { //if book made, P1 goes again
									player1.checkHandForBook(); 
									turn = true;
								}
								else {
									turn = false;  
								}
						}
					}
				} // p1 turn if loop end 
				
			if(turn == false) {
				while(player2.checkHandForBook()) { //P2 book all present pairs 
					player2.checkHandForBook();
				}
					
					if(player2.getHandSize() > 0) { //if P2 has cards in their hand
					    	Card next = new Card();  //next move 
						next = player2.chooseCardFromHand();
						
							if(player1.rankInHand(next)) { //if player2 has card 
								String s = "P1 says - Yes. I have a " + next.getRank();
								System.out.println(s);	
								player2.addCardToHand(player1.findRankCard(next));
								player2.checkHandForBook(); //check for book
								turn = false; //p2 go again if steal card from p1 
							}
							
							else { //go fish 
								if(deck.getSize() > 0) {
								String s = "P1 says - Go Fish";
							 	System.out.println(s);	
							 	Card goFish = new Card();
							 	goFish = deck.dealCard();
								player2.addCardToHand(goFish);
								s = "P2 draws " + goFish.toString();
								System.out.println(s);	
									if(player2.checkHandForBook()) { //if book made, P2 goes again
										player2.checkHandForBook(); 
										turn = false;
									}
									else {
										turn = true;  
									}
								}
							}
					}
					else {									//if P2 has no cards in their hand, draw card
							if(deck.getSize() > 0) {
								String s = "P1 says - Go Fish";
							 	System.out.println(s);	
							 	Card goFish = new Card();
							 	goFish = deck.dealCard();
								player2.addCardToHand(goFish);
								s = "P2 draws " + goFish.toString();
								System.out.println(s);	
									if(player2.checkHandForBook()) { //if book made, P2 goes again
										player2.checkHandForBook(); 
										turn = false;
									}
									else {
										turn = true;  
									}
								}
					}
			}
		} //closes BIG while loop (cont. until 26 pairs in book)
		
		if(player1.getBookSize() > player2.getBookSize()) {
			String s = player1.getName() + " wins with " + player1.getBookSize()/2 + " booked pairs.";
			System.out.println(s);
			System.out.println(player1.bookToString());
			//System.out.println(player2.bookToString());
		}
		else if(player1.getBookSize() == player2.getBookSize()) {
			String s = player1.getName() + player1.getName() + " are tied with " + player1.getBookSize()/2 + " booked pairs each.";
			System.out.println(s);
			s = player1.getName() + "'s Pairs:";
			System.out.println(s);
			System.out.println(player1.bookToString());
			s = player2.getName() + "'s Pairs:";
			System.out.println(s);
			System.out.println(player2.bookToString());
		}
		else {
			String s = player2.getName() + " wins with " + player2.getBookSize()/2 + " booked pairs.";
			System.out.println(s);
			System.out.println(player2.bookToString());
			//System.out.println(player1.bookToString());
		}
		//use to debug number of books 
		//System.out.println(player1.bookToString());
	    //System.out.println(player2.bookToString());
	}
}
		
	

	

