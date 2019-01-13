import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class Button extends JButton implements MouseListener{
	
	TextField textfield;
	
	/* old constructor
	Button(String s){
		this.setText(s);
	}
	*/
	
	Button(String s, TextField tf){
		this.setText(s);
		this.addMouseListener(this);
		this.textfield = tf;
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			this.textfield.setText("");
			this.textfield.requestFocusInWindow(); //returns focus to textfield after clicking button
		}
	}
	public void mouseReleased(MouseEvent e) {}
	
}
