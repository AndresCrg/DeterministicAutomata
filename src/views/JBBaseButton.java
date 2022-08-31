//Class Package
package views;

//Imports
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import controller.Commands;

//Class Start
public class JBBaseButton extends JButton{
	
	/**
	 * Serializable Version
	 */
	private static final long serialVersionUID = 1L;

	//Constructor Start
	public JBBaseButton(ImageIcon icon,ActionListener actionListener,ImageIcon pressesIcon,Commands command) {
		this.setIcon(icon);
		this.addActionListener(actionListener);
		this.setBackground(Color.WHITE);
		this.setActionCommand(command.toString());
		this.setMargin(new Insets(0,0,0,0));
		this.setIconTextGap(0);
		this.setBorderPainted(false);
		this.setBorder(null);
		this.setText(null);
		this.setPressedIcon(pressesIcon);
		this.setSize(icon.getImage().getWidth(null),icon.getImage().getHeight(null));
	}//Constructor End
}//Class End
