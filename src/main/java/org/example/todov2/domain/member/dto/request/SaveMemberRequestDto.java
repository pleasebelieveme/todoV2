package org.example.todov2.domain.member.dto.request;

import lombok.Getter;

@Getter
public class SaveMemberRequestDto {

	private final String name;
	private final String password;
	private final String email;

	public SaveMemberRequestDto(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
}
