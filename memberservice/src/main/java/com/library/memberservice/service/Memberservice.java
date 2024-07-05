package com.library.memberservice.service;
import com.library.memberservice.model.Member;

import java.util.List;
import java.util.Optional;

public interface Memberservice {

    List<Member> getAllMembers();

    Optional<Member> getMemberById(Long memberId);

    Member addMember(Member member);

    Member updateMember(Long memberId, Member member);

    void deleteMember(Long memberId);

}


