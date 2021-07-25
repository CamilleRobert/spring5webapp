package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eic", "Evans");
        Book aBook = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(aBook);
        aBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(aBook);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("A Java's book", "14541548");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started Booktstrap");
        System.out.println("Number of books : " + bookRepository.count());
    }
}
