package backendformanga.manga.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import backendformanga.manga.pojos.User;


public interface UserRepository extends MongoRepository<User, Integer>{


}
