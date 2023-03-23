package in.ashutosh.reposetory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.ashutosh.Entity.game2.Book;

public interface BookReposetory extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b JOIN FETCH b.authors WHERE b.id = :id")
	Optional<Book> findByIdWithAuthors(@Param("id") Long id);

	@Query("SELECT b FROM Book b JOIN b.authors a WHERE a.id = :authorId")
	List<Book> findByAuthorId(@Param("authorId") Long authorId);

}
