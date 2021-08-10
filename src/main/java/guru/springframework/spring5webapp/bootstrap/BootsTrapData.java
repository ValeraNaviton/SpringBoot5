package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsTrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootsTrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }

    @Override
    public void run(String...args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("Ottawa");
        publisher.setState("ON");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author andrew = new Author("Andrew", "Tyler");
        Book paskuda = new Book("How to be a teacher, who will never be forg...forgotten", "9650543");

        andrew.getBooks().add(paskuda);
        paskuda.getAuthors().add(andrew);

        paskuda.setPublisher(publisher);
        publisher.getBooks().add(paskuda);

        authorRepository.save(andrew);
        bookRepository.save(paskuda);
        publisherRepository.save(publisher);

        Author baxanean = new Author("Dumitru", "Baxanean");
        Book mudak = new Book("How to be whoever you want and stay alive", "54325");

        baxanean.getBooks().add(mudak);
        mudak.getAuthors().add(baxanean);

        mudak.setPublisher(publisher);
        publisher.getBooks().add(mudak);

        authorRepository.save(baxanean);
        bookRepository.save(mudak);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: "+bookRepository.count());
        System.out.println("Publisher Number of Books:" + publisher.getBooks().size());


    }

}
