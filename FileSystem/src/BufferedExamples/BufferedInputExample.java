package BufferedExamples;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputExample {

	public static void main(String[] args) throws IOException {
		
		FileInputStream in = new FileInputStream("C:\\Rohit\\Dates\\11-01-2023\\rohit.txt");
		BufferedInputStream br = new BufferedInputStream(in);
		int c;
		
		while ((c=br.read())!=-1) {
			System.out.print((char)c);
		}

	}

}
