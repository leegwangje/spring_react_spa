package project.abc123.semiprojectv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.abc123.semiprojectv2.domain.Pds;

public interface PdsRepository extends JpaRepository<Pds, Long> {

    Pds findByPno(int pno);

    
}
