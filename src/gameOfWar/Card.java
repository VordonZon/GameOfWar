package gameOfWar;

public class Card {
	private int cardValue;
	private String cardName;
	private String suit;
	private String type;
	
	public int getCardValue() {
		return cardValue;
	}
	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String type, String suit) {
		this.suit = suit;
		this.type = type;
		this.cardName = type + " of " + suit;
	}

	public void describe() {
		System.out.println("Card Name: " + this.cardName + "  Card Value: " + this.cardValue);
	}
	public String getSuit() {
		return suit;
	}
	public String getType() {
		return type;
	}
}
