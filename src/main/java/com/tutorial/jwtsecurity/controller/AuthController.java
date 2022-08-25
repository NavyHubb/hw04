package com.tutorial.jwtsecurity.controller;


import com.tutorial.jwtsecurity.controller.dto.*;
import com.tutorial.jwtsecurity.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/member")  // SecurityConfig 에서 "/auth/**" 요청은 전부 허용했기 때문에 토큰 검증 로직을 타지 않는다.
@RequiredArgsConstructor
public class AuthController {
    // 회원가입 및 로그인 관련
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseDto<?> signup(@RequestBody @Valid MemberSignupDto memberSignupDto) {
        return authService.signup(memberSignupDto);
    }

    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody MemberRequestDto memberRequestDto, HttpServletResponse response) {
        return authService.login(memberRequestDto, response);
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}
