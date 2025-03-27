package project.abc123.semiprojectv2.service;

import org.springframework.data.domain.Page;
import project.abc123.semiprojectv2.domain.Board;
import project.abc123.semiprojectv2.domain.BoardDTO;
import project.abc123.semiprojectv2.domain.BoardListDTO;

public interface BoardService {

    Board newBoard(Board board);

    BoardListDTO readBoard(int cpg);

    BoardListDTO findBoard(int cpg,String findtype, String findkey);

    Page<BoardDTO> testreadBoard(int cpg);
}
