package br.edu.fateccotia.falae.controller;

import java.util.List;
import java.util.Map;
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
import br.edu.fateccotia.falae.model.Reactions;
import br.edu.fateccotia.falae.service.ReactionsService;

@RestController
@RequestMapping("/reactions")
public class ReactionsController {
	
	@Autowired
	ReactionsService reactionsService;
	
	@GetMapping
	public ResponseEntity<List<Reactions>> findALL() {
		List<Reactions> list = reactionsService.findALL();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Reactions> find(@PathVariable(name = "id") Integer id) {
		Optional<Reactions> reactions = this.reactionsService.findById(id);
		if (reactions.isPresent()) {
			return ResponseEntity.ok(reactions.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Reactions> creat(@RequestBody Reactions reactions) {
		Reactions reactionsCreated = reactionsService.save(reactions);

		return ResponseEntity.status(HttpStatus.CREATED).body(reactionsCreated);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Reactions> edit(@PathVariable(name = "id") Integer id, @RequestBody Reactions reactions) {
		Optional<Reactions> reactionsActual = this.reactionsService.findById(id);
		if (reactionsActual.isPresent()) {
			reactionsActual.get().setDataReaction(reactions.getDataReaction());
			reactionsActual.get().setTipoReaction(reactions.getTipoReaction());
			return ResponseEntity.ok(this.reactionsService.save(reactionsActual.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id){
        Optional<Reactions> reactionsActual = this.reactionsService.findById(id);
        if(reactionsActual.isPresent()) {
        	reactionsService.delete(id);
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	

}
