package question;
/*
 * 에러에는 두 가지가 있다.
 * 하나는 컴파일 타임 에러이고  - 문법에러 이고.....
 * 두번째는 런타임 에러 이다. - 샐행 오류이다.(논리의 오류이다.)
 */
public class Q_1_2 {
	public static void main(String[] args) {
		java.util.Scanner sc= new java.util.Scanner(System.in);
		//지구의 몸무게
		double wEarth = 0;
		System.out.println("지구의 몸무게를 입력하세요");
		if(sc.hasNextDouble()) {
			wEarth = sc.nextDouble();
			double wMoon = 0.0;
			Common cm = new Common(); //friendly상태여서 Q1_1_1의 Common 쓸 수 있음
			wMoon = cm.moonWeight(wEarth);		
			System.out.println("지구의 몸무게 : "+wEarth+" kg");
			System.out.println("달의 몸무게 : "+wMoon+" kg");			
		}else {
			System.out.println("실수만 입력해주세요!!!!!!!!!!경고!!");
			return; //main메소드 탈출한다. 22번 아래는 진행하지 않는다.
		}
		System.out.println("---뽕뿅---");			
	}

}
