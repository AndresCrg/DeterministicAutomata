/**
 * @author Manuel Canon
 */
// Class location
package models;

//Class Start
public class Transition {

	// Attributes
	private Status initialStatus, finalStatus; // Initial Status and Final Status of the Transition
	private char value; // Ascci Value of the character

	/**
	 * Constructor Start -- Constructor Class
	 * 
	 * @param initialStatus -- Initial Status of the Transition
	 * @param finalStatus   -- Final Status of the Transition
	 * @param value         -- Ascci value of the character into initialStatus and
	 *                      FinalStatus
	 */
	public Transition(Status initialStatus, Status finalStatus, char value) {
		super();
		this.initialStatus = initialStatus;
		this.finalStatus = finalStatus;
		this.value = value;
	}// Constructor End

	/**
	 * Method Start -- Return Initial Status
	 * 
	 * @return Initial Status of the Transition
	 */
	public Status getInitialStatus() {
		return initialStatus;
	}// Method End

	/**
	 * Method Start -- Enter Initial Status
	 * 
	 * @param initialStatus Initial Status of the Transition
	 */
	public void setInitialStatus(Status initialStatus) {
		this.initialStatus = initialStatus;
	}// Method End

	/**
	 * Method Start -- Return Final Status
	 * 
	 * @return Final Status of the Transition
	 */
	public Status getFinalStatus() {
		return finalStatus;
	}// Method End

	/**
	 * Method Start -- Enter Final Status
	 * 
	 * @param finalStatus Final Status of the Transition
	 */
	public void setFinalStatus(Status finalStatus) {
		this.finalStatus = finalStatus;
	}// Method End

	/**
	 * Method Start -- Return Ascci value of the character into initialStatus and
	 * FinalStatus
	 * 
	 * @return value Ascci value of the character into initialStatus and FinalStatus
	 */
	public char getValue() {
		return value;
	}// Method End

	/**
	 * Method Start -- Enter Ascci value of the character into initialStatus and
	 * FinalStatus
	 * 
	 * @param value Ascci value of the character into initialStatus and FinalStatus
	 */
	public void setValue(char value) {
		this.value = value;
	}// Method End

	@Override
	public String toString() {
		return "Estado del que parte : " + initialStatus.getName() + "\nEstado al que llega : " + finalStatus.getName() + "\nSimbolo : "
				+ value + "\n";
	}

}// Class End
