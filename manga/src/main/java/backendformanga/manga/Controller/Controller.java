package backendformanga.manga.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import backendformanga.manga.Repository.UserRepository;
import backendformanga.manga.Repository.webtoonRepository;
import backendformanga.manga.pojos.User;
import backendformanga.manga.pojos.webtoon;



@RestController
public class Controller {
	
	@Autowired
	private webtoonRepository wedrep;
	
	@Autowired
	private UserRepository use ;
	
	
	@PostMapping("/adduser")
	public User addusers(@RequestBody User user) {
		use.save(user);
		return user;
	}
	
	
	@GetMapping("/auth/{email}/{password}")
	public ResponseEntity<Object> findbyuserpassemail(@PathVariable String email, @PathVariable String password) {
	    for (User u : use.findAll()) {
	        if (u.getPassword().equalsIgnoreCase(password) && u.getEmail().equalsIgnoreCase(email)) {
	            return ResponseEntity.ok(new Object[]{u, "Success: Logged in successfully!"});
	        }
	    }
	    
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Object[]{null, "Failed: Login failed!"});
	}
	
	
	@PostMapping("/addwebtoon")
	public webtoon addwebtoon(@RequestBody webtoon web) {
		wedrep.save(web);
		return web;
	}
	
	
	@GetMapping("/allwebtoon")
	public List<webtoon> findallwebtoon() {
		return wedrep.findAll();
	}
	
	@DeleteMapping("/deletetoonbyid/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
	    try {
	    	webtoon p = wedrep.findById(id).orElse(null);
	        if (p != null) {
	            wedrep.delete(p);
	            return ResponseEntity.ok("Webtoon deleted successfully!");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Webtoon not found");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the Webtoon.");
	    }
	}
	
	
	
	
	
	@GetMapping("/findwebtoonbyid/{id}")
	public ResponseEntity<Object> findProduct(@PathVariable int id) {
	    try {
	        webtoon p = wedrep.findById(id).orElse(null);
	        if (p != null) {
	            return ResponseEntity.ok(p);  
	        } else {
	           
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Webtoon not found");
	        }
	    } catch (Exception e) {
	       
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while fetching the Webtoon.");
	    }
	}
	
	

}
