package az.developia.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springdemo.model.Book;
import az.developia.springdemo.repository.BookRepository;

@Service
public class BookService { 

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public void save(Book b) {
		bookRepository.save(b);
	}
	
	public void deleteById(Integer id) {
		bookRepository.deleteById(id); 
	}
}
