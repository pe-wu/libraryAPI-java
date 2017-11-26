package se.lib;

public class BookDetails {
	private String isbn;
	private String author;
    private String title;

	BookDetails(String isbn, String author, String title) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return isbn + ", " +
				author + ", " +
				title;
	}

    String getIsbn() {
        return isbn;
    }
}
