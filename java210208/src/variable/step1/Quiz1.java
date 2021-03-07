package variable.step1;
/* 이클립스에서 컴파일은 언제 일어나나요?
 * A.java에서 A.class로 바뀌는 순간. 즉, 저장될 때 컴파일이 일어난다.
 * 이클립스에서 소스는 src에 제정되고
 * 컴파일된 소스는 bin 폴더에 저장됨.
 * 업체에 이행할 때는 .java를 배포하지 않고, .class 만 배포한다.
 * 왜냐하면 주석, 소스를 보지 않기 때문이다.
 */
public class Quiz1 {
	int x = 10;	
	//메소드는 2가지 종류가 있다.
	//JVM에서 제공하는 메소드와 사용자 정의 메소드
	//메소드 선언 순서는 리턴타입 메소드이름(){실행문;} <- 기초 
	//메소드 선언할 때 리턴타입과 반환타입을 결정할 수 있다. <- 기초 아님. 코딩을 직접 해봐야 함, 연습만이 살 길!
	public static void main(String[] args) {
		Quiz1 q = new Quiz1();
		System.out.println("methodA(int x)호출 성공 => " +q.x);//여긴 static 이 있기 때문에 x를 그냥 사용 하지 못하고 반드시 *인스턴스화* 해야 함.
		q.methodA();
		q.methodA(5);
		q.methodA('A');
		//Variable q = new Variable();
		//q.methodA(1);

	}
	//methodA의 호출이 선언 앞에 오더라도 에러가 아님.
		//왜냐하면 자바는 절차지향의 프로그램 언어가 아니니까
		//왜냐하면 객체지향 언어이므로 호출순서와는 상관이 없다.
		//자바에서는 같은 이름의 메소드를 중복하여 선언할 수 있다.
		//이것을 가능하게 하는 규칙은 *메소드 오버로딩*이디.
		//메소드 오버로딩은 반드시 파라미터의 타입이 다르거나(합집합:둘 중의 하나만 만족해도 참) 파라미터의 갯수가 달라야한다.
		//주의사항: 리턴타입이 있고 없고는 영향을 주지 않는다.
		private void methodA() {//private으로 하면 내안에서만 사용할 수 있다. 외부에 클래스에서는 접근이 불가. 호출이 안됨. 재사용 불가
			Quiz1 q = new Quiz1();
			System.out.println("methodA호출 성공");
		}
		//파라미터 x에는 누가 값을 정해주는 걸까요?
		//언제 결정되는 걸까요?
		private void methodA(int x1) {//private으로 하면 내 안에서만 사용할 수 있다.
			x+=10;
			System.out.println("methodA(int x)호출 성공  ==> "+x);
		}
		private int methodA(char x) {//private으로 하면 내 안에서만 사용할 수 있다.
			//여기는 static이 메소드이름에 없기 때문에 x를 그냥 사용할 수 있다**********인스턴스화 안해도 ㄱㅊ
			System.out.println("methodA(int x)호출 성공  => "+x);
			return 'a';
		}
	

}
