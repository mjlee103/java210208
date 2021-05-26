package ZipCodeSearch.copy;

import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;

/*
 * 자료구조의 종류
 * 1)List 계열
 * 	 ArrayList: 싱글스레드 안전, 동기화 처리 생략, 속도 빠름
 * 	 Vector: 멀티스레드 안전, 동기화처리, 속도 느린편
 *           경합, 다중 접속자 처리, 순서, 동기화 처리 
 * 2) Map 계열(해시태그)
 * 
 * 3)Set계열(빈도 낮음) - 빈도 낮으니 여유 안되는 사람은 버려 
 */


public class ZipCodeList extends JFrame {
	
	public static void main(String[] args) {
		//꺽쇠(다이아몬드 여산자)를 제네릭이라고 함. 생성부에는 타입 없이 다이아몬드 연산자만 붙임. 
		Vector<ZipCodeVO> v = new Vector<>(); //뒤에는 생략 가능해서 다이아몬드 연산자만 작성해도 됨, 다형성 누릴 수 없음. 
		List<ZipCodeVO>  v2 = new Vector<>();// 다형성 누림.
		ZipCodeVO zcVO 		= null;
		ZipCodeVO zcVOs[] 	= null;
		int i = 0;
		while(i<3) {
			//zcVO.setAddress("서울시");
			zcVO = new ZipCodeVO(); //인스턴스화 선언-주소번지 만들어지고 메모리에 올라감 
			zcVO.setAddress("서울시"); //good
			System.out.println("zcVO조수번지 바뀐다. ===>" +zcVO.getAddress());// ->"서울시"
			v.add(zcVO);//서울시를 vector에 담음 , 참조(zcVO)에 의한 호출 - 원본
			zcVO.setAddress("인천직할시");//ok address ="서울시"
			i++;
		}
		for(int x=0;x<v.size();x++) {
			ZipCodeVO zVO = v.get(x);//31번에서 만들어진 VO와는 다른 것임.
			System.out.println(zVO);//다른 주소번지가 출력된다. 
		}
		zcVOs = new ZipCodeVO[v.size()]; //객체배열이 3개 만들어진다.
		System.out.println("배열의 크기는"+zcVOs.length); //3이 출력됨. 
		v.copyInto(zcVOs); //Vector에 담긴 것을 배열에 담아준다. 
		for(int y=0;y<zcVOs.length;y++) {
			System.out.println(zcVOs[y]+", "+zcVOs[y].getAddress()); //객체 배열의 주소번지가 3개 출력된다. 
		}
	}
	
}
