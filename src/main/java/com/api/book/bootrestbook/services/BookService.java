package com.api.book.bootrestbook.services;

import java.util.List;
import org.springframework.stereotype.Component;
import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    // private static List<Book> booksList = new ArrayList<>();

    // static {
    //     booksList.add(new Book(1, "Python Learning in 1 days", "Faran"));
    //     booksList.add(new Book(2, "Python Learning in 2 days", "Faran"));
    //     booksList.add(new Book(3, "Python Learning in 3 days", "Faran"));
    // }

    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        // return booksList;

        return  (List<Book>) this.bookRepository.findAll();
    }

    public Book getBookById(int id) {
        // return booksList.stream().filter(lambda -> lambda.getId() == id).findFirst().get();
        
        return this.bookRepository.findById(id);
    }

    public Book addbBook(Book book) {
        // booksList.add(book);
        // return book;

        this.bookRepository.save(book);
        return book;
    }

    public void deleteBook(int id) {
        // booksList = booksList.stream().filter(lambda -> lambda.getId() != id).collect(Collectors.toList());

        this.bookRepository.deleteById(id);
    }

    public void updateBook(Book book, int id) {
        // booksList = booksList.stream().map(b -> {
        //     if (b.getId() == id) {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        book.setId(id);
        this.bookRepository.save(book);
    }

}
