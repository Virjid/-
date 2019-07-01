package com.virjid.app.view;

public class PokerView {
	private static String cardFormat(int card) {
    	char[] colors = new char[] {'♦','♣','♥','♠'};
    	
    	int colorIndex = card/100;
		int number = card - 100*colorIndex;
    	return colors[colorIndex-1]+" "+number;
	}
    
    public static void paint(int[] cards) {
    	for (int card : cards) {
    		System.out.print(cardFormat(card)+"   ");
    	}
    	System.out.println();
    }
}
