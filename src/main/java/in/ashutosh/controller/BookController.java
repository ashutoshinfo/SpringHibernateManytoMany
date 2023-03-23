package in.ashutosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashutosh.Entity.game2.Book;
import in.ashutosh.Entity.json.BookRequest;
import in.ashutosh.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/books")
	public ResponseEntity<Book> createBook(@RequestBody BookRequest bookRequest) {

		return bookService.insertBookAndAuthor(bookRequest);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		Book bookByIdWithAuthors = bookService.getBookByIdWithAuthors(id);
		if (bookByIdWithAuthors != null) {
			return ResponseEntity.ok(bookByIdWithAuthors);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/by-author/{id}")
	public ResponseEntity<List<Book>> findByAuthorId(@PathVariable Long id) {
		List<Book> bookByIdWithAuthors = bookService.findByAuthorId(id);
		if (bookByIdWithAuthors != null) {
			return ResponseEntity.ok(bookByIdWithAuthors);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBookById(@PathVariable Long id) {
		Book bookByIdWithAuthors = bookService.getBookByIdWithAuthors(id);
		if (bookByIdWithAuthors != null) {
			return ResponseEntity.ok(bookByIdWithAuthors);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
