package question;

import java.util.Random;

public class MaxNumFind {
	void randomNum() {
		Random random = new Random();
		int[] n = new int[10];
		for(int i=0;i<10;i++) {
			n[i] = random.nextInt(100);
		}
		maxNum(n);
		seeNum(n);
	}
	void maxNum(int n[]) {
		int re=n[0];
		for(int i=1;i<n.length;i++) {
			if(re<n[i]) re=n[i];
		}
		System.out.println("가장 큰 수는: "+re+" 입니다.");
	}
	void seeNum(int n[]) {
		System.out.println("안에 들어있는 수는 다음과 같습니다.");
		for(int i=0;i<n.length;i++) {
			System.out.print(n[i]+" ");
		}
	}
	public static void main(String[] args) {
		MaxNumFind result = new MaxNumFind();
		result.randomNum();
	}

}
