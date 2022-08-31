package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import controller.Action;
import controller.Controller;

public class PnlTableTest extends JDialog{

	private static final Color MY_RED_COLOR = Color.decode("#e65124");
	private static final Color MY_GREEN_COLOR = Color.decode("#76b900");
	private static final long serialVersionUID = 1L;
	private static final String INPUT_STRING = "Input";
	private static final String RESULT = "Result";
	private static final String VIEW_STATE_ROUTE = "View Route";
	private static final String RUN_INPUTS_TXT = "Run Inputs";
	private static final String CLEAR_TXT = "Clear";
	private static final Font FONT_CANDARA_LIGTH_DATA = new Font("Candara Light", Font.PLAIN, 19);
	private static final Font FONT_CANDARA_LIGTH_TITLE = new Font("Candara Light", Font.BOLD, 22);
	private static final Color MY_COLOR_WHITE = Color.decode("#ffffff");
	private static final Color MY_COLOR_BLACK = Color.decode("#000000");
	private JTable tableValidateInputs;
	private DefaultTableModel model;
	private TableCellEditor tableCellEditor;
	private TableCellRenderer tableCellRenderer;
	private Controller controller;
	
	public PnlTableTest(Controller controller) {
		setLayout(new BorderLayout());
		setSize(550, 600);
		this.controller = controller;
		model = new DefaultTableModel(new Object[] {}, 1); 
		model.setColumnIdentifiers(new String[] {INPUT_STRING, RESULT, VIEW_STATE_ROUTE});
		tableValidateInputs = new JTable(model);
		tableValidateInputs.getTableHeader().setFont(FONT_CANDARA_LIGTH_TITLE);
		tableValidateInputs.getTableHeader().setBackground(Color.BLACK);
		tableValidateInputs.getTableHeader().setForeground(Color.WHITE);
		tableValidateInputs.setFont(FONT_CANDARA_LIGTH_DATA);
		tableValidateInputs.setAlignmentY(CENTER_ALIGNMENT);
		this.setLocationRelativeTo(null);
		tableValidateInputs.setRowHeight(25);
		tableValidateInputs.addKeyListener(controller);
		tableCellRenderer = new TableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				return (JButton) value;
			}
		};
		tableCellEditor = new TableCellEditor() {
			
			@Override
			public boolean stopCellEditing() {
				return true;
			}
			
			@Override
			public boolean shouldSelectCell(EventObject anEvent) {
				return false;
			}
			
			@Override
			public void removeCellEditorListener(CellEditorListener l) {
				
			}
			
			@Override
			public boolean isCellEditable(EventObject anEvent) {
				return true;
			}
			
			@Override
			public Object getCellEditorValue() {
				return null;
			}
			
			@Override
			public void cancelCellEditing() {
				
			}
			
			@Override
			public void addCellEditorListener(CellEditorListener l) {
				
			}
			
			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
				return (JButton)value;
			}
		};

		add(new JScrollPane(tableValidateInputs), BorderLayout.CENTER);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setBackground(MY_COLOR_WHITE);
		
		JButton btnRunInputs = configBtn(controller, Action.RUN_INPUTS, RUN_INPUTS_TXT, MY_GREEN_COLOR);
		pnlButtons.add(btnRunInputs);
		JButton btnClear = configBtn(controller, Action.CLEAR, CLEAR_TXT, MY_RED_COLOR);
		pnlButtons.add(btnClear);
		
		add(pnlButtons, BorderLayout.PAGE_END);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void dataTable(){
		tableValidateInputs.getColumn(VIEW_STATE_ROUTE ).setCellEditor(tableCellEditor);
		tableValidateInputs.getColumn(VIEW_STATE_ROUTE).setCellRenderer(tableCellRenderer);
	}
	
	private JButton btnViewRoute(String myString) {
		JButton btnViewRoute = new JButton(new ImageIcon(getClass().getResource("/images/foto.png")));
		btnViewRoute.setName(myString);
		btnViewRoute.setActionCommand(Action.VIEW_ROUTE.toString());
		btnViewRoute.addActionListener(controller);
		btnViewRoute.setBackground(MY_COLOR_WHITE);
		btnViewRoute.setFocusable(false);
		btnViewRoute.setEnabled(true);
		return btnViewRoute;
	}
	
	public void createNewRow() {
		model.addRow(new Object[] {});
		String test = String.valueOf(model.getValueAt(model.getRowCount() - 2, 0));
		System.out.println(model.getRowCount());
		model.setValueAt(btnViewRoute(test), model.getRowCount() - 2, 2);
		System.out.println(test);
		model.fireTableStructureChanged();
		dataTable();
	}
	
	public ArrayList<String> getStringsFromTable() {
		ArrayList<String> stringToTest = new ArrayList<String>();
		for (int i = 0; i < model.getRowCount()-1; i++) {
			stringToTest.add(String.valueOf(model.getValueAt(i, 0)));
		}
		return stringToTest;
	}
	
	public void printResults(String[] result) {
		for (int i = 0; i < result.length; i++) {
			model.setValueAt(result[i], i, 1);			
		}

	}
	
	public void clearList() {
		model.setRowCount(0);
		model.addRow(new Object[] {});
		revalidate();
		repaint();
	}
	
	public JButton configBtn(Controller controller, Action myAction, String info, Color colorSelected) {
		JButton btn = new JButton(info);
		btn.setFont(FONT_CANDARA_LIGTH_DATA);
		btn.setPreferredSize(new Dimension(150, 50));
		btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
		btn.setBackground(MY_COLOR_WHITE);
		btn.setForeground(MY_COLOR_BLACK);
		btn.setOpaque(true);
		btn.setFocusable(false);
		btn.setActionCommand(myAction.toString());
		btn.addActionListener(controller);
		btn.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(null);
				btn.setForeground(MY_COLOR_BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(colorSelected);
				btn.setForeground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		return btn;
	}
}