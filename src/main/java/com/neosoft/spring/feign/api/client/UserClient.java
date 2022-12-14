package com.neosoft.spring.feign.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.neosoft.spring.feign.api.dto.CommentsResponse;
import com.neosoft.spring.feign.api.dto.PostsResponse;
import com.neosoft.spring.feign.api.dto.UserResponse;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "USER-CLIENT")
public interface UserClient {

	@GetMapping("/users")
	public List<UserResponse> getUsers();

	@GetMapping("/posts")
	public List<PostsResponse> getPosts();

	@GetMapping("/posts/{userId}")
	public PostsResponse getPostsById(@PathVariable int userId);

	@GetMapping("/comments")
	public List<CommentsResponse> getComments();

	@GetMapping("/posts/{postId}/comments")
	public List<CommentsResponse> getCommentsByPostId(@PathVariable int postId);

	@GetMapping("comments")
	public List<CommentsResponse> getCommentByQueryParam(@RequestParam int postId);

}
