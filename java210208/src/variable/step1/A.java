package variable.step1;
//전역 변수의 경우 초기화를 생략할 수 있다. 
public class A {
	double kor = 0;
	double math = 0;
	double eng = 0;
	
	double kor1;
	double math1;
	double eng1;
	
	double kor2 = 70;
	double math2 = 80;
	double eng2 = 90;
	void methodA() {
		kor = 70;
		math = 80;
		eng = 90;
	}
	public static void main(String[] args) {
		
	}
}
