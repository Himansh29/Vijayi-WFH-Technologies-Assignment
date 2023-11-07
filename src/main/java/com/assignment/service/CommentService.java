package com.assignment.service;

import java.util.List;

import com.assignment.entity.Comment;

public interface CommentService {
	
	Comment addComment(Comment comment);
    List<Comment> getCommentsForUser(Long userId);
    List<Comment> getComments(String commentTo);
}
