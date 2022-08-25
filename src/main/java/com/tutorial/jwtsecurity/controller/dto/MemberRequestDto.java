package com.tutorial.jwtsecurity.controller.dto;

import com.tutorial.jwtsecurity.entity.Authority;
import com.tutorial.jwtsecurity.entity.Member;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {
    // 로그인, 회원가입 할 때 사용


    private String nickname;
    private String password;

    public Member toMember(PasswordEncoder passwordEncoder) {
        // Member 클래스에서 생성자를 만들 때 @Builder 를 적용했기 때문에 아래 형식으로 객체 생성 가능한 것
        return Member.builder()
                .nickname(nickname)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(nickname, password);
    }
}
