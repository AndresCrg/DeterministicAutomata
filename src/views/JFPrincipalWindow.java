package views;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Commands;
import controller.Controller;

public class JFPrincipalWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JBBaseButton addLanguage, addStatus, addTransition, selectInitialStatus, selectFinalStatus, checkChain;
	private JPTable tablePanel;
	private JLabel imageForeground;
	private PnlTableTest pnlTableTest;


	public JFPrincipalWindow(Controller controller) {
		this.setSize(550, 600);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponents(controller);
		
		pnlTableTest = new PnlTableTest(controller);
	}
	
	public void visibleJDialog() {
		pnlTableTest.setVisible(true);
	}

	private void initComponents(Controller controller) {
		ImageIcon addLanguageImage = new ImageIcon(getClass().getResource("/images/Add_Language.png"));
		ImageIcon addLangugageImagePress = new ImageIcon(getClass().getResource("/images/Add_Language_Press.png"));
		addLanguage = new JBBaseButton(addLanguageImage, controller, addLangugageImagePress, Commands.ADD_LANGUAGE);
		addLanguage.setBounds(20, 20, 150, 50);
		this.add(addLanguage);

		ImageIcon addStatusImage = new ImageIcon(getClass().getResource("/images/Add_Status.png"));
		ImageIcon addStatusImagePress = new ImageIcon(getClass().getResource("/images/Add_Status_Press.png"));
		addStatus = new JBBaseButton(addStatusImage, controller, addStatusImagePress, Commands.ADD_STATUS);
		addStatus.setBounds(190, 20, 150, 50);
		this.add(addStatus);

		ImageIcon addTransitionImage = new ImageIcon(getClass().getResource("/images/Add_Transition.png"));
		ImageIcon addTransitionImagePress = new ImageIcon(getClass().getResource("/images/Add_Transition_Press.png"));
		addTransition = new JBBaseButton(addTransitionImage, controller, addTransitionImagePress,
				Commands.ADD_TRANSITION);
		addTransition.setBounds(360, 20, 150, 50);
		this.add(addTransition);

		ImageIcon addInitialStatusImage = new ImageIcon(getClass().getResource("/images/Select_Initial_Status.png"));
		ImageIcon addInitialStatusImagePress = new ImageIcon(
				getClass().getResource("/images/Select_Initial_Status_Press.png"));
		selectInitialStatus = new JBBaseButton(addInitialStatusImage, controller, addInitialStatusImagePress,
				Commands.ADD_INITIAL_STATUS);
		selectInitialStatus.setBounds(20, 90, 150, 50);
		this.add(selectInitialStatus);

		ImageIcon addFinalStatusImage = new ImageIcon(getClass().getResource("/images/Select_Final_Status.png"));
		ImageIcon addFinalStatusImagePress = new ImageIcon(
				getClass().getResource("/images/Select_Final_Status_Press.png"));
		selectFinalStatus = new JBBaseButton(addFinalStatusImage, controller, addFinalStatusImagePress,
				Commands.ADD_FINAL_STATUS);
		selectFinalStatus.setBounds(190, 90, 150, 50);
		this.add(selectFinalStatus);

		ImageIcon checkChainImage = new ImageIcon(getClass().getResource("/images/Check_Chain.png"));
		ImageIcon checkChainImagePress = new ImageIcon(getClass().getResource("/images/Check_Chain_Press.png"));
		checkChain = new JBBaseButton(checkChainImage, controller, checkChainImagePress, Commands.CHECK_CHAIN);
		checkChain.setBounds(360, 90, 150, 50);
		this.add(checkChain);

		ImageIcon image = new ImageIcon(getClass().getResource("/images/Image_Foreground.jpg"));
		imageForeground = new JLabel(image);
		imageForeground.setBounds(20, 160, 500, 400);
		this.add(imageForeground);

		tablePanel = new JPTable();
		tablePanel.setBounds(20, 160, 500, 400);
		this.getContentPane().add(tablePanel);

	}

	public void startTableLanguage(ArrayList<Character> language) {
		imageForeground.setVisible(false);
		tablePanel.setLanguage(language);
		tablePanel.generateHeaders();
		tablePanel.setVisible(true);
		this.repaint();
	}

	public void startTableStatus(ArrayList<String> status) {
		imageForeground.setVisible(false);
		tablePanel.setStatusNames(status);
		tablePanel.generateStatus();
		tablePanel.setVisible(true);
		this.repaint();
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
	public void startTableTransitions(ArrayList<String> transitions) {
		imageForeground.setVisible(false);
		tablePanel.setTransitions(transitions);
		tablePanel.generateTransitions();
		tablePanel.setVisible(true);
		this.repaint();
	}

	public void startTableInitialStatus(String name) {
		imageForeground.setVisible(false);
		tablePanel.setInitialStatus(name);
		tablePanel.setVisible(true);
		this.repaint();
	}
	
	public void startTableFinalStatus(ArrayList<String> finalStatus) {
		imageForeground.setVisible(false);
		tablePanel.setFinalStatus(finalStatus);
		tablePanel.setVisible(true);
		this.repaint();
	}

	public void startPanelImage() {
		tablePanel.setVisible(false);
		imageForeground.setVisible(true);
		imageForeground.repaint();
		this.repaint();
	}

	public JBBaseButton getAddLanguage() {
		return addLanguage;
	}

	public void setAddLanguage(JBBaseButton addLanguage) {
		this.addLanguage = addLanguage;
	}

	public JBBaseButton getAddStatus() {
		return addStatus;
	}

	public void setAddStatus(JBBaseButton addStatus) {
		this.addStatus = addStatus;
	}

	public JBBaseButton getAddTransition() {
		return addTransition;
	}

	public void setAddTransition(JBBaseButton addTransition) {
		this.addTransition = addTransition;
	}

	public JBBaseButton getSelectInitialStatus() {
		return selectInitialStatus;
	}

	public void setSelectInitialStatus(JBBaseButton selectInitialStatus) {
		this.selectInitialStatus = selectInitialStatus;
	}

	public JBBaseButton getSelectFinalStatus() {
		return selectFinalStatus;
	}

	public void setSelectFinalStatus(JBBaseButton selectFinalStatus) {
		this.selectFinalStatus = selectFinalStatus;
	}

	public JBBaseButton getCheckChain() {
		return checkChain;
	}

	public void setCheckChain(JBBaseButton checkChain) {
		this.checkChain = checkChain;
	}

	public JPTable getTablePanel() {
		return tablePanel;
	}

	public void setTablePanel(JPTable tablePanel) {
		this.tablePanel = tablePanel;
	}

	public PnlTableTest getPnlTableTest() {
		return pnlTableTest;
	}

	public void setPnlTableTest(PnlTableTest pnlTableTest) {
		this.pnlTableTest = pnlTableTest;
	}
	
	


}
