package in.ashutosh.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashutosh.Entity.game2.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
