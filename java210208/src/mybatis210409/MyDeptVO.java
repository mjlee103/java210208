package mybatis210409;
//제품테이블
public class MyDeptVO {
	private String productnum=null;
	private int    danga=0;
	private String productname=null;
	private String productcompany=null;
	public String getProductnum() {
		return productnum;
	}
	public void setProductnum(String productnum) {
		this.productnum = productnum;
	}
	public int getDanga() {
		return danga;
	}
	public void setDanga(int danga) {
		this.danga = danga;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductcompany() {
		return productcompany;
	}
	public void setProductcompany(String productcompany) {
		this.productcompany = productcompany;
	}
}
