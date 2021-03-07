package com.vo;

public class DeptVoSimulation {
	void methodB() {//바환값이 전혀 역할을 못함.
		
	}
	DeptVO methodA() {//반환값이 3가지까지 가능함.
		return new DeptVO();		
	}
	DeptVO[] methodC() {
		return new DeptVO[3];
	}

	public static void main(String[] args) {
		// 생성자: DeptVO dvo = new DeptVO(50, "사업부", "se");
		DeptVO dvo = new DeptVO();
		//위치: 어디에 호출해야 할까요?
		//insert here =>
		dvo.setDeptno(30);//(ㅇ)
		//int x = dvo.setDeptno(30)l// (x) void라 return 타입이 없음.
		//dvo.setDname("영업부");
		int myDeptNo = dvo.getDeptno();//0출력
		//insert here 부서번호 30을 출력하도록 코드를 추가하시오.
		String myDname = dvo.getDname();//null
		String myLoc = dvo.getLoc();//null
		System.out.println(myDeptNo); //30
		dvo = new DeptVO();
		dvo.setDeptno(300);
		myDeptNo = dvo.getDeptno();
		

	}

}
