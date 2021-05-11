import java.io.*;
import java.util.*;

public class CreateFileDemo {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Enter the folder path: ");
		String folderPath = in.nextLine();
		// C:\\Users\\ADMIN\\Desktop\\Folder Create test

		System.out.print("Enter file name: ");
		String fileName = in.nextLine();
		// remember to add \\ before write the file name and also write the file format such as .txt / .java
		
		File folder_path = new File(folderPath);
		
		CreateFolder(folder_path);
		ReadFile(folder_path, fileName);
		WriteFile(folder_path, fileName);
		
		
	}
	
	public static void CreateFolder(File folder_path){
		
		if(!folder_path.exists()){
			folder_path.mkdirs();
			System.out.println("\nFolder is created successful!");
		}
		else{
			System.out.println("\nFolder exists!");
		}
	}
	
	public static void ReadFile(File folder_path, String fileName) {
		
		try {
			
			// run here when the file is exists
			
			FileReader fr = new FileReader(folder_path + fileName);
			
			System.out.println("File exists!");
			//WriteFile(folder_path, fileName);
			
			fr.close();
		} catch (IOException e) {
			
			// run here when the file is not exists
			
			System.out.println("File is creating...");
		}
	}
	
	public static void WriteFile(File folder_path, String fileName){
		
		//run here to create the file
			
			try {
				FileWriter fw = new FileWriter(folder_path + fileName, true);
				
				fw.write(FileContent());
				
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}
	
	public static String FileContent(){
		
		System.out.print("Content: ");
		String content = in.nextLine();
		
		return content;
	}
}
