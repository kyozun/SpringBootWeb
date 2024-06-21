package com.cuong.springbootweb.service;

import com.cuong.springbootweb.model.Book;
import com.cuong.springbootweb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired()
    private  BookRepository bookRepository;


    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return this.bookRepository.save(book);
    }

    public Optional<Book> getBookById(int id) {
        return this.bookRepository.findById(id);
    }

    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(int id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return this.bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book Not Found");
        }
    }


}
