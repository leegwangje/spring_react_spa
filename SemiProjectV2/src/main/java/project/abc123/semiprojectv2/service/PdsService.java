package project.abc123.semiprojectv2.service;


import org.springframework.web.multipart.MultipartFile;
import project.abc123.semiprojectv2.domain.Gallery;
import project.abc123.semiprojectv2.domain.Pds;
import project.abc123.semiprojectv2.domain.PdsReplyDTO;

import java.util.List;

public interface PdsService {

//    List<GalleryListDTO> selectGallery();

//    GalleryImageDTO readOneGalleryImage(int gno);

    boolean newPds(Pds pds, List<MultipartFile> panames);

    PdsReplyDTO readOnePdsReply(int pno);
}
