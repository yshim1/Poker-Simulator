package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	/* Use the @Test annotation for JUnit 4 
	 * [This is just an example, please erase
	 * it and write some real tests.]    */
//	@Test
//	public void testShuffle() {
//		Deck newDeck = new Deck();
//		newDeck.deal(17);
//		newDeck.shuffle();
//		
//		for(int i=0; i<newDeck.getNumCards();i++) {
//			System.out.println(newDeck.getCardAt(i));
//		}
//		
//	}
	@Test
	public void testHasPair() {
		Card [] cards = new Card[5];
		cards[0] = new Card(1,1);
		cards [1] = new Card (5,0);
		cards [2] = new Card (1,3);
		cards [3] = new Card (3, 1);
		cards [4] = new Card (5,2);
		assertTrue(PokerHandEvaluator.hasPair(cards) == true);
	}
	@Test 
	public void testThreeOfAKind() {
		Card[] cards = new Card[5];
		cards[0] = new Card(7,1);
		cards [1] = new Card (7,0);
		cards [2] = new Card (3,3);
		cards [3] = new Card (7, 2);
		cards [4] = new Card (11,3);
		boolean result = PokerHandEvaluator.hasThreeOfAKind(cards);
		assertTrue(result == true);
	}
	@Test 
	public void testFlush() {
		Card[] cards = new Card[5]; 
		cards [0] = new Card (7,1);
		cards[1] = new Card (9,1);
		cards [2] = new Card (12,1);
		cards [3] = new Card (1,1);
		cards [4] = new Card (2,1);
		boolean result = PokerHandEvaluator.hasFlush(cards);
		assertTrue(result == true);
	}
//	@Test
//	public void testHasFourOfAKind() {
//		Card[] cards = new Card[5]; 
//		cards [0] = new Card (1,3);
//		cards[1] = new Card (6,2);
//		cards [2] = new Card (6,0);
//		cards [3] = new Card (6,1);
//		cards [4] = new Card (6,3);
//		boolean result = PokerHandEvaluator.hasFourOfAKind(cards);
//		assertFalse(result == true);
//	}
//	@Test
//	public void testHasStraight() {
//		Card[] cards = new Card[5]; 
//		cards [0] = new Card (2,3);
//		cards[1] = new Card (3,2);
//		cards [2] = new Card (4,0);
//		cards [3] = new Card (5,1);
//		cards [4] = new Card (6,1);
//		boolean result = PokerHandEvaluator.hasStraight(cards);
//		assertTrue(result == true);
//	}
	
}

