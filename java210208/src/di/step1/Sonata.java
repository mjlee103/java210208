package di.step1;

public class Sonata {
	private String carColor = null;
	private int speed = 0;
	private int WheelNum = 4;
	public Sonata() {}//디폴트 생성자
	public Sonata(String carColor, int speed) {
		this.carColor = carColor;
		this.speed = speed;
	}
	public String toString() {
		return "그녀의 자동차는 "+this.carColor
				+" 이고 현재 속도는 "+ this.speed+" 입니다.";
		}
}
