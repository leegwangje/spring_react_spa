package project.abc123.semiprojectv2.service;


import org.springframework.web.multipart.MultipartFile;
import project.abc123.semiprojectv2.domain.Gallery;

import java.util.List;

public interface GalleryService {

//    List<GalleryListDTO> selectGallery();

//    GalleryImageDTO readOneGalleryImage(int gno);

    boolean newGalleryImage(Gallery gal, List<MultipartFile> ginames);
}
