import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IndFile {

	IndFile(String s){
		String fn = s;
	}

	public void parseInd(String f) {
		Scanner s;
		try{
			s = new Scanner(new File(f));
			while(s.hasNextLine()) {
				String line = s.nextLine();
				System.out.println(line);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
}
