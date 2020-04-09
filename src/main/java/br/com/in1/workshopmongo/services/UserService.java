package br.com.in1.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.in1.workshopmongo.domain.User;
import br.com.in1.workshopmongo.dto.UserDTO;
import br.com.in1.workshopmongo.repository.UserRepository;
import br.com.in1.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
		
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
	public void delete(String id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException(id);
		}
	}	
	/*		catch (DataIntegrityViolationException e) {
			 throw new DatabaseException(e.getMessage());
		}
	}
	*/
	
	public User update(User obj) {
			User entity = repository.findById(obj.getId()).get(); //Prepara o objeto monitorado para alterar e depois gravar no banco
			updateData(entity, obj);
			return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
	}

}
