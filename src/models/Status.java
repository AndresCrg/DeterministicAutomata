/**
 * @author Manuel Canon
 */
// Class location
package models;

// Class Start
public class Status {

//Attributes
	private String name; //Status name
	private int id; //Status id

	/**
	 * Constructor Start -- Constructor Class
	 * 
	 * @param name -- Status Name
	 * @param id   -- Status id
	 */
	public Status(String name, int id) {
		this.name = name;
		this.id = id;
	}// Constructor End

	/**
	 * Method Start -- Return Status Name
	 * 
	 * @return Status Name
	 */
	public String getName() {
		return name;
	}// Method End

	/**
	 * Method Start -- Enter Status Name
	 * 
	 * @param name Status Name
	 */
	public void setName(String name) {
		this.name = name;
	}// Method End

	/**
	 * Method Start -- Return Status id
	 * 
	 * @return id Status id
	 */
	public int getId() {
		return id;
	}// Method End

	/**
	 * Method Start -- Enter Status id
	 * 
	 * @param id Status id
	 */
	public void setId(int id) {
		this.id = id;
	}// Method End

}// Class End
