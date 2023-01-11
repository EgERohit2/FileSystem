package BufferedExamples;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BuffferedOutputExmple {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileOutputStream out = new FileOutputStream("C:\\Rohit\\Dates\\11-01-2023\\rohit.txt");
		BufferedOutputStream br = new BufferedOutputStream(out);
		
		String s = "Hello world";
		byte b[]= s.getBytes();
		try {
			br.write(b);
			br.flush();
			br.close();
			out.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
