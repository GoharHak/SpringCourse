package com.example.springcource.services;

import com.example.springcource.models.Book;
import com.example.springcource.models.Person;
import com.example.springcource.repositories.BooksRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
    public List<Book> findAll(boolean sortByYear){
        if(sortByYear)
        return booksRepository.findAll(Sort.by("year"));
        else
         return booksRepository.findAll();
    }

    public List<Book> findWithPagination(Integer page, Integer booksPerPage, boolean sortByYear){
        if(sortByYear)
            return booksRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("year"))).getContent();
        else
            return booksRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
    }

    public Book findOne(int id){
        Optional<Book> book = booksRepository.findById(id);
        return book.orElse(null);
    }

    @Transactional
    public void save(Book book){
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook){
        Book bookToBeUpdated  = booksRepository.findById(id).get();
        updatedBook.setId(id);
        updatedBook.setOwner(bookToBeUpdated.getOwner());
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id){
        booksRepository.deleteById(id);
    }

    public List<Book> searchByTitle(String title){
        return booksRepository.findByTitleStartingWith(title);
    }

    //Return null if book has no owner
    public Person getBookOwner(int id) {
        //here no need to do Hibernate.initilize() as owner load not lazy
        return booksRepository.findById(id).map(Book::getOwner).orElse(null);

    }


    @Transactional // free book
    public  void release(int id){
        booksRepository.findById(id).ifPresent(
                book->{
                    book.setOwner(null);
                    book.setTakenAt(null);
                }
        );
    }
    @Transactional // free book
    public  void assign(int id, Person selectedPerson ){
        booksRepository.findById(id).ifPresent(
                book->{
                    book.setOwner(selectedPerson);
                    book.setTakenAt(new Date());
                }
        );
    }


}
