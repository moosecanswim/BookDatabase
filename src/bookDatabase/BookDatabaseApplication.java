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

	/*	//bookDB.add(new Book("sku","title","author","description",100));
		bookDB.add(new Book(1,"Java1001","Head First Java","Kathy Sierra and Bert Bates","Easy to read Java workbook",47.50,"Fiction"));
		bookDB.add(new Book(2,"Java1002","Thinking in Java","Bruce Eckel","Details about Java under the hood",20.00,"science"));
		bookDB.add(new Book(3,"Orcl1003","OCP: Oracle Certified Professional Java SE","Jeanne Boyarsky","Everything you need to know in one place",45.00,"nonFiction"));
		bookDB.add(new Book(4,"Python1004","Automate the Boring Stuff with Python","Al Sweigart","Fun with Python",10.50,"Fiction"));
		bookDB.add(new Book(5,"Zombie1005","The Maker's Guide to the Zombie Apocalypse","Simon Monk","Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi",16.50,"nonFiction"));
		bookDB.add(new Book(6,"Rasp1006","Raspberry Pi Projects for the Evil Genius","Kyle","A dozen fiendishly fun projects for the Raspberry Pi!",14.75,"Fiction"));
		bookDB.add(new Book(7,"Rasp1007","Rasb 2","Kyle","A dozen fiendishly fun projects for the Raspberry Pi!",15.75,"nonFiction"));
*/
		
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
