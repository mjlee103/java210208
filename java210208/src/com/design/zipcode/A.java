package com.design.zipcode;

import java.util.ArrayList;

public class A {
/*
 * 컬렉션 프레임워크에서 제공하는 클래스 중 하나이다.
 * 여기에 담을 수 잇는 것들은 기본적으로 Object급이다.
 * 원시형 타입은 담을 수가 없다.
 * 
 * 배열과는 무엇이 다른가요? 늘었다 줄었다가 가능하다고, 객체 타입이면 무엇이든 담을 수 있으며 끼워넣기가 가능하다. 
 * 
 * 제네릭이라는 것은 내 안에 어떤 타입이 명시하는 것이다. 
 * ArrayList<String> f2 = new ArrayList<String>();의 <String>
 */
	public static void main(String[] args) {
		ArrayList f1 = new ArrayList();
		f1.add("수박");
		f1.add("딸기");
		f1.add("키위");
		//제네릭이 없는 경우이므로 타입을 확인할 수 없다. Object인것 까지만 확인이 가능함. 
		/*
		for(String str:f1) {
			System.out.println(str);
		}
		*/
		for(Object str:f1) { //쓰고 싶다면 Object  타입에 맞춰줘야 한다. 
			System.out.println(str);
		}
		String my = (String)f1.get(0);
		Object obj = f1.get(2);
		System.out.println(my);
		System.out.println(obj);
		System.out.println("===================[[아래]]======================");
		ArrayList<String> f2 = new ArrayList<String>();
		f2.add("수박");
		f2.add("딸기");
		f2.add("키위");
		f2.add(1, "바나나");// 수박 바나나 딸기 키위 순서가 된다 <-끼워넣기 한것 
		for(String str:f2) {
			System.out.println(str);
		}
		String my2 = f2.get(0);
		Object obj2 = f2.get(2);
		System.out.println(my2);
		System.out.println(obj2);
		ArrayList<ZipCodeVO> f3 = new ArrayList<>();//뒤에는 생략 가능
		ZipCodeVO zVO = new ZipCodeVO();
		zVO.setZipcode(25356);
		zVO.setAddress("서울시 마포구 공덕동 246번지"); //VO에 담고
		f3.add(zVO);
		zVO.setZipcode(21358);
		zVO.setAddress("서울시 구로구 고척동"); //VO에 담고
		f3.add(zVO);
		for(ZipCodeVO rzVO:f3) {
			System.out.println(rzVO);
		}
		System.out.println("조서번지를 두 번 접근한다는게 무슨 말이지?");
		for(ZipCodeVO rzVO:f3) {
			String addr = rzVO.getAddress();
			System.out.println(addr);
		}
	}
}
