package com.vo;

public class Member89VO {
	private String mem_id = null; //아이디 담기
	private String mem_pw = null; //비번담기
	private boolean gender = false; //성별담기
	
	/*
	 * 생성자는 반환 타입이 없다.
	 * 그러나 void, int 같은 것을 넣게 되면 메소드가 되어버린다. 주의해야 함. ex)public void Member89VO(){} ==> 메소드(o), 생성자(x)
	 * 클래스 이름과 동일해야 하고
	 * 전역변수의 초기화를 담당함
	 * static 블럭에서 하는 일을 맡겨도 괜찮다.
	 * 만일 소켓 통신 통해서 서버사이드와 클라이언트 사이드 구현(구척)
	 */
	/*
	 *메소드 오버로딩
	 *전제조건: 모두 같은 이름을 가져야 함.
	 *접근제한자가 있고 없고는 영향 없다.
	 *리턴타입이 있고 없고 영향 없다. <- 생성자는 해당 없음.
	 *예외를 던지고 그렇지 않고는 영향 없다. 
	 *void go() throws Exception, SQLException{}
	 */
	public Member89VO() {}//디폴트 생성자
	public Member89VO(String mem_id) {//파라미터가 있는 생성자
		this.mem_id = mem_id;
	}
	public Member89VO(String mem_id, String mem_pw) {//파라미터가 있는 생성자
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;	
	}
	public Member89VO(String mem_id, String mem_pw, boolean gender) {//파라미터가 잇는 생성자
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.gender = gender;		
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
}
	

