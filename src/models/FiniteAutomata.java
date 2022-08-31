/**
 * @author Manuel Canon
 * This class allows create a finite deterministic automata
 */
// Class location
package models;

//Necessary imports
import java.util.ArrayList;

//Class Start
public class FiniteAutomata {

	// Attributes
	private ArrayList<Status> statusList; // List of all Status
	private ArrayList<Transition> transitions; // Transitions of the Deterministic Automata
	private Status initalStatus; // Initial Status of the Deterministic Automata
	private ArrayList<Status> finalStatus; // Final Status of the Deterministic Automata
	private ArrayList<Character> language;

	/**
	 * Constructor Start -- Constructor Class
	 * 
	 */
	public FiniteAutomata() {
		statusList = new ArrayList<Status>(); // Init ArrayList status
		language = new ArrayList<Character>();
		transitions = new ArrayList<Transition>(); // Init ArrayList transitions
		finalStatus = new ArrayList<Status>(); // Init ArrayList finalStatus
	}// Constructor End

	/**
	 * Method Start -- Add status
	 * 
	 * @param status Status to add
	 */
	public void addStatus(Status status) {
		statusList.add(status);
	}// Method End

	/**
	 * Method Start -- Add symbol to language
	 * 
	 * @param symbol symbol to add
	 */
	public void addSymbol(char symbol) {
		this.language.add(symbol);
	}// Method End

	/**
	 * Method Start -- This methos allows check if a symbols exist
	 * 
	 * @param symbol symbol to check
	 * @return true if symbol exist and false if not exist
	 */
	public boolean checkSymbol(char symbol) {
		boolean isTrue = true;
		boolean result = false;
		for (int i = 0; i < language.size() && isTrue; i++) {
			if (language.get(i).equals(symbol)) {
				isTrue = false;
				result = true;
			}
		}
		return result;
	}

	/**
	 * Method Start -- This method allow check if one state exist
	 * 
	 * @param name name state to check
	 * @return true if status exist and false if not exist
	 */
	public boolean checkStatus(String name) {
		boolean isTrue = true;
		boolean result = false;
		for (int i = 0; i < statusList.size() && isTrue; i++) {
			if (statusList.get(i).getName().equals(name)) {
				isTrue = false;
				result = true;
			}
		}
		return result;
	}

	/**
	 * Method Start
	 * 
	 * @param name
	 */
	public void deleteStatus(String name) {
		for (int i = 0; i < statusList.size(); i++) {
			if (statusList.get(i).getName().equals(name)) {
				statusList.remove(statusList.get(i));
			}
		}
	}

	/**
	 * Method Start -- Add initial Status to Language
	 * 
	 * @param status Initial Status to add
	 */
	public void addInitialStatus(Status status) {
		this.initalStatus = status;
	}// Method End

	/**
	 * Method Start -- Add final Status to Language
	 * 
	 * @param status Initial Status to add
	 */
	public void addFinalStatus(Status status) {
		finalStatus.add(status);
	}// Method End

	/**
	 * Method Start -- Add transition to the Deterministic Automata
	 * 
	 * @param transition Transition to add
	 */
	public void addTransition(Transition transition) {
		transitions.add(transition);
	}// Method End

	/**
	 * Method Start -- Ask status in the List of Status
	 * 
	 * @param id         Id of the Status
	 * @param statusList List of the Status to Ask
	 * @return status Status of the Deterministic Automata
	 */
	public boolean checkStatus(int id, ArrayList<Status> statusList) {
		boolean isTrue = true;
		boolean result = false;
		for (int i = 0; i < statusList.size() && isTrue; i++) {
			if (statusList.get(i).getId() == id) {
				result = true;
				isTrue = false;
			}
		}
		return result;

	}// Method End

	/**
	 * Method Start -- Ask status in the List of Status
	 * 
	 * @param id         Id of the Status
	 * @param statusList List of the Status to Ask
	 * @return status Status of the Deterministic Automata
	 */
	public Status askStatus(String name) {
		boolean isTrue = true;
		Status result = null;
		for (int i = 0; i < statusList.size() && isTrue; i++) {
			if (statusList.get(i).getName().equals(name)) {
				result = statusList.get(i);
				isTrue = false;
			}
		}
		return result;
	}// Method End

	/**
	 * Method Start -- Ask transition in the Deterministic Automata
	 * 
	 * @param idInitialStatus Id of the Initial Status of the Transition
	 * @param value           Character into initial status and finalStatus
	 * @return Transition of the Deterministic Automata
	 */
	/*
	 * public Transition askTransition(int idInitialStatus, char value) { boolean
	 * isTrue = true; Transition result = null; for (int i = 0; i <
	 * transitions.size() && isTrue; i++) { if
	 * ((transitions.get(i).getInitialStatus().getId() == idInitialStatus) &&
	 * (transitions.get(i).getValue() == value)) { result = transitions.get(i);
	 * isTrue = false; } }
	 * 
	 * return result; }
	 */
	// Method End

	public ArrayList<Transition> askTransition(int idInitialStatus, char value) {
		boolean isTrue = true;
		ArrayList<Transition> result = new ArrayList<Transition>();
		for (int i = 0; i < transitions.size() && isTrue; i++) {
			if ((transitions.get(i).getInitialStatus().getId() == idInitialStatus)
					&& (transitions.get(i).getValue() == value)) {
				result.add(transitions.get(i));
			}
		}

		return result;
	} // Method End

	/**
	 * Method Start -- Check if a chain belongs to the Deterministic Automata
	 * 
	 * @param chain Chain to check
	 * @return status Status of the Deterministic Automata
	 */
	/*
	 * public String checkChain(String chain) { boolean check = false; String result
	 * = "Cadena " + chain + "\n"; char[] stringToChar = chain.toCharArray(); Status
	 * auxStatus = this.initalStatus; int count = 1; Transition auxTransition =
	 * null; for (char c : stringToChar) { result += (count + " Pasada --- \n");
	 * auxTransition = this.askTransition(auxStatus.getId(), c);
	 * 
	 * if (auxTransition != null) { result += (auxTransition.toString()); auxStatus
	 * = auxTransition.getFinalStatus(); } else { auxStatus = null; result +=
	 * ("El simbolo no tiene punto de destino \n"); } count++; } if (auxStatus !=
	 * null) { if ((this.checkStatus(auxStatus.getId(), this.finalStatus)) == true)
	 * { check = true; } } result += check; return result; }
	 */
	// Method End
	
	public String checkChain(String chain, Status initial, String textAux) {
		boolean check = false;
		String result = textAux;
		String chainAux = chain;
		char[] stringToChar = chain.toCharArray();
		Status auxStatus = initial;
		int count = 1;
		ArrayList<Transition> auxTransition = new ArrayList<Transition>();
		for (char c : stringToChar) {
			chainAux = chain.substring(1, chainAux.length());
			auxTransition = this.askTransition(auxStatus.getId(), c);
			if (auxTransition.size() != 0) {
				if (auxTransition.size() == 1) {
					result += ("\n ---  " + count + " Transición  --- \n");
					result += auxTransition.get(0).toString();
					auxStatus = auxTransition.get(0).getFinalStatus();
				}
				if (auxTransition.size() > 1) {
					ArrayList<Boolean> auxResult = new ArrayList<Boolean>();
					String auxStringResult = "";
					for (Transition transition : auxTransition) {
						auxStringResult += "\nSiguiendo por el Estado " + transition.getFinalStatus().getName() + "\n";
						auxStringResult += this.isAccept(chainAux, transition.getFinalStatus(), "") + "\n";
						auxResult.add(this.isAccept(chainAux, transition.getFinalStatus(), ""));
					}
					result += auxStringResult;
					for (boolean aux : auxResult) {
						if (aux == true) {
							check = true;
						}
					}
				}
			} else {
				auxStatus = null;
				result += ("El simbolo no tiene punto de destino \n");
				break;
			}
			count++;
		}
		if (auxStatus != null) {
			if ((this.checkStatus(auxStatus.getId(), this.finalStatus))) {
				check = true;
			}
		}
		result += "\nRESULTADO FINAL : ";
		result += check;
		return result;
	} // Method End

	/*
	 * public boolean isAccept(String chain) { boolean check = false; String result
	 * = "Cadena " + chain + "\n"; char[] stringToChar = chain.toCharArray(); Status
	 * auxStatus = this.initalStatus; int count = 1; Transition auxTransition =
	 * null; for (char c : stringToChar) { result += (count + " Pasada --- \n");
	 * auxTransition = this.askTransition(auxStatus.getId(), c);
	 * 
	 * if (auxTransition != null) { result += (auxTransition.toString()); auxStatus
	 * = auxTransition.getFinalStatus(); } else { auxStatus = null; result +=
	 * ("El simbolo no tiene punto de destino \n"); } count++; } if (auxStatus !=
	 * null) { if ((this.checkStatus(auxStatus.getId(), this.finalStatus)) == true)
	 * { check = true; } } result += check; return check; }
	 */ // Method End

	public boolean isAccept(String chain, Status initial, String textAux) {
		boolean check = false;
		String chainAux = chain;
		char[] stringToChar = chain.toCharArray();
		Status auxStatus = initial;
		ArrayList<Transition> auxTransition = new ArrayList<Transition>();
		for (char c : stringToChar) {
			chainAux = chain.substring(1, chainAux.length());
			auxTransition = this.askTransition(auxStatus.getId(), c);
			if (auxTransition.size() != 0) {
				if (auxTransition.size() == 1) {
					auxStatus = auxTransition.get(0).getFinalStatus();
				}
				if (auxTransition.size() > 1) {
					ArrayList<Boolean> auxResult = new ArrayList<Boolean>();
					for (Transition transition : auxTransition) {
						auxResult.add(this.isAccept(chainAux, transition.getFinalStatus(), ""));
					}
					for (boolean aux : auxResult) {
						if (aux == true) {
							check = true;
						}
					}
				}
			} else {
				auxStatus = null;
				break;
			}
		}
		if (auxStatus != null) {
			if ((this.checkStatus(auxStatus.getId(), this.finalStatus))) {
				check = true;
			}
		}
		return check;
	} // Method End

	/**
	 * Method Start -- Get status list
	 * 
	 * @return status list of the Deterministic Automata
	 */
	public ArrayList<Status> getStatusList() {
		return statusList;
	}// Method End

	/**
	 * Method Start -- Add status list to Deterministic Automata
	 * 
	 * @param statusList Status List from Deterministic Automata
	 */
	public void setStatusList(ArrayList<Status> statusList) {
		this.statusList = statusList;
	}// Method End

	/**
	 * Method Start -- Get transitions list
	 * 
	 * @return transitions list
	 */
	public ArrayList<Transition> getTransitions() {
		return transitions;
	}// Method End

	/**
	 * Method Start -- Add transitions list
	 * 
	 * @param transitions list of transitions
	 */
	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}// Method End

	/**
	 * Method Start - Get initial Status
	 * 
	 * @return initial Status
	 */
	public Status getInitalStatus() {
		return initalStatus;
	}// Method End

	/**
	 * Method Start -- Add initial status
	 * 
	 * @param initalStatus initial status of the determinsitic Automata
	 */
	public void setInitalStatus(Status initalStatus) {
		this.initalStatus = initalStatus;
	}// Method End

	/**
	 * Method Start - Get final Status
	 * 
	 * @return final Status
	 */
	public ArrayList<Status> getFinalStatus() {
		return finalStatus;
	}// Method End

	/**
	 * Method Start -- Add list of final status
	 * 
	 * @param finalStatus list of final status
	 */
	public void setFinalStatus(ArrayList<Status> finalStatus) {
		this.finalStatus = finalStatus;
	}// Method End

	/**
	 * Method Start - Get language (List of language symbols )
	 * 
	 * @return language (List of language symbols)
	 */
	public ArrayList<Character> getLanguage() {
		return language;
	}// Method End

	/**
	 * Method Start -- Add Language (List of symbols)
	 * 
	 * @param language (List of symbols)
	 */
	public void setLanguage(ArrayList<Character> language) {
		this.language = language;
	}// Method End

}
