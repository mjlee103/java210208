package variable.step1;

public class Account1_1 {
		double kor = 0, math = 0, eng = 0;
		/*
		 * 총점을 구하는 메소드입니다.
		 * @param kor2 학생의 국어점수
		 * @param math2 학생의 수학 점수
		 * @param eng2 학생의 영어 점수
		 * @return tot 한 학생의 세 과목 총점을 구하여 담는 변수
		 */
		private double hap(double kor2, double math2, double eng2) {
			return kor2+math2+eng2;
		}
		/*
		 * 평균을 구하는 메소드 구현, 값에 의한 호출이다. 
		 * @param tot : hap 메소드를 호출하여 tot를 받아온다.
		 * @param subjectNumber : 과목수
		 * @return
		 */
		private double avg(double tot, int subjectNumber) { //0,0ㅇ 찍히면 배달사고가 일어난다. => 단위 테스트 통해서 확인하고 진행
			System.out.println("tot==>"+tot+", subjectNumber==>"+subjectNumber);
			double imsi = tot/subjectNumber;
			return imsi;
		}
		//나는 메소드를 선언할 수 있다.
		//메소드 안에 있는 콤마는 열거형 연산자라고 한다.
		//dot(.) 연산자: 주소번지.전역변수
		//접근제한자(access modifier) - static 수정자 - 리턴타입 - 메소드이름(파라미터1, 파라미터2,...)
		
		public static void main(String[] args) {
			Account1_1 ac = new Account1_1();
			ac.kor = 70;
			ac.math = 80;
			ac.eng = 90;
			double tot = ac.hap(ac.kor, ac.math, ac.eng);//총점 계산됨
			//위에서 계산한 총점을 avg 메소드의 파라미터로 넘기려면
			//반드시 리턴타입이 필요함.
			//double test_avg=ac.avg(tot);//평균 계산됨.
			double test_avg2 = ac.avg(tot,3); //평균 계산됨.
			System.out.println("이 학생의 평균 점수는"+test_avg2+"점 입니다.");

		}

	}
