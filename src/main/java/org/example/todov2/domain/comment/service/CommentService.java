package org.example.todov2.domain.comment.service;

import java.util.List;

import org.example.todov2.domain.comment.dto.request.SaveCommentRequestDto;
import org.example.todov2.domain.comment.dto.request.UpdateCommentRequestDto;
import org.example.todov2.domain.comment.dto.response.CommentResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
	CommentResponseDto saveComment(SaveCommentRequestDto dto, Long todosId);
	List<CommentResponseDto> findAllComment();
	void updateComment(UpdateCommentRequestDto dto, Long commentId);
	void deleteComment(Long commentId);
}
