//show info of file

package BufferedExamples;

import java.io.File;

public class ShowFileInformation {

	public static void main(String[] args) {
		File file = new File("C:\\Rohit\\Dates\\11-01-2023\\NewCode.txt");
		if (file.exists()) {
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
			System.out.println(file.canRead());
			System.out.println(file.canWrite());
			System.out.println(file.length());
		}
		else {
			System.out.println("file not exists");
		}
	}
}
