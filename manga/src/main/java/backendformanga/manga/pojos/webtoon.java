package backendformanga.manga.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Manga")
public class webtoon {
	
	@Id
	private int id ;
	private String title;
	private String description;
	private String characters;
	public webtoon(int id, String title, String description, String characters) {
		
		this.id = id;
		this.title = title;
		this.description = description;
		this.characters = characters;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCharacters() {
		return characters;
	}
	public void setCharacters(String characters) {
		this.characters = characters;
	}
	
	
}
