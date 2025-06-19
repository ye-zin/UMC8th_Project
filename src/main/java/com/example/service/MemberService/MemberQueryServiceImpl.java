package com.example.service.MemberService;

import com.example.apiPayload.code.status.ErrorStatus;
import com.example.apiPayload.exception.handler.MemberHandler;
import com.example.config.security.jwt.JwtTokenProvider;
import com.example.domain.Member;
import com.example.repository.MemberRepository.MemberRepository;
import com.example.converter.MemberConverter;
import com.example.web.dto.MemberResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberInfoDTO(member);
    }
}
