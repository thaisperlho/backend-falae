package br.edu.fateccotia.falae.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fateccotia.falae.model.Posts;
import br.edu.fateccotia.falae.model.Reactions;

@Repository
public interface ReactionsRepository extends JpaRepository<Reactions, Integer> {
	

}
