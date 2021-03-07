package ch5.singleton;

public class Testing {

	public static void main(String[] args) {
		Singleton1_1 s1 = new Singleton1_1();
		System.out.println("s1:"+s1);
		s1 = null;
		s1 = new Singleton1_1(); 
		System.out.println("s1:"+s1);//#10-11넘어갈때 Candidate 상태로 바진다.     => 다른 주소번지 찍힘.
		s1 = null;
		s1 = new Singleton1_1();
		System.out.println("s1:"+s1);
		Singleton1_1 uniqueInstance = Singleton1_1.getInstance(); //메인 안에 있기 때문에 지역변수여서 s1 이라고 하는 것과 차이 없음
		System.out.println("uniqueInstnace:"+uniqueInstance);
		Singleton1_1 uniqueInstance2 = Singleton1_1.getInstance();     
		System.out.println("unizueInstance2:"+uniqueInstance2);
		Singleton1_1 uniqueInstance3 = Singleton1_1.getInstance();   //    => 같은 주소번지 찍힘.
		System.out.println("uniqueInstance3:"+uniqueInstance3);
		

	}

}
