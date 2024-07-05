package com.library.memberservice.repository;



import com.library.memberservice.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Memberrepository extends JpaRepository<Member, Long> {

    // Additional query methods can be defined here if needed
    // need to add some code to find a number

}
