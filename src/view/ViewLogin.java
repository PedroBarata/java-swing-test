package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.LoginController;
import jdbc.DBUtils;
import model.Account;

public class ViewLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEmail;
	private JPasswordField pwdPass;

	/**
	 * Launch the application.
	 */
	public ViewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setBounds(97, 70, 251, 31);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(97, 53, 70, 15);
		getContentPane().add(lblEmail);

		JLabel lblPass = new JLabel("Password");
		lblPass.setBounds(97, 144, 70, 15);
		getContentPane().add(lblPass);

		pwdPass = new JPasswordField();
		pwdPass.setText("");
		pwdPass.setBounds(97, 164, 251, 31);
		getContentPane().add(pwdPass);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pwd = String.copyValueOf(pwdPass.getPassword());
				try {
					LoginController loginCtrl = new LoginController();
					Account loggedAcc = loginCtrl.validateLogin(txtEmail.getText(), pwd);
					
					if(loggedAcc != null && loggedAcc.getUserId() != null) {
						JOptionPane.showMessageDialog(null, "Welcome to system " + loggedAcc.getUsername()+ "!");
					} else {
						JOptionPane.showMessageDialog(null, "Invalid email or password!");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnLogin.setBounds(164, 277, 117, 25);
		getContentPane().add(btnLogin);
	}

}
