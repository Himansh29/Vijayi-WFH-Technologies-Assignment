package com.assignment.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.Comment;
import com.assignment.entity.User;
import com.assignment.exception.UserNotFoundException;
import com.assignment.repo.CommentRepository;
import com.assignment.repo.UserRepository;
import com.assignment.service.CommentService;

import jakarta.transaction.Transactional;
@Service
public class CommentServiceImple implements CommentService {

	private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentServiceImple(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Comment addComment(Comment comment) {
        User user = userRepository.findById(comment.getPostedByUser().getId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        comment.setPostedByUser(user);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsForUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        return commentRepository.findByPostedByUser(user);
    }

	@Override
	public List<Comment> getComments(String commentTo) {
		return null;
	}


}
