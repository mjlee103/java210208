package variable.step1;

public class MainMethod {
	/*
	 * @param.args: 파라미터의 타입은 배열입니다.
	 * String args[] = new String[3]:
	 * main메소드는 좀 특별한 경우라서 따로 설명함.
	 * 오늘의 학습목표: main메소드에 대해 설명하기
	 */
	public static void main(String[] args) {
		System.out.println(args[0]);
		//만일 숫자라면 20 출력하고 문자라면 1010 출력해 볼거야
		//int + int = int
		//int + String = 붙여쓰기
		System.out.println(args[0]+10); //무슨타입이지?
		//타입을 체크할 수 잇는 연산자가 있다. 왜냐하면 자바는 컴파일할 때 타입을 따지기 때문이다.
		if(args[0] instanceof String) {
			System.out.println("나는 문자열이야");
		}
		else {
			System.out.println("나는 문자열이 아니야!!!");
		}
		if(true) {//else를 실행되지 않는다. 왜냐하면 상수이기 때문이다.
			System.out.println("나는 참 입니다.");
		}
		else {
			System.out.println("나는 거짓입니다");
		}
		for(int i=0;i<100;i=+1) {
			if(true) {
				System.out.println(i+":나는 참이야~~");
			}
		}//// end of for
	}

}
