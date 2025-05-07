package org.example.todov2.domain.reply.controller;

import org.example.todov2.domain.comment.dto.request.UpdateCommentRequestDto;
import org.example.todov2.domain.reply.dto.request.SaveReplyRequestDto;
import org.example.todov2.domain.reply.dto.request.UpdateReplyRequestDto;
import org.example.todov2.domain.reply.dto.response.ReplyResponseDto;
import org.example.todov2.domain.reply.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService replyService;

	@PostMapping("todos/comments/{commentId}/replies")
	public ResponseEntity<ReplyResponseDto> saveReply(@RequestBody SaveReplyRequestDto dto, @PathVariable Long commentId) {
		ReplyResponseDto responseDto = replyService.saveReply(dto, commentId);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}

	@PatchMapping("/todos/comments/replies/{replyId}")
	public ResponseEntity<Void> updateReply(
		@RequestBody UpdateReplyRequestDto dto,
		@PathVariable Long replyId
	) {
		replyService.updateReply(dto, replyId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/todos/comments/replies/{replyId}")
	public ResponseEntity<Void> deleteReply(@PathVariable Long replyId) {
		replyService.deleteReply(replyId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
