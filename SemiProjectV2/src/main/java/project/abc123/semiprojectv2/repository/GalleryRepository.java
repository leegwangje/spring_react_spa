package project.abc123.semiprojectv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.abc123.semiprojectv2.domain.Gallery;
import project.abc123.semiprojectv2.domain.User;

import java.util.Optional;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {


    
}
