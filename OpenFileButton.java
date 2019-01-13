import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class OpenFileButton extends JButton implements MouseListener{
	
	TextField textfield;
	
	/* old constructor
	Button(String s){
		this.setText(s);
	}
	*/
	
	OpenFileButton(String s, TextField tf){
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
			//this.textfield.setText("");
			this.getFile();
			this.textfield.requestFocusInWindow(); //returns focus to textfield after clicking button
		}
	}
	public void mouseReleased(MouseEvent e) {}

	public void getFile() {
		JFileChooser fc = new JFileChooser(".");
		int choice = fc.showOpenDialog(this);
		if( choice == JFileChooser.APPROVE_OPTION) {
			String fn = fc.getSelectedFile().getAbsolutePath();
			JOptionPane.showMessageDialog(this, fn, "Selected File", JOptionPane.PLAIN_MESSAGE);
			System.out.println(fn);
			this.textfield.setText(fn);
		}

	}
	
}
