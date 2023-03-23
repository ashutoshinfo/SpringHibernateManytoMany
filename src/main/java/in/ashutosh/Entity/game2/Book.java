package in.ashutosh.Entity.game2;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	private String title;

	@ManyToMany
	@JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "fk_book") }, inverseJoinColumns = {
			@JoinColumn(name = "fk_author") })
	private List<Author> authors = new ArrayList<Author>();
}
