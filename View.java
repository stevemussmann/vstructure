import javax.swing.JPanel;

class View extends JPanel{
	
	View(){
		
		/* old way of doing this - before changing the button to clear text from text field
		//this.add(new StaticTextField("Static text field"));
		//this.add(new AutoCompleteTextField(20));
		//this.add(new Button("This is a button"));
		*/
		
		AutoCompleteTextField tf = new AutoCompleteTextField(20);
		this.add(new StaticTextField("Enter words here:")); //add static text field
		this.add(tf); //add JTextField
		this.add(new Button("Clear Text Box", tf)); //add JButton
	}
	
}
