package niuniu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 * @author jsc
 * @date 2021/4/8 08 36
 * @discription ������
 * @Version 1.0
 */
public class CardsBuilder {

	public static Poker[] shuffleCards() {
		int[] arr = new int[52];//�˿˶�Ӧ��ֵ����
		initArr(arr);//��ʼ��Ϊ1-52
		Poker[] cards = new Poker[52];//û����Ӵ�С��
		initCards(cards);
//		List list = Arrays.asList(arr);
//     	Collections.shuffle(list);//����ı�ԭ��������
		upsetArr(arr);
		setCards(arr, cards);
		return cards;
	}

	//�ƺų�ʼ��
	public static void initArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
	}

	//��ʼ��poker��
	public static void initCards(Poker[] cards) {
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new Poker();
		}
	}

	//���Ҷ�Ӧ��С����
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

	//�˿���������ֵ�������Ӧ
	public static void setCards(int[] arr, Poker[] cards) {
		Suit[] suits = Suit.values();
		for (int i = 0; i < arr.length; i++) {
			cards[i].id = arr[i];
			cards[i].value = (arr[i] - 1) / 4 + 1;	// �õ���ֵ(�Է���A 1 ÷��A 2 ����A 3 ����A 4  ����2 5  ...��������)
			cards[i].suit = suits[(arr[i] - 1) % 4];	// �õ���ɫ
		}
	}

}
