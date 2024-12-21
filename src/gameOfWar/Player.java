package gameOfWar;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> hand = new ArrayList<>();
	private int score = 0;
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void describe() {
		System.out.println("----------------------------------------");
		System.out.println("PlayerName: " + this.name + " - Score: " + this.score + " - HandSize: " + hand.size());
		System.out.println(this.name + "'s hand: ");
		
		for (Card card : hand) {
			System.out.println("Value: " + String.format("%2s",card.getCardValue()) + " - " + card.getCardName());
		}
	}
	
	public Card flip() {
		Card topCard = hand.get(0);
		hand.remove(0);
		return topCard;
	}
	
	public void draw(Deck deck) {
		Card cardFromDeck = deck.draw();
		hand.add(cardFromDeck);
	}
	
	public void incrementScore() {
		this.score += 1;
	}
	
	public int getScore() {
		return this.score;
	}
	public String getName() {
		return this.name;
	}
}
