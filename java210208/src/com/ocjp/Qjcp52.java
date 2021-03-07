package com.ocjp;

enum Dogs {collie, harrier, shepherd};

public class Qjcp52 {
	void m() {
		System.out.println(Dogs.collie);
		System.out.println(Dogs.harrier);
		System.out.println(Dogs.shepherd);
		String name = "이순신" ; //switch 안에 string 타입 가능함. 
		switch(name) {
			case "이순신" :
				System.out.println("이순신");
			break;
			case "김유신" :
			System.out.println("김유신");
				break;
		}// end of switch
	}

	public static void main(String[] args) {
		Dogs myDog = Dogs.shepherd;
		switch(myDog) {
			case collie:
				System.out.println("collie");
			case shepherd:
				System.out.println("shepherd");
			case harrier:
				System.out.println("harrier");
		}//end of switch
	}//////end of main
}//////////end of Qcjp52
