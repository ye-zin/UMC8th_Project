package com.example.service.MemberService;

import com.example.web.dto.MemberRequestDTO;
import com.example.domain.Member;
import com.example.web.dto.MemberResponseDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);
}

