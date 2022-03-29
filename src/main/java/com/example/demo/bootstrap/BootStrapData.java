package com.example.demo.bootstrap;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    System.out.println("Started in Bootstrap");

    Publisher publisher=new Publisher();
    publisher.setName("Mediaspaul");
    publisher.setAddressLine1("victoire");
    publisher.setCity("kinshasas");

    publisherRepository.save(publisher);
    System.out.println("Publisher Count: " + publisherRepository.count());

    Author eric=new Author("eric","evan");
    Book python =new Book("django","12111");
    eric.getBooks().add(python);
    python.getAuthors().add(eric);

    python.setPublisher(publisher);
    publisher.getBooks().add(python);

    authorRepository.save(eric);
    bookRepository.save(python);
    publisherRepository.save(publisher);


    Author rod=new Author("rod","johnson");
    Book springbook =new Book("spring","121811");
    rod.getBooks().add(springbook);
    springbook.getAuthors().add(rod);

    springbook.setPublisher(publisher);
    publisher.getBooks().add(springbook);

    authorRepository.save(rod);
    bookRepository.save(springbook);
    publisherRepository.save(publisher);



        System.out.println("Numbers of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
