package br.com.in1.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.in1.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String	> {
	
	public List<Post> findByTitleContainingIgnoreCase(String text);

}
