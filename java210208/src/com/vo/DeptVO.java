package com.vo;
/*오라클과 자바의 만남 -> DeptVo가 둘의 연결고리
 * VO, 패턴: 데이터의 영속성을 유지해주는 오라클 서버 제품과 연결하기
 * data 관리 목적 - 모든 집합의 이름 뒤에 접미어로 VO 붙임, VO 붙이면 무조건 데이터를 의미한다는 것임.
 * 메인메소드는 필요없다. 단독으로 실행하지 않기 때문이다. 
 */

/*
 * Number(2): 정수형, 담을 수 있는 크기는 99까지 임계값이다.
 * 			    자바에서는 in(4byte), long(8byte)으로 받음.
 * varchar2(4000) : = string
 * VO패턴을 사용하면 한번에 3가지 종류 값을 관리 가능 함. ex 부서명, 부서번호, 지역
 * VO패턴이 여러 종류의 테이블을 관리하는 게 맞지만  로우 (가로방향)은 한번에 한 개 로우까지만 관리 가능
 * 서버 자체는 항상 동시에 여러사람이 접속할 수 있다.
 * 이러한 여러 사람을 따로 관리할 수 잇어야 한다. <-Thread 공부: 직젖ㅂ 서버를 운영할 수 잇는 코딩 
 */

/*<인스턴스화 하는 이유>
 * DeptVO dvo = new DeptVO();
 * 이것은 합법인가?
 */

public class DeptVO {
	//생성자
	//public DeptVO(int deptno, stirng dname, string loc){
	// this.setDeptno(deptno);
	// this.setDname(dname);
	// this.setLoc(loc);
	//}

	private int deptno =0; //원시형 타입: 부르면 값이 나온다. 4byte이어서 229540 229544 ...
	private String dname = null; //레퍼런스 타입(클래스급임): 값이 아니라 주소번지가 나옴. 
	private String loc = null; 
		
		//getter메소드 - Read: 반환값이 있다. 
		public int getDeptno() {
			return deptno;
		}
		//setter 메소드 - write&save: 반환값이 없다. 대신 parameter가 존재함.
		public void setDeptno(int deptno) {
			//deptno = 0; <- 상수, 재사용성이 덜어짐.
			//this는 나 자신을 가리키는 수정자임. 여기서는 지변과의 식별을 위해 사용되었다. 생략할 수 있지만 헷갈릴 가능성이 높아
			this.deptno = deptno;
		}
		public String getDname() {
			return dname;
		}
		public void setDname(String dname) {//지변
			this.dname = dname;
		}
		public String getLoc() {
			return loc;
		}
		public void setLoc(String loc) {
			this.loc = loc;
	 }
 }


