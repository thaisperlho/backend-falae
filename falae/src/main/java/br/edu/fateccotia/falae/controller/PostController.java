package br.edu.fateccotia.falae.controller;

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
import br.edu.fateccotia.falae.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;

	@GetMapping
	public ResponseEntity<List<Posts>> findALL() {
		List<Posts> list = postService.findALL();
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

}
