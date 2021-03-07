package question;

import java.util.Scanner;
public class Q_2 {
	public long add_num(long n){
		//1번방법
		long re=0;
		for(int i=1;i<=n;i++) re+=i;
		return re;
		/*2번방법
		 long re=n;
		 while(n>0){
		 	re+=--n;
		 }
		 return re;
		 */
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Q_2 num=new Q_2();
		long n=scan.nextLong();
		System.out.println(num.add_num(n));
	}

}
