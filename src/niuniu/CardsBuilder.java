package niuniu;

import java.util.Random;

public class CardsBuilder {

	public static Poker[] shuffleCards() {
		int[] arr = new int[52];
		initArr(arr);
		Poker[] cards = new Poker[52];
		initCards(cards);
		upsetArr(arr);
		setCards(arr, cards);
		return cards;
	}
	
	public static void initArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
	}
	
	public static void initCards(Poker[] cards) {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new Poker();
		}
	}
	
	public static void upsetArr(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			swap(new Random().nextInt(i + 1), i, arr);
		}
	}
	
	public static void swap(int i, int j, int[] arr) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	
	public static void setCards(int[] arr, Poker[] cards) {
		Suit[] suits = Suit.values();
		for (int i = 0; i < arr.length; i++) {
			cards[i].id = arr[i];
			cards[i].value = (arr[i] - 1) / 4 + 1;	// 得到数值
			cards[i].suit = suits[(arr[i] - 1) % 4];	// 得到花色
		}
	}
	
}
