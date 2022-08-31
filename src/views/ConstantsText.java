//Class Package
package views;

//Class Start
public enum ConstantsText {

	// Constants
	READ_STATUS_NAME("Ingrese el nombre del estado"),
	READ_CHAIN("Ingrese la cadena a validar"),
	ERROR_NO_VALID_OPTION(	"A ingresado una opción no válida"),
	ERROR_NO_VALID_SYMBOL(	"No se puede agregar un valor vacío al lenguaje"),
	ERROR_NO_VALID_STATUS_NAME(	"No se puede agregar un valor vacío como nombre del estado"),

	READ_INITIAL_STATUS_NAME("Ingrese el nombre del estado inicial"),
	READ_FINAL_STATUS_NAME("Ingrese el nombre del estado final"),
	READ_INITIAL_STATUS_NAME_TRANSITION("Ingrese el nombre del estado inicial de la transición"),
	READ_FINAL_STATUS_NAME_TRANSITION("Ingrese el nombre del estado final de la transición"),
	READ_SYMBOL_TRANSITION("Ingrese el símbolo entre el estado inicial y el final de la transición"),
	READ_SYMBOL("Ingrese el símbolo"), READ_QUANTITY_SYMBOLS("Ingrese la cantidad de símbolos del lenguaje"),
	LANGUAGE_SUCESSFULL("El lenguaje se agregó con éxito"), TITLE_LANGUAGE_SUCESSFULL("Lenguaje agregado"),
	INITIAL_STATUS_SUCESSFULL("El estado inicial se agregó con éxito"),
	TITLE_INITIAL_STATUS_SUCESSFULL("Estado inicial agregado"),
	FINAL_STATUS_SUCESSFULL("El estado final se agregó con éxito"),
	TITLE_FINAL_STATUS_SUCESSFULL("Estado final agregado"), TRANSITION_SUCESSFULL("La transición se agregó con éxito"),
	ERROR_NO_LANGUAGE_STATUS("No es posible agregar un estado porque el lenguaje del autómata no tiene símbolos"),
	ERROR_INITIAL_STATUS_N0_EXIST_TRANSITION("No es posible agregar la transición porque el estado inicial no existe"),
	ERROR_INITIAL_STATUS_N0_EXIST("El estado inicial no existe"),
	ERROR_FINAL_STATUS_N0_EXIST_TRANSITION("No es posible agregar la transición porque el estado final no existe"),
	ERROR_FINAL_STATUS_N0_EXIST("El estado final no existe"),
	ERROR_SYMBOL_N0_EXIST_TRANSITION("No es posible agregar la transición porque el simbolo no existe"),
	ERROR_LANGUAGE_EXIST("Ya existe un lenguaje definido para el automata finito determinista , ¿Desea eliminarlo?"),
	ERROR_STATUS_EXIST("Ya existe un estado definido para el automata finito determinista , ¿Desea eliminarlo?"),
	ERROR_INITIAL_STATUS_EXIST(
			"Ya existe un estado inicial definido para el automata finito determinista , ¿Desea eliminarlo?"),
	TITLE_ERROR("ERROR"), TITLE_DELETE("ELIMIANDO DEL AUTÓMATA"),
	LANGUAGE_DELETE_SUCESSFULL("El lenguaje del autómata fue elimiando"),
	STATUS_DELETE_SUCESSFULL("El estado del autómata fue elimiando"),
	INITIAL_STATUS_DELETE_SUCESSFULL("El estado inicial del autómata fue elimiando"),
	TITLE_TRANSITION_SUCESSFULL("Transición agregaga"), STATUS_SUCESSFULL("El estado se agregó con éxito"),
	TITLE_STATUS_SUCESSFULL("Estado agregado");
	;

	// Class Attributes
	private String text;

	// Constructor Start
	private ConstantsText(String text) {
		this.text = text;
	}// Constructor End

	/**
	 * Method Start -- Get text of the enum
	 * 
	 * @return text of the Enum
	 */
	public String getText() {
		return text;
	}// Method End

}// Class End
