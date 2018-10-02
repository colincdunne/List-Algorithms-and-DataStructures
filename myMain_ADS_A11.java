
import java.util.Scanner;

public class myMain_ADS_A11 {

	//-------------------------------------------------------------------
	// 0. static class variable to read from user
	//-------------------------------------------------------------------	
	static Scanner sc = new Scanner(System.in);
	
	//-------------------------------------------------------------------
	// 1. Ask user for an option: select_option
	//-------------------------------------------------------------------
	public static int select_option(){
		int option = 0;
			
		System.out.println("------------------------------------");
		System.out.println("			    MENU				");
		System.out.println("------------------------------------");
		System.out.println("1. Load database from file");
		System.out.println("2. Display database players");
		System.out.println("3. Check if player is in database");
		System.out.println("4. Show player info");
		System.out.println("5. Add player to database");
		System.out.println("6. Update player of database");
		System.out.println("7. Remove player from database");
		System.out.println("8. Sort the players of the database");
		System.out.println("9. Save database to file");
		System.out.println("0. Exit");
		
		boolean selected = false;
		
		while (selected == false){
			System.out.println("Please enter an option");
			try {
				option = sc.nextInt();
				sc.nextLine();
				if ((option >= 0) && (option <= 9))
					selected = true;
				else
					System.out.println("Sorry but the option must be 0..9");
				
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a valid option");
			}		
		}
				
		return option;
	}

	//-------------------------------------------------------------------
	// 2. Interactive session with the user: interactive_session
	//-------------------------------------------------------------------
	public static void interactive_session(){
		//1. We create the list (initially empty)/
		boolean finish = false;
		myList m = new myListArrayList();
		String input;

		//2. While the user wants to continue the session
		while (finish == false){

			//2.1. We clear the screen
			for (int i = 0; i < 100; i++)
				System.out.println();
			
			//2.2. Ask for the next operation to be performed
			int option = select_option();
			
			//2.3. Perform the operations
			switch (option){
			case 1: //Load from file 
				//We get the file to be read from
				//System.out.println("Please enter the name of the file to be read");
				//input = sc.nextLine();

				//We perform the operation
				m.load_file("database.txt");
				break;

			case 2: //Display Elements
				m.show_elements();
				break;
				
			case 3: //Check if element belongs to the list
				System.out.println("Please enter the name of the player");
				input = sc.nextLine();
				int i = m.find_element(input);
				
				if (i == -1)
					System.out.println("The player is not in the list");
				else
					System.out.println("The player is in the list");
				
				System.out.println("Check Operation Completed");
				break;
				
			case 4: //Show player details
				System.out.println("Please enter the name of the player");
				input = sc.nextLine();
				m.show_info(input);
				break;
				
			case 5: //Add a new player 
				try{
					System.out.println("Please enter the name of the player");
					String n = sc.next();
					System.out.println("Please enter the goals of the player");
					int g = sc.nextInt();
					sc.nextLine();

					m.add(n, g);				
				}
				catch (Exception e) {
					System.out.println("Sorry but the details entered are not correct");
				}	
				break;
				
			case 6: //Update a player
				try{
					System.out.println("Please enter the name of the player");
					String n = sc.next();
					System.out.println("Please enter the goals of the player");
					int g = sc.nextInt();
					sc.nextLine();

					m.update(n, g);				
				}
				catch (Exception e) {
					System.out.println("Sorry but the details entered are not correct");
				}					
				
				break;
				
			case 7: //Remove a player 
				System.out.println("Please enter the name of the player");
				input = sc.nextLine();
				m.remove(input);
				break;
		
			case 8: //Sort the elements 
				m.bubble_sort();
				break;
				
			case 9: //Write to file 
				//We get the file to be read from
// 				System.out.println("Please enter the name of the file to be read");
// 				input = sc.nextLine();
				
				//We perform the operation
				m.write_file("database.txt");
				break;

			default: 
				finish = true;
				break;
			}
			
			System.out.println("Press any key to continue");
			sc.nextLine();

		}
		
	}
	
	
	//-------------------------------------------------------------------
	// MAIN
	//-------------------------------------------------------------------
	public static void main(String[] args) {
		interactive_session();		
	}
		
}
