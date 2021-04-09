package niuniu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * @author jsc
 * @date 2021/4/8 08 36
 * @discription 发牌类
 * @Version 1.0
 */
public class CardsBuilder {

	public static Poker[] shuffleCards() {
		int[] arr = new int[52];//扑克对应数值数组
		initArr(arr);//初始化为1-52
		Poker[] cards = new Poker[52];//没有添加大小王
		initCards(cards);
//		List list = Arrays.asList(arr);
//     	Collections.shuffle(list);//不会改变原来的数组
		upsetArr(arr);
		setCards(arr, cards);
		return cards;
	}

	//牌号初始化
	public static void initArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
	}

	//初始化poker类
	public static void initCards(Poker[] cards) {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new Poker();
		}
	}

	//打乱对应大小数组
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

	//扑克数组与数值数组相对应
	public static void setCards(int[] arr, Poker[] cards) {
		Suit[] suits = Suit.values();
		for (int i = 0; i < arr.length; i++) {
			cards[i].id = arr[i];
			cards[i].value = (arr[i] - 1) / 4 + 1;	// 得到数值(以方块A 1 梅花A 2 红桃A 3 黑桃A 4  方块2 5  ...进行排序)
			cards[i].suit = suits[(arr[i] - 1) % 4];	// 得到花色
		}
	}

}
