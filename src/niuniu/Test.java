package niuniu;

import java.util.Scanner;

/**
 * @author jsc
 * @date 2021/4/8 08 36
 * @discription ������
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("**********���ֶ�ţ**********");

        int players = 10;
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("�������������(���10�����)��");
            players = input.nextInt();
            if (players > 1 && players <= 10) {
                break;
            }
        }

        Room room = new Room(players);
        room.setPlayers();
        room.startGame();
        room.showPlayer();
        room.showBanker();
        room.gameResult();
    }

}
