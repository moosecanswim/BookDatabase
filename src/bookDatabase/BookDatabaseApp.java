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
		bookDB.add(new Book("Rasp1006","Raspberry Pi Projects for the Evil Genius","Donald Norris","A dozen fiendishly fun projects for the Raspberry Pi!",14.75));

		System.out.println("there are "+ bookDB.size() + " books in the database");
		System.out.println();
		
		
		
		for(Book i : bookDB){
			i.printBook();
		}

		searchSku(bookDB);

	}
	public static void searchSku(ArrayList<Book> inArray){
		Scanner scan = new Scanner(System.in);
		String skuToSearch=null;
		System.out.println("Please enter a sku to search");
		if(scan.hasNext()){
			skuToSearch = scan.nextLine();
		}else{
			System.out.println("there is an issue entering your sku");
		}
		//System.out.println("we are searching for "+skuToSearch);
		
		for(Book i : inArray){
			if(skuToSearch.equals(i.getSku())){
				System.out.println("Found it!");
				i.printBook();
			}else{
				System.out.println("Sore but i dont have it");
				//add capability to create a new entry from here
			}
		}
		scan.close();
	}
}