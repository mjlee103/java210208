package mybatis210409;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductCon implements ActionListener{
	ProductView pv   = null;
	ProductDao  pd   = new ProductDao();
 	public ProductCon(ProductView pv) {
		this.pv = pv;
	}
 	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		String command = ae.getActionCommand();
		if(obj == pv.jmi_selALL) {
			pd.refresh(this);
		}
		
		else if(obj == pv.jmi_sel) {
			pd.condition("jmi_sel",this);
		}
		/*
		else if(obj == pv.jmi_ins) {
			pd.set("입력", null, pv, true,true,this);
		}
		else if(obj == pv.jmi_upd) {
			pd.condition("jmi_upd",this);
		}
		else if(obj == pv.jmi_del) {
			pd.delete(this);
		}
		else if("처리".contentEquals(command)) {
			pd.updateORnewproduct(this);
		}
		else if("닫기".contentEquals(command)) {  
			pv.pDia.dispose();
		}
	*/
	}

}
