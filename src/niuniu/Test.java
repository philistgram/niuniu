package niuniu;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.println("**********���ֶ�ţ**********");
		Scanner input = new Scanner(System.in);
		System.out.print("���������������");
		int n = input.nextInt();
		Room room = new Room(n);
		room.setPlayers();
		room.startGame();
		room.showPlayer();
		room.showBanker();
		room.gameResult();
	}

}
