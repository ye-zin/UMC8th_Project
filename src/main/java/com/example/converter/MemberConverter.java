package com.example.converter;

import com.example.web.dto.MemberRequestDTO;
import com.example.web.dto.MemberResponseDTO;
import com.example.domain.Member;
import com.example.domain.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberResponseDTO.LoginResultDTO toLoginResultDTO(Long memberId, String accessToken) {
        return MemberResponseDTO.LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static MemberResponseDTO.MemberInfoDTO toMemberInfoDTO(Member member){
        return MemberResponseDTO.MemberInfoDTO.builder()
                .name(member.getName())
                .email(member.getEmail())
                .gender(member.getGender().name())
                .build();
    }


    public static Member toMember(MemberRequestDTO.JoinDto request){

//        Gender gender = null;

//        switch (request.getGender()){
//            case 1:
//                gender = Gender.MALE;
//                break;
//            case 2:
//                gender = Gender.FEMALE;
//                break;
//            case 3:
//                gender = Gender.NONE;
//                break;
//        }

        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .gender(request.getGender())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .role(request.getRole())   // 추가된 코드
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
