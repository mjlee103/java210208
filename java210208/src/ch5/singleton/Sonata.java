package ch5.singleton;

public class Sonata {
	private static Sonata myCar= null;
	int speed = 0;
	public void stop() {
		System.out.println("stop메소드 호출 성공");
		speed = speed -1;
	}
	private Sonata() {
		
	}
	public static synchronized Sonata getInstance( ) { // 노란색만으로 safe 해짐
			if (myCar == null){
				myCar = new Sonata();
			}
			return myCar;
		   }
	}
