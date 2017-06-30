package niuniu;

public enum Suit {
	// 花色按降序排列
	DIAMOND("方块"),	
	CLUB("梅花"),
	HEART("红桃"),
	SPADE("黑桃");

	String name;
	
	Suit(String name) {
		this.name = name;
	}
	
}
