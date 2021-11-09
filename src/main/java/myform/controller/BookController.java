package myform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myform.model.Book;
import myform.repository.BookRepository;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    private BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //@RequestMapping(value="/books" , method=RequestMethod.GET)
    @GetMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }


    //@RequestMapping(value="/books" , method=RequestMethod.POST)
    @PostMapping("/addBook")
    public String addBook(String title, String author){
        Book book = new Book(title, author);
        bookRepository.save(book);
        return "redirect:/books";
    }


    //@RequestMapping(value="/books" , method=RequestMethod.POST)
    @PostMapping("/deleteBook{id}")
    public String deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
    
    
}
