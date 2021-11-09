package myform.repository;

import org.springframework.data.repository.CrudRepository;

import myform.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}
