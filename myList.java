
public interface myList {
	
	//-------------------------------------------------------------------
	// Create an empty MyList: create_empty
	//-------------------------------------------------------------------
	//public myList create_empty(); --> Java does not support constructors in interfaces
	
	//-------------------------------------------------------------------
	// 1. Load a MyList from file: load_file
	//-------------------------------------------------------------------
	public void load_file(String s);

	//-------------------------------------------------------------------
	// 2. Display MyFile content: show_elements
	//-------------------------------------------------------------------
	public void show_elements();

	//-------------------------------------------------------------------
	// 3. Find element in MyList: find_element
	//-------------------------------------------------------------------
	public int find_element(String s);

	//-------------------------------------------------------------------
	// 4. Show info of element in MyList: show_info
	//-------------------------------------------------------------------
	public void show_info(String s);
	
	//-------------------------------------------------------------------
	// 5. Add new element to MyList: add_by_keyboard
	//-------------------------------------------------------------------
	public void add(String s, int i);

	//-------------------------------------------------------------------
	// 6. Update element of MyList: update
	//-------------------------------------------------------------------
	public void update(String s, int g);
	
	//-------------------------------------------------------------------
	// 7. Remove element of MyList: remove
	//-------------------------------------------------------------------
	public void remove(String s);

	//-------------------------------------------------------------------
	// 8. sort elements of MyList: bubble_sort
	//-------------------------------------------------------------------
	public void bubble_sort();
	
	//-------------------------------------------------------------------
	// 9. Write a MyList to file: write_file
	//-------------------------------------------------------------------
	public void write_file(String s);
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get number of elements in MyList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length();
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get element at of MyList at a concrete position: my_get_element
	//-------------------------------------------------------------------
	public myPlayer my_get_element(int index);
		
	//-------------------------------------------------------------------
	// Basic Operation --> Add element to MyList at a concrete position: my_add_element 
	//-------------------------------------------------------------------
	public void my_add_element(int index, myPlayer player);
	
	//-------------------------------------------------------------------
	// Basic Operation --> Remove element of MyList at a concrete position: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index);
	
}
