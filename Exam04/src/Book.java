
public class Book {
	String title;
	int price;
	String author;
	String publisher;
	String pubdate;
	
	public Book(String title, int price, String author, String publisher, String pubdate) {
		this.title = title;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.pubdate = pubdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubDate() {
		return pubdate;
	}

	public void setPubDate(String pubdate) {
		this.pubdate = pubdate;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", author=" + author + ", publisher=" + publisher
				+ ", pubdate=" + pubdate + "]";
	}
	
}