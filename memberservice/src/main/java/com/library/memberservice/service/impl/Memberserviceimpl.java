package com.library.memberservice.service.impl;

import com.library.memberservice.model.Member;
import com.library.memberservice.repository.Memberrepository;
import com.library.memberservice.service.Memberservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Memberserviceimpl implements Memberservice {

    private final Memberrepository memberRepository;

    @Autowired
    public Memberserviceimpl(Memberrepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> getMemberById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public Member addMember(Member member) {
        // Additional business logic can be added here if needed
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Long memberId, Member member) {
        if (memberRepository.existsById(memberId)) {
            member.setId(memberId);
            return memberRepository.save(member);
        }
        return null; // or throw an exception
    }

    @Override
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
