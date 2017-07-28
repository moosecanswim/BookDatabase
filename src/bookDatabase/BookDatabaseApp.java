package bookDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDatabaseApp {
	/***
	 * This application is going to allow you to create a database of books and search it based on the sku.  it may be possible to alter the method so that we can search it on different perameters too
	 * This will present a menu to create, read (display all), and delete enteries or quit
	 * I've already populated it with 6 books. (could add a quantity field to the book class and be able to add more of the same book)
	 * this would require me to override the .equals() class to compare all fields.
	 * @param args
	 */



	public static void main (String[] args){

		//Compile database origionaly
		ArrayList<Book> bookDB = new ArrayList<Book>();

		//bookDB.add(new Book("sku","title","author","description",100));
		bookDB.add(new Book("Java1001","Head First Java","Kathy Sierra and Bert Bates","Easy to read Java workbook",47.50));
		bookDB.add(new Book("Java1002","Thinking in Java","Bruce Eckel","Details about Java under the hood",20.00));
		bookDB.add(new Book("Orcl1003","OCP: Oracle Certified Professional Java SE","Jeanne Boyarsky","Everything you need to know in one place",45.00));
		bookDB.add(new Book("Python1004","Automate the Boring Stuff with Python","Al Sweigart","Fun with Python",10.50));
		bookDB.add(new Book("Zombie1005","The Maker's Guide to the Zombie Apocalypse","Simon Monk","Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi",16.50));
		bookDB.add(new Book("Rasp1006","Raspberry Pi Projects for the Evil Genius","Kyle","A dozen fiendishly fun projects for the Raspberry Pi!",14.75));
		bookDB.add(new Book("Rasp1007","Rasb 2","Kyle","A dozen fiendishly fun projects for the Raspberry Pi!",15.75));

		Scanner scan = new Scanner(System.in);
		boolean run = true;
		do{
			System.out.println("Would you like to (1)display the book database (2)search the database or (3) add an entery to the database?  press any other button to quit");
			String response = scan.nextLine();
			switch(response){
			case "1" :
				//case one- display database
				displayDatabase(bookDB);
				break;
			case "2" :
				//case two- search database
				//searchSku(bookDB);
				searchAuthor(bookDB);
				break;
			case "3" :
				//case three- add entry 
				bookDB.add(createBook());
				//next step create an entry then ask if they want to add it to the database
				break;
			default:
				//leave the program
				System.out.println("cya brah");
				run = false;

			}

		}while(run);

		System.out.println("Exiting Program");
	}
	public static void searchAuthor(ArrayList<Book> inArray){
		Scanner scanAuthor = new Scanner(System.in);
		String authorToSearch=null;
		System.out.println("Please enter an author to search (not case sensitive)");
		if(scanAuthor.hasNext()){
			authorToSearch = scanAuthor.nextLine();
		}else{
			System.out.println("There is an issue entering your author.");
		}
		//System.out.println("we are searching for "+authorToSearch);

		Boolean foundIt = false;
		int authorCount = 0;
		for(Book i : inArray){
			if(authorToSearch.equalsIgnoreCase(i.getBookAuthor())){
				if(authorCount == 0){
					System.out.println("Found some! Displaying the information below: ");
					//authorCount++;
				}
				i.printBook();
				authorCount++;
				foundIt = true;
			}else{
				//add capability to create a new entry from here
			}
		}if(foundIt == false){
			System.out.println("Sorry but i dont have it but if you would like to add it you can do so from the main menu");  

		}
	}
	public static void searchSku(ArrayList<Book> inArray){
		Scanner scanSku = new Scanner(System.in);
		String skuToSearch=null;
		System.out.println("Please enter a sku to search (case sensitive)");
		if(scanSku.hasNext()){
			skuToSearch = scanSku.nextLine();
		}else{
			System.out.println("There is an issue entering your sku.");
		}
		//System.out.println("we are searching for "+skuToSearch);

		Boolean foundIt = false;
		for(Book i : inArray){
			if(skuToSearch.equals(i.getSku())){
				System.out.println("Found it! Displaying the information below: ");
				i.printBook();
				foundIt = true;
			}else{
				//add capability to create a new entry from here
			}
		}if(foundIt == false){
			System.out.println("Sorry but i dont have it but if you would like to add it you can do so from the main menu");  

		}

	}
	public static Book createBook(){
		String inSku = null;
		String inTit = null;
		String inAut = null;
		String inDec = null;
		double inPri = 0.0;

		System.out.println("Creating a book!");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a SKU: ");
		inSku = scan.nextLine();
		System.out.println("Enter a Title: ");
		inTit = scan.nextLine();
		System.out.println("Enter an Author: ");
		inAut = scan.nextLine();
		System.out.println("Enter a Description: ");
		inDec = scan.nextLine();
		System.out.println("Enter a Price: ");
		boolean realEntry = false;
		while(realEntry==false){
			if(scan.hasNextDouble()){
				inPri = scan.nextDouble();
				realEntry = true;
			}else{
				System.out.println("Please try another PRICE IN NUMBERS");
				scan.next();
				realEntry = false;
			}
		}
		//scan.next();
		Book newBook = new Book(inSku,inTit,inAut,inDec,inPri);
		System.out.println("Book Accetped");

		return newBook;
	}
	public static void displayDatabase(ArrayList<Book> inArray){
		System.out.println("There are "+ inArray.size() + " books in the database.");
		System.out.println();
		String output = String.format("%-10s | %-50s | %-30s | %-70s | %6s", "SKU","Title","Author","Description","Price");
		System.out.println("________________________________________________________________________________________________________________________________________________________");
		System.out.println(output);
		for(Book i : inArray){
			i.printBook();
		}
		System.out.println("________________________________________________________________________________________________________________________________________________________");
	}
}