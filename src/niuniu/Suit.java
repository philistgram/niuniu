package niuniu;
/**
 * @author jsc
 * @date 2021/4/8 08 36
 * @discription 花色类
 * @Version 1.0
 */
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
