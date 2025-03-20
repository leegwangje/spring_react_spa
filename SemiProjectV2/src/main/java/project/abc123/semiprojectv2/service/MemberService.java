package project.abc123.semiprojectv2.service;


import project.abc123.semiprojectv2.domain.Member;
import project.abc123.semiprojectv2.domain.MemberDTO;

public interface MemberService {


    boolean newMember(MemberDTO member);

    Member loginMember(MemberDTO member);
}
