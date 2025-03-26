package project.abc123.semiprojectv2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.abc123.semiprojectv2.domain.Board;
import project.abc123.semiprojectv2.domain.BoardDTO;


import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {


    @Query(value =  "select  bno, title, userid, regdate, thumbs, views from  boards order by bno desc limit :stnum,:pageSize",
    nativeQuery = true)
    List<BoardDTO>findBoards(int stnum, int pageSize);
}
