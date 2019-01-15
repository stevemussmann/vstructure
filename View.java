import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class View extends JPanel implements ActionListener{
	PopList pl, rm;
	JButton buttonIn, buttonOut;
	
	View(){
		
		this.pl = new PopList();
		this.rm = new PopList();
		this.rm.setModel(new DefaultListModel());

		TextField tf = new TextField(20);
		this.add(new StaticTextField("Path to Clumpp Ind File:")); //add static text field
		this.add(tf); //add JTextField
		this.add(new OpenFileButton("Browse...", tf)); //add JButton
		this.add(new ParseFileButton("Read File", tf, pl));
		//this.add(new ParseFileButton("Read File", tf));

		JScrollPane plScroll = new JScrollPane(pl);
		JScrollPane rmScroll = new JScrollPane(rm);

		this.buttonIn = new JButton(">>");
		this.buttonIn.addActionListener(this);
		
		this.buttonOut = new JButton("<<");
		this.buttonOut.addActionListener(this);

		this.add(plScroll);
		this.add(buttonIn);
		this.add(buttonOut);
		this.add(rmScroll);

		this.add(new PlotButton("Make Plot", tf));

	}

	@Override
	public void actionPerformed(ActionEvent e){

		int i=0;

		DefaultListModel plModel = (DefaultListModel)this.pl.getModel();
		DefaultListModel rmModel = (DefaultListModel)this.rm.getModel();

		if(e.getSource() == this.buttonIn){
			int[] fromindex = this.pl.getSelectedIndices();
			Object[] from = this.pl.getSelectedValues();

			for(i=0; i<from.length; i++){
				rmModel.addElement(from[i]);
			}

			for(i= (fromindex.length-1); i>=0; i--){
				plModel.remove(fromindex[i]);
			}

		}

		else if(e.getSource() == buttonOut){
			Object[] to = this.rm.getSelectedValues();
			int[] toindex = this.rm.getSelectedIndices();

			for(i=0; i<to.length; i++){
				plModel.addElement(to[i]);
			}

			for(i= (toindex.length-1); i>=0; i--){
				rmModel.remove(toindex[i]);
			}

		}

	}
	
}
