package org.example.todov2.domain.member.service;

import org.example.todov2.domain.member.dto.request.SaveMemberRequestDto;
import org.example.todov2.domain.member.dto.response.MemberResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
	MemberResponseDto save(SaveMemberRequestDto dto);
}
