import javax.swing.DefaultListModel;
import javax.swing.JList;

public class PopList extends JList {
	//DefaultListModel<String> items;

	PopList() {
		//this.items = new DefaultListModel<String>();
		//this.setModel(items);
		//this.items = new DefaultListModel();
		this.setVisibleRowCount(10);
		this.setFixedCellHeight(20);
		this.setFixedCellWidth(140);
		//this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	}

} 
