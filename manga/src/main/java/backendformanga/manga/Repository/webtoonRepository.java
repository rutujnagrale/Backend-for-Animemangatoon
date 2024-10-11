
package backendformanga.manga.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import backendformanga.manga.pojos.webtoon;

@Repository
public interface webtoonRepository extends MongoRepository<webtoon , Integer> {
	
//	public webtoon (int id);
	
	

}
