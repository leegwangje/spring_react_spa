package project.abc123.semiprojectv2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import project.abc123.semiprojectv2.domain.Board;
import project.abc123.semiprojectv2.domain.BoardDTO;
import project.abc123.semiprojectv2.domain.BoardListDTO;
import project.abc123.semiprojectv2.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    @Value("${board.pagesize}") private int pageSize;

    @Override
    public Board newBoard(Board board) {
        // insert = save(JPA)
        return boardRepository.save(board);
    }

    @Override
    public BoardListDTO readBoard(int cpg) {
        int stnum = (cpg - 1) * pageSize;
        int totalItems = (int)boardRepository.count();  // jpa 자동 생성
       List<BoardDTO>boards= boardRepository.findBoards(stnum,pageSize);

        return new BoardListDTO(cpg,totalItems,pageSize,boards);
    }


}
