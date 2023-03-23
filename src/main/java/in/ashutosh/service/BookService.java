package in.ashutosh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.ashutosh.Entity.game2.Author;
import in.ashutosh.Entity.game2.Book;
import in.ashutosh.Entity.json.AuthorRequest;
import in.ashutosh.Entity.json.BookRequest;
import in.ashutosh.reposetory.AuthorRepository;
import in.ashutosh.reposetory.BookReposetory;

@Service
public class BookService {

	@Autowired
	private BookReposetory bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	public ResponseEntity<Book> insertBookAndAuthor(BookRequest bookRequest) {
		// Create a new Book entity
		Book book = new Book();
		book.setTitle(bookRequest.getTitle());

		// Loop through the AuthorRequest objects and create Author entities
		for (AuthorRequest authorRequest : bookRequest.getAuthors()) {

			Optional<Author> findById = authorRepository.findById(Long.parseLong(authorRequest.getId()));
			if (findById.isPresent()) {
				// Map the Author entity
				authorRepository.save(findById.get());
				// Add the Author entity to the Book entity's list of authors
				book.getAuthors().add(findById.get());
			} else {
				return null;
			}

		}

		// Save the Book entity
		bookRepository.save(book);

		return ResponseEntity.ok(book);

	}

	public Book getBookByIdWithAuthors(Long id) {
		Optional<Book> findByIdWithAuthors = bookRepository.findByIdWithAuthors(id);
		if (findByIdWithAuthors.isPresent()) {
			return findByIdWithAuthors.get();
		} else {
			return null;

		}
	}

	public void deleteBookById(Long bookId) {
		bookRepository.deleteById(bookId);
	}

	@Cacheable("findByAuthorId")
	public List<Book> findByAuthorId(Long authorId) {
		return bookRepository.findByAuthorId(authorId);

	}

}
