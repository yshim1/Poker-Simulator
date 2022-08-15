package poker;
public class PokerHandEvaluator {

	//boolean return type that checks if their is a pair in the hand
	public static boolean hasPair(Card [] cards) {
		for(int i = 0; i < cards.length; i++) {
			for(int j = i + 1; j < cards.length; j++) {
				int value = cards[i].getValue();
				int pairValue = cards[j].getValue();
				if(value == pairValue && j != i) {
					return true;
				}
			}
		}
		return false;
	}
	//boolean return type that checks if there is two values that have a pair in the hand
	public static boolean hasTwoPair(Card [] cards) {
		int count = 0;
		int [] arr = new int [cards.length];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = cards[i].getValue();
		}
		for(int i = 0; i < cards.length; i++) {
			for(int j = i + 1; j < cards.length; j++) {
				if(arr [i] == arr[j] && j != i) {
					count++;
				}
			}
		}
		if(count == 2) {
			return true;
		}
		return false;
	}
	//boolean return type that checks if a value occurs 3 times
	public static boolean hasThreeOfAKind(Card [] cards) {
		int count = 0; 
		int [] arr = new int [cards.length];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = cards[i].getValue();
		}

		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length ; j++) {
				if(arr[i] == arr[j]) {
					count++;
				}
			}
			if(count < 2) {
				count = 0;
			}
			else if(count == 2) {
				return true;
			}
		}
		return false;
	}
	//boolean return type that checks if the hand has values that are consecutive
	public static boolean hasStraight(Card [] cards) {
//		int [] arr = new int [4];
//		int count = 0;
//		for(int i = 0; i < 9; i++) {
//			for(int j = i; j<= i+4 ; j++) {
//				int value = arr[i];
//				if(value == 1) {
//					count++;
//				}
//			}
//		}
//		if(count == 5) {
//			return true;
//		}
		return false;
	}
	//boolean return type that checks if all the cards have the same suit
	public static boolean hasFlush(Card [] cards) {
		int [] arr = new int [cards.length];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = cards[i].getSuit();
		}
		for(int i = 1 ; i <arr.length; i++) {
			if(arr[0] != arr[i]) {
				return false;
			}
			else {
				continue;
			}
		}
		return true;
	}
	//boolean return type that checks if there is a pair and a three of a kind in the hand
	public static boolean hasFullHouse(Card [] cards) {
		if(hasPair(cards) == true && hasThreeOfAKind(cards)== true) {
			return true;
		}
		return false;
	}
	//boolean return type that checks if a value occurs 4 times
	public static boolean hasFourOfAKind(Card [] cards) {
		int count = 0; 
		int [] arr = new int [cards.length];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = cards[i].getValue();
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length ; j++) {
				if(arr[i] == arr[j]) {
					count++;
				}
			}
			if(count < 3) {
				count = 0;
			}
			else if(count == 3) {
				return true;
			}
		}
		return false;
	}
	//boolean return type that checks if all cards are consecutive and if they belong to the same suit
	public static boolean hasStraightFlush(Card [] cards) {
		if(hasStraight(cards) == true && hasFlush(cards) == true) {
			return true;
		}
		else {
			return false;
		}
	}
}
