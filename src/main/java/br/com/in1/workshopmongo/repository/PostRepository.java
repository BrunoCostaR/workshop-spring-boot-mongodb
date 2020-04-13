package br.com.in1.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.in1.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String	> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	public List<Post> searchTitle(String text);
	
	public List<Post> findByTitleContainingIgnoreCase(String text);
	

}
