package com.example.springstablehigh.repository;

import com.example.springstablehigh.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
