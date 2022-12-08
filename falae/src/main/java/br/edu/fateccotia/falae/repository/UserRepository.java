package br.edu.fateccotia.falae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fateccotia.falae.model.Users;

@Repository 
public interface UserRepository extends JpaRepository<Users, Integer> {
	
	public Optional<Users> findByEmail(String email);

}
