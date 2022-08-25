package com.tutorial.jwtsecurity.controller.dto;

import com.tutorial.jwtsecurity.entity.Authority;
import com.tutorial.jwtsecurity.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignupDto {

    @NotBlank
    @Size(min = 4, max = 12)
    @Pattern(regexp = "[a-zA-Z\\d]*${3,12}")
    private String nickname;

    @NotBlank
    @Size(min = 4, max = 32)
    @Pattern(regexp = "[a-z\\d]*${3,32}")
    private String password;

    @NotBlank
    private String passwordConfirm;

    public Member toMember(PasswordEncoder passwordEncoder) {
        // Member 클래스에서 생성자를 만들 때 @Builder 를 적용했기 때문에 아래 형식으로 객체 생성 가능한 것
        return Member.builder()
                .nickname(nickname)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .build();
    }
}
