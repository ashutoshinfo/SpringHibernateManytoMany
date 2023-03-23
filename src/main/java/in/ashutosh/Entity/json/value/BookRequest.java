package in.ashutosh.Entity.json.value;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
	private String title;
	private List<AuthorRequest> authors;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<AuthorRequest> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorRequest> authors) {
		this.authors = authors;
	}
}
