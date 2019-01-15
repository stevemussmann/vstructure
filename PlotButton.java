import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javafx.stage.Stage;

public class PlotButton extends JButton implements MouseListener{

	//BarPlot bp;
	TextField textfield;
	
	PlotButton(String s, TextField tf){
	//ParseFileButton(String s, TextField tf){
		//this.bp = new BarPlot();
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
			//String[] args = new String[0];
			//this.bp.launch(args);
			javafx.application.Application.launch(BarPlot.class);
			//Stage s = new Stage();
			//new BarPlot().start(s);
//			bp.start(BarPlot.bpStage);
			//public static void main(String[] args){
			//	javafx.application.Application.launch(BarPlot.class, args);
			//}
		}
	}
	public void mouseReleased(MouseEvent e) {}
/*
	public void makePlot() {
		System.out.println(f);
		this.ind = new IndFile(f);
		this.ind.parseInd(this.poplist);
		//ind.parseInd();
	}
*/	
}
