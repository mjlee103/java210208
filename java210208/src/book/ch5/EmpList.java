package book.ch5;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class EmpList {
	public String[] getEmpDetail(int empno) {
		String[] info = new String[2];
		EmpVO eVO = new EmpVO();
		eVO.setEmpno(7566);
		int deptno = eVO.getDeptno(); //7566사원에 대한 부서번호일 것이다.
		String ename = eVO.getEname();
		info[0] = ename;
		DeptVO dVO = new DeptVO();
		dVO.setDeptno(deptno); //emp테이블에서 얻어온 7566 사원에 대한 부서번호이다.
		String dname = dVO.getDname();
		info[1] = dname;
		return info;
		
	}
		

	public static void main(String[] args) {
		/*변수명을 지정하지 않으면 주소가 버려지는 예시 
		 * EmpVO eVO = new EmpVO();
			eVO = new EmpVO();
			eVO = new EmpVO();		
			eVO = new EmpVO();
		 */
	}

}
