package com.example.springcource.dao;

import com.example.springcource.models.Book;
import com.example.springcource.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.management.openmbean.OpenDataException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("Select * from Book", new BeanPropertyRowMapper<Book>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }
    public void save(Book book){
         jdbcTemplate.update("Insert into Book ( title, author, year) VALUES (?,?,?)",book.getTitle(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book updatedBook){
       jdbcTemplate.update("Update Book Set title =?,author =?, year =? where id =?",updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getYear(), updatedBook.getId());
    }

    public void delete(int id){
        jdbcTemplate.update("Delete from Book where id =?", id);
    }
//    Join Book and Person tables to get person, owned mentioned books
    public Person getBookOwner(int id){
        return jdbcTemplate.query("Select p.* from Book b Join Person p on p.id =b.person_id where b.id = ?", new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class)).stream().findAny().orElse(null);
    }

//    Book return to library, and no author
    public void release(int id){
        jdbcTemplate.update("UPDATE Book Set person_id = NULL where id =?",id);
    }

//    Set book to person
    public void assign(int id, Person selectedPerson){
        jdbcTemplate.update("Update Book set person_id=? where id =?", selectedPerson.getId(), id);
    }
}
