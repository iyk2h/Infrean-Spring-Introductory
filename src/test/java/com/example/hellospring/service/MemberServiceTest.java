package com.example.hellospring.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.hellospring.domain.Member;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void 회원가입_정상() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findById(saveId).get();
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("member");

        Member member2 = new Member();
        member2.setName("member");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    }

    @Test
    void findMembers() {
    }

    @Test
    void findById() {
    }
}