package views;

import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View {

	public int readInt(String message) {
		int condition = 0;
		String result = JOptionPane.showInputDialog(message);
		if (result == null) {
			condition = 0;
		} else {
			try {
				condition = Integer.parseInt(result);

			} catch (NumberFormatException e) {
				this.showErrorMessage(ConstantsText.ERROR_NO_VALID_OPTION.getText(),
						ConstantsText.TITLE_ERROR.getText());
			}
		}

		return condition;
	}

	public char readChar(String message) {
		String input = JOptionPane.showInputDialog(message);
		char result = ' ';
		if (!input.equals("")) {

			result = input.toCharArray()[0];

		}
		return result;
	}

	public String readString(String message) {
		return JOptionPane.showInputDialog(message);
	}

	public void showInformationMessage(String message, String title) {	
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void showInformationMessageScoll(String message, String title) {
		
		JTextArea textArea = new JTextArea(message);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize( new Dimension( 250, 500 ) );
		JOptionPane.showMessageDialog(null, scrollPane, title,  
		                                       JOptionPane.INFORMATION_MESSAGE);
		
	}

	public int showConfirmMessage(String message) {
		return JOptionPane.showConfirmDialog(null, message);
	}

	public void showErrorMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}

}
