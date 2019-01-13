import javax.swing.JPanel;

class View extends JPanel{
	
	View(){
		
		/* old way of doing this - before changing the button to clear text from text field
		//this.add(new StaticTextField("Static text field"));
		//this.add(new AutoCompleteTextField(20));
		//this.add(new Button("This is a button"));
		*/
		
		TextField tf = new TextField(20);
		this.add(new StaticTextField("Path to Clumpp Ind File:")); //add static text field
		this.add(tf); //add JTextField
		this.add(new OpenFileButton("Open File", tf)); //add JButton
		this.add(new ParseFileButton("Read File", tf));
	}
	
}
