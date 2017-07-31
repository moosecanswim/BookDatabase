package bookDatabase;

public class Book {
	private int index;
	private String sku;
	private String bookTitle;
	private String bookAuthor;
	private String description;
	private double price;
	private String catagory;

	
	public Book(int inIndex, String inSku, String inBookTitle, String inBookAuthor, String inDescription, double inPrice, String inCatagory){
		this.index = inIndex;
		this.sku= inSku;
		this.bookTitle = inBookTitle;
		this.bookAuthor = inBookAuthor;
		this.description = inDescription;
		this.price = inPrice;
		this.catagory = inCatagory;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public void printBook(){
		String output = String.format("%-10s | %-50s | %-30s | %-70s | $%6.2f", sku,bookTitle,bookAuthor,description,price);
		System.out.println(output);
		
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
