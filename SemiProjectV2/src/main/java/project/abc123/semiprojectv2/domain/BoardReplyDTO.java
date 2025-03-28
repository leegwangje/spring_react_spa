package project.abc123.semiprojectv2.domain;


import lombok.Data;

import java.util.List;


@Data
public class BoardReplyDTO {

    private Board bd;
    private List<?>rps;

    public BoardReplyDTO(Board bd, List<?> rps ) {
        this.rps = rps;
        this.bd = bd;
    }
}
