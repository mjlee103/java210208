package question;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
	int dap=0;
	
	public void hintGame(int i) {
		if(i==1) {
			if(dap%2==0)System.out.println("이 값은 짝수 입니다 ");
			else System.out.println("이 값은 홀수 입니다 ");
		}else if(i==2) {
			System.out.println("이 값은 3으로 나누었을 때 나머지는"+dap%3+"입니다.");	
		}else {
			int n=4;
			while(true) {
				if(dap%n==0) break;
				n++;
			}
			System.out.println("이 값은 "+n+"의 배수입니다.");				
		}
	}
	
	public void comeGame() {
		Scanner sc = new Scanner(System.in);
		int randomNum;
		Random r= new Random();
		System.out.println("0부터 몇까지 중에서 랜덤 값을 불러올까요?");
		randomNum=sc.nextInt();
		int dap = r.nextInt(randomNum);
		gameStart();		
	}
	
	public void gameStart() {	
		Scanner sc = new Scanner(System.in);
		int result;
		System.out.println("랜덤값을 입력했습니다. 기회는 3번 드립니다.");
		for(int i=1;i<=3;i++) {
			System.out.println("힌트를 원하시면 -1을 입력해주세요. 그렇지 않으면 값을 입력하시면 됩니다.");
			result=sc.nextInt();
			if(result==-1) {
				hintGame(i);
				System.out.println("힌트를 드렸으니 값을 입력해주세요.");				
				result=sc.nextInt();
			}
			if(result==dap) {
				System.out.println("축하합니다. 정답입니다.");
				return;
			}else if(result>dap) {
				System.out.println("입력한 값보다 작습니다.");
			}else {
				System.out.println("입력한 값보다 큽니다.");
			}
			System.out.println("기회는"+ (3-i) +"번 남았습니다.");
		}		
		System.out.println("안타깝네요. 정답은 "+dap+" 입니다.");
	}
	
	public static void main(String[] args) {
		RandomGame me = new RandomGame();
		me.comeGame();
	}

}
