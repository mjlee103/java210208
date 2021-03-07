package book.ch7;

/*
 * 배열과 메소드 오버로딩 확인
 * 메소드 오버로딩 규칙
 * 1. 반드시 파라미터의 갯수가 달라야 한다.
 * 2. 반드시 파라미터의 타입이 달라야 한다.
 * 
 * 주의사항
 * 1. 리턴타입이 있고 없고는 영향이 없다.
 * 	ex) void go(){}랑 int (){}를 선언하면 에러 발생
 * 2. 접근 제한자가 있고 없고 또른 다른것은 영향이 없다. 
 * 	ex) public void go()랑 void go()는 에러 발생
 * (public>protected(패키지가 다르더라도 상속관계에 있다면 가능)> friendly(같은 패키지 안에서만)>private
 */	
public class Array4 {
	double ds[], d2;
	double[] d3, d4;
	void mothodA() {
		ds = new double[3];
		d2 = 3.14;
		d3 = new double[2];
		//d4 = 5.1;
		//d4 = new double[5];
		d4[3] = 2.3;
		
	}
	public static void main(String[] args) {
		Array4 a4 = new Array4();
		a4.mothodA(); 
		
	}

}
// 배열 크기를 지정하지 않고 d4[3] = 2.3;처럼 선언하면 이클립스에선 정상으로 인식하지만 식행하면 오류가 난다.
// 방을 지정하지 않고 초기화했기 때문이다. 
