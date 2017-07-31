package bookDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDatabase {
	/***
	 * This application is going to allow you to create a database of books and search it based on the sku.  it may be possible to alter the method so that we can search it on different perameters too
	 * This will present a menu to create, read (display all), and delete enteries or quit
	 * I've already populated it with 6 books. 
	 * this would require me to override the .equals() class to compare all fields.
	 * 
	 */

	//modify an entry
	public static void modify(Book input){

		Scanner scan = new Scanner(System.in);
		String response = null;
		
		System.out.println("This is the entry you want to modify:" );
		input.printBook();
		System.out.println("What would you like to modify: (1) sku, (2) title, (3) author, (4) description, (5) catagory, (6) price");
		while(!scan.hasNextLine()){
			System.out.println("There was an issue with yout input.");
		}
		response = scan.nextLine();
		Book tempBook = input;
		switch(response){
		case "1":
			//change the sku
			System.out.println(String.format("The current sku is %s",input.getSku()));
			String newSku = null;
			String confirmation = null;

			System.out.println("What should the new sku be?");
			while(!scan.hasNextLine()){
				System.out.println("There was an issue with that you put into for the sku.  please try again");
			}

			newSku = scan.nextLine();
			System.out.println(String.format("Replace old sku: %s with new sku %s.  (c)onfirm of (d)eny these changes.",tempBook.getSku(),newSku));
			while(!scan.hasNextLine()){
				System.out.println("press c or d to confirm or deny");
			}confirmation = scan.nextLine();
			if(confirmation.equalsIgnoreCase("c")){
				//confirm
				input.setSku(newSku);
				System.out.println("sku was changed to " + input.getSku());
			}if(confirmation.equalsIgnoreCase("d")){
				//deny
				System.out.println("sku will remain " + tempBook.getSku());
			}else{
				//do nothing
			}
			
			
			//add something to check the sku.  you cannot modify something to match another sku
			break;
		case "2":
			//change the title
			System.out.println("Modify the Title");
			break;
		case "3":
			//change the author
			System.out.println("Modify the Author");
			break;
		case "4":
			//change the description
			System.out.println("Modify the Description");
			break;
		case "5":
			//change the catagory
			System.out.println("Modify the Catagory");
			break;
		case "6":
			//change the price
			System.out.println("Modify the Price");
			break;
			
		default:
			System.out.println("Exiting modify");	
		}
		
		
		
		
		
		
	}

	//populate the database with default enteries
	public static ArrayList<Book> insertDefaultEntries (){
		ArrayList<Book> bookDB = new ArrayList<Book>();

		//bookDB.add(new Book("sku","title","author","description",100));
		bookDB.add(new Book("Java1001","Head First Java","Kathy Sierra and Bert Bates","Easy to read Java workbook",47.50,"Fiction"));
		bookDB.add(new Book("Java1002","Thinking in Java","Bruce Eckel","Details about Java under the hood",20.00,"science"));
		bookDB.add(new Book("Orcl1003","OCP: Oracle Certified Professional Java SE","Jeanne Boyarsky","Everything you need to know in one place",45.00,"nonFiction"));
		bookDB.add(new Book("Python1004","Automate the Boring Stuff with Python","Al Sweigart","Fun with Python",10.50,"Fiction"));
		bookDB.add(new Book("Zombie1005","The Maker's Guide to the Zombie Apocalypse","Simon Monk","Defend Your Base with Simple Circuits, Arduino, and Raspberry Pi",16.50,"nonFiction"));
		bookDB.add(new Book("Rasp1006","Raspberry Pi Projects for the Evil Genius","Kyle","A dozen fiendishly fun projects for the Raspberry Pi!",14.75,"Fiction"));
		bookDB.add(new Book("Rasp1007","Rasb 2","Kyle","A dozen fiendishly fun projects for the Raspberry Pi!",15.75,"nonFiction"));


		return bookDB;

	}


	public static void searchCatagory(ArrayList<Book> inArray){
		Scanner scanCatagory = new Scanner(System.in);
		String catagoryToSearch=null;
		System.out.println();
		System.out.println("Please enter catagory from the choices below (non case sensative)");  
		//print a list of catagoies avalable to choose from
		ArrayList <String> catagoryOptions = new ArrayList<String>();
		for(Book i : inArray){
			if(!catagoryOptions.contains(i.getCatagory())){
				System.out.println(i.getCatagory());
				catagoryOptions.add(i.getCatagory());
			}
		}
		
		while(!scanCatagory.hasNext()){
			System.out.println("There is an issue entering your catagory.");
		}catagoryToSearch = scanCatagory.nextLine();

		Boolean foundIt = false;
		int catagoryCount = 0;
		for(Book i : inArray){
			if(catagoryToSearch.equalsIgnoreCase(i.getCatagory())){
				if(catagoryCount == 0){
					System.out.println("Found some! Displaying the information below: ");
					//authorCount++;
				}
				i.printBook();
				catagoryCount++;
				foundIt = true;
			}else{
				//add capability to create a new entry from here
			}
		}if(foundIt == false){
			System.out.println("Sorry but i dont have it but if you would like to add it you can do so from the main menu");  

		}
	}

	public static void searchAuthor(ArrayList<Book> inArray){
		Scanner scanAuthor = new Scanner(System.in);
		String authorToSearch=null;
		System.out.println("Please enter an author to search (not case sensitive)");
		while(!scanAuthor.hasNext()){
			System.out.println("There is an issue entering your author.");
		}authorToSearch = scanAuthor.nextLine();

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
		while(!scanSku.hasNext()){
			System.out.println("There is an issue entering your sku.");
		}skuToSearch = scanSku.nextLine();
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
		}
		System.out.println("foundIt is " + foundIt );
		if(foundIt == false){
			System.out.println("Sorry but i dont have it but if you would like to add it you can do so from the main menu");  

		}

	}
	
	//should add a verify so a sku cannot be entered that matches another sku that is in the database already
	public static Book createBook(){
		String inSku = null;
		String inTit = null;
		String inAut = null;
		String inDec = null;
		double inPri = 0.0;
		String inCat = null;

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
		System.out.println("Enter a Catagory: (fiction) or (nonFiction)"); //develop a way to know what all the catagories are and have the user choose from a list of them
		inDec = scan.nextLine();
		System.out.println("Enter a Price: ");
		while(!scan.hasNextDouble()){
			System.out.println("Please try another PRICE IN NUMBERS");
			scan.next();
		}inPri = scan.nextDouble();

		//scan.next();
		Book newBook = new Book(inSku,inTit,inAut,inDec,inPri,inCat);
		System.out.println("Book Accetped");

		return newBook;
	}
	public static void displayDatabase(ArrayList<Book> inArray){
		System.out.println("There are "+ inArray.size() + " books in the database.");
		System.out.println();
		String output = String.format("%-5s | %-12s | %-50s | %-30s | %-70s | %6s", "index","SKU","Title","Author","Description","Price");
		System.out.println("________________________________________________________________________________________________________________________________________________________");
		System.out.println(output);
		int count=0;
		for(Book i : inArray){
			System.out.print(count + " ");
			i.printBook();
			count++;
		}
		System.out.println("________________________________________________________________________________________________________________________________________________________");
	}
}