package org.example.todov2.domain.member.entity;

import org.example.todov2.common.BaseEntity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

	public Member() {}

	public Member(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	// public MemberResponseDto toDto() {
	// 	return new MemberResponseDto(this.name, this.email);
	// }
	//
	// public void updatePassword(String password) {
	// 	this.password = password;
	// }
}
