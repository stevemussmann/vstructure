import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IndFile {
	String fn;

	IndFile(String f){
		this.fn = f;
	}

	public void parseInd() {
		Scanner s;
		try{
			s = new Scanner(new File(this.fn));
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
