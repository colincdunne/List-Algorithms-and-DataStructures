import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class myListArrayList implements myList {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------
    private ArrayList<myPlayer> items; //See the use of a dynamic data structure: ArrayList

    //--------------------------------------------------
    // Constructor
    //--------------------------------------------------    
    public myListArrayList(){
        this.items = new ArrayList<myPlayer>();
    }

    //-------------------------------------------------------------------
    // Create an empty MyList: create_empty
    //-------------------------------------------------------------------
    //public myList create_empty(){}

    //-------------------------------------------------------------------
    // 1. Load a MyList from file: load_file
    //-------------------------------------------------------------------
    public void load_file(String s){                

        try {
            //1. We create the file variable
            File my_file = new File(s);
            Scanner sc = new Scanner(my_file);

            //2. We empty the list
            int size = this.my_get_length();
            for (int i = 0; i < size; i++)
                this.my_remove_element(0);

            //3. We fill MyList with the content of the file
            int count = 0;
            while (sc.hasNext()){
                myPlayer player = new myPlayer(sc.next(), sc.nextInt());
                this.my_add_element(count, player);
                count = count + 1;
            }

            //4. We close the scanner
            sc.close();

            System.out.println("Load Operation Completed");
        } 
        catch (Exception e)  {
            System.out.println("Sorry but there is not such file");
        }   
    }

    //-------------------------------------------------------------------
    // 2. Display MyFile content: show_elements
    //-------------------------------------------------------------------
    public void show_elements(){
        for(int k = 0; k < my_get_length(); k++) {
            my_get_element(k).print_info();
        }
    }

    //-------------------------------------------------------------------
    // 3. Check if element is in MyList: find_element
    //-------------------------------------------------------------------
    public int find_element(String s){
        for(int k = 0; k < my_get_length(); k++) {
            if(my_get_element(k).get_name().contains(s)) {
                return k;
            }
        }
        return -1;
    }

    //-------------------------------------------------------------------
    // 4. Show info of element in MyList: show_info
    //-------------------------------------------------------------------
    public void show_info(String s){
        for(int k = 0; k < my_get_length(); k++) {
            if(my_get_element(k).get_name().contains(s)) {
                my_get_element(k).print_info();
            }
        }
    }

    //-------------------------------------------------------------------
    // 5. Add new element to MyList: add_by_keyboard
    //-------------------------------------------------------------------
    public void add(String s, int i){
        myPlayer value = new myPlayer(s, i);
        my_add_element((my_get_length()), value);
        System.out.println("The Player" + s + "has been added to the databade");
    }

    //-------------------------------------------------------------------
    // 6. Update element of MyList: update
    //-------------------------------------------------------------------
    public void update(String s, int g){
        boolean found = false;

        for(int k = 0; k < my_get_length(); k++)
        {
            if(my_get_element(k).get_name().equals(s))
            {
                my_get_element(k).set_goals(g);
                found = true;
                System.out.println("Player information has been updated");
            }

            if(k ==(my_get_length()-1) && !found)
            {
                System.out.println("No player with the name: " + s + " exists in the database");
            }
        }
    }

    //-------------------------------------------------------------------
    // 7. Remove element of MyList: remove_element
    //-------------------------------------------------------------------
    public void remove(String s){
        boolean found = false;

        for(int k = 0; k < my_get_length(); k++)
        {
            if(my_get_element(k).get_name().equals(s))
            {
                my_remove_element(k);
                found = true;
                System.out.println("The Player: " + s + " has been removed from the list");
            }

            if(k ==(my_get_length()-1) && !found)
            {
                System.out.println("No player with the name: " + s + " exists in the databse");
            }
        }
    }

    //-------------------------------------------------------------------
    // 8. sort elements of MyList: bubble_sort
    //-------------------------------------------------------------------
    public void bubble_sort(){  
        myPlayer temp;

        for(int x = 0; x < my_get_length() - 1; x++) {
            for(int y = 0; y < my_get_length() - x - 1; y++) {
                 if(my_get_element(y).smaller(my_get_element(y+1))) {
                     temp = my_get_element(y);
                     my_add_element(y, my_get_element(y+1));
                     my_remove_element(y+1);
                     my_add_element(y+1, temp);
                     my_remove_element(y+2);
                }
            }
        }
    }

    //-------------------------------------------------------------------
    // 9. Write a MyList to file: write_file
    //-------------------------------------------------------------------
    public void write_file(String s){
        try {
            PrintWriter dataFile = new PrintWriter(s);
            
            for(int k = 0; k < this.my_get_length(); k++) {
                dataFile.println(this.my_get_element(k).get_name() + " " + this.my_get_element(k).get_goals());
            }
            System.out.println("The data has been saved to the file");
            dataFile.close();
        }
        
        catch(Exception e) {
            System.out.println("File does not exist!");
        }
    }

    //-------------------------------------------------------------------
    // Basic Operation --> Get number of elements in MyList: my_get_length
    //-------------------------------------------------------------------   
    public int my_get_length(){
        return this.items.size();
    }

    //-------------------------------------------------------------------
    // Basic Operation --> Get element at of MyList at a concrete position: my_get_element
    //-------------------------------------------------------------------
    public myPlayer my_get_element(int index){
        myPlayer value = null;

        try{            
            value = this.items.get(index);      
                     }
        catch (Exception e){
            System.out.println("Sorry, not such an index to access");
        }

        return value;   
    }

    //-------------------------------------------------------------------
    // Basic Operation --> Add element to MyList at a concrete position: my_add_element 
    //-------------------------------------------------------------------
    public void my_add_element(int index, myPlayer value){
        try{
            this.items.add(index, value);
        }
        catch (Exception e){
            System.out.println("Sorry, not such an index to add");
        }       
    }

    //-------------------------------------------------------------------
    // Basic Operation --> Remove element of MyList at a concrete position: my_remove_element 
    //-------------------------------------------------------------------   
    public void my_remove_element(int index){
        try{            
            this.items.remove(index);       
        }
        catch (Exception e){
            System.out.println("Sorry, not such an index to remove");
        }       
    }

}
