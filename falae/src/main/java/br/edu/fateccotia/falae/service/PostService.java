package br.edu.fateccotia.falae.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fateccotia.falae.model.Posts;
import br.edu.fateccotia.falae.model.PostsGet;
import br.edu.fateccotia.falae.repository.PostGetRepository;
import br.edu.fateccotia.falae.repository.PostRepository;

@Service
public class PostService {
	
	private PostRepository postRepository;
	
	private PostGetRepository postGetRepository;

	
	public PostService(PostRepository postRepository, PostGetRepository postGetRepository) {
		super();
		this.postRepository = postRepository;
		this.postGetRepository = postGetRepository;
	}

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
	public List<PostsGet> buscaComQtdReaction() {
		return this.postGetRepository.buscaComQtdReaction();
	}
}
