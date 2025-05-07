package org.example.todov2.domain.reply.repository;

import org.example.todov2.domain.comment.entity.Comment;
import org.example.todov2.domain.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface ReplyRepository extends JpaRepository<Reply,Long> {

	default Reply findReplyByIdOrElseThrow(Long replyId) {
		return findById(replyId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + replyId));
	}
}
