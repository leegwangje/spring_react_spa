package project.abc123.semiprojectv2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.abc123.semiprojectv2.domain.Board;
import project.abc123.semiprojectv2.domain.BoardListDTO;
import project.abc123.semiprojectv2.service.BoardService;

@CrossOrigin(origins="http://localhost:5173")
@Slf4j
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

   private final BoardService boardService;



    @PostMapping("/write")
    public ResponseEntity<?> writeok(@RequestBody Board board) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("list된 게시물 정보 : {}", board);

        try {

            boardService.newBoard(board) ;
                response = ResponseEntity.ok().build();

        } catch (IllegalStateException ex) {
            response = ResponseEntity.badRequest().body(ex.getMessage());
        }

        return response;
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestParam(defaultValue = "1") int cpg) {
        BoardListDTO boardListDTO = boardService.readBoard(cpg);

        return new ResponseEntity<>(boardListDTO, HttpStatus.OK);
    }
}
