package niuniu;
/**
 * @author jsc
 * @date 2021/4/8 08 36
 * @discription ��ɫ��
 * @Version 1.0
 */
public enum Suit {
	// ��ɫ����������
	DIAMOND("����"),	
	CLUB("÷��"),
	HEART("����"),
	SPADE("����");

	String name;
	
	Suit(String name) {
		this.name = name;
	}
	
}
