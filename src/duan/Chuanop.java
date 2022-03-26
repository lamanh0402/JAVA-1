package duan;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Chuanop extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Thu> listthu =new ArrayList<>();

	public Chuanop() {
        setLayout(new GridLayout(1,0));
		DefaultTableModel dm=new DefaultTableModel();
        dm.addColumn("Số phiếu ");
        dm.addColumn("Học viên ");
        dm.addColumn("Nhân viên ");
        dm.addColumn("Dịch vụ ");
        dm.addColumn("Ngày thu ");
        dm.addColumn("Số tiền ");
        dm.addColumn("Thu trước ");
        dm.addColumn("Trạng thái thu ");
		final JTable tbl=new JTable(dm);
		JScrollPane sc=new JScrollPane(tbl);
		add(sc);
		showTablet (dm);
	}
	 public void showTablet (DefaultTableModel dm) {
	   	 listthu=DBConnection.findchuanop(toString());
	   	dm.setRowCount(0);
	       listthu.forEach((thu) -> {
	       dm.addRow(new Object[] {thu.getsophieu(),thu.gethocvien(),thu.getnhanvien(),thu.getdichvu(),thu.getngaythu(),thu.getsotien(),thu.getthutruoc(),
	       		thu.gettrangthaithu()});
	       });
	       
	       }

}


