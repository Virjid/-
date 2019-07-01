package com.virjid.app.view;

import com.virjid.app.model.Player;
import com.virjid.app.model.Rule;
import com.virjid.app.util.ConsoleUtil;

public class InputView {
	public static boolean isStake() {
		String in; boolean isStake;
		while(true) {
			try {
				in = ConsoleUtil.readLine("是否押注？(y/n) > ");
				if (in.equals("y")) isStake=true;
				else if (in.equals("n")) isStake=false;
				else throw new IllegalArgumentException("只能输入 y 或 n ！");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException e) {
				System.out.println("请输入内容！");
			}
		}
		return isStake;
	}
	
	public static void getCash(Player player) {
		while(true) {
			try {
				Rule.CASH = ConsoleUtil.readInt("请输入押金(元)（默认200元），您还有"+player.getChip()+"元 > ", 200);
				if (Rule.CASH>player.getChip()) throw new IllegalArgumentException("输入的押金不能高于自己所剩的筹码！您还有"+player.getChip()+"元");
				if (Rule.CASH<=0) throw new IllegalArgumentException("输入的押金必须为大于0的整数！");
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException e) {
				System.out.println("请输入内容！");
			}
		}
	}
}
