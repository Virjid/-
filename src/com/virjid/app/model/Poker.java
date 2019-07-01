package com.virjid.app.model;

import com.virjid.app.util.ArrayUtil;

public class Poker {
	private int[] cards;
	private int pointer;
	
	public Poker() {
		// 定义扑克牌数组及其计数器
		this.cards = new int[52];
		int index=0;
		// 填入黑桃、红桃、梅花、方块
		for (int i=100; i<=400; i+=100)
			for (int j=1; j<=13; j++)
				this.cards[index++] = i+j;
		
		// 洗牌
		shuffle();
		
		// 将发牌指针初始化为0
		this.pointer = 0;
	}
	
	/**
     * 洗牌
     */
    private void shuffle() {
    	int index;
		for (int i=0; i<this.cards.length; i++) {
			index = (int)(Math.random()*52);
			this.cards[0] = this.cards[index] + (this.cards[index]=this.cards[0])*0;
		}
	}
    
    /**
     * 发牌
     */
    public int[] dealCards(int num) {
    	if (pointer+3>51) {
    		shuffle();
    		pointer = 0;
    	}
    	int[] sub = ArrayUtil.subArray(cards, pointer, num);
    	pointer += 3;
    	return sub;
    }
}
