package com.in28minutes.rest.webservices.restfulwebservices.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResource {
	@Autowired
	private PostDaoService service;
	@GetMapping("/users/{userid}/posts")
	public List<Post> retrieveAllPostsForUser(@PathVariable int userid) {
		return service.findByUser(userid);
	}
	@GetMapping("/users/{userid}/posts/{postid}")
	public Post retrieveSpecificPostForUser(@PathVariable int userid, @PathVariable int postid) {
		return service.findByUserAndPost(userid, postid);
	}

	/*@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}*/
}
