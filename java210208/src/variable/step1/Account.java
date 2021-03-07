package variable.step1;

public class Account {
	double kor = 0, math = 0, eng = 0;
	/*
	 * 총점을 구하는 메소드입니다.
	 * @param kor2 학생의 국어점수
	 * @param math2 학생의 수학 점수
	 * @param eng2 학생의 영어 점수
	 * @return tot 한 학생의 세 과목 총점을 구하여 담는 변수
	 */
	double hap(double kor2, double math2, double eng2) {
		return kor2+math2+eng2;
	}
	/*
	 * 평균을 구하는 메소드 구현
	 * @param tot : hap 메소드를 호출하여 tot를 받아온다.
	 * @return
	 */
	private double avg(double tot) {
		return tot/3;
	}

	public static void main(String[] args) {
		Account ac = new Account();
		ac.kor = 70;
		ac.math = 80;
		ac.eng = 90;
		double tot = ac.hap(ac.kor, ac.math, ac.eng);//총점 계산됨
		//위에서 계산한 총점을 avg 메소드의 파라미터로 넘기려면
		//반드시 리턴타입이 필요함.
		double test_avg = ac.avg(tot); //평균 계산됨.
		System.out.println("이 학생의 평균 점수는"+test_avg+"점 입니다.");

	}

}
