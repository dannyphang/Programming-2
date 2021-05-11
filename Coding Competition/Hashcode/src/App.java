import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
    		// Input
		int numPizzas;
		Map<Integer, Integer> teams = new HashMap<>();

		List<String> inputArr = new ArrayList<String>();    //constructs a string buffer with no characters

		try {
			File file = new File("a_example.in");    //creates a new file instance
			FileReader fr = new FileReader(file);   //reads the file
			BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream

			String line;
			while ((line = br.readLine()) != null) {
				inputArr.add(line);
			}
			fr.close();    //closes the stream and release the resources

		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] trimmedString = ((String) inputArr.get(0)).split(" ");
		numPizzas = Integer.parseInt(trimmedString[0]);
		System.out.println("line = " + numPizzas);
		// for(int i = 0; i < trimmedString.length; i++){
		// 	System.out.print(trimmedString[i]);
		// }
		

		

		inputArr.remove(0);

		System.out.println("numPizzas: " + numPizzas);

		for (int i = 1; i < trimmedString.length; i++) {
			int numMembers = Integer.parseInt(trimmedString[i]);
			teams.put(i+1, numMembers);
			System.out.println("team of " + (i+1) + ": " + numMembers);
		}

		Map<Integer, String> pizzaMap = new HashMap<>();

		for (int i = 0; i < inputArr.toArray().length; i++) {
			String[] trimmedString2 = ((String) inputArr.get(i)).split((" "));
			int numIngredients = Integer.parseInt(trimmedString2[0]);

			// System.out.print("Pizza " + i + ": ");

			for (int j = 1; j <= numIngredients; j++) {
				pizzaMap.put(j-1, trimmedString2[j]);
				// System.out.print(trimmedString2[j] + " ");
			}

			// System.out.print("\n");
		}

		// Solve
		Map<Integer, Integer> selectedTeam = new HashMap<Integer, Integer>();
    List<Integer> teamArr = new ArrayList<Integer>();

    for (Map.Entry<Integer, Integer> entry: teams.entrySet()) {
      for (int i = 0; i < entry.getValue(); i++) {
        teamArr.add(entry.getKey());
      }
    }

    for (int i = 0; i < teamArr.size(); i++) {
      int temp = numPizzas;

      selectedTeam = new HashMap<Integer, Integer>(){

          {
        put(2, 0);
        put(3, 0);
        put(4, 0);
      }};

      temp -= (Integer) teamArr.get(i);
      
      selectedTeam.put((Integer) teamArr.get(i), (Integer) selectedTeam.get((Integer) teamArr.get(i)) + 1);

      /*
          temp (5) - i = 
          
          
    */ 
      
      
      for (int j = teamArr.size() - 1; j >= 0; j--) {
        if (j == i) continue;
        if (temp > 0) {
          temp -= (Integer) teamArr.get(j);
          
          /*
          i + j + j
          i + 4 + j
          
          
          */ 
           
          
          
          selectedTeam.put((Integer) teamArr.get(j), (Integer) selectedTeam.get((Integer) teamArr.get(j)) + 1);
        } else {
          continue;
        }
      }

      if (temp == 0) break;
    }

		System.out.println(selectedTeam);
  }
}