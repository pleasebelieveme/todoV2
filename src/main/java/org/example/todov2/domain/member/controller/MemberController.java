package org.example.todov2.domain.member.controller;

import org.example.todov2.domain.member.dto.request.SaveMemberRequestDto;
import org.example.todov2.domain.member.dto.response.MemberResponseDto;
import org.example.todov2.domain.member.dto.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping
	public ResponseEntity<MemberResponseDto> saveMember(@RequestBody SaveMemberRequestDto dto) {
		MemberResponseDto responseDto = memberService.save(dto);
		return new ResponseEntity<MemberResponseDto>(responseDto, HttpStatus.CREATED);
	}
}
