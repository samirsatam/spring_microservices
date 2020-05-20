package com.in28minutes.rest.webservices.restfulwebservices.posts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {
	private static List<Post> posts = new ArrayList<>();
	static {
		posts.add(new Post(1, 1, "User1 is awesome"));
		posts.add(new Post(2, 1, "User1 is really awesome"));
		posts.add(new Post(3, 2, "No User2 is awesome"));
	}
	private static int postsCount = 3;
	public List<Post> findAll() {
		return posts;
	}
	public Post save(Post post) {
		if (post.getId() == null) {
			post.setId(++postsCount);
		}
		posts.add(post);
		return post;
	}
	public List<Post> findByUser(int userId) {
		List<Post> postlist = new ArrayList<Post>();
		for(Post post:posts) {
			if (post.getUserid()==userId) {
				postlist.add(post);
			}
		}
		if (postlist.isEmpty())
			throw new PostNotFoundException("userId:" + userId);
		return postlist;
	}
	public Post findByUserAndPost(int userId, int postId) {
		Post retPost = null;
		for(Post post:posts) {
			if ( (post.getUserid()==userId) && (post.getId() == postId) ) {
				retPost = post;
			}
		}
		if (retPost == null)
			throw new PostNotFoundException("userId:" + userId + " postId:" + postId);
		return retPost;

	}	
}
