package project.abc123.semiprojectv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.abc123.semiprojectv2.domain.Reply;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

   List<Reply> findByPnoOrderByRef(Long pno);

}
