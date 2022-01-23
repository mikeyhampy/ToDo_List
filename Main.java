import java.util.Scanner;
// import java.io.File;
// import java.io.FileNotFoundException;

class Main {
    public static void main(String[] args) {
        int choice = 0;
        Read_list reader = new Read_list();
        reader.todoArray = reader.getList();
        Delete_file wipe_list = new Delete_file();

            do { 
                Scanner userInput = new Scanner(System.in);
                // options for editing todo list
                System.out.print("Choose an Option!\n");
                System.out.print("1 - add item to list\n");
                System.out.print("2 - remove item from list\n");
                System.out.print("3 - view list\n");
                System.out.print("4 - delete list\n");
                System.out.print("5 - quit\n");
                String choice_string = userInput.nextLine();

                // check if user input is a number
                try {
                    choice = Integer.parseInt(choice_string);
                } catch (Exception e) {
                    choice = 6;
                }

                // action for valid numbers
                if (choice == 1) {
                    // add item Write to list
                    Write_list write_new = new Write_list();
                    reader.todoArray = write_new.main(args, reader.todoArray);
                } else if (choice == 2) {
                    // remove item from list
                    Remove_item delete_items = new Remove_item();
                    reader.todoArray = delete_items.main(args, reader.todoArray);
                } else if (choice == 3) {
                    // will read file and output a list
                    System.out.println("\n***Current ToDo list Items***\n");

                    int count_items = 1;
                    for(String i : reader.todoArray) {
                        System.out.println(count_items + " - " + i);
                        count_items += 1;
                    }
                    System.out.println("\n");
                } else if (choice == 4) {
                    // will delete file and make another one with the same name
                    Scanner yes_no = new Scanner(System.in);
                        System.out.println("Are you sure you want to delete the list?");
                        System.out.println("Enter 1 for YES and any other number for NO!");
                        
                        int answer_y_n = yes_no.nextInt();
                        if (answer_y_n > 0 && answer_y_n < 2) {
                            reader.todoArray = reader.emptyArray;
                            wipe_list.main(args);
                            System.out.println("Your list IS deleted");
                        } else {
                            System.out.println("Your list ISN'T deleted");
                        }
                    
                } else if (choice == 5) {
                    System.out.println("\nexit program\n");
                    // wipe_list.main(args);
                }  else if (choice > 5 || choice < 1) {
                    System.out.println("\n***invalid Input***\n");
                }
                
            }
            while (choice != 5);
        
    }
}