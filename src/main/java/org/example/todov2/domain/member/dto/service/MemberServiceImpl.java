package org.example.todov2.domain.member.dto.service;

import org.example.todov2.domain.member.dto.request.SaveMemberRequestDto;
import org.example.todov2.domain.member.dto.response.MemberResponseDto;
import org.example.todov2.domain.member.entity.Member;
import org.example.todov2.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	@Override
	public MemberResponseDto save(SaveMemberRequestDto dto) {
		Member savedMember = memberRepository.save(new Member(dto.getName(), dto.getPassword(), dto.getEmail()));
		return new MemberResponseDto(savedMember.getId(), savedMember.getName(), savedMember.getEmail());
	}
}
