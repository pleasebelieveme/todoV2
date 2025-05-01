package org.example.todov2.domain.todo.service;

import org.example.todov2.domain.member.dto.request.SaveMemberRequestDto;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.todo.dto.request.SaveTodoRequestDto;
import org.example.todov2.domain.todo.dto.response.TodoResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface TodoService {
	TodoResponseDto save(SaveTodoRequestDto dto, Member member);
}
