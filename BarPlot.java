//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Arrays;
//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
import java.util.Map;
//import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

public class BarPlot extends Application {

	BarPlot() {
		
	}

	@Override
	public void start(Stage stage) {

		//Defining the axes
		CategoryAxis xAxis = new CategoryAxis();

		xAxis.setLabel("category");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Ancestry");
		yAxis.setAutoRanging(false);
		yAxis.setUpperBound(1.0);

		//Creating the Bar chart
		StackedBarChart<String, Number> stackedBarChart = new StackedBarChart<>(xAxis, yAxis);
		//stackedBarChart.setTitle("Historic World Population by Region");

		//get data from IndFile class

		//System.out.println(IndFile.fn);

		//implementing read of data. Old test method is block commented below new method

		for(Map.Entry<String, HashMap<String, double[]>> popEntry : IndFile.data.entrySet()){
			String pop = popEntry.getKey();
			
			for(Map.Entry<String, double[]> indEntry : popEntry.getValue().entrySet()){
				String ind = indEntry.getKey();
				double[] anc = indEntry.getValue();
			}
		}

/*
	String file = "ClumppIndFile.output.6";
	Scanner s;
	ArrayList<String> list = new ArrayList<>();
	try{
		for(int i=5; i<11; i++){
			s = new Scanner(new File(file));
			XYChart.Series<String, Number> series = new XYChart.Series<>(); 
			series.setName(Integer.toString(i));
			//for(int j=0; j<112; j++){
			while(s.hasNextLine()) {
				String line = s.nextLine();
				String[] splitLine = line.split("\\s+");
				System.out.println(splitLine[0] + " " + splitLine[i]);
				series.getData().add(new XYChart.Data<>(splitLine[0],Double.parseDouble(splitLine[i])));
			}
			stackedBarChart.getData().add(series);
		}

	}catch(FileNotFoundException e){
		e.printStackTrace(System.err);
		System.exit(1);
	}

	//System.out.println(list);
*/
    
		//set gap between bars on plot
		stackedBarChart.setCategoryGap(0.0);
		stackedBarChart.setPrefSize(1200,400);
 
		//Creating a Group object
		Group root = new Group(stackedBarChart);

		//Creating a scene object
		Scene scene = new Scene(root, 1300, 500);
      
		//Setting title to the Stage
		stage.setTitle("stackedBarChart");

		//Adding scene to the stage
		stage.setScene(scene);

		//Displaying the contents of the stage
		stage.show();
	}


   public static void main(String args[]){ 
      launch(args); 
   } 
}
