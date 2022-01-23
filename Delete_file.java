import java.io.File;
import java.io.IOException;

public class Delete_file {
    public void main(String[] args) { 
        File myObj = new File("List.txt"); 
        if (myObj.delete()) { 
            // delete file
        } else {
            System.out.println("Failed to delete the file.");
        }  
        try {
            if (myObj.createNewFile()) {
                // create file
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    } 
}
