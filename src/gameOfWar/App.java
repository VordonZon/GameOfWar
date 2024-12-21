package gameOfWar;

public class App {
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		
		deck.shuffle();
		dealCards(deck,player1,player2);
		
		player1.describe();
		player2.describe();
		
		System.out.println();
		
		//Plays all turns of the game
		for (int num = 1; num <= 26; num++) {
			playTurn(player1,player2);
		}
		
		//finds winner or draw
		if (player1.getScore() > player2.getScore()) {
			printWinner(player1.getName(), player1, player2);
		} else {
			printWinner(player2.getName(), player1, player2);
		}
	}
	
	public static void printWinner(String winner, Player player1, Player player2) {
		System.out.println();
		System.out.println("              WINNER: " + winner + "!");
		System.out.println("--------------------------------------------");
		System.out.println(player1.getName() + "'s Score: " + player1.getScore() + "   " + player2.getName() + "'s Score: " + player2.getScore());
		System.out.println("--------------------------------------------");
	}
	private static void dealCards(Deck deck,Player player1,Player player2) {
		for (int num = 1; num <= 52; num++) {
			//player1 first
			if (!(num % 2 == 0)) {
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}
	}
	
	//each player flips their card and this logic compares cards and awards points
	private static void playTurn(Player player1,Player player2) {
		Card p1Card = player1.flip();
		Card p2Card = player2.flip();
		String whoWonRound = null;
		
		if (p1Card.getCardValue() == p2Card.getCardValue() ) {
			//Draw. Neither player gets the point
			System.out.println(String.format("%45s","Draw!  No points awarded."));
			
		} else if(p1Card.getCardValue() > p2Card.getCardValue()) {
			//Award player1 the point
			whoWonRound = player1.getName();
			player1.incrementScore();
			
		} else {
			//Award player2 then point
			whoWonRound = player2.getName();
			player2.incrementScore();
		}
		
		//If there is no draw, print comparisons
		if (!(p1Card.getCardValue() == p2Card.getCardValue())) {
			System.out.println(whoWonRound + " Won     " +
					"P1: " + String.format("%-6s", p1Card.getType()) + ": " + String.format("%-2s", p1Card.getCardValue()) + "     VS     " + 
					 String.format("%2s", p2Card.getCardValue()) + " :" + String.format("%6s" , p2Card.getType()) + " :P2" );
		}
	}
	
}
