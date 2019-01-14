import javax.swing.JPanel;
import javax.swing.JScrollPane;

class View extends JPanel{
	
	View(){
		
		PopList pl = new PopList();

		TextField tf = new TextField(20);
		this.add(new StaticTextField("Path to Clumpp Ind File:")); //add static text field
		this.add(tf); //add JTextField
		this.add(new OpenFileButton("Browse...", tf)); //add JButton
		this.add(new ParseFileButton("Read File", tf, pl));
		//this.add(new ParseFileButton("Read File", tf));

		JScrollPane plScroll = new JScrollPane(pl);
		this.add(plScroll);

	}
	
}
