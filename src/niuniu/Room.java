package niuniu;

import java.util.Random;
import java.util.Scanner;

public class Room {

	int playerNum;							// �����
	Player[] players = new Player[6];		// �������
	Poker[] pokers;							// һ���˿���
	Player banker;							// ׯ��
	Player[] player;						// �м�����
	Player winner;
	
	public Room(int n) {
		this.playerNum = n;
	}
	
	public void setPlayers() {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < playerNum; i++) {
			System.out.print((i + 1) + "�����: ");
			String name = input.next();
			players[i] = new Player(name);
		}
		setBanker();
		System.out.println("������Ϸ��ׯ���ǣ�" + banker.name);
		input.close();
	}
	
	public void setBanker() {
		banker = players[new Random().nextInt(playerNum)];
	}
	/*
	public void setPlayer() {
		for (int i = 0; i < playerNum; i++) {
			if (players[i] == banker) continue;
			player[i]
		}
	}
	*/
	public void startGame() {
		pokers = CardsBuilder.shuffleCards();
		System.out.println("���濪ʼ����..........");
		for (int i = 0; i < playerNum; i++) {
			deal(players[i], i);
		}
	}
	// ����
	public void deal(Player p, int n) {
		for (int i = n; i < n + 5; i++) {
			p.myCards[i - n] = pokers[i + n * 5];
		}
	}
	
	public void showPlayer() {
		System.out.println("�м�����..........");
		for (int i = 0; i < playerNum; i++) {
			if (players[i] != banker) {
				players[i].showdown();
				players[i].niuniu();
				players[i].getResult();
				System.out.println();
			}
		}
	}
	
	public void showBanker() {
		System.out.println("ׯ������..........");
		banker.showdown();
		banker.niuniu();
		banker.getResult();
		System.out.println();
	}

	public void gameResult() {
		winner = banker;						// �ȼٶ�ׯ��Ӯ
		for (int i = 0; i < playerNum; i++) {
			if (players[i] != banker) {			
				if (players[i].niu > winner.niu) {	// ˭ţ�����˭Ӯ
					winner = players[i];
				} else if (players[i].niu == winner.niu) {		// ţ����ͬ�ͱ�������
					if (players[i].getMax() > winner.getMax()) {	
						winner = players[i];
					}
				}
			}
		}
		System.out.println("������Ϸ��Ӯ����" + winner.name);
	}
	
}
