# 简介 brief introduction
简单的java实现的牛牛游戏（输入玩家个数及玩家ID，自动发牌，随机给出庄家及计算牌型及输赢情况）

Simple java implementation of Niuniu game (input the number of players and player ID, automatic licensing, random dealer and calculation card type and win or lose situation)

## 玩家个数 number of players
设置在2-10名（由于一副扑克最多只能由10个人玩）

Set at 2-10 (since a deck of cards can only be played by 10 people at most)

## 牌型分析 analysis of brand type
五张牌取三张牌排列组合有10种方案，且只生成一种牌型

There are 10 schemes for the arrangement and combination of three cards out of five cards, and only one card type is generated.

### bug或不足 bug or deficiency

1.没有添加大小王（可以用作任意牌，使游戏玩法更加丰富）

No big or small king added (can be used as any card to enrich the game)

2.没有五花牛，五小牛的牌型判断

There is no wuhuaniu, the brand type judgment of wuhuaniu

3.仅仅判断谁是最大的

Just judge who is the biggest

####
游戏介绍及规则说明

一、基础说明：
游戏人数： 2-5人。
牌的构成：包括大小王的一副扑克牌，共54张牌。
简单流程：每个牌手发5张牌，在自己的牌中选出3张凑成10的整数倍，庄家与闲家进行输赢比较。
牌面分数：10、J、Q、K、小王、大王都为10 点，A为1点、其他按牌面数字计算点数。
二、牌型介绍：
金牛王：三张花牌加大小王的牛牛。双王牛牛。
金牛：所有牌都是10、J、Q、K的牛牛。
牛牛：任意3 张牌之和为10 的整数倍数，如果另外两张牌之和也为10 的整数倍数，即为牛牛。
有牛：任意三张牌之和为10的整数倍数，如果另外两张牌之和不为10的整数倍数，则根据这两张牌之和的个位数为该副牌的分数，为有牛牌型。
无牛：任意三张牌之和都不能为10 的整数倍数，则判定该牌型为无牛。
三、比较大小规则：
根据牌型比较大小，如果牌型大小一样，则比最大单张牌的点数，如果点数相同再比较最大单张牌的花色。
牌型大小：金牛王>金牛>牛牛>牛九>牛八>牛七>牛六>牛五>牛四>牛三>牛二>牛一>无牛
单牌大小：大王>小王>K>Q>J>10>9>8>7>6>5>4>3>2>A。
花色大小排序：黑桃>红桃>草花>方块
四、定庄规则：
抢庄资格：所有符合庄家要求的玩家均可入围抢庄。
轮庄启动：符合庄家要求的玩家均未参与抢庄。
五、输赢判断：
庄家不下注，开牌后庄家与所有闲家比牌。
庄家通吃：牌面大过所有闲家。
庄家通赔：牌面小过所有闲家。
如果庄家牌面即未大过所有闲家也未小过所有闲家。
闲家赢：大过庄家的赢于庄家。
闲家输：小过庄家的输给庄家。
六、牌型倍率：
金牛王：6倍押注+聚宝金盆。
金牛：6倍押注+聚宝银盆。
牛牛：6倍押注+喜金。
牛九：4倍押注。
牛七牛八：2倍押注。
牛一至牛六：1倍押注。
无牛：1倍押注。