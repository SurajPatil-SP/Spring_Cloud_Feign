package com.neosoft.spring.feign.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.spring.feign.api.client.UserClient;
import com.neosoft.spring.feign.api.dto.CommentsResponse;
import com.neosoft.spring.feign.api.dto.PostsResponse;
import com.neosoft.spring.feign.api.dto.UserResponse;

@RestController
public class HomeController {

	@Autowired
	private UserClient client;

	@GetMapping("/findAllUser")
	public List<UserResponse> getAllUser() {
		return client.getUsers();
	}
	
	@GetMapping("/findAllPost")
	public List<PostsResponse> getAllPost(){
		return client.getPosts();
	}
	
	@GetMapping("/findPostById/{userId}")
	public PostsResponse getPostById(@PathVariable int userId) {
		return client.getPostsById(userId);
	}
	
	@GetMapping("/findAllComment")
	public List<CommentsResponse> getAllComment(){
		return client.getComments();
	}
	
	@GetMapping("/findCommentsByPostId/{postId}")
	public List<CommentsResponse> getAllCommentsByPostId(@PathVariable int postId) {
		return client.getCommentsByPostId(postId);
	}
	
	@GetMapping("/findAllComments")
	public List<CommentsResponse> getAllCommentsByQueryParam(@RequestParam int postId) {
		return client.getCommentByQueryParam(postId);
	}

}
