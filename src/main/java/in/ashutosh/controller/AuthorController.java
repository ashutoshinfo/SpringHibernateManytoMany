package in.ashutosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashutosh.Entity.game2.Author;
import in.ashutosh.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}

	@PostMapping
	public Author addAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author);
	}
}
