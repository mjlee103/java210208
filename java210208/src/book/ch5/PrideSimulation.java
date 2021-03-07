package book.ch5;

public class PrideSimulation {

	public static void main(String[] args) {
		//Pride myCar = new Pride(); //오류 나는 이유는 pride가 private으로 설정되어 있기 때문임. 
		//private을 하면 인캡슐레이션이 적용 된다.
		//생성자를 선언할 때 private 으로 선언 했으므로 디폴트 생성자로 활용하고 싶다면 싱글톤패턴으로 정의하여 사용해야 
		Pride herCar = new Pride(10);  //오류를 해결하는 방법은 파라미터에 값을 넣어주는 것 
		Pride himCar = new Pride(100,4); //이렇게 메소드 안에 선언하는 것은 지역변수 임. 
				//설계자에 따라 여러개의 생성자를 만들 수 있고, 같은 생성자를 가질 수도 있다. 
				//같은 이름을 가진 생성자인 경우에는 파라미터의 갯수에 따라 구별할 수 있다. 
				//다른 패키지에서 사용할 수 있나 없나의 문제는 접근 제한제의 문제임. 
		himCar.wheelNum = 4;  
		herCar.wheelNum = 14;  //4->14
		Pride.wheelNum= 5; // 완벽한 문장
		//Pride.wheelNum = 5; //초기화 순서라는 것은 static이 사용되기 전에 결정되는 것임. 
		himCar.speed = 10;
		herCar.speed = 50;   //10->50 안바뀜, 인스턴스 변수이기 때문이다. non-static 영역임. 
		System.out.println("himCar.wheelNum: "+himCar.wheelNum);
		System.out.println("herCar.wheelNum: "+herCar.wheelNum);
		System.out.println("himCar.wheelNum: "+Pride.wheelNum);
		System.out.println("himCar.speed: "+himCar.speed);
		System.out.println("himCar.speed: "+herCar.speed);
		
	}

}
