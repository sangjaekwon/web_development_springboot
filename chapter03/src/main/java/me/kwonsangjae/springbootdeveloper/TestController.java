package me.kwonsangjae.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/test")
    public ArrayList<Member> getAllMembers() {
        ArrayList<Member> members = testService.getAllMembers();
        return members;
    }
    
}
