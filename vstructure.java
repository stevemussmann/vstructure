import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class vstructure extends JFrame{

	public vstructure() {
		View view = new View();
		createMenuBar();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(view);
		this.setTitle("Word Search");
		this.setSize(500,100);
		this.setVisible(true);
		
	}

	private void createMenuBar(){
		JMenuBar menubar = new JMenuBar();

		//File Menu
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		//Open item for File Menu
		JMenuItem open = new JMenuItem("Open");
		open.addActionListener((event) -> this.getFile());

		//Exit item for File Menu
		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_E);
		exit.setToolTipText("Exit Application");
		exit.addActionListener((event) -> System.exit(0));

		//file menu items
		fileMenu.add(open);
		fileMenu.add(exit);

		//menu bar items
		menubar.add(fileMenu);

		setJMenuBar(menubar);

	}

	public void getFile() {
		JFileChooser fc = new JFileChooser("."); //get contents of current folder
		int choice = fc.showOpenDialog(this);
		if( choice == JFileChooser.APPROVE_OPTION) {
			String fn = fc.getSelectedFile().getAbsolutePath();
			JOptionPane.showMessageDialog(this, fn, "The file you chose", JOptionPane.PLAIN_MESSAGE);
			System.out.println(fn);
		}
		//System.out.println("code reached");
	}
	
	public static void main(String[] args) {
		new vstructure();
	}

}
