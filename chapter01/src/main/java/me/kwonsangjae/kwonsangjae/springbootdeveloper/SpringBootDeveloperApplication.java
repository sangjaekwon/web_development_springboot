package me.kwonsangjae.kwonsangjae.springbootdeveloper;

/*
    모든 프로젝트에는 main에 해당하는 클래스가 존재합니다 -> 실행용 클래스
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDeveloperApplication.class, args);

    }
}