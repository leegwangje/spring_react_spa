package project.abc123.semiprojectv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.abc123.semiprojectv2.domain.GalleryImage;
import project.abc123.semiprojectv2.domain.User;

import java.util.Optional;

public interface GalleryImageRepository extends JpaRepository<GalleryImage, Long> {


    
}
