package com.example.be_study_2026.week7;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// 아직 회원가입 기능이 없기에 서버 실행 시 DB에 계정 넣는 코드 생성
@Component
@RequiredArgsConstructor
public class DataInit implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final MenuRepository menuRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (memberRepository.findByUsername("admin").isEmpty()) {
            memberRepository.save(new Member(
                "admin",
                passwordEncoder.encode("1234"),
                "ADMIN"
            ));
        }
        if (memberRepository.findByUsername("user01").isEmpty()) {
            memberRepository.save(new Member(
                "user01",
                passwordEncoder.encode("1234"),
                "USER"
            ));
        }
        if (memberRepository.findByUsername("user02").isEmpty()) {
            memberRepository.save(new Member(
                "user02",
                passwordEncoder.encode("1234"),
                "USER"
            ));
        }
        if (menuRepository.count() == 0) {
            menuRepository.save(new Menu("아메리카노", 4000, 100));
            menuRepository.save(new Menu("라떼", 4500, 100));
        }
    }

}
