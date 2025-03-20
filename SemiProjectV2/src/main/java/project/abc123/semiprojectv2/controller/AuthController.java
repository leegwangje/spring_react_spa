package project.abc123.semiprojectv2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.abc123.semiprojectv2.domain.Member;
import project.abc123.semiprojectv2.domain.MemberDTO;
import project.abc123.semiprojectv2.domain.User;
import project.abc123.semiprojectv2.service.MemberService;
import project.abc123.semiprojectv2.service.UserService;

// 교차출처 리소스 공유 CORS
@CrossOrigin(origins="http://localhost:5173")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {


    private final MemberService memberService;
    private final UserService userService;

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
    public ResponseEntity<?> loginok(@RequestBody MemberDTO member) {
        // @RequestBody (문자열로 받기)
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 로그인 정보 : {}", member);

        try {

            Member LoginUser = memberService.loginMember(member);

            response = ResponseEntity.ok().build();
        } catch (IllegalStateException e) {

            response = ResponseEntity.badRequest().body(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }

        return response;
    }

}
