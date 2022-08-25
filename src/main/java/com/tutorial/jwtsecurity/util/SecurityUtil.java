package com.tutorial.jwtsecurity.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Slf4j
public class SecurityUtil {

    private SecurityUtil() { }

    // SecurityContext 의 Authentication 객체를 이용해 name 을 리턴해주는 메소드
    public static Long getCurrentMemberId() {
        // 이 SecurityContext 는 어디서 온겨?
        // Request 가 들어올 때 JwtFilter 의 doFilter 를 거쳐 유저 정보 저장
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getName() == null) {
            throw  new RuntimeException("Security Context 에 인증 정보가 없습니다.");
        }

        return Long.parseLong(authentication.getName());
    }
}