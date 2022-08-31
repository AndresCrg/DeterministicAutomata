package views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final String TITLE_APP = "Deterministic Finite Automata";
	private PnlTableTest pnlTableTest;
	
	public Window(Controller controller) {
		setTitle(TITLE_APP);
		setIconImage(new ImageIcon(getClass().getResource("/img/compartir.png")).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pnlTableTest = new PnlTableTest(controller);
		add(pnlTableTest, BorderLayout.LINE_END);
		
		setVisible(true);
	}
	
	public void createNewRow() {
		pnlTableTest.createNewRow();
	}
	
	public ArrayList<String> getStringToTest(){
		return pnlTableTest.getStringsFromTable();
	}
	
	public void clearList() {
		pnlTableTest.clearList();
	}
}