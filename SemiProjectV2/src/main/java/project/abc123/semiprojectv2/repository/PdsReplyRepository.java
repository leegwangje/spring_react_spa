package project.abc123.semiprojectv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.abc123.semiprojectv2.domain.PdsReply;

import java.util.ArrayList;

public interface PdsReplyRepository extends JpaRepository<PdsReply, Long> {

    ArrayList <PdsReply> findByPno(int pno);
    
}
