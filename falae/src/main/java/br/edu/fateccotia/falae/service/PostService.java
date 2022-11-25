package br.edu.fateccotia.falae.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateccotia.falae.model.Posts;
import br.edu.fateccotia.falae.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public Posts save(Posts posts) {
		return this.postRepository.save(posts);
	}

	public List<Posts> findALL() {
		return this.postRepository.findAll();
	}

	public Optional<Posts> findById(Integer id) {
		return this.postRepository.findById(id);
	}

	public void delete(Integer id) {
		postRepository.deleteById(id);
	}
}
