package niuniu;

import java.util.Random;
import java.util.Scanner;

/**
 * @author jsc
 * @date 2021/4/8 08 36
 * @discription 房间类
 * @Version 1.0
 */
public class Room {

    int playerNum;                            // 玩家数
    Player[] players = new Player[10];        // 所有玩家
    Poker[] pokers;                           // 一副扑克牌
    Player banker;                            // 庄家
    Player winner;                            // 赢家

    //初始化玩家数
    public Room(int players) {
        this.playerNum = players;
    }

    //设置玩家姓名
    public void setPlayers() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < playerNum; i++) {
            System.out.print((i + 1) + "号玩家: ");
            String name = input.next();
            players[i] = new Player(name);
        }
        setBanker();
        System.out.println("本局游戏的庄家是：" + banker.name);
        input.close();
    }

    //随机设置庄家
    public void setBanker() {
        banker = players[new Random().nextInt(playerNum)];
    }

    public void startGame() {
        pokers = CardsBuilder.shuffleCards();
        System.out.println("...........开始发牌..........");
        for (int i = 0; i < playerNum; i++) {
            deal(players[i], i);
        }
    }

    // 发牌(第一个从0-4,第二个从5-9,以此类推，可优化成别种发牌方式)
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
        System.out.println("闲家亮牌..........");
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
        System.out.println("庄家亮牌..........");
        banker.showdown();
        banker.niuniu();
        banker.getResult();
        System.out.println();
    }

    public void gameResult() {
        winner = banker;                        // 先假定庄家赢
        for (int i = 0; i < playerNum; i++) {
            if (players[i] != banker) {
                if (players[i].niu > winner.niu) {    // 谁牛数大就谁赢
                    winner = players[i];
                } else if (players[i].niu == winner.niu) {        // 牛数相同就比最大的牌
                    if (players[i].getMax() > winner.getMax()) {
                        winner = players[i];
                    }
                }
            }
        }
        System.out.println("本局游戏的赢家是" + winner.name);
    }

}
