package org.example.todov2.domain.comment.repository;

import org.example.todov2.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	default Comment findCommentByIdOrElseThrow(Long reviewId) {
		return findById(reviewId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + reviewId));
	}
}
