package org.example.todov2.domain.member.dto.response;

import org.example.todov2.domain.member.entity.Member;

import lombok.Getter;

@Getter
public class MemberResponseDto {

	private final Long id;
	private final String name;
	private final String email;

	public MemberResponseDto(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public static MemberResponseDto toDto(Member member) {
		return new MemberResponseDto(
			member.getId(),
			member.getName(),
			member.getEmail()
		);
	}
}
