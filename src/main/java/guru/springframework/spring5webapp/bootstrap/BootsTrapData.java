package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsTrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootsTrapData(AuthorRepository authorRepository, BookRepository bookRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;

    }

    @Override
    public void run(String...args) throws Exception {

        Author andrew = new Author("Andrew", "Tyler");
        Book paskuda = new Book("How to be a teacher, who will never be forg...forgotten", "9650543");

        andrew.getBooks().add(paskuda);
        paskuda.getAuthors().add(andrew);

        authorRepository.save(andrew);
        bookRepository.save(paskuda);

        Author baxanean = new Author("Dumitru", "Baxanean");
        Book mudak = new Book("How to be whoever you want and stay alive", "54325");

        baxanean.getBooks().add(mudak);
        mudak.getAuthors().add(baxanean);

        authorRepository.save(baxanean);
        bookRepository.save(mudak);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: "+bookRepository.count());

    }

}
