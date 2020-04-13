package br.com.in1.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.in1.workshopmongo.domain.Post;
import br.com.in1.workshopmongo.repository.PostRepository;
import br.com.in1.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
/*	
	public List<Post> findAll() {
		return repository.findAll();
	}
*/	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}
/*		
	public Post insert(Post obj) {
		return repository.save(obj);
	}
	
	public Post fromDTO(PostDTO objDTO) {
		return new Post(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
	public void delete(String id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(id);
		}
	}	
	
	public Post update(Post obj) {
			Post entity = repository.findById(obj.getId()).get(); //Prepara o objeto monitorado para alterar e depois gravar no banco
			updateData(entity, obj);
			return repository.save(entity);
	}

	private void updateData(Post entity, Post obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
	}
*/
}
