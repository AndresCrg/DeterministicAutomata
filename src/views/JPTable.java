package views;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class JPTable extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable table;
	private JTableHeader tableHeader;
	private JScrollPane scroll;
	private ArrayList<Character> language;
	private ArrayList<String> statusNames;
	private ArrayList<String> transitions;
	private ArrayList<String> finalStatus;
	private String initialStatus;

	public JPTable() {
		this.setBackground(Color.WHITE);
		this.initComponents();
		language = new ArrayList<Character>();
		statusNames = new ArrayList<String>();
		transitions = new ArrayList<String>();
	}

	public void initComponents() {

		model = new DefaultTableModel();
		table = new JTable(model);
		tableHeader = table.getTableHeader();
		tableHeader.setBackground(Color.BLACK);
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		((DefaultTableCellRenderer) tableHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		scroll = new JScrollPane(table);
		scroll.setBackground(Color.orange);
		this.add(scroll);
	}

	public void generateHeaders() {
		int i = 1;

		if (language != null) {
			String[] header = new String[language.size() + 1];
			header[0] = "Estados";
			for (char character : language) {
				header[i] = "" + character;
				i++;
			}
			model.setColumnIdentifiers(header);
		}
	}

	public void generateStatus() {
		if (table.getRowCount() != 0) {
			int aux = 0;
			while (aux < table.getRowCount()) {
				model.removeRow(aux);
			}
		}
		if (statusNames.size() != 0) {
			for (String string : statusNames) {
				if (string.equals(initialStatus)&& !this.isFinalStatus(string) ) {
					model.addRow(this.convertStatus("->" + string));
				} else if (this.isFinalStatus(string)&& !string.equals(initialStatus)) {
					model.addRow(this.convertStatus("*" + string));
				} else if (this.isFinalStatus(string)&& string.equals(initialStatus)) {
					model.addRow(this.convertStatus("->*" + string));
				}else {
					model.addRow(this.convertStatus(string));
				}
			}
		}
	}

	private boolean isFinalStatus(String status) {
		boolean result = false;
		if (finalStatus != null) {
			for (String string : finalStatus) {
				if (string.equals(status)) {
					result = true;
				}
			}
		}
		return result;
	}

	public void generateTransitions() {
		if (table.getRowCount() != 0) {
			int aux = 0;
			while (aux < table.getRowCount()) {
				model.removeRow(aux);
			}
		}
		if (statusNames.size() != 0) {
			for (String string : statusNames) {
				model.addRow(convertToStringTransitions(transitions, string));

			}
		}
	}

	public void selectInitalStatus(String name) {
		boolean isTrue = true;
		for (int i = 0; i < statusNames.size() && isTrue; i++) {
			if (statusNames.get(i).equals(name)) {
				String result = "->" + statusNames.get(i);
				statusNames.set(i, result);
				isTrue = false;
			}
		}
	}
	
	public String[] convertToStringTransitions(ArrayList<String> transitions, String status) {
		String[] auxTransition = new String[3];
		String[] result = new String[language.size() + 1];
		for (String string : transitions) {
			auxTransition = string.split("#");
			if (auxTransition[0].equals(status)) {

				result[0] = status;

				for (int i = 0; i < language.size(); i++) {
					if (language.get(i) == auxTransition[1].charAt(0)) {
						if (auxTransition[2].equals("/")) {
							result[i + 1] = "/";

						} else {
							result[i + 1] = auxTransition[2];

						}
					}
				}
			}
			if (auxTransition[0].equals("->" + status)) {
				result[0] = "->" + status;
				for (int i = 0; i < language.size(); i++) {
					if (language.get(i) == auxTransition[1].charAt(0)) {
						if (auxTransition[2].equals("/")) {
							result[i + 1] = "/";
						} else {
							result[i + 1] = auxTransition[2];
						}
					}
				}
			}

			if (auxTransition[0].equals("* " + status)) {
				result[0] = "* " + status;
				for (int i = 0; i < language.size(); i++) {
					if (language.get(i) == auxTransition[1].charAt(0)) {
						if (auxTransition[2].equals("/")) {
							result[i + 1] = "/";
						} else {
							result[i + 1] = auxTransition[2];
						}
					}
				}
			}

			if (auxTransition[0].equals("-> * " + status)) {
				result[0] = "-> * " + status;
				for (int i = 0; i < language.size(); i++) {
					if (language.get(i) == auxTransition[1].charAt(0)) {
						if (auxTransition[2].equals("/")) {
							result[i + 1] = "/";
						} else {
							result[i + 1] = auxTransition[2];
						}
					}
				}
			}
		}
		return result;
	}

	public String[] convertStatus(String status) {
		int quantity = 1;
		if (language.size() != 0) {
			quantity = language.size();
		}
		String[] result = new String[quantity];
		result[0] = status;
		return result;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTableHeader getTableHeader() {
		return tableHeader;
	}

	public void setTableHeader(JTableHeader tableHeader) {
		this.tableHeader = tableHeader;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public ArrayList<Character> getLanguage() {
		return language;
	}

	public void setLanguage(ArrayList<Character> language) {
		this.language = language;
	}

	public ArrayList<String> getStatusNames() {
		return statusNames;
	}

	public void setStatusNames(ArrayList<String> statusNames) {
		this.statusNames = statusNames;
	}

	public ArrayList<String> getTransitions() {
		return transitions;
	}

	public void setTransitions(ArrayList<String> transitions) {
		this.transitions = transitions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInitialStatus() {
		return initialStatus;
	}

	public void setInitialStatus(String initialStatus) {
		this.initialStatus = initialStatus;
	}

	public ArrayList<String> getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(ArrayList<String> finalStatus) {
		this.finalStatus = finalStatus;
	}

	public void addFinalStatus(String name) {
		finalStatus.add(name);
	}

}