package poker;
/*The Deck class represents a deck of cards.  It starts off with 52 cards,
but as cards are dealt from the deck, the number of cards becomes smaller.*/ 

public class Deck {
/*private instance variable that stores the Cards that are currently in the Deck:*/
	
	private Card[] cards;
/*This constructor initializes the Deck with 52 card objects, 
 * representing the 52 cards that are in a standard deck.*/
	
	public Deck() {
		cards = new Card [52];
		int count = 0;
		for(int suit = 0; suit < 4; suit++) {
			for(int value = 1; value < 14; value++) {
				cards[count] = new Card (value, suit);
				count++;
			}
		}
	}
	//Standard Copy Constructor Makes Shallow Copy
	public Deck(Deck other) {
		cards = new Card[other.getNumCards()];
		for(int i = 0; i < other.getNumCards(); i++) {
			cards[i] = other.getCardAt(i);
		}
	}
	//Returns card at position. Position represents an integer.
	public Card getCardAt(int position) {
		return cards[position];
	}
	//Gets number of Cards in object. Takes no parameters. Returns integer
	public int getNumCards() {
		return cards.length;
	}
//This method will re-arrange the cards that are in the deck.  The idea is that the deck will be divided into two "packets" -- the top half and the bottom half.  The new array of cards will consist of:  the first card from the top packet, followed by the first card from the bottom packet, 
//followed by the second card from the top packet, 
//followed by the second card from the bottom packet, etc.
	public void shuffle() {
		int numberOfCards = getNumCards();
		Card [] shuffle = new Card [numberOfCards];
		Card [] top = new Card [numberOfCards/2];
		Card [] bottom = new Card [numberOfCards/2];
		if(numberOfCards % 2 == 0) {
			top = new Card[numberOfCards/2];
			bottom = new Card[numberOfCards/2];
		for(int i = 0; i < cards.length/2; i++) {
			top [i] = cards [i];
		}
		int countTwo = 0;
		for(int i = cards.length/2; i < cards.length; i++) {
			bottom [countTwo] = cards[i];
			countTwo++;
		}
		int countThird = 0; 
		int countFourth = 0;
		for(int i = 0; i < cards.length; i++) {
			if(i % 2 == 1) {
				shuffle[i] = bottom[countThird];
				countThird++;
			}
			else if (i % 2 == 0) {
				shuffle[i] = cards [countFourth];
				countFourth++;
			}
		}
		}
		if(numberOfCards % 2 == 1) {
			top = new Card [(numberOfCards/2) + 1];
			bottom = new Card[numberOfCards/2];
		}
		for(int i = 0; i < cards.length - 1; i++) {
			cards [i] = shuffle[i];
			cards[cards.length-1] = bottom[0];
			
		}
	}
	//Removes cards from top of deck to a position called position. Puts top portion to the bottom
	public void cut(int position) {
		Card [] cut = new Card [cards.length];
		Card [] temp = new Card [position];
		for(int i = 0; i < position; i++) {
			temp [i] = cards[i];
		}
		int count = 0;
		for( int i = position; i < cards.length; i++) {
			cut[count] = cards[i];
			count++;
		}
		for(int i = 0; i < cards.length - position; i++) {
			cards[i] = cut[i];
		}	
		int countTwo = 0;
		for(int i = cards.length - position; i < cards.length; i++) {
			cards[i] = temp[countTwo];
			countTwo++;
		}
	}
	//Takes in an integer and returns a card array. It will deal number of cards from top of deck
	public Card[] deal(int numCards) {
		Card [] smaller = new Card [cards.length - numCards]; 
		Card [] dealtCards = new Card [numCards];
		int count = 0;
		for(int i = numCards; i < cards.length; i++) {
			smaller [count] = cards[i];
			count++;
		}
		for( int i = 0; i < numCards; i++) {
			dealtCards[i] = cards[i];
		}
		cards = smaller;
		return dealtCards;
	}
}

