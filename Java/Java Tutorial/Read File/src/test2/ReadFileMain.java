package test2;

import java.util.*;
import java.io.*;

public class ReadFileMain {
	
	static Scanner in = new Scanner(System.in);
	static ReadFile rf = new ReadFile();
	

	public static void main(String[] args){
        
		int count = 0, error = 0;
		boolean checkOverwrite;
		rf.readTheFile();
		// System.out.println(rf.getInputArr());
		
		do{
			for(int i = 0; i < 5; i++){
				do{
					String value = "";
					checkOverwrite = false;
					switch(i){
						case 0:
							System.out.print("First Name: ");
							break;
						case 1:
							System.out.print("Last Name: ");
							break;
						case 2:
							System.out.print("IC Number: ");
							break;
						case 3:
							System.out.print("Phone Number: ");
							break;
						case 4:
							System.out.print("Email: ");
							break;
					}	
					value = in.nextLine();
					checkOverwrite = WriteFile(value, i);
				}while(checkOverwrite == true);
				
			}
		}while(error != 0);
		
		rf.readTheFile();
		
		String[] firstName = new String[rf.getInputArr().size() / 5];
		String[] lastName = new String[rf.getInputArr().size() / 5];
		String[] icNum = new String[rf.getInputArr().size() / 5];
		String[] phoneNum = new String[rf.getInputArr().size() / 5];
		String[] email = new String[rf.getInputArr().size() / 5];
		
		Object[] obj = rf.getInputArr().toArray();
		
		for(int i = 0; i < rf.getInputArr().size(); i+=5){
			firstName[count] = (String)obj[i];
			count++;
		}
		count = 0;
		for(int i = 1; i < rf.getInputArr().size(); i+=5){
			lastName[count] = (String)obj[i];
			count++;
		}
		count = 0;
		for(int i = 2; i < rf.getInputArr().size(); i+=5){
			icNum[count] = (String)obj[i];
			count++;
		}
		count = 0;
		for(int i = 3; i < rf.getInputArr().size(); i+=5){
			phoneNum[count] = (String)obj[i];
			count++;
		}
		count = 0;
		for(int i = 4; i < rf.getInputArr().size(); i+=5){
			email[count] = (String)obj[i];
			count++;
		}
		// System.out.println(rf.getInputArr());
		for(int i = 0; i < firstName.length; i++){
			System.out.println("\nUser " + (i + 1) + ":~");
			System.out.println("First Name: " + firstName[i]);
			System.out.println("Last Name: " + lastName[i]);
			System.out.println("IC number: " + icNum[i]);
			System.out.println("Phone Number: " + phoneNum[i]);
			System.out.println("Email: " + email[i]);
		}
		
		// System.out.println("First Name: " + Arrays.toString(firstName));
		// System.out.println("Last Name: " + Arrays.toString(lastName));
		// System.out.println("IC number: " + Arrays.toString(icNum));
		// System.out.println("Phone Number: " + Arrays.toString(phoneNum));
		// System.out.println("Email: " + Arrays.toString(email));
		
		// for(int i = 0; i < firstName.length; i++){
		// 	System.out.println("User " + (i + 1) + ":~");
		// 	System.out.println("First Name: " + firstName[i]);
		// 	System.out.println("Last Name: " + lastName[i]);
		// 	System.out.println("IC number: " + icNum[i]);
		// 	System.out.println("Phone Number: " + phoneNum[i]);
		// 	System.out.println("Email: " + email[i] + "\n");
		// }
		
        in.close();
	}
	
	public static boolean WriteFile(String value, int checkNumber){
		boolean overwrite = false;
		//run here to create the file
		
		try {
			FileWriter fw = new FileWriter(rf.getFile(), true);
			for(int i = checkNumber; i < rf.getInputArr().size(); i+=5){
				if(value.equals(rf.getInputArr().get(i))){
					overwrite = true;
					break;
				}
				else{
					overwrite = false;
				}
			}
			if(overwrite == false){
				fw.write("\n" + value);
			}
			else{
				System.out.println("value exist!");
			}
			
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return overwrite;
	}
}
