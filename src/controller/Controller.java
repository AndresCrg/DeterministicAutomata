package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;

import models.FiniteAutomata;
import models.Status;
import models.Transition;
import views.ConstantsText;
import views.JFPrincipalWindow;
import views.View;

public class Controller implements ActionListener, KeyListener {

	private JFPrincipalWindow window;
	private View viewObj;
	private FiniteAutomata deterministicAutomata;

	public Controller() {
		viewObj = new View();
		deterministicAutomata = new FiniteAutomata();
		window = new JFPrincipalWindow(this);
		window.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {

		case ADD_LANGUAGE:
			addLenguage();
			paintTable();
			break;
		case ADD_STATUS:
			addStatus();
			paintTable();
			break;
		case ADD_TRANSITION:
			addTransition();
			paintTable();
			break;
		case ADD_INITIAL_STATUS:
			addInitialStatus();
			paintTable();
			break;
		case ADD_FINAL_STATUS:
			addFinalStatus();
			paintTable();
			break;
		case CHECK_CHAIN:
			checkChain();
			break;
		case RUN_INPUTS:
			runInputs(window.getStringToTest());
			break;
		case CLEAR:
			clearList();
			break;
		case VIEW_ROUTE:
			viewRoute(((JButton) e.getSource()).getName());
			break;
		default:
			break;
		}

	}

	private void addLenguage() {

		if (deterministicAutomata.getLanguage().size() == 0) {

			int quantity = viewObj.readInt(ConstantsText.READ_QUANTITY_SYMBOLS.getText());

			for (int i = 0; i < quantity; i++) {
				char auxiliar = viewObj.readChar(ConstantsText.READ_SYMBOL.getText());
				if (auxiliar == ' ') {
					viewObj.showErrorMessage(ConstantsText.ERROR_NO_VALID_SYMBOL.getText(),
							ConstantsText.TITLE_ERROR.getText());
					i = i - 1;
				} else {
					deterministicAutomata.addSymbol(auxiliar);
				}
			}
			if (quantity != 0) {
				viewObj.showInformationMessage(ConstantsText.LANGUAGE_SUCESSFULL.getText(),
						ConstantsText.TITLE_LANGUAGE_SUCESSFULL.getText());
			}
		} else {
			int option = viewObj.showConfirmMessage(ConstantsText.ERROR_LANGUAGE_EXIST.getText());
			if (option == 0) {
				deterministicAutomata.getLanguage().clear();
				viewObj.showInformationMessage(ConstantsText.LANGUAGE_DELETE_SUCESSFULL.getText(),
						ConstantsText.TITLE_DELETE.getText());
				window.startPanelImage();
			}
		}
	}

	private void addStatus() {
		int id = deterministicAutomata.getStatusList().size() + 1;
		String name = viewObj.readString(ConstantsText.READ_STATUS_NAME.getText());
		if (name == null) {
			viewObj.showErrorMessage(ConstantsText.ERROR_NO_VALID_STATUS_NAME.getText(),
					ConstantsText.TITLE_ERROR.getText());
			addStatus();
		} else {
			if (deterministicAutomata.checkStatus(name)) {
				int option = viewObj.showConfirmMessage(ConstantsText.ERROR_STATUS_EXIST.getText());
				if (option == 0) {
					deterministicAutomata.deleteStatus(name);
					viewObj.showInformationMessage(ConstantsText.STATUS_DELETE_SUCESSFULL.getText(),
							ConstantsText.TITLE_DELETE.getText());

				}
			} else {
				deterministicAutomata.addStatus(new Status(name, id));
				viewObj.showInformationMessage(ConstantsText.STATUS_SUCESSFULL.getText(),
						ConstantsText.TITLE_STATUS_SUCESSFULL.getText());
			}
		}
	}

	private void addTransition() {
		Status initialStatus, finalStatus;
		String nameInitialStatus, nameFinalStatus;
		char symbolTransition;
		if (deterministicAutomata.getLanguage().size() != 0) {
			nameInitialStatus = viewObj.readString(ConstantsText.READ_INITIAL_STATUS_NAME_TRANSITION.getText());
			initialStatus = deterministicAutomata.askStatus(nameInitialStatus);
			if (initialStatus != null) {
				nameFinalStatus = viewObj.readString(ConstantsText.READ_FINAL_STATUS_NAME_TRANSITION.getText());
				finalStatus = deterministicAutomata.askStatus(nameFinalStatus);
				if (finalStatus != null) {
					symbolTransition = viewObj.readChar(ConstantsText.READ_SYMBOL_TRANSITION.getText());
					if (deterministicAutomata.checkSymbol(symbolTransition)) {
						Transition transition = new Transition(initialStatus, finalStatus, symbolTransition);
						deterministicAutomata.addTransition(transition);
						viewObj.showInformationMessage(ConstantsText.TRANSITION_SUCESSFULL.getText(),
								ConstantsText.TITLE_TRANSITION_SUCESSFULL.getText());
					} else {
						viewObj.showErrorMessage(ConstantsText.ERROR_SYMBOL_N0_EXIST_TRANSITION.getText(),
								ConstantsText.TITLE_ERROR.getText());
					}

				} else {
					viewObj.showErrorMessage(ConstantsText.ERROR_FINAL_STATUS_N0_EXIST_TRANSITION.getText(),
							ConstantsText.TITLE_ERROR.getText());
				}
			} else {
				viewObj.showErrorMessage(ConstantsText.ERROR_INITIAL_STATUS_N0_EXIST_TRANSITION.getText(),
						ConstantsText.TITLE_ERROR.getText());
			}

		} else {
			viewObj.showErrorMessage(ConstantsText.ERROR_NO_LANGUAGE_STATUS.getText(),
					ConstantsText.TITLE_ERROR.getText());
		}
	}

	private void addInitialStatus() {
		String nameStatus = viewObj.readString(ConstantsText.READ_INITIAL_STATUS_NAME_TRANSITION.getText());
		Status initialStatus = deterministicAutomata.askStatus(nameStatus);
		if (deterministicAutomata.getInitalStatus() != null) {
			int option = viewObj.showConfirmMessage(ConstantsText.ERROR_INITIAL_STATUS_EXIST.getText());
			if (option == 0) {
				deterministicAutomata.setInitalStatus(null);
				viewObj.showInformationMessage(ConstantsText.INITIAL_STATUS_DELETE_SUCESSFULL.getText(),
						ConstantsText.TITLE_DELETE.getText());

			}
		} else if (initialStatus != null) {
			deterministicAutomata.addInitialStatus(initialStatus);
			viewObj.showInformationMessage(ConstantsText.INITIAL_STATUS_SUCESSFULL.getText(),
					ConstantsText.TITLE_INITIAL_STATUS_SUCESSFULL.getText());
		} else {
			viewObj.showErrorMessage(ConstantsText.ERROR_INITIAL_STATUS_N0_EXIST.getText(),
					ConstantsText.TITLE_ERROR.getText());
		}
	}

	private void addFinalStatus() {
		String nameStatus = viewObj.readString(ConstantsText.READ_FINAL_STATUS_NAME.getText());
		Status finalStatus = deterministicAutomata.askStatus(nameStatus);
		if (finalStatus != null) {
			deterministicAutomata.addFinalStatus(finalStatus);
			viewObj.showInformationMessage(ConstantsText.FINAL_STATUS_SUCESSFULL.getText(),
					ConstantsText.TITLE_FINAL_STATUS_SUCESSFULL.getText());
		} else {
			viewObj.showErrorMessage(ConstantsText.ERROR_FINAL_STATUS_N0_EXIST.getText(),
					ConstantsText.TITLE_ERROR.getText());
		}

	}

	private ArrayList<String> convertStatusToStrings(ArrayList<Status> status) {
		ArrayList<String> result = new ArrayList<String>();
		for (Status statusName : status) {
			result.add(statusName.getName());
		}
		return result;
	}

	/*
	 * private ArrayList<String> convertTransitionsToStrings() { ArrayList<String>
	 * result = new ArrayList<String>(); ArrayList<Transition> trans =
	 * deterministicAutomata.getTransitions();
	 * 
	 * for (int i = 0; i < trans.size(); i++) { String initialStatus =
	 * trans.get(i).getInitialStatus().getName(); String finalStatus =
	 * trans.get(i).getFinalStatus().getName(); String symbol = "" +
	 * trans.get(i).getValue(); if (deterministicAutomata.getInitalStatus() == null
	 * && deterministicAutomata.getFinalStatus().size() == 0) { String value =
	 * initialStatus + "#" + symbol + "#" + finalStatus; result.add(value); } else {
	 * if (deterministicAutomata.getInitalStatus() != null) { if
	 * (this.isFinalStatus(initialStatus) &&
	 * initialStatus.equals(deterministicAutomata.getInitalStatus().getName())) { }
	 * else if
	 * (initialStatus.equals(deterministicAutomata.getInitalStatus().getName())) {
	 * result.add("->" + initialStatus + "#" + symbol + "#" + finalStatus); } } if
	 * (deterministicAutomata.getFinalStatus().size() != 0) { if
	 * (this.isFinalStatus(initialStatus) &&
	 * initialStatus.equals(deterministicAutomata.getInitalStatus().getName())) {
	 * result.add("-> * " + initialStatus + "#" + symbol + "#" + finalStatus); }
	 * else if (this.isFinalStatus(initialStatus)) { result.add("* " + initialStatus
	 * + "#" + symbol + "#" + finalStatus); } } if
	 * (!this.isFinalStatus(initialStatus) &&
	 * !initialStatus.equals(deterministicAutomata.getInitalStatus().getName())) {
	 * result.add(initialStatus + "#" + symbol + "#" + finalStatus); } } }
	 * 
	 * for (String string : this.statusWithoutTransitions()) { if
	 * (deterministicAutomata.getInitalStatus() == null &&
	 * deterministicAutomata.getFinalStatus().size() == 0) { String value = string +
	 * "#" + "/" + "#" + "/"; result.add(value); } else { if
	 * (deterministicAutomata.getInitalStatus() != null) { if
	 * (this.isFinalStatus(string) &&
	 * string.equals(deterministicAutomata.getInitalStatus().getName())) { } else if
	 * (string.equals(deterministicAutomata.getInitalStatus().getName())) {
	 * result.add("->" + string + "#" + "/" + "#" + "/"); } } if
	 * (deterministicAutomata.getFinalStatus().size() != 0) { if
	 * (this.isFinalStatus(string) &&
	 * string.equals(deterministicAutomata.getInitalStatus().getName())) {
	 * result.add("-> * " + string + "#" + "/" + "#" + "/"); } else if
	 * (this.isFinalStatus(string)) { result.add("* " + string + "#" + "/" + "#" +
	 * "/"); } } if (!this.isFinalStatus(string) &&
	 * !string.equals(deterministicAutomata.getInitalStatus().getName())) {
	 * result.add(string + "#" + "/" + "#" + "/"); } } }
	 * 
	 * return result; }
	 */
	
	private String askFinalStatusWithValue(ArrayList<Transition> trans,String status,String symbol){
		String result = "";
		
		for (Transition transition : trans) {
			String auxValue = ""+transition.getValue();
			if(transition.getInitialStatus().getName().equals(status)&& auxValue.equals(symbol)) {
				result+=(transition.getFinalStatus().getName() + " ");
			}
		}
		return result;
	}

	private ArrayList<String> convertTransitionsToStrings() {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Transition> trans = deterministicAutomata.getTransitions();

		for (int i = 0; i < trans.size(); i++) {
			String initialStatus = trans.get(i).getInitialStatus().getName();
			String symbol = "" + trans.get(i).getValue();
			String finalStatus = this.askFinalStatusWithValue(trans, initialStatus, symbol);
			
			if (deterministicAutomata.getInitalStatus() == null && deterministicAutomata.getFinalStatus().size() == 0) {
				String value = initialStatus + "#" + symbol + "#" + finalStatus;
				result.add(value);
			} else {
				if (deterministicAutomata.getInitalStatus() != null) {
					if (this.isFinalStatus(initialStatus)
							&& initialStatus.equals(deterministicAutomata.getInitalStatus().getName())) {
					} else if (initialStatus.equals(deterministicAutomata.getInitalStatus().getName())) {
						result.add("->" + initialStatus + "#" + symbol + "#" + finalStatus);
					}
				}
				if (deterministicAutomata.getFinalStatus().size() != 0) {
					if (this.isFinalStatus(initialStatus)
							&& initialStatus.equals(deterministicAutomata.getInitalStatus().getName())) {
						result.add("-> * " + initialStatus + "#" + symbol + "#" + finalStatus);
					} else if (this.isFinalStatus(initialStatus)) {
						result.add("* " + initialStatus + "#" + symbol + "#" + finalStatus);
					}
				}
				if (!this.isFinalStatus(initialStatus)
						&& !initialStatus.equals(deterministicAutomata.getInitalStatus().getName())) {
					result.add(initialStatus + "#" + symbol + "#" + finalStatus);
				}
			}
		}

		for (String string : this.statusWithoutTransitions()) {
			if (deterministicAutomata.getInitalStatus() == null && deterministicAutomata.getFinalStatus().size() == 0) {
				String value = string + "#" + "/" + "#" + "/";
				result.add(value);
			} else {
				if (deterministicAutomata.getInitalStatus() != null) {
					if (this.isFinalStatus(string)
							&& string.equals(deterministicAutomata.getInitalStatus().getName())) {
					} else if (string.equals(deterministicAutomata.getInitalStatus().getName())) {
						result.add("->" + string + "#" + "/" + "#" + "/");
					}
				}
				if (deterministicAutomata.getFinalStatus().size() != 0) {
					if (this.isFinalStatus(string)
							&& string.equals(deterministicAutomata.getInitalStatus().getName())) {
						result.add("-> * " + string + "#" + "/" + "#" + "/");
					} else if (this.isFinalStatus(string)) {
						result.add("* " + string + "#" + "/" + "#" + "/");
					}
				}
				if (!this.isFinalStatus(string) && !string.equals(deterministicAutomata.getInitalStatus().getName())) {
					result.add(string + "#" + "/" + "#" + "/");
				}
			}
		}

		return result;
	}

	private boolean isFinalStatus(String name) {
		boolean result = false;
		for (Status status : deterministicAutomata.getFinalStatus()) {
			if (status.getName().equals(name)) {
				result = true;
			}
		}
		return result;
	}

	private ArrayList<String> statusWithoutTransitions() {
		ArrayList<String> auxiliarStatus = new ArrayList<String>();
		ArrayList<String> auxiliarTransitions = new ArrayList<String>();

		for (Status status2 : deterministicAutomata.getStatusList()) {
			auxiliarStatus.add(status2.getName());
		}

		for (Transition transt : deterministicAutomata.getTransitions()) {
			auxiliarTransitions.add(transt.getInitialStatus().getName());
		}

		auxiliarStatus.removeAll(auxiliarTransitions);
		return auxiliarStatus;
	}

	private void paintTable() {
		if (deterministicAutomata.getLanguage().size() != 0) {
			window.startTableLanguage(deterministicAutomata.getLanguage());
		} else {
			String[] object = { "Estados" };
			window.getTablePanel().getModel().setColumnIdentifiers(object);
		}

		if (deterministicAutomata.getInitalStatus() != null) {
			System.out.println(this.isFinalStatus(deterministicAutomata.getInitalStatus().getName()));
			window.startTableInitialStatus(deterministicAutomata.getInitalStatus().getName());

		}

		if (deterministicAutomata.getFinalStatus().size() != 0) {
			window.startTableFinalStatus(convertStatusToStrings(deterministicAutomata.getFinalStatus()));
		}

		if (deterministicAutomata.getStatusList().size() != 0) {
			window.startTableStatus(this.convertStatusToStrings(deterministicAutomata.getStatusList()));
		}
		if (deterministicAutomata.getTransitions().size() != 0) {
			ArrayList<String> list = this.convertTransitionsToStrings();
			window.startTableTransitions(list);
		}
	}

	private void checkChain() {
		window.visibleJDialog();
	}

	private void viewRoute(String chain) {
		System.out.println(deterministicAutomata.getInitalStatus() == null);
		viewObj.showInformationMessageScoll(deterministicAutomata.checkChain(chain, deterministicAutomata.getInitalStatus(), ""), "RESULTADO");
				

	}

	private void clearList() {
		window.clearList();
	}

	private void runInputs(ArrayList<String> stringToTest) {
		String[] result = new String[stringToTest.size()];
		for (int i = 0; i < stringToTest.size(); i++) {
			result[i] = "" + (deterministicAutomata.isAccept(stringToTest.get(i),
					deterministicAutomata.getInitalStatus(), ""));
		}
		window.getPnlTableTest().printResults(result);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			window.createNewRow();
		}
	}

}
