package mybatis210409;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductDia extends JDialog{
	   ///화면에 나올 이름들///////////////////////////////////////////
	   JPanel       jp_center       	= new JPanel();
	   JLabel       jlb_productno   	= new JLabel("제품번호");
	   JTextField   jtf_productno   	= new JTextField();
	   JLabel       jlb_productname		= new JLabel("제품명");
	   JTextField   jtf_productname 	= new JTextField();
	   JLabel       jlb_danga           = new JLabel("단가");
	   JTextField   jtf_danga           = new JTextField();
	   JLabel       jlb_productcompany  = new JLabel("제조업체");
	   JTextField   jtf_productcompany  = new JTextField();
	   
	   JPanel       jp_south    = new JPanel();
	   JButton     jbtn_account = new JButton("처리");
	   JButton    jbtn_close    = new JButton("닫기");
	   
	   ProductView pv   = null;
	   public ProductDia(ProductView pv) {
		   this.pv = pv;
		   this.initDisplay();
	   }
	public void initDisplay() {
		  jp_center.setLayout(null);
	      jlb_productno.setBounds(20, 20, 100, 20);
	      jtf_productno.setBounds(130, 20, 100, 20);
	      jlb_productname.setBounds(20, 45, 100, 20);
	      jtf_productname.setBounds(130, 45, 150, 20);
	      jlb_danga.setBounds(20, 70, 100, 20);
	      jtf_danga.setBounds(130, 70, 150, 20);
	      jlb_productcompany.setBounds(20, 95, 100, 20);
	      jtf_productcompany.setBounds(130, 95, 150, 20);
	      jp_center.add(jlb_productno);
	      jp_center.add(jtf_productno);
	      jp_center.add(jlb_productname);
	      jp_center.add(jtf_productname);
	      jp_center.add(jlb_danga);
	      jp_center.add(jtf_danga);
	      jp_center.add(jlb_productcompany);
	      jp_center.add(jtf_productcompany);
	      
	      jbtn_account.addActionListener(pv.pc);
	      jbtn_close.addActionListener(pv.pc);
	      jp_south.add(jbtn_account);
	      jp_south.add(jbtn_close);

	      this.add("Center", jp_center);
	      this.add("South",jp_south);
	      this.setTitle("");
	      this.setSize(500, 400);
	      this.setVisible(false);
	   }
}
