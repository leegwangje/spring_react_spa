package project.abc123.semiprojectv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.abc123.semiprojectv2.domain.User;

public interface UserRepository  extends JpaRepository<User, Long> {

    boolean existsByUserid(String userid);

    boolean existsByEmail(String email);

    User findByUserid(String userid);
    
}
