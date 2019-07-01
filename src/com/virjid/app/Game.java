package com.virjid.app;

import com.virjid.app.model.Player;
import com.virjid.app.model.Poker;
import com.virjid.app.view.InputView;

public class Game {
	public static void run() {
		//1 欢迎语
		System.out.println("欢迎来到炸金花游戏房间\n您和电脑都将拥有100000元的初始筹码\n现在开始游戏！\n");
		
		//2 初始化
		Poker poker = new Poker();
		Player player = new Player(100000, poker);
		Player computer = new Player(100000, poker);
		
		//3 无穷循环运行游戏
		core(player, computer, poker);

		//4 游戏结束语
		System.out.println("感谢对该游戏的支持！");
	}
	
	private static void core(Player player, Player computer, Poker poker) {
		// 无穷循环运行游戏
		int result = 0;
		while (true) {
			//1 获取双方玩家的输入
			getUserInput(player, poker);     //3.1.1 获取player输入
			computer.dealCards(poker); //3.1.2 生成computer发牌
			
			//2 游戏核心逻辑
			result = player.compare(computer);
			
			//3 结算游戏对抗结果
			//3.1 结算本回合战况
			paintResult(player, computer, result);
			
			//3.2 结算游戏是否可以结束：双方玩家是否存在筹码不足的情况
			if (computer.getChip()<=0) {
				System.out.println("恭喜您战胜了电脑！");
				break;
			} else if (player.getChip()<=0) {
				System.out.println("很遗憾，您挑战失败了...-_-||");
				break;
			}
		}
	}
	
	private static void getUserInput(Player player, Poker poker) {
		boolean isStake; 
		while (true) {
			try {
				//1 发牌
				System.out.println("发牌中......");
				player.dealCards(poker);
				System.out.println("发牌完毕，您的手牌为：");
				player.showCards();

				//2 询问用户是否弃牌
				isStake = InputView.isStake();
				
				//3 弃牌重发
				if (!isStake) continue;
				
				//4 输入押注金额
				InputView.getCash(player);
				
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException e) {
				System.out.println("请输入内容！");
			}
		}
	}
	
	
	public static void paintResult(Player player, Player computer, int result) {
		System.out.println("================================");
		// 结算本回合战况
		if (result == 0) System.out.println("本回合平局！");
		else if (result == 1) System.out.println("本回合您获胜！");
		else System.out.println("本回合电脑获胜！");
		System.out.println("电脑手中的牌为：");
		computer.showCards();
		System.out.println("您手中的牌为：");
		player.showCards();
		System.out.println("您的所剩筹码："+player.getChip()+"元");
		System.out.println("电脑的所剩筹码："+computer.getChip()+"元");
		System.out.println("================================");
	}
}
