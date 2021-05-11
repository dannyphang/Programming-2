package test2;

import java.util.*;

import java.io.*;
public class ReadFile {
    private File file = new File(".\\src\\test\\StudentInfo");
    private List<String> inputArr = new ArrayList<String>();

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    public List<String> getInputArr() {
        return inputArr;
    }

    public void setInputArr(List<String> inputArr) {
        this.inputArr = inputArr;
    }
    
    public void readTheFile(){
        String line;
        
        try {
			
			FileReader fr = new FileReader(".\\src\\test\\StudentInfo");   //reads the file
			BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            
            // to clear the elements of the List
            for(int i = inputArr.size() - 1; i >= 0; i--){
                inputArr.remove(i);
            }
            
            // System.out.println(inputArr);
			while ((line = br.readLine()) != null) {
				inputArr.add(line);
				
            }
            
			fr.close();    //closes the stream and release the resources
		} catch (IOException e) {
			e.printStackTrace();
        }
        // System.out.println(getInputArr());
    }
}
    
