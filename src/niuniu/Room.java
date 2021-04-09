package niuniu;

import java.util.Random;
import java.util.Scanner;

/**
 * @author jsc
 * @date 2021/4/8 08 36
 * @discription ������
 * @Version 1.0
 */
public class Room {

    int playerNum;                            // �����
    Player[] players = new Player[10];        // �������
    Poker[] pokers;                           // һ���˿���
    Player banker;                            // ׯ��
    Player winner;                            // Ӯ��

    //��ʼ�������
    public Room(int players) {
        this.playerNum = players;
    }

    //�����������
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

    //�������ׯ��
    public void setBanker() {
        banker = players[new Random().nextInt(playerNum)];
    }

    public void startGame() {
        pokers = CardsBuilder.shuffleCards();
        System.out.println("...........��ʼ����..........");
        for (int i = 0; i < playerNum; i++) {
            deal(players[i], i);
        }
    }

    // ����(��һ����0-4,�ڶ�����5-9,�Դ����ƣ����Ż��ɱ��ַ��Ʒ�ʽ)
    public void deal(Player p, int n) {
        for (int i = n; i < n + 5; i++) {
            if (n == 0) {
                p.myCards[i - n] = pokers[i + n * 5];
            } else {
                p.myCards[i - n] = pokers[i + n * 5 - n];
            }
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
        winner = banker;                        // �ȼٶ�ׯ��Ӯ
        for (int i = 0; i < playerNum; i++) {
            if (players[i] != banker) {
                if (players[i].niu > winner.niu) {    // ˭ţ�����˭Ӯ
                    winner = players[i];
                } else if (players[i].niu == winner.niu) {        // ţ����ͬ�ͱ�������
                    if (players[i].getMax() > winner.getMax()) {
                        winner = players[i];
                    }
                }
            }
        }
        System.out.println("������Ϸ��Ӯ����" + winner.name);
    }

}
