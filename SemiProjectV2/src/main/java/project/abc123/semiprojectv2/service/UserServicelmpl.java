package project.abc123.semiprojectv2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.abc123.semiprojectv2.domain.Member;
import project.abc123.semiprojectv2.domain.User;
import project.abc123.semiprojectv2.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServicelmpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User newUser(User user) {
        // 아이디 중복 체크
        if (userRepository.existsByUserid(user.getUserid())) {
            throw new IllegalStateException("이미 존재하는 아이디입니다!!");
        }

        // 이메일 중복 체크
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalStateException("이미 존재하는 이메일입니다!!");
        }
        return userRepository.save(user);
    }



    @Override
    public User loginMember(User user) {
        User findUser = userRepository.findByUserid(user.getUserid());

        if (findUser == null || findUser.getPasswd().equals(user.getPasswd())) {
            throw new IllegalStateException("아이디나 비밀번호가 일치하지 않습니다");
        }


        return findUser;
    }
}
