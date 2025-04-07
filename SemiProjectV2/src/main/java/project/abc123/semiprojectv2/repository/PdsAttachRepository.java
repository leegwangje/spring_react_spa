package project.abc123.semiprojectv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.abc123.semiprojectv2.domain.PdsAttach;

import java.util.ArrayList;

public interface PdsAttachRepository extends JpaRepository<PdsAttach, Long> {

ArrayList <PdsAttach> findByPno(int pno);

    
}
