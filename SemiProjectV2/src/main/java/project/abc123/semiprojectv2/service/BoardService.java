package project.abc123.semiprojectv2.service;

import project.abc123.semiprojectv2.domain.Board;
import project.abc123.semiprojectv2.domain.BoardListDTO;

public interface BoardService {

    Board newBoard(Board board);

    BoardListDTO readBoard(int cpg);
}
