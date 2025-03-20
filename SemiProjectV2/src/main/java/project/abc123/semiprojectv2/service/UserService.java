package project.abc123.semiprojectv2.service;

import project.abc123.semiprojectv2.domain.User;

public interface UserService {

    User newUser(User user);

    User loginMember(User user);
}
