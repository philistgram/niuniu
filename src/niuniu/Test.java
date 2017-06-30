package niuniu;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		System.out.println("**********欢乐斗牛**********");
		Scanner input = new Scanner(System.in);
		System.out.print("请输入玩家人数：");
		int n = input.nextInt();
		Room room = new Room(n);
		room.setPlayers();
		room.startGame();
		room.showPlayer();
		room.showBanker();
		room.gameResult();
	}

}
