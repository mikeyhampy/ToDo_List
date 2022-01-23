import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Write_list {
    public ArrayList<String> main(String[] args, ArrayList<String> todoArray) { 

        Scanner number = new Scanner(System.in);
        System.out.print("\nEnter the number of Items you'd Like to add: \n");
        int number_loop = number.nextInt();
        String write_string = "";
        int counter = 0;

        for(int i = 0; i < number_loop; i++) {
            Scanner new_item = new Scanner(System.in);
            System.out.print("\nEnter new task: \n");
            String item = new_item.nextLine();
            todoArray.add(item);
        }

        for(String j : todoArray) {
            counter += 1;
            if (counter == todoArray.size()) {
                write_string += (j);
            }
            else {
                write_string += (j + ",");
            }
        }
        try {  
            FileWriter myWriter = new FileWriter("List.txt");
            myWriter.write(write_string);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return todoArray;
    }   
}
