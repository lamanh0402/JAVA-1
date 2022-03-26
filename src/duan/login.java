
package duan;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener{
	JTextField jtfUserName, jtfPwd;
	
	public login() {
        setSize(350, 150);
        setTitle("ĐĂNG NHẬP");
		
		setLayout(new GridLayout(3,2));
		
		JLabel jlbUserName = new JLabel("UserName");
		add(jlbUserName);
		
		jtfUserName = new JTextField(20);
		add(jtfUserName);

		JLabel jlbPwd = new JLabel("Password");
		add(jlbPwd);
		
		jtfPwd = new JPasswordField(20);
		add(jtfPwd);
		
		JButton jbtLogin = new JButton("Login");
		jbtLogin.addActionListener(this);
		add(jbtLogin);
		
		JButton jbtReset = new JButton("Reset");
		jbtReset.addActionListener(this);
        add(jbtReset);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String nameButton = e.getActionCommand();//e.getSource()
        if(nameButton.equals("Reset")) {
        	jtfUserName.setText("");
    		jtfPwd.setText("");
        }
        if(nameButton.equals("Login")){
			if(jtfUserName.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Username is empty! \n");
				}
		    if(jtfPwd.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Password is empty! \n");
		   

			if(jtfUserName.getText().equals("lttbinh20it2") && jtfPwd.getText().equals("123")) {
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
				this.setVisible(false);
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
		}
	}

	public static void main(String args[]) {
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
		new login();
	}
	
}
