import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class IndFile {
	String fn;
	HashMap<String, HashMap<String, double[]>> data;
	int sPops;
	int gPops;

	IndFile(String f){
		this.fn = f;
	}

	public void parseInd() {
		Scanner s;
		try{
			s = new Scanner(new File(this.fn));
			data = new HashMap<String, HashMap<String, double[]>>();
			while(s.hasNextLine()) {
				String line = s.nextLine();
				this.gPops = this.parseLine(line);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace(System.err);
			System.exit(1);
		}

		this.sPops = data.size(); // record number of sample populations

		System.out.println("# sample pops = " + Integer.toString(this.sPops));
		System.out.println("# genetic pops = " + Integer.toString(this.gPops));
	}

	int parseLine(String l) {
		//System.out.println(l);
		String[] sl = l.split("\\s+"); //split line
		String[] subset = Arrays.copyOfRange(sl, 5, sl.length); //subset columns w/ancestry

		int nAncestry = sl.length - 5;

		double[] ancestry = this.DoubleArray(subset); //convert String array to double array
		System.out.println(sl[1].toString() + "," + Arrays.toString(ancestry)); //test print

		//put data into HashMap of HashMaps of arrays
		//key 1 = sample pop
		//key 2 = individual ID
		//value = ancestry
		if(!(data.containsKey(sl[3]))){
			//System.out.println("Line reached (empty)");
			data.put(sl[3], new HashMap<String, double[]>());
			data.get(sl[3]).put(sl[1],ancestry);
		}else{
			//System.out.println(sl[3] + " is not emtpy");
			data.get(sl[3]).put(sl[1],ancestry);
			
		}

		return nAncestry;

	}


	double[] DoubleArray(String[] array) {
		double[] converted = new double[array.length];

		for(int i=0; i < array.length; i++) {
			converted[i] = Double.parseDouble(array[i]);
		}

		return converted;
	}
	
}
