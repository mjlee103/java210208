package question;

//public class Common으로 할 수 없음 -> 하나안에 두개의 public class는 붛가능
class Common{
	public double moonWeight(double wEarth) {
		//달의 몸무게
		double wMoon = 0.0;
		wMoon = (wEarth*17)/100.0;//(double*int)/int=double
		return wMoon;
	}
}
public class Q_1_1 {
	public static void main(String[] args) {
		java.util.Scanner sc= new java.util.Scanner(System.in);
		//지구의 몸무게
		double wEarth = 0;
		System.out.println("지구의 몸무게를 입력하세요");
		wEarth = sc.nextDouble();
		double wMoon = 0.0;
		Common cm = new Common();
		wMoon = cm.moonWeight(wEarth);		
		System.out.println("지구의 몸무게 : "+wEarth+" kg");
		System.out.println("달의 몸무게 : "+wMoon+" kg");
	}

}
