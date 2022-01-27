import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFile{
	public static int[] readIn(){
		try {
			File file = new File("/Users/c.paulline/eclipse-workspace/FileRead/src/case1.txt");
			Scanner scan = new Scanner(file);
			String temp = "";
			while(scan.hasNextLine()) {
				temp += scan.nextLine() + ", ";
			}
			scan.close(); 
			
			String[] str = temp.split(", ");
			
			int[] result = new int[str.length];
			for(int i=0; i<str.length; i++) {
				result[i] = Integer.parseInt(str[i]);
			}
			return result;
		
		} catch (FileNotFoundException e) {
			System.out.println("An Error Occured");
			e.printStackTrace();
			return null;
		}

	}
}