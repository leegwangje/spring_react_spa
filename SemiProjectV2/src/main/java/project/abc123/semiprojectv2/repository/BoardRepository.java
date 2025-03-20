package project.abc123.semiprojectv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.abc123.semiprojectv2.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {


}
