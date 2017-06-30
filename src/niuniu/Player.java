package niuniu;

public class Player {

	String name;
	Poker[] myCards = new Poker[5];
	int niu = -1;
	
	public Player(String name) {
		this.name = name;
	}
	
	public int niuniu() {
		for (int i = 0; i < myCards.length - 2; i++) {
			for (int j = i + 1; j < myCards.length - 1; j++) {
				for (int k = j + 1; k < myCards.length; k++) {
					if (sum(i, j, k, myCards) >= 10
							&& sum(i, j, k, myCards) % 10 == 0) {
						niu = sumOfAll(myCards) % 10;
						break;
					} 
				}
			}
		}
		return niu;
	}
	
	public int sum(int i, int j, int k, Poker[] myCards) {
		int sum = 0;
		sum = sum + (myCards[i].value >= 10 ? 10 : myCards[i].value);
		sum = sum + (myCards[j].value >= 10 ? 10 : myCards[j].value);
		sum = sum + (myCards[k].value >= 10 ? 10 : myCards[k].value);
		return sum;
	}
	
	public int sumOfAll(Poker[] myCards) {
		int sum = 0;
		for (int i = 0; i < myCards.length; i++) {
			sum = sum + (myCards[i].value >= 10 ? 10 : myCards[i].value);
		}
		return sum;
	}
	
	public void getResult() {
		if (niu < 0) {
			System.out.println("没牛");
		} else if (niu % 10 == 0){
			System.out.println("牛牛");
			niu = 10;
		} else {
			System.out.println("牛" + niu);
		}
	}
	
	public int getMax() {
		int max = -1;
		for (int i = 0; i < myCards.length; i++) {
			if (myCards[i].id > max) {
				max = myCards[i].id;
			}
		}
		return max;
	}
	
	public void showdown() {
		System.out.print("玩家" + name + "的牌是");
		for (int i = 0; i < myCards.length; i++) {
			switch (myCards[i].value) {
			case 1:
				System.out.print(myCards[i].suit.name + "A ");
				break;
			case 11:
				System.out.print(myCards[i].suit.name + "J ");
				break;
			case 12:
				System.out.print(myCards[i].suit.name + "Q ");
				break;
			case 13:
				System.out.print(myCards[i].suit.name + "K ");
				break;
			default:
				System.out.print(myCards[i].suit.name + myCards[i].value + " ");
				break;
			}
		}
	}
}
