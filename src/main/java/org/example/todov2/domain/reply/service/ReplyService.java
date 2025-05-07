package org.example.todov2.domain.reply.service;

import java.util.List;

import org.example.todov2.domain.reply.dto.request.SaveReplyRequestDto;
import org.example.todov2.domain.reply.dto.request.UpdateReplyRequestDto;
import org.example.todov2.domain.reply.dto.response.ReplyResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ReplyService {
	ReplyResponseDto saveReply(SaveReplyRequestDto dto, Long commentId);
	List<ReplyResponseDto> findAllReply();
	void updateReply(UpdateReplyRequestDto dto, Long replyId);
	void deleteReply(Long replyId);
}
