import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read_list {
    // Global variable
    ArrayList<String> todoArray = new ArrayList<String>();
    ArrayList<String> emptyArray = new ArrayList<String>();
    
    public ArrayList<String> getList() {
        // Local variables
        String path = "List.txt";
        String line = "";
        ArrayList<String> addingValues = new ArrayList<String>();

        // read file into an array
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                while((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    for(String i : values) {
                        addingValues.add(i);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addingValues;
    }
}


