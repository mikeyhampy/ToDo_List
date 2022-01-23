import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Remove_item {
    public ArrayList<String> main(String[] args, ArrayList<String> todoArray) { 

        Scanner number = new Scanner(System.in);
        System.out.print("\nEnter the number of Items you'd Like to remove: ");
        int number_loop = number.nextInt();
        String write_string = "";
        int counter = 0;

        for(int i = 0; i < number_loop; i++) {
            Scanner item_index = new Scanner(System.in);
            int current_index_count = 1;
            for(String l : todoArray) {
                System.out.print(current_index_count + " - " + l + "\n");
                current_index_count += 1;
            }
            System.out.print("\nEnter the number of the item(s) you'd like to delete: ");
            int index = item_index.nextInt();
            todoArray.remove(index - 1);
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
