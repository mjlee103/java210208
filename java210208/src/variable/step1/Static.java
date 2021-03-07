package variable.step1;

public class Static {
	/*
	 * non static 타입은 static 영역에서 접근 불가 = 호출 불가 = 사용 불가
	 */
	static void avg() {//사용자 정의 메소드이다.
		System.out.println("avg 호출 성공");
	}
	public static void main(String[] args) {
		// if (args == null | args.lentth == 0)
		if(args.length==0) {
			//아래 문장은 조건에 따라 한번도 실행기회를 못가질 수도 있다.
			System.out.println("입력 고고");
			return; //main 메소드 탈출하기
		}
		System.out.println(args[0]+10); //20이 출력되는 코드로 수정하시오.
		int imsi = Integer.parseInt(args[0]);
		System.out.println(imsi+10);//20이 출력되도록
		System.out.println("======="+(int)(imsi+10));//20이 출력 되도록!
		//
	}

}

//자바에서 제공하는 메소드를 사용했을 때 직접 만들어 쓰는 것에 비해 단점이 있나요?
// 자바 가상머신이 만든 것을 쓰는 것이 안전하다. 