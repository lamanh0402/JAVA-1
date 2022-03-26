package duan;

import java.awt.GridLayout;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Danhsachchi extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection dbCon;
	ArrayList<Chi> listchi =new ArrayList<>();

	private DefaultTableModel dm;
	public Danhsachchi() {
        setLayout(new GridLayout(1,0));
		DefaultTableModel dm=new DefaultTableModel();
        dm.addColumn("Số phiếu ");
        dm.addColumn("Giảng viên ");
        dm.addColumn("Nhân viên chi  ");
        dm.addColumn("Dịch vụ ");
        dm.addColumn("Ngày chi ");
        dm.addColumn("Số tiền ");
		final JTable tbl=new JTable(dm);
		JScrollPane sc=new JScrollPane(tbl);
		add(sc);
		showTable(dm);
	}
	 public void showTable(DefaultTableModel dm) {
	   	 listchi=DBConnection.findAllChi();
	   	dm.setRowCount(0);
	       listchi.forEach((chi) -> {
	       dm.addRow(new Object[] {chi.getsophieuchi(),chi.getgiangvien(),chi.getnhanvienchi(),chi.getdichvuchi(),chi.getngaychi(),chi.getsotienchi()});
	       });
	       
	       }

}
