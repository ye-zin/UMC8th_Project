package com.example.service.MemberService;

import com.example.web.dto.MemberResponseDTO;
import com.example.domain.Member;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface MemberQueryService {
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}