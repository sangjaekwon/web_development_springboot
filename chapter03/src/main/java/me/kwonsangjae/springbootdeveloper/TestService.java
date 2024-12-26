package me.kwonsangjae.springbootdeveloper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TestService {

    @Autowired
    MemberRepository memberRepository;

    public ArrayList<Member> getAllmembers() {
        return memberRepository.findAll();
    }
    /*
        1. MemberRePository라는 빈을 주입 받은 후에,
        2. findAll() 메소드를 호출해서 멤버 테이틀에 저장된 멤버 목록을 가져옴
     */
}
