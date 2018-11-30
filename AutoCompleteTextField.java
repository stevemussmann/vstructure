import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class AutoCompleteTextField extends JTextField implements KeyListener{

	static TreeSet<String> tree = null;
	
	AutoCompleteTextField(int cols){
		super(cols);
		//this.requestFocusInWindow();
		this.addKeyListener(this);
		if(AutoCompleteTextField.tree == null){
			AutoCompleteTextField.tree = new TreeSet<String>();
			Scanner s;
			try{
				s = new Scanner(new File("lexicon.txt"));
				while(s.hasNextLine()) {
					String word = s.nextLine();
					AutoCompleteTextField.tree.add(word);
				}
			}catch (FileNotFoundException e){
				e.printStackTrace(System.err);
				System.exit(1);
			}
		}
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
		//e.consume();
		char c = e.getKeyChar();//get the character that is typed
		String input;
		if(c == KeyEvent.VK_BACK_SPACE){
			input = this.getText();//capture the the existing text field if backspace is pressed
		}else{
			this.replaceSelection(""); //remove highlighted text
			input = this.getText() + c;//add the character to the existing text field
			int length = input.length(); //get length of input in text box
			String match = AutoCompleteTextField.tree.ceiling(input); //find the match in the treeset
			if(length > match.length()){
				length = match.length(); //check if contents of textfield have exceeded length of best match, and reset length if this occurs
			}
			String substring = match.substring(0, length); //grab the substring from the match
			
			if(substring.equals("")){
				//do nothing to the textbox if it contains no characters
			}else if(input.equals(substring)){
				this.setText(match);
				this.select(length, match.length());
			}else{
				this.setText(input);
			}
			
		}
		
		e.consume();
	}
	
}
