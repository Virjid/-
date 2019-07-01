package com.virjid.app.model;

import com.virjid.app.util.ArrayUtil;

public class Rule {
	public static int CASH;    // 押金
	
//	public static void setCash(int cash) {
//		Rule.CASH = cash;
//	}
	
	/**
     * 6=炸弹 5=顺金 4=金花 3=顺子 2=对子 1=散牌 0=235
     */
    public static int cardType(int[] cards) {
    	int[] colors = new int[3];
    	int[] number = new int[3];
    	
    	for (int i=0; i<3; i++) {
    		colors[i] = cards[i]/100;
    		number[i] = cards[i] - 100*colors[i];
    	}
    	
    	ArrayUtil.sort(number);
    	if (number[0]==2&&number[1]==3&&number[2]==5) return 0;
    	if (ArrayUtil.isAllEquals(number)) return 6;
    	if (ArrayUtil.isAllEquals(colors) && ArrayUtil.isSerial(number, true)) return 5;
    	if (ArrayUtil.isAllEquals(colors)) return 4;
    	if (ArrayUtil.isSerial(number, true)) return 3;
    	if (ArrayUtil.hasEquals(number)) return 2;
    	return 1;
	}
    
    /**
     * 比较
     * 
     * @return 1表示player1获胜，2表示player2获胜，0表示平局
     */
    public static int compare(int[] player1, int[] player2) {
    	int type1 = cardType(player1);
    	int type2 = cardType(player2);
    	
    	if (type1==0&&type2==6) return 1;
    	if (type1==6&&type2==0) return 2;
    	
    	if (type1<type2) return 2;
    	if (type1>type2) return 1;
    	
    	return 0;
    }
}
