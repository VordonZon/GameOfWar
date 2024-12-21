package gameOfWar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> deck = new ArrayList<Card>();
	private String[] suitNames = {"Clubs","Diamonds","Hearts","Spades"};
	
	//Loops through all 52 cards and sets correct values and suit per card
	public Deck() {
		int totalSuits = 4;
		int cardsPerSuit = 13;
		for(int suitNum = 0; suitNum < totalSuits; suitNum++) {
			for(int cardNum = 1; cardNum <= cardsPerSuit; cardNum++) {
				String[] cardInfo = getCardTypeAndValue(cardNum);
				
				Card card = new Card();
				card.setCardName(cardInfo[0],suitNames[suitNum]);
				card.setCardValue(Integer.parseInt(cardInfo[1]));
				
				deck.add(card);
			}
		}
	}
	
	//Shuffles Deck
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card draw() {
		Card topCard = deck.get(0);
		deck.remove(0);
		return topCard;
	}
	
	//makes getCardTypeAndValue many lines of code shorter
	private String[] setValues(String name, String num) {
		String[] value = {name,num};
		return value;
	}
	private String[] getCardTypeAndValue(int cardNum) {
		switch (cardNum) {
			case 1: 
				return setValues("Ace","14");
			case 2:
				return setValues("Two","2");
			case 3:
				return setValues("Three","3");
			case 4:
				return setValues("Four","4");
			case 5:
				return setValues("Five","5");
			case 6:
				return setValues("Six","6");
			case 7:
				return setValues("Seven","7");
			case 8:
				return setValues("Eight","8");
			case 9:
				return setValues("Nine","9");
			case 10:
				return setValues("Ten","10");
			case 11:
				return setValues("Jack","11");
			case 12:
				return setValues("Queen","12");
			case 13:
				return setValues("King","13");
			default:
				return setValues("","");
		}
	}
	

	
	
	
	/*
	 *  i.     Fields

                         1.     cards (List of Card)

               ii.    Methods

                         1.     shuffle (randomizes the order of the deck)

                         2.     draw (removes and returns the top card of the deck field)

                         3.     In the constructor, when a new Deck is instantiated, the deck field should be populated with the standard 52 cards.
	 */
}
