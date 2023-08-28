package nhatsang.maven_example_jar;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		LibraryService libraryService = new LibraryService();

        List<Book> booksByAuthor = libraryService.getAllBooksByAuthor("J.K. Rowling");
        for (Book book : booksByAuthor) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor().getName());
        }
        
        libraryService.updateBookHQL(1, "HARRY PORTER");
        
        List<Book> booksByAuthor2 = libraryService.getAllBooksByAuthor("J.K. Rowling");
        for (Book book : booksByAuthor2) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor().getName());
        }
	}
}
