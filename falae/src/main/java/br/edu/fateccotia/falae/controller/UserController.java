package br.edu.fateccotia.falae.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateccotia.falae.model.Users;
import br.edu.fateccotia.falae.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	

	private UserService userService;
	private final PasswordEncoder encoder;
	

	public UserController(UserService userService, PasswordEncoder encoder) {
		this.userService = userService;
		this.encoder = encoder;
	}
	

	@GetMapping
	public ResponseEntity<List<Users>> findALL() {
		List<Users> list = userService.findALL();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Users> find(@PathVariable(name = "id") Integer id) {
		Optional<Users> user = this.userService.findById(id);
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Users> creat(@RequestBody Users user) {
		user.setSenha(encoder.encode(user.getSenha()));
		Users userCreated = userService.save(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Users> edit(@PathVariable(name = "id") Integer id, @RequestBody Users user) {
		Optional<Users> userActual = this.userService.findById(id);
		if (userActual.isPresent()) {
			userActual.get().setNickname(user.getNickname());
			userActual.get().setEmail(user.getEmail());
			userActual.get().setSenha(encoder.encode(user.getSenha()));
			userActual.get().setPicture(user.getPicture());
			userActual.get().setStatus(user.getStatus());
			return ResponseEntity.ok(this.userService.save(userActual.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id){
        Optional<Users> userActual = this.userService.findById(id);
        if(userActual.isPresent()) {
            userService.delete(id);
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/validarSenha")
	public ResponseEntity<Boolean> validarsenha(@RequestParam String email, String senha){

		
        Optional<Users> optUser = userService.findByEmail(email);
        if (optUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Users user = optUser.get();
        boolean valid = encoder.matches(senha, user.getSenha());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
		
	}
	
	
}
