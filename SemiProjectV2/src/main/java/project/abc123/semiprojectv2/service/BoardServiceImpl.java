package project.abc123.semiprojectv2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.abc123.semiprojectv2.domain.Board;
import project.abc123.semiprojectv2.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;



    @Override
    public Board newBoard(Board board) {
        // insert = save(JPA)
        return boardRepository.save(board);
    }


}
