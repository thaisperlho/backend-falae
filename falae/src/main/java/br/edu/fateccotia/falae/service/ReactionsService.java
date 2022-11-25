package br.edu.fateccotia.falae.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateccotia.falae.model.Reactions;
import br.edu.fateccotia.falae.repository.ReactionsRepository;

@Service
public class ReactionsService {
	@Autowired
	private ReactionsRepository reactionsRepository;

	public Reactions save(Reactions reactions) {
		return this.reactionsRepository.save(reactions);
	}

	public List<Reactions> findALL() {
		return this.reactionsRepository.findAll();
	}

	public Optional<Reactions> findById(Integer id) {
		return this.reactionsRepository.findById(id);
	}

	public void delete(Integer id) {
		reactionsRepository.deleteById(id);
	}
}
