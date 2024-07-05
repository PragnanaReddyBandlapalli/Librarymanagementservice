package com.library.memberservice.controller;

import com.library.memberservice.model.Member;
import com.library.memberservice.service.Memberservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final Memberservice memberService;

    @Autowired
    public MemberController(Memberservice memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long memberId) {
        Optional<Member> member = memberService.getMemberById(memberId);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member addedMember = memberService.addMember(member);
        return new ResponseEntity<>(addedMember, HttpStatus.CREATED);
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<Member> updateMember(@PathVariable Long memberId, @RequestBody Member member) {
        Member updatedMember = memberService.updateMember(memberId, member);
        if (updatedMember != null) {
            return ResponseEntity.ok(updatedMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
