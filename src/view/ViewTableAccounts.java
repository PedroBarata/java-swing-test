package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.AccountTableController;

//To open with another View
public class ViewTableAccounts extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the application.
	 */
	public ViewTableAccounts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 426, 202);
		panel.add(scrollPane);

		Object[] columns = { "Username", "E-mail" };
		AccountTableController tableCtrl = new AccountTableController();
		table = tableCtrl.createTable(columns);

		scrollPane.setViewportView(table);

	}

}
