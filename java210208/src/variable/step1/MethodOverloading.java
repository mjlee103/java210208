package variable.step1;

import com.vo.DeptVO;

public class MethodOverloading {
	/*
	 * @param pdvd: 조건절에서 사용될 상수값을 담음, where 들어갈 조건값으로 사용됨.
	 * @return rdvo: 오라클에서 조회된 결과값을 담음, 화면 출력용으로 사용.
	 */
	DeptVO go(Deptvo dpvo) {//메소드 이름은 같은데 서로 다른 메소드로 인지함.
		//다음 go들은 메소드 오버로딩임
		System.out.println(pdvo.getDeptvo()+", "+pdvo.getDname()+", "+pdvo.getLoce());
		DeptVo rdvo = null;
		rdvo = new DeptVO(); //오라클 경유한 다음 조회 결과를 받아온 내용을 담는 클래스임.
		return rdvo;
	}
	void go() {
		System.out.println("파라미터가 없는 go() 호출 성공");
	}
	void go(int i) {//값에 의한 호출이다. i에는 메소드 호출할 때 파라미터로 넘어오는 10이 복사됨.
		System.out.println("파라미터가 int인 go(19) 호출 성공"+i);//원시형 타입을 불러서 값이 호출됨
	}
	void go(String name) {
		System.out.println("파라미터가 String인 go(jiny) 호출 성공"+name);
	}
	public static void main(String[] args) {
		MethodOverloading mol = new MethodOverloading();
		mol.go();
		mol.go(19); // 그 값은 여기서 메소드 호출 할 때 결정됨. (파라미터)
		//string은 call by reference 인데 call by value 이다.
		mol.go("jiny"); //참조형 타입이기 때문에 참조에 의한 호출이다. String만 예외이다. 호출할 때 주소번지가 아니라 값이 출력되기 때문임.
		DeptVO pdvo = new DeptVO();
		pdvo.setDeptno(50); / int
		pdvo.setDname("개발1팀");//string
		pdvo.setLoc("제주도"); //string
		pdvo=mol.go(dpvo);//주소번지를 넘겼다. 참조에 의한 호출이다. <> 값에 의한 호출이다.
		mol.go(pdvo);

	}

}
