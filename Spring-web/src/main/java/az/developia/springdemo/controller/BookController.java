package az.developia.springdemo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.springdemo.model.Author;
import az.developia.springdemo.model.Book;
import az.developia.springdemo.repository.AuthorRepository;
import az.developia.springdemo.repository.BookRepository;
import az.developia.springdemo.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@GetMapping("/list")
	@PreAuthorize(value = "hasAuthority('list:books')")
	public String ShowBooksPage(Model model) {
		List<Book> books = bookService.getAllBooks();
		int i=1;
		for(Book book : books) {
			book.setCounter(i++);
		}
		
		model.addAttribute("books",books );

		return "books";
	}

	@GetMapping("/show-save-page")
	@PreAuthorize(value = "hasAuthority('open:save:book')")
	public String showSavePage(Model model) {
		Book b = new Book();
		
		List<String> languages=new ArrayList<>();
		languages.add("azerbaycan");
		languages.add("Rus");
		languages.add("Ingilis");
		languages.add("Fransiz");
		languages.add("Alman");
		
		model.addAttribute("languages", languages);
		
		List<Author> authors=authorRepository.findAll();
		
		model.addAttribute("authors", authors);
		
		model.addAttribute("book", b);
		model.addAttribute("header", "Yeni kitab qeydiyati");
		return "book-save";
	}

	@PostMapping("/save")
	@PreAuthorize(value = "hasAuthority('save:book')")
	public String bookSave(@Valid @ModelAttribute(name = "book") Book b,
			BindingResult br, Model model) {
		
		if (br.hasErrors()) {
			return "book-save";
		}
		if (b.getId() == null) {
			bookService.save(b);
		} else {
			//bookService.edit(b);
		} 
		
		return "redirect:/books/list";
	}	  
	
	@InitBinder
	private void initBinder(WebDataBinder editor) {
		StringTrimmerEditor e =new StringTrimmerEditor(false);
		editor.registerCustomEditor(String.class, e);
	}
	
	@GetMapping("/book-search")
	@PreAuthorize(value = "hasAuthority('list:books')")
	public String searchBooks(Model model,@RequestParam(name="bookName")String bookName) {
		bookName=bookName.toLowerCase();
		model.addAttribute("books", bookRepository.findByNameNative(bookName));

		return "books";
	}
	
	@GetMapping("/delete-name")
	@PreAuthorize(value = "hasAuthority('save:books')")
	public String deleteByName(@RequestParam(name="bookName")String bookName) {
		bookName=bookName.toLowerCase();
		bookRepository.deleteByNameNative(bookName);

		return "redirect:/books/list";
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize(value = "hasAuthority('delete:book')")
	public String delete(@PathVariable Integer id , Model m) {
		
		boolean bookFinded=bookRepository.findById(id).isPresent();
		if (bookFinded) {
			bookRepository.deleteById(id);
		}else {
			m.addAttribute("message", "Bu id-li kitab artiq silinib");
			return "error-page";
		}
		
		return "redirect:/books/list";
	}
	
	
	@GetMapping("/edit/{id}")
	@PreAuthorize(value = "hasAuthority('edit:book')")
	public String edit(@PathVariable Integer id , Model m) {
		
		boolean bookFinded=bookRepository.findById(id).isPresent();
		Book b=null;
		if (bookFinded) {
			b = bookRepository.findById(id).get();
		}else {
			m.addAttribute("message", "Bu id-li kitab artiq yoxdur");
			return "error-page";
		}
		
		m.addAttribute("book", b);
		m.addAttribute("header", "Redakte");
		
		return "book-save";
	}
	
	
	
	
	

}
