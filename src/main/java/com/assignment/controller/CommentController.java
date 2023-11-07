package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.Comment;
import com.assignment.exception.InvalidRequestException;
import com.assignment.exception.UserNotFoundException;
import com.assignment.service.CommentService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
public class CommentController {
	
	private final CommentService commentService;
	
	@Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
		
	 @PostMapping("/add")
	    public ResponseEntity<String> addComment(@RequestBody Comment comment) {
	        try {
	            Comment addedComment = commentService.addComment(comment);
	            return ResponseEntity.ok("Comment added successfully");
	        } catch (InvalidRequestException e) {
	            return ResponseEntity.badRequest().body("Invalid Request");
	        } catch (UserNotFoundException e) {
	            return ResponseEntity.badRequest().body("Invaid User, User does not exist in the database");
	        }
	    }
	
	@GetMapping("/user/{userId}/comments")
    public ResponseEntity<List<Comment>> getCommentsForUser(@PathVariable Long userId) {
		List<Comment> userComments = commentService.getCommentsForUser(userId);
        return ResponseEntity.ok(userComments);
    }
}
