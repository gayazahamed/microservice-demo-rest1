package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.UserRepo;

@RestController

public class UserRest {
	
	@Autowired
	private UserRepo userrepo;
	
	@Value("${myprop}")
	private String myProp;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		System.out.print("myProp :"+myProp);
		return userrepo.findAll();
	}
	
	@GetMapping("/users2")
	public ResponseEntity getUsers2() {
		//return userrepo.findAll();
		return  ResponseEntity.ok(userrepo.findAll());
	}
	
//	@GetMapping("/users/{id}")
//	public User getUser(@PathVariable Integer id) {
//		 Optional<User> us= userrepo.findById(id);
//		 return us.get();
//	}

	
	@GetMapping("/users/{id}")
	public ResponseEntity getUser1(@PathVariable Integer id) throws ResNotFoundException {
		 Optional<User> us= userrepo.findById(id);
		 if(us.isPresent()) {			 
			 return ResponseEntity.ok(us.get());
		 }else {
			 throw new ResNotFoundException("user not thereeeee");
		 }
		// return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User "+id +" not found");
	}

	
	@PostMapping("/users")
	public ResponseEntity createUser(@RequestBody User user) throws URISyntaxException{
		user.setId(null);
	User user2=	userrepo.save(user);
		
		return ResponseEntity.created(new URI(user2.getId().toString())).body(user2);
	}
	
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity delUser1(@PathVariable Integer id) {
		   userrepo.deleteById(id);
		 
		 return ResponseEntity.ok().build();
	}
}
