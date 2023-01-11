//create a file 

package BufferedExamples;

import java.io.File;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Rohit\\Dates\\11-01-2023\\NewCode.txt");
		if (file.createNewFile()) {
			System.out.println("files created successfully..");
		}
		else {
			System.out.println("file alredy exist");
		}
		
		

	}

}
