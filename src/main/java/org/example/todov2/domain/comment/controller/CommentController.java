package org.example.todov2.domain.comment.controller;

import java.util.List;

import org.example.todov2.domain.comment.dto.request.SaveCommentRequestDto;
import org.example.todov2.domain.comment.dto.request.UpdateCommentRequestDto;
import org.example.todov2.domain.comment.dto.response.CommentResponseDto;
import org.example.todov2.domain.comment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@PostMapping("/todos/{todoId}/comments")
	public ResponseEntity<CommentResponseDto> saveComment(@RequestBody SaveCommentRequestDto dto, @PathVariable Long todoId) {
		CommentResponseDto responseDto = commentService.saveComment(dto, todoId);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}

	@GetMapping("/members/me/comments")
	public ResponseEntity<List<CommentResponseDto>> findAllComment() {
		List<CommentResponseDto> responseDtoList = commentService.findAllComment();
		return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
	}

	@PatchMapping("/todos/comments/{commentId}")
	public ResponseEntity<Void> updateComment(
		@RequestBody UpdateCommentRequestDto dto,
		@PathVariable Long commentId
	) {
		commentService.updateComment(dto, commentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/todos/comments/{commentId}")
	public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
		commentService.deleteComment(commentId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
