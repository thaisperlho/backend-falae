package br.edu.fateccotia.falae.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateccotia.falae.model.Posts;
import br.edu.fateccotia.falae.model.PostsGet;
import br.edu.fateccotia.falae.model.Reactions;
import br.edu.fateccotia.falae.model.Users;
import br.edu.fateccotia.falae.service.PostService;
import br.edu.fateccotia.falae.service.ReactionsService;
import br.edu.fateccotia.falae.service.UserService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	private PostService postService;
	private ReactionsService reactionsService;
	private UserService userService;
	
	

	public PostController(PostService postService, ReactionsService reactionsService, UserService userService) {
		this.postService = postService;
		this.reactionsService = reactionsService;
		this.userService = userService;
	}

//	@GetMapping
//	public ResponseEntity<List<Posts>> findALL() {
//		List<Posts> list = postService.findALL();
//		return ResponseEntity.ok(list);
//	}
	@GetMapping
	public ResponseEntity<List<PostsGet>> buscaComQtdReaction() {
		List<PostsGet> list = postService.buscaComQtdReaction();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Posts> find(@PathVariable(name = "id") Integer id) {
		Optional<Posts> post = this.postService.findById(id);
		if (post.isPresent()) {
			return ResponseEntity.ok(post.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Posts> creat(@RequestBody Posts post) {
		Posts postCreated = postService.save(post);

		return ResponseEntity.status(HttpStatus.CREATED).body(postCreated);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Posts> edit(@PathVariable(name = "id") Integer id, @RequestBody Posts post) {
		Optional<Posts> postActual = this.postService.findById(id);
		if (postActual.isPresent()) {
			postActual.get().setPost(post.getPost());
			return ResponseEntity.ok(this.postService.save(postActual.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id){
        Optional<Posts> postActual = this.postService.findById(id);
        if(postActual.isPresent()) {
            postService.delete(id);
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@PostMapping("/{idPost}/{tipoReaction}/{idUser}")
	public ResponseEntity<Reactions> creatReaction(@PathVariable(name = "idPost") Integer idPost,
			@PathVariable(name = "tipoReaction") Integer tipoReaction,
			@PathVariable(name = "idUser") Integer idUser) {
		
		Optional<Posts> post = this.postService.findById(idPost);
		Optional<Users> user = this.userService.findById(idUser);
		
		
		Reactions reactions = new Reactions();
		
		reactions.setDataReaction(new Date());
		reactions.setPost(post.get());
		reactions.setUser(user.get());
		reactions.setTipoReaction(tipoReaction);
		
		this.reactionsService.save(reactions);

		return ResponseEntity.status(HttpStatus.CREATED).body(reactions);
	}

}
