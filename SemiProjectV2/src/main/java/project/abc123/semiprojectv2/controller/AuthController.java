package project.abc123.semiprojectv2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import project.abc123.semiprojectv2.domain.Board;
import project.abc123.semiprojectv2.domain.Member;
import project.abc123.semiprojectv2.domain.MemberDTO;
import project.abc123.semiprojectv2.domain.User;
import project.abc123.semiprojectv2.jwt.JwtTokenProvider;
import project.abc123.semiprojectv2.service.MemberService;
import project.abc123.semiprojectv2.service.UserService;

import java.util.HashMap;
import java.util.Map;

// 교차출처 리소스 공유 CORS
@CrossOrigin(origins = {"http://localhost:5173", "http://172.30.1.58:3000"})

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final MemberService memberService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> joinok(@RequestBody User user) {
                                   // @RequestBody (문자열로 받기)
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 회원 정보 : {}", user);

        try {

            userService.newUser(user);
            response = ResponseEntity.ok().build();
        } catch (IllegalStateException e) {

            response = ResponseEntity.badRequest().body(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }

        return response;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> loginok(@RequestBody User user) {
        // @RequestBody (문자열로 받기)
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 로그인 정보 : {}", user);

        try {

            // 스프링 시큐리티에서 제공하는 인증처리 메니저로 인증 처리
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserid(),user.getPasswd())
            );
            // 인증이 완료되면 jwt 토큰 생성
            final String jwt = jwtTokenProvider.generateToken(user.getUserid());

            // 생성한 토큰을 JSON 형식으로 만듦
            Map<String, Object> tokens = Map.of(
              "accessToken", jwt
            );

            response = ResponseEntity.ok().body(tokens);
        } catch (BadCredentialsException e) {

            response = ResponseEntity.badRequest().body("아이디나 비밀번호가 일치하지 않습니다!");
            log.info(e.getMessage());
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return response;
    }


}
