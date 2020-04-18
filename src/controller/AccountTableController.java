package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Account;

public class AccountTableController {

	public JTable createTable(Object[] columns) {
		JTable table = new JTable();
		table.setModel(createAndPopulateModel(columns));
		return table;
	}

	private DefaultTableModel createAndPopulateModel(Object[] columns) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);

		Account acc = new Account();
		ResultSet result = acc.getAllAccounts();

		int colNumber;
		try {
			colNumber = result.getMetaData().getColumnCount();
			while (result.next()) {
				Object[] data = new Object[colNumber];
				for (int i = 0; i < colNumber; i++) {
					data[i] = result.getObject(i + 1);
				}
				model.addRow(data);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
}
