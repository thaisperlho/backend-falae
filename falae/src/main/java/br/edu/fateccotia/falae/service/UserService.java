package br.edu.fateccotia.falae.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateccotia.falae.model.Users;
import br.edu.fateccotia.falae.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Users save(Users user) {
		return this.userRepository.save(user);
	}

	public List<Users> findALL() {
		return this.userRepository.findAll();
	}

	public Optional<Users> findById(Integer id) {
		return this.userRepository.findById(id);
	}

	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

}
