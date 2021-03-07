package variable.step1;
/*
 * 처음부터 전역변수 kor, math, eng에 0대신에 점수를 넣는건 안되나요?
 * 되지만 이 값은 한 번에 하나만 기억된다.
 * java에서는 각 타입이 갖는 초기 값이 정해져 있다.
 * 예를들면 숫자형 초기값은 int = 0;, long = 0;, float = 0.0f;, double = 0.0d
 */

public class Asimulation {

	public static void main(String[] args) {
		A a = new A(); //인스턴스화
		System.out.println("영어: "+a.eng); //0
		System.out.println("수학: "+a.math); //0
		System.out.println("국어: "+a.kor); //0
		System.out.println("====================");
		System.out.println("영어: "+a.eng1); //0
		System.out.println("수학: "+a.math1); //0
		System.out.println("국어: "+a.kor1); //0
		System.out.println("====================");
		System.out.println("영어: "+a.eng2); //0
		System.out.println("수학: "+a.math2); //0
		System.out.println("국어: "+a.kor2); //0
		A a2 = new A();
		a2.eng2 = 95;
		a2.math2 = 85;
		a2.kor2 = 75;
		System.out.println("====================");
		System.out.println("영어: "+a.eng2); //95
		System.out.println("수학: "+a.math2); //85
		System.out.println("국어: "+a.kor2); //75
		//같은 타입이지만 서로 다른 내용과 메소드 처리결과를 가질 수 있다.
		//인스턴스화를 할 때마다 복제본이 여러개 생긴다. 
		

	}

}
