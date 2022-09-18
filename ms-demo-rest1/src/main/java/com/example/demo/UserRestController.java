package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exception.ResNotFoundException;
import com.example.demo.model.Post;
import com.example.demo.model.PostRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserRepo; 
@RestController

public class UserRestController {
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private PostRepository postrepo;
	
	
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
	
	
	//Hateoas
	@GetMapping("/users2/{id}")
	public EntityModel<User> getUser(@PathVariable Integer id) {
		 Optional<User> us= userrepo.findById(id);
		 User user = us.get();
		 EntityModel<User> euser =  EntityModel.of(user);
		 
		 WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
		  euser.add(link.withRel("All-users"));
		 return euser;
	}

	
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
	public ResponseEntity createUser(@Valid @RequestBody User user) throws URISyntaxException{
		user.setId(null);
	User user2=	userrepo.save(user);
		
		return ResponseEntity.created(new URI(user2.getId().toString())).body(user2);
	}
	
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity delUser1(@PathVariable Integer id) {
		   userrepo.deleteById(id);		 
		 return ResponseEntity.ok().build();
	}
	
	
	
	@GetMapping("/users/{id}/posts")
	public List<Post> getPosts(@PathVariable Integer id) throws ResNotFoundException {
		Optional<User> us= userrepo.findById(id);
		 if(us.isPresent()) {			 
			 return us.get().getPosts();
		 }else {
			 throw new ResNotFoundException("user not thereeeee");
		 }	 
		  
	}
	
	@PostMapping("/users/{id}/posts")
	public ResponseEntity 
	createPost(@PathVariable Integer id,@Valid @RequestBody Post post) throws URISyntaxException, ResNotFoundException{
		Optional<User> us= userrepo.findById(id);
		if(us.isPresent()) {			 
				post.setUser(us.get());
			Post newpost=	this.postrepo.save(post);
			
			URI locaiton =ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(newpost.getId()).toUri();
			return ResponseEntity.created(locaiton).build();
			//return ResponseEntity.created(
			//new URI(post.getId().toString())).body(newpost);

		 }else {
			 throw new ResNotFoundException("user not thereeeee");
		 }	 
	 	
		
	}
	
}
