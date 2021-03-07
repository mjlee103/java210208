package book.ch5;
/*
 * 싱글톤 패턴의 정의 
 * 해당 클래스의 인스턴스가 하나만 만들어지고 어디서든지 그 인스턴스에 접근할 수 있도록 하기 위한 패턴이다.
 * 클래스변수
 * 인스턴스변수
 * 방법1: 고전적인 싱글톤 패턴 구현법
 * 방법2: 성능이나 벙목현상을 고려하여 구현하기
 * 방법3: 
 */
public class Pride {
	//클래스 변수이다.
	static int wheelNum =0;
	int 		speed 	=0;
	
	private Pride() { //캡슐레이션 해서 외부에서 수정할 수 없고, 메소드로 구현해야 함
		//<-고전적인 싱글토 패턴 리턴타입은 프라이드, 하나만 관리하려면 null체크 해야 함. 
	}
	public Pride(int speed) {
		this.speed = speed; //전역변수의 장애: 자꾸 변경되는 것 
	}
	public Pride(int speed, int wheelNum) {
		this.speed 		= speed;
		this.wheelNum 	= wheelNum;
	}
	void speedUp() {
		speed = speed + 1; // non static 메소드
	}
	/*static void stop() {  //문법적으로 문제가 되기 때문에 고려대상이 아님. 
	  speed = 0;
	 }
	*/
	static void change() { //change 메소드 , 문법적으로 OK.
		wheelNum = 2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
 //static 은 값이 1개 이고 공유x, 전역변수는 값이 2개이상 올 수 있음 & 공유 ok