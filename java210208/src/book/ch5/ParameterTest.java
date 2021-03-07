package book.ch5;

public class ParameterTest {
   String g_rdname = null;
   static int methodA() {
      return 100;
   }
   static int methodA(int p_empno) {
      return 100;
   }
   void methodA(int p_empno, String rdname) {
      g_rdname = rdname;
   }
   public static void main(String[] args) {
	   	int y = methodA(7566);				 //이것도 되고, 아래도 되지만!
		int x = ParameterTest.methodA(7566); //class명을 붙여주면 더 직관적이라서 앞에 클래스명을 쓰고, static메소드를 써주는게 좋다.
		System.out.println(y+x);
		String rdname = "개발2팀";
		ParameterTest pt = new ParameterTest();//1번 얘는 재사용이 가능/풍선 끈이 존재
		pt.methodA();
		pt.methodA(7566, rdname);
		System.out.println(new ParameterTest().g_rdname);//2번 얘는 재사용 불가능/풍선 끈이 없다
		System.out.println(pt.g_rdname);
	}

}
