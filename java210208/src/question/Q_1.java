package question;

public class Q_1 {
	public double moonWeight(double wEarth) {
		//달의 몸무게
		double wMoon = 0.0;
		wMoon = (wEarth*17)/100.0;//(double*int)/int=double
		return wMoon;
	}
	public static void main(String[] args) {
		java.util.Scanner sc= new java.util.Scanner(System.in);
		//지구의 몸무게
		double wEarth = 0;
		System.out.println("지구의 몸무게를 입력하세요");
		wEarth = sc.nextDouble();
		double wMoon = 0.0;
		Q_1 q2 = new Q_1();
		wMoon = q2.moonWeight(wEarth);		
		System.out.println("지구의 몸무게 : "+wEarth+" kg");
		System.out.println("달의 몸무게 : "+wMoon+" kg");
		//1번방법
		//double weight=scan.nextDouble();
		//System.out.println(weight*0.17+"kg");
		/*2번방법
		 * double result=weight*0.17;
		 * System.out.println(result+"kg");
		 */
		
	}

}
