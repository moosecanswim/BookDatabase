package bookDatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class BookDatabaseApplication {
	/***
	 * This application is going to allow you to create a database of books and search it based on the sku.  it may be possible to alter the method so that we can search it on different perameters too
	 * This will present a menu to create, read (display all), and delete enteries or quit
	 * I've already populated it with 6 books.
	 * 
	 */

	public static void main (String[] args){

		//Compile database original
		ArrayList<Book> bookDB = new ArrayList<Book>();

		bookDB = BookDatabase.insertDefaultEntries ();

		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		do{
			System.out.println("Would you like to (1)display the book database (2)search the database or (3) add an entery to the database (4) modify an entry?  press any other button to quit");
			String response = scan.nextLine();
			switch(response){
			case "1" :
				//case one- display database
				BookDatabase.displayDatabase(bookDB);
				break;
			case "2" :
				//case two- search database
				String output = null;
				boolean runSearchChoice = true;
				do{
					//choose what your search criteria is
					System.out.println();
					System.out.println("Would you like to search by (1) SKU (2) Author or (3) Catagory?  press any other button to go back to main menu");
					String responseSearchChoice = scan.nextLine();
					switch(responseSearchChoice){
					case "1" :
						//case one - search sku
						BookDatabase.searchSku(bookDB);
						break;
					case "2" :
						//case two- search author
						BookDatabase.searchAuthor(bookDB);
						break;
					case "3" :
						//case three- search catagory
						BookDatabase.searchCatagory(bookDB);
						break;
					default:
						//leave the program
						System.out.println("Exit Search");
						runSearchChoice = false;

					}

				}while(runSearchChoice);


				break;
			case "3" :
				//case three- add entry 
				bookDB.add(BookDatabase.createBook());
				//next step create an entry then ask if they want to add it to the database
				break;
			case "4":
				//modify an entry
                BookDatabase.displayDatabase(bookDB);
                System.out.println("Which entry would you like to modify? (enter the index number on left)");
                int indexChoice = 0;
                while(!scan.hasNextInt()){
                    System.out.println("you need to enter a number");
                }indexChoice = scan.nextInt();
                BookDatabase.modify(bookDB.get(indexChoice));

				
				break;
				
			default:
				//leave the program
				System.out.println("cya brah");
				run = false;

			}

		}while(run);

		System.out.println("Exiting Program");
	}




}
