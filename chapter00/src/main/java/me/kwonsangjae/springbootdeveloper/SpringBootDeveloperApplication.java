package me.kwonsangjae.springbootdeveloper;

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
/*
    처음으로 SpringBootDeveloperApplication 파일을 실행시키면 whiteLabel error page가 뜸
    햔재 요청에 해당하는 페이지가 존재하지 않기 때문에 생겨난 문제
    -> 스프링 애플리케이션은 실행된 것

    20241223 MON.
        1. IntelliJ Community Version 설치 -> bin.PATH
        2. Git 설치
        3. GitHub 연동 -> web_springboot
        4. IntelliJ에 Gradle 및 SpringBoot 프로젝트 생성
        5. POSTMAN 설치
 */