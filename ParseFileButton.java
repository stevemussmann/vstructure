import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ParseFileButton extends JButton implements MouseListener{
	
	TextField textfield;
	PopList poplist;
	
	ParseFileButton(String s, TextField tf, PopList pl){
	//ParseFileButton(String s, TextField tf){
		this.poplist = pl;
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
			String file = this.textfield.getText();
			this.parseFile(file);
		}
	}
	public void mouseReleased(MouseEvent e) {}

	public void parseFile(String f) {
		System.out.println(f);
		IndFile ind = new IndFile(f);
		ind.parseInd(this.poplist);
		//ind.parseInd();
	}
	
}
