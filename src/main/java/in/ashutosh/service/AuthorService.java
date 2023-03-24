package in.ashutosh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import in.ashutosh.Entity.game2.Author;
import in.ashutosh.reposetory.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Cacheable("getAllAuthors")
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	public Author addAuthor(Author author) {
		return authorRepository.save(author);
	}

}
