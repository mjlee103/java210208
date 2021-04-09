package mybatis210409;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductView{
	JFrame    jf           = null;
	JMenuBar  jbm          = new JMenuBar();
	JMenu     jm_file      = new JMenu("File");
	JMenuItem jmi_sel      = new JMenuItem("상세조회");
	JMenuItem jmi_selALL   = new JMenuItem("전체조회");
	JMenuItem jmi_ins      = new JMenuItem("입력");
	JMenuItem jmi_upd      = new JMenuItem("수정");
	JMenuItem jmi_del      = new JMenuItem("삭제");
	
	//테이블 그리기
	String cols[] = {"제품번호","제품이름","단가","제조업체"};d
	String data[][] = new String[0][4];
	DefaultTableModel    dtm_dept = new DefaultTableModel(data,cols);
	JTable             	 jtb_dept = new JTable(dtm_dept);
	JScrollPane          jsp_dept = new JScrollPane(jtb_dept);
	ProductCon pc = null;
	ProductDia  pDia = null;

	public void initDisplay() {
		jf   = new JFrame();
		pc   = new ProductCon(this);
		pDia = new ProductDia(this);
	    jmi_ins.addActionListener(pc);
	    jmi_sel.addActionListener(pc);
	    jmi_selALL.addActionListener(pc);
	    jmi_upd.addActionListener(pc);
	    jmi_del.addActionListener(pc);
		
		jm_file.add(jmi_selALL);
	    jm_file.add(jmi_sel);
	    jm_file.add(jmi_ins);
	    jm_file.add(jmi_upd);
	    jm_file.add(jmi_del);
		jbm.add(jm_file);
		jf.setJMenuBar(jbm);
	    jf.setTitle("제품목록");
	    jf.add("Center",jsp_dept);
	    jf.setSize(500, 400);
	    jf.setVisible(true);
	}
	public static void main(String[] args) {
		ProductView aBook = new ProductView();
		aBook.initDisplay();
	}
}