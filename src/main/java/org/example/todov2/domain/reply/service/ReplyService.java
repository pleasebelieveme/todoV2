package org.example.todov2.domain.reply.service;

import org.example.todov2.domain.reply.dto.request.SaveReplyRequestDto;
import org.example.todov2.domain.reply.dto.request.UpdateReplyRequestDto;
import org.example.todov2.domain.reply.dto.response.ReplyResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ReplyService {
	ReplyResponseDto saveReply(SaveReplyRequestDto dto, Long commentId);
	void updateReply(UpdateReplyRequestDto dto, Long replyId);
}
