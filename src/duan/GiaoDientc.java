package duan;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;



public class GiaoDientc extends JFrame implements ActionListener,MouseListener, TreeSelectionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	 private Connection dbCon;
	ArrayList<Thu> listthu =new ArrayList<>();
	ArrayList<Chi>listchi=new ArrayList<>();
	int index =0;
	private JTextField tfsp;
	private JTextField tfspc;
	private JTextField tfgv;
	private JTextField tfnvc;
	private JTextField tfdvc;
	private JTextField tfnc;
	private JTextField tfstc;
	private JTextField tfnv;
	private JTextField tfhv;
	private JTextField tfdv;
	private JTextField tfnt;
	private JTextField tfst;
	private JTextField tftt;
	private JComboBox<String> cbottt;

	private JButton bttquaylai ;
	private JButton bttquaylai1;
	private JButton bttxoa;
	private JButton bttxoa1;
	private JButton bttupdate;
	private JButton bttupdate1;
	private JButton btttimkiem;
	private JButton btttimkiem1;
	private JButton bttthem;
	private JButton bttthem1;
	private JButton btttimkiemtk;
	private JButton bttnew;
	private JButton bttnew1;
	private JButton bttexit;

    private JTable table;
	private JTable table1;

	private DefaultTableModel dfModel;
	private DefaultTableModel dfModel1;

	JFrame frame;
	
    public GiaoDientc() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            dbCon= DriverManager.getConnection("jdbc"+":mysql://localhost:8889/QLThuChi","root","root");
    	}catch (Exception e) {
    		System.out.println(e);
    	}
		add();
          listchi=DBConnection.findAllChi();
          listthu=DBConnection.findAllThu();
		showTable();
		showTableChi();
	}
  
	private void add() {
		frame=new JFrame();
		frame.setBounds(1000,1000,1054,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CHƯƠNG TRÌNH QUẢN LÝ THU CHI ");
		
		JMenuBar menubar=new JMenuBar();
		 setJMenuBar(menubar);
		JMenu mnuFile=new JMenu("File");
		mnuFile.setMnemonic('F'); 
		JMenu mnuEdit=new JMenu("Edit"); 
		mnuEdit.setMnemonic('E'); 
		JMenu mnuView=new JMenu("View");
		mnuView.setMnemonic('V'); 
        JMenu mnuHelp=new JMenu("Help");
		mnuHelp.setMnemonic('H'); 
		JMenu mnuSearch=new JMenu("Search");
		mnuSearch.setMnemonic('S'); 
        menubar.add(mnuFile); 
		menubar.add(mnuEdit);
		menubar.add(mnuView);
		menubar.add(mnuHelp);
		menubar.add(mnuSearch);
		JMenuItem mnuFileNew=new JMenuItem("New"); 
		JMenuItem mnuFileOpen=new JMenuItem("Open");
		JMenuItem mnuFileSave=new JMenuItem("Save");
		JMenuItem mnuFileSaveAs=new JMenuItem("Save as");
		JMenuItem mnuFileExit=new JMenuItem("Exit"); 
		JMenuItem mnuEditUndo=new JMenuItem("Undo"); 
		JMenuItem mnuEditRedo=new JMenuItem("Redo"); 
		JMenuItem mnuEditCut=new JMenuItem("Cut"); 
		JMenuItem mnuEditCopy=new JMenuItem("Copy"); 
		JMenuItem mnuEditPaste=new JMenuItem("Paste"); 
		JMenuItem mnuEditFind=new JMenuItem("Find"); 
		JMenuItem mnuEditReplace=new JMenuItem("Replace"); 
        mnuFile.add(mnuFileNew);
	    mnuFile.add(mnuFileOpen);
		mnuFile.addSeparator(); 
		mnuFile.add(mnuFileSave);
		mnuFile.add(mnuFileSaveAs);
        mnuFile.addSeparator(); 
		mnuFile.add(mnuFileExit);
		mnuEdit.add(mnuEditUndo);
		mnuEdit.add(mnuEditRedo);
		mnuEdit.addSeparator();
		mnuEdit.add(mnuEditCut);
		mnuEdit.add(mnuEditCopy);
		mnuEdit.add(mnuEditPaste);
		mnuEdit.addSeparator();
		mnuEdit.add(mnuEditFind);
		mnuEdit.add(mnuEditReplace);
        frame.add(menubar,BorderLayout.NORTH);

		JTabbedPane tabbedPane=new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel tp=new JPanel();
        tabbedPane.addTab("QUẢN LÝ THU PHÍ", null,tp,null);
		tabbedPane.setForegroundAt(0,Color.BLACK);
		tabbedPane.setMnemonicAt(0, 1055);
		tabbedPane.setBackgroundAt(0, SystemColor.menu);;
		tp.setLayout(null);
        
		JDesktopPane desktopPane1=new JDesktopPane();
		desktopPane1.setDragMode(10);
		desktopPane1.setBackground(Color.LIGHT_GRAY);
		desktopPane1.setBounds(0,0,1402,780);
		desktopPane1.setToolTipText((""));
		desktopPane1.setForeground(Color.GREEN);
		tp.add(desktopPane1);
        JInternalFrame internalFrame=new JInternalFrame("THU");
		internalFrame.setClosable(true);
		internalFrame.setIconifiable(true);
		internalFrame.setMaximizable(true);
		internalFrame.setEnabled(false);
		internalFrame.setBounds(0,0,1400,750);
		internalFrame.setVisible(true);

		JPanel pnBorder=new JPanel();
		pnBorder.setLayout(new BorderLayout());
        JPanel pnlLeft=new JPanel(new GridLayout(0,1));
		pnlLeft.add(new JLabel("THÔNG TIN THU PHÍ ",JLabel.CENTER));
		pnlLeft.add(new JLabel("Số phiếu:"));
		pnlLeft.add(tfsp=new JTextField(20));
		pnlLeft.add(new JLabel("Học viên:"));
		pnlLeft.add(tfhv=new JTextField(20));
		pnlLeft.add(new JLabel("Nhân viên thu:"));
		pnlLeft.add(tfnv=new JTextField(20));
		pnlLeft.add(new JLabel("Dịch vụ:"));
		pnlLeft.add(tfdv=new JTextField(20));
		pnlLeft.add(new JLabel("Ngày thu:"));
		pnlLeft.add(tfnt=new JTextField(20));
		pnlLeft.add(new JLabel("Số tiền:"));
		pnlLeft.add(tfst=new JTextField(20));
		pnlLeft.add(new JLabel("Thu trước:"));
		pnlLeft.add(tftt=new JTextField(20));
		pnlLeft.add(new JLabel("Trạng thái thu:"));
		String[]nop= {" Đã nộp "," Chưa nộp"};
		pnlLeft.add(cbottt=new JComboBox<String>(nop));	
		

	    JPanel bt1;
		pnlLeft.add(bt1=new JPanel());
		bt1.add(bttthem  =new JButton("Thêm  "));
		bttthem  .setMnemonic('T');
		bt1.add(bttxoa=new JButton("Xoá"));
		bttxoa.setMnemonic('X');
		bt1.add(bttupdate =new JButton("Sửa "));
		bttupdate.setMnemonic('S');
		bt1.add(btttimkiem=new JButton("Tìm Kiếm"));
		btttimkiem.setMnemonic('K');
		bt1.add(bttexit=new JButton("EXit"));
		bttexit.setMnemonic('E');
		JPanel bt2;
		pnlLeft.add(bt2=new JPanel());
		bt2.add(bttquaylai=new JButton("Show"));
		bttquaylai.setMnemonic('S');
		bt2.add(bttnew=new JButton("New"));
		bttnew.setMnemonic('N');
		
		desktopPane1.add(internalFrame);
		pnBorder.add(pnlLeft,BorderLayout.WEST);
        JPanel pnlRight=new JPanel(new GridLayout(0,1));
		  String[] hearders={"Số phiếu ","Học viên  ","Nhân viên thu ","Dịch vụ ","Ngày thu  ","Số tiền ","Thu trước ","Trạng thái thu "};
		pnlRight.add(new JScrollPane(table=new JTable(dfModel=new DefaultTableModel(hearders,0))));
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlLeft, pnlRight    );
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);	
		pnBorder.add(splitPane ,BorderLayout.CENTER);
		internalFrame.add(pnBorder);
		bttquaylai.addActionListener(this);
		bttxoa.addActionListener(this);
		bttupdate.addActionListener(this);
		btttimkiem.addActionListener(this);
		bttthem.addActionListener(this);
		bttnew.addActionListener(this);
		bttexit.addActionListener(this);
		table.addMouseListener(this);

		
		JPanel cp=new JPanel();
		tabbedPane.addTab("QUẢN LÝ CHI  ",null,cp,null);
		tabbedPane.setMnemonicAt(0, 1055);
		tabbedPane.setBackgroundAt(0, SystemColor.menu);;
		cp.setLayout(null);
		JDesktopPane desktopPane2=new JDesktopPane();
		desktopPane2.setDragMode(10);
		desktopPane2.setBackground(Color.LIGHT_GRAY);
		desktopPane2.setBounds(0,0,1402,780);
		desktopPane2.setToolTipText((""));
		desktopPane2.setForeground(Color.GREEN);
		cp.add(desktopPane2);
		JInternalFrame internalFrame2=new JInternalFrame("CHI");
		internalFrame2.setClosable(true);
		internalFrame2.setMaximizable(true);
		internalFrame2.setIconifiable(true);
		internalFrame2.setEnabled(false);
		internalFrame2.setBounds(0,0,1400,750);
		internalFrame2.setVisible(true);
        JPanel pnBorder1=new JPanel();
		pnBorder1.setLayout(new BorderLayout());
		JPanel pnlLeft1=new JPanel(new GridLayout(0,1));
		pnlLeft1.add(new JLabel("THÔNG TIN CHI ",JLabel.CENTER));
		pnlLeft1.add(new JLabel("Số phiếu:"));
		pnlLeft1.add(tfspc=new JTextField(20));
		pnlLeft1.add(new JLabel("Giảng viên :"));
		pnlLeft1.add(tfgv=new JTextField(20));
		pnlLeft1.add(new JLabel("Nhân viên chi:"));
		pnlLeft1.add(tfnvc=new JTextField(20));
		pnlLeft1.add(new JLabel("Dịch vụ:"));
		pnlLeft1.add(tfdvc=new JTextField(20));
		pnlLeft1.add(new JLabel("Ngày chi:"));
		pnlLeft1.add(tfnc=new JTextField(20));
		pnlLeft1.add(new JLabel("Số tiền:"));
		pnlLeft1.add(tfstc =new JTextField(20));
        JPanel bt3;
		pnlLeft1.add(bt3=new JPanel());
		bt3.add(bttthem1=new JButton("Thêm "));
		bttthem1.setMnemonic('T');
		bt3.add(bttxoa1=new JButton("Xoá"));
		bttxoa1.setMnemonic('X');
		bt3.add(bttupdate1=new JButton("Sửa"));
		bttupdate1.setMnemonic('S');
		bt3.add(btttimkiem1=new JButton("Tìm Kiếm"));
		btttimkiem1.setMnemonic('K');
		JPanel bt4;
		pnlLeft1.add(bt4=new JPanel());
		bt4.add(bttquaylai1=new JButton("Show"));
		bttquaylai.setMnemonic('S');
		bt4.add(bttnew1=new JButton("New"));
		bttnew1.setMnemonic('N');
		desktopPane2.add(internalFrame2);

		pnBorder1.add(pnlLeft1,BorderLayout.WEST);
		JPanel pnlRight1=new JPanel(new GridLayout(1,1));
		String[] hearders1={"Số phiếu ","Giảng viên ","Nhân viên chi","Dịch vụ ","Ngày chi ","Số tiền "};
		pnlRight1.add(new JScrollPane(table1=new JTable(dfModel1=new DefaultTableModel(hearders1,0))));
	    JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnlLeft1, pnlRight1   );
		splitPane1.setOneTouchExpandable(true);
		splitPane1.setDividerLocation(150);
		pnBorder1.add(splitPane1 ,BorderLayout.CENTER);
        internalFrame2.add(pnBorder1);
		bttquaylai1.addActionListener(this);
		bttxoa1.addActionListener(this);
		bttupdate1.addActionListener(this);
		btttimkiem1.addActionListener(this);
		bttthem1.addActionListener(this);
		bttnew1.addActionListener(this);
		table1.addMouseListener(this);
		

		JPanel tk=new JPanel();
		tabbedPane.addTab("THỐNG KÊ",null,tk,null);
		tabbedPane.setForegroundAt(0,Color.BLACK);
		tabbedPane.setMnemonicAt(0, 1055);
		tabbedPane.setBackgroundAt(0, SystemColor.menu);;
		tk.setLayout(null);
		JDesktopPane desktopPane3=new JDesktopPane();
		desktopPane3.setDragMode(10);
		desktopPane3.setBackground(Color.LIGHT_GRAY);
		desktopPane3.setBounds(0,0,1402,780);
		desktopPane3.setToolTipText((""));
		desktopPane3.setForeground(Color.GREEN);
		tk.add(desktopPane3);
		JInternalFrame internalFrame3=new JInternalFrame("THỐNG KÊ  ");
		internalFrame3.setClosable(true);
		internalFrame3.setMaximizable(true);
		internalFrame3.setIconifiable(true);
		internalFrame3.setEnabled(false);
		internalFrame3.setBounds(0,0,1400,750);
		internalFrame3.setVisible(true);
		desktopPane3.add(internalFrame3 );
        
		JPanel pnBorder3=new JPanel();
        pnBorder3.setLayout(new BorderLayout());
        JPanel pnlLeft3=new JPanel(new GridLayout(0,1));
        pnlLeft3.setBounds(0, 0, 100, 200);
         DefaultMutableTreeNode thongke=new DefaultMutableTreeNode("Thống kê");
         DefaultMutableTreeNode dsthu= new DefaultMutableTreeNode("Thu")  ;
         dsthu.add(new DefaultMutableTreeNode("Danh sách thu"));
         DefaultMutableTreeNode chuanop=new DefaultMutableTreeNode("Chưa nộp");
         DefaultMutableTreeNode danop=new DefaultMutableTreeNode("Đã nộp");
         dsthu.add(chuanop);
         dsthu.add(danop);
         DefaultMutableTreeNode dschi=new DefaultMutableTreeNode("Chi");
         dschi.add(new DefaultMutableTreeNode("Danh sách chi"));
         DefaultMutableTreeNode tong =new DefaultMutableTreeNode("Tổng thu chi");
         tong.add(new DefaultMutableTreeNode("Tổng"));
         thongke.add(dsthu);
         thongke.add(dschi);
         thongke.add(tong);
         final JTree tree=new JTree(thongke);
         pnlLeft3.add(tree);
         JPanel pntk;
         pnlLeft3.add(pntk=new JPanel());
 	     pntk.add(btttimkiemtk=new JButton("Tìm Kiếm"));
 		 btttimkiemtk.setMnemonic('K');
 		 pnBorder3.add(pnlLeft3,BorderLayout.WEST);
        
 		 JPanel pnlRight3=new JPanel();
         pnlRight3.setLayout(new CardLayout());
         pnlRight3.add(new Danhsachthu(),"Danhsachthu");
         pnlRight3.add(new Danhsachchi(),"Danhsachchi");
         pnlRight3.add(new Danop(),"Danop");
         pnlRight3.add(new Chuanop(),"Chuanop");
         pnBorder3.add(pnlRight3,BorderLayout.CENTER);

         internalFrame3.add(pnBorder3);
         tree.addTreeSelectionListener(this);
 		 btttimkiemtk.addActionListener(this);

         tree.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Object o=tree.getLastSelectedPathComponent();
				DefaultMutableTreeNode
				node=(DefaultMutableTreeNode)o;
		        if(node.toString().equals("Danh sách thu"))    {
					CardLayout cl=(CardLayout)pnlRight3.getLayout();
					cl.show(pnlRight3, "Danhsachthu");
				}else if(node.toString().equals("Danh sách chi"))    {
					CardLayout cl=(CardLayout)pnlRight3.getLayout();
					cl.show(pnlRight3, "Danhsachchi");
				}else if(node.toString().equals("Chưa nộp")) {
					CardLayout cl=(CardLayout)pnlRight3.getLayout();
					cl.show(pnlRight3, "Chuanop");
				}else if(node.toString().equals("Đã nộp")) {
					CardLayout cl=(CardLayout)pnlRight3.getLayout();
					cl.show(pnlRight3, "Danop");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
					
			   }				
			});
    }  
	  public void showTable() {
		   	 listthu=DBConnection.findAllThu();
		   	dfModel.setRowCount(0);
		       listthu.forEach((thu) -> {
		       dfModel.addRow(new Object[] {thu.getsophieu(),thu.gethocvien(),thu.getnhanvien(),thu.getdichvu(),thu.getngaythu(),thu.getsotien(),thu.getthutruoc(),
		       		thu.gettrangthaithu(),thu.getdiachi()});
		       });
		       
		       }
		    public void showTableChi() {
		      listchi=DBConnection.findAllChi();
		      dfModel1.setRowCount(0);
			  listchi.forEach((chi)  -> {
		    	dfModel1.addRow(new Object[] { chi.getsophieuchi(),chi.getgiangvien(),chi.getnhanvienchi(),chi.getdichvuchi(),chi.getngaychi(),chi.getsotienchi()});
		    });
		      
		    }
		    
	public static void main(String[]args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDientc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDientc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDientc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDientc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		EventQueue.invokeLater(new Runnable(){
			public void run(){
	try{
		GiaoDientc window=new GiaoDientc();
		window.frame.setVisible(true);
	}catch(Exception e){
		e.printStackTrace();
	}
   }
 });
}
    public boolean check() {
    	if(tfsp.getText().equals("")||tfhv.getText().equals("")||tfnv.getText().equals("")||tfdv.getText().equals("")||tfnt.getText().equals("")||tfst.getText().equals("")||tftt.getText().equals("")) {
    		 JOptionPane.showMessageDialog(rootPane, "Hãy nhập đủ dữ liệu sau đó ấn Thêm ");
             return false;	
    	}
		return true;
    }
    public boolean checkchi() {
    	if(tfspc.getText().equals("")||tfgv.getText().equals("")||tfnvc.getText().equals("")||tfdvc.getText().equals("")||tfnc.getText().equals("")||tfstc.getText().equals("")) {
   		 JOptionPane.showMessageDialog(rootPane, "Hãy nhập đủ dữ liệu sau đó ấn Thêm ");
         return false;
    	}
    	return true;
    }
    public void napVaoONhapLieuThu(int index) {
        tfsp.setText(String.valueOf(listthu.get(index).getsophieu()));
    	tfhv.setText(listthu.get(index).gethocvien());
    	tfnv.setText(listthu.get(index).getnhanvien());
    	tfdv.setText(listthu.get(index).getdichvu());
    	tfnt.setText(listthu.get(index).getngaythu());
    	tfst.setText(String.valueOf(listthu.get(index).getsotien()));
    	tftt.setText(String.valueOf(listthu.get(index).getthutruoc()));
    	cbottt.setToolTipText(listthu.get(index).gettrangthaithu());
    }
    public void napVaoONhapLieuChi(int index) {
    	tfspc.setText(String.valueOf(listchi.get(index).getsophieuchi()));
    	tfgv.setText(listchi.get(index).getgiangvien());
    	tfnvc.setText(listchi.get(index).getnhanvienchi());
    	tfdvc.setText(listchi.get(index).getdichvuchi());
    	tfnc.setText(listchi.get(index).getngaychi());
    	tfstc.setText(String.valueOf(listchi.get(index).getsotienchi()));  
    }
    @Override
	public void mouseClicked(MouseEvent e) {
		thuclicked();
		chiclicked();
	}
    
	
	private void thuclicked() {
		try {
			index=table.getSelectedRow();
			napVaoONhapLieuThu(index);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	private void chiclicked() {
		try {
			index=table1.getSelectedRow();
			napVaoONhapLieuChi(index);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(bttupdate)) updateAction();
		else if(e.getSource().equals(bttxoa))xoaAction();
		else if(e.getSource().equals(btttimkiem))timkiemAction();
		else if(e.getSource().equals(bttquaylai)) saveAction();
		else if(e.getSource().equals(bttthem))themAction();
		else if(e.getSource().equals(bttnew))newAction();
		else if(e.getSource().equals(bttxoa1))xoachiAction();
		else if(e.getSource().equals(btttimkiem1))timkiemchiAction();
		else if(e.getSource().equals(bttquaylai1))savechiAction();
		else if(e.getSource().equals(bttthem1))themchiAction();
		else if(e.getSource().equals(bttnew1))newchiAction();
		else if(e.getSource().equals(bttupdate1))updatechiAction();
		else if(e.getSource().equals(btttimkiemtk))timkiemtkAction();
		else if(e.getSource().equals(bttexit)) exitac();
}
	
  
private void exitac() {
       System.exit(0);		
	}

private void newAction() {
		tfsp.setText("");
		tfhv.setText("");
		tfnv.setText("");
		tfdv.setText("");
		tfnt.setText("");
		tfst.setText("");
		tftt.setText("");
		cbottt.setToolTipText("");
	 }	
   private void newchiAction() {
	   tfspc.setText("");
	   tfgv.setText("");
	   tfnvc.setText("");
	   tfdvc.setText("");
	   tfnc.setText("");
	   tfstc.setText("");
   }
   public boolean addThu(Thu thu) {
		 String sql="insert into THU (sophieu, hocvien, nhanvien, dichvu, ngaythu, sotien, thutruoc, trangthaithu)"+"values(?,?,?,?,?,?,?,?)";
	 try {           
		PreparedStatement ps = dbCon.prepareStatement(sql);
	    		ps.setInt(1, thu.getsophieu());
	            ps.setString(2, thu.gethocvien());
	            ps.setString(3, thu.getnhanvien());
	            ps.setString(4, thu.getdichvu());
	            ps.setString(5, thu.getngaythu());
	            ps.setDouble(6, thu.getsotien());
	            ps.setDouble(7, thu.getthutruoc());
	            ps.setString(8, thu.gettrangthaithu());
	            return ps.executeUpdate()>0;
	    	}catch(Exception e) {
	      	   System.out.println(e);
	    	}
			return false;
	    }
   public boolean addChi(Chi chi) {
	   String sql="insert into CHI (sophieuchi,giangvien,nhanvienchi,dichvuchi,ngaychi,sotienchi)"+"values(?,?,?,?,?,?)";
	   try {
		   PreparedStatement ps=dbCon.prepareStatement(sql);
		   ps.setInt(1,chi.getsophieuchi());
		   ps.setString(2, chi.getgiangvien());
		   ps.setString(3, chi.getnhanvienchi());
		   ps.setString(4, chi.getdichvuchi());
		   ps.setString(5, chi.getngaychi());
		   ps.setDouble(6, chi.getsotienchi());
		   return ps.executeUpdate()>0;
	   }catch(Exception e) {
		   System.out.println(e);
	   }
	   return false;
   }
   private void themAction() {
  	 if(check()) { 
				 Thu thu=new Thu();
			     thu.setsophieu(Integer.parseInt((tfsp.getText())));
			     thu.sethocvien(tfhv.getText());
			     thu.setnhanvien(tfnv.getText());
			     thu.setdichvu(tfdv.getText());
			     thu.setngaythu(tfnt.getText());
			     thu.setsotien(Double.parseDouble(tfst.getText()));
		         thu.setthutruoc(Double.parseDouble(tftt.getText()));
	    	     thu.settrangthaithu(cbottt.getSelectedItem().toString());
			     listthu.add(thu);
			     if(addThu(thu)) {
	                 JOptionPane.showMessageDialog(rootPane, "Lưu thành công ");
			     }else {
	                 JOptionPane.showMessageDialog(rootPane, "Trùng số phiếu !");
			     } 
		           showTable();
		     }
   }
   private void themchiAction() {
	   if(checkchi()) {
		   Chi chi=new Chi();
		   chi.setsophieuchi(Integer.parseInt((tfspc.getText())));
		   chi.setgiangvien(tfgv.getText());
		   chi.setnhanvienchi(tfnvc.getText());
		   chi.setdichvuchi(tfdvc.getText());
		   chi.setngaychi(tfnc.getText());
		   chi.setsotienchi(Double.parseDouble(tfstc.getText()));
		   listchi.add(chi);
		   if(addChi(chi)) {
               JOptionPane.showMessageDialog(rootPane, "Lưu thành công ");
		   }else {
			   JOptionPane.showMessageDialog(rootPane, "Trùng số phiếu !");
		     } 
	       showTableChi();
	   }
   }
   private void updateAction() {
		try {
	          String sql="update THU set hocvien=?,nhanvien=?,dichvu=?,ngaythu=?,sotien=?,thutruoc=?,trangthaithu=? where THU.sophieu=?";
	          PreparedStatement ps = dbCon.prepareStatement(sql);
	          index=table.getSelectedRow();
			if(listthu.size() == 0) {
            JOptionPane.showMessageDialog(rootPane, " Hãy nhập thêm học viên rồi Sửa!");
           }
			else if(index==-1) {
           JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn dòng có học viên cần Sửa !");
           }else {
	                 ps.setString(1, tfhv.getText());
	                 ps.setString(2, tfnv.getText());
	                 ps.setString(3, tfdv.getText());
	                 ps.setString(4, tfnt.getText());
	                 ps.setDouble(5, Double.parseDouble(tfst.getText()));
	                 ps.setDouble(6, Double.parseDouble(tftt.getText()));
	                 ps.setString(7, cbottt.getToolTipText());
	                 ps.setInt(8, Integer.parseInt(tfsp.getText()));
	                 ps.executeUpdate ();
	                showTable();
                   JOptionPane.showMessageDialog(rootPane, "Sửa   thành công ");
			}} 
		catch(Exception e){
	         JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn dòng có học viên cần Sửa !");
	         }
}
   private void updatechiAction() {
	   try {
		   String sql="update CHI set giangvien=?,nhanvienchi=?,dichvuchi=?,ngaychi=?,sotienchi=? where CHI.sophieuchi=?";
		   PreparedStatement ps=dbCon.prepareStatement(sql);
		   index=table1.getSelectedRow();
		   if (listchi.size()==0) {
			   JOptionPane.showMessageDialog(rootPane, " Hãy nhập thêm giảng viên rồi Sửa!");
           }
			else if(index==-1) {
           JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn dòng có giảng viên cần Sửa !");
           }else {
        	   ps.setString(1, tfgv.getText());
        	   ps.setString(2, tfnvc.getText());
        	   ps.setString(3, tfdvc.getText());
        	   ps.setString(4, tfnc.getText());
        	   ps.setDouble(5, Double.parseDouble(tfstc.getText()));
        	   ps.setInt(6, Integer.parseInt(tfspc.getText()));
	           ps.executeUpdate ();
	           showTableChi();
               JOptionPane.showMessageDialog(rootPane, "Sửa   thành công ");
           }
	   }catch(Exception e) {
	         JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn dòng có học viên cần Sửa !");
	   }
   }
   private void timkiemAction() {
	    String input=JOptionPane.showInputDialog(rootPane," Chọn học viên để tìm kiếm ");
	    if(input!=null&& input.length()>0) {
	    	listthu=DBConnection.findhocvien(input);
	    	dfModel.setRowCount(0);
	       
	    	listthu.forEach((thu)->
	    	{dfModel.addRow(new Object[] {
	    			thu.getsophieu(),thu.gethocvien()
	    			,thu.getnhanvien(),thu.getdichvu(),thu.getngaythu(),thu.getsotien(),thu.getthutruoc(),thu.gettrangthaithu(),thu.getdiachi()});
	    		
	    	});
	    }  else {
	    	showTable();
	    }
	}
   private void timkiemchiAction() {
	   String input=JOptionPane.showInputDialog(rootPane," Chọn giảng viên để tìm kiếm ");
	    if(input!=null&& input.length()>0) {
	    	listchi=DBConnection.findgiangvien(input);
	    	dfModel1.setRowCount(0);
	    	
	    	listchi.forEach((chi)->
	    	{dfModel1.addRow(new Object[] {
	        		chi.getsophieuchi(),chi.getgiangvien(),chi.getnhanvienchi(),chi.getdichvuchi(),chi.getngaychi(),chi.getsotienchi()});
	    	});
	    }else {
	    	showTableChi();
	    }
   }
   private void timkiemtkAction() {
	   String input=JOptionPane.showInputDialog(rootPane," Chọn tên  để tìm kiếm ");
	   if(input!=null&& input.length()>0) {
		   
	   }

   }
    private void xoaAction() {
		int index=table.getSelectedRow();
		if(index >=0) {
			Thu thu=listthu.get(index);
			
           int option=JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xoá không?");
           System.out.println("option:"+option);
       if(option==0) {
       	DBConnection.deleteThu(thu.getsophieu());
       	showTable();
       }
    }
}
    private void xoachiAction() {
    	int index=table1.getSelectedRow();
    	if(index>=0) {
    		Chi chi=listchi.get(index);
    		int option=JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn xoá không?");
            System.out.println("option:"+option);
            if(option==0) {
                 DBConnection.deletechi(chi.getsophieuchi());
                 showTableChi();
    	}
    }
}   	
	private void saveAction() {
		try {
	          String sql="select * from THU ";
	          dbCon.prepareStatement(sql);
	         showTable();
		}catch(Exception e) {
		   System.out.println(e);
	   }
}
	private void savechiAction() {
		try {
			String sql="select*from CHI";
			dbCon.prepareStatement(sql);
			showTableChi();
		}catch(Exception e) {
		    System.out.println(e);
		}
	}
	
	 
@Override
public void valueChanged(TreeSelectionEvent e) {
	// TODO Auto-generated method stub
	
}
}
		
    