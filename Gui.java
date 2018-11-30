import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Gui extends JFrame{

	public Gui() {
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

		//Exit item for File Menu
		JMenuItem eMenuItem = new JMenuItem("Exit");
		eMenuItem.setMnemonic(KeyEvent.VK_E);
		eMenuItem.setToolTipText("Exit Application");
		eMenuItem.addActionListener((event) -> System.exit(0));

		fileMenu.add(eMenuItem);
		menubar.add(fileMenu);

		setJMenuBar(menubar);

	}
	
	public static void main(String[] args) {
		new Gui();
	}

}
