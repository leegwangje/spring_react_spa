package project.abc123.semiprojectv2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

        Pageable pageable = PageRequest.of(cpg, pageSize, Sort.Direction.DESC, "bno");
        Page<BoardDTO> pageboards= boardRepository.findBy(pageable);
        List<BoardDTO> boards = pageboards.getContent();
        int totalItems =(int)pageboards.getTotalElements();
        int cntpg = pageboards.getTotalPages();
        return new BoardListDTO(cpg,totalItems,pageSize,boards);
    }


}
