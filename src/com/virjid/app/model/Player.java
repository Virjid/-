package com.virjid.app.model;

import com.virjid.app.view.PokerView;

public class Player {
	private int chip;    // 筹码
	private int[] cards; // 手牌
	
	public Player(int chip, Poker poker) {
		this.chip = chip;
		this.cards = poker.dealCards(3);
	}
	
	public void dealCards(Poker poker) {
		cards = poker.dealCards(3);
	}
	
	public int compare(Player other) {
		// 1表示自己获胜，2表示另一个玩家获胜，0表示平局
		int result = Rule.compare(this.cards, other.cards);
		
		if (result==1) {
			this.chip+=Rule.CASH;
			other.chip-=Rule.CASH;
		} else if (result==2) {
			this.chip-=Rule.CASH;
			other.chip+=Rule.CASH;
		}
		return result;
	}
	
	public void showCards() {
		PokerView.paint(cards);
	}
	
	public int getChip() {
		return chip;
	}
}
