package me.kwonsangjae.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest // 테스트용 애너테이션 컨텍스트 생성
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class TestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers: 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        // given
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        // when
        final ResultActions result = mockMvc.perform(get(url) // (1)
                .accept(MediaType.APPLICATION_JSON)); // (2)

        // then
        result .andExpect(status().isOk()) // (3)
                //  (4)
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}
/*
    (1): perform() 메소드는 요청을 전송하는 역할을 하는 메소드.
         return값으로 ResultActions 객체를 받음.
         ResultActions 객체는 반환값을 검증하고 확인하는 andExpect() 메소드를 제공함.

    (2): accept() 메소드는 요청을 보낼 때 무슨 타입으로 응당을 받을지 결정하는 메소드

    (3): andExcept() 메소드는 응답을 검증. TestController에서 만든 API는 응답으로 OK(200)을 반환하므로 이에 해당하는 메소드인
         isOk()를 사용해 응답 코드가 200인지 확인
    (4): jsonOPath("$[0].{필드명}")은 JSON 응답값의 값(value)을 가져오는 역할을 하는 메소드
         배열의 인덱스가 0번째에 들어있는 객체의 id, name의 값을 가져오고 저장된 값과 같은지 확인
            (memberRepositry.savedMember.getId()등을 이용해서)
 */
    /*
        @SpringBootTest:
            애플리케이션 클래스에 추가하는 애너테이션인 @SpringBootApplicataion에 있는 클래스를 찾고,
            그 클래스에 포함돼 있는 빈을 찾은 다음, 테스트용 애플리케이션 컨텍스트라는 것을 생성
        @AutoConfigureMockMvc:
            MockMvc를 생성하고 자동으로 구성하는 애너테이션으로, 이 것은 애플리케이션을 서버에 배포하지 않고도
            테스트용 MVC 환경을 만들거나 요청, 전송, 응답 기능을 제공하는 유틸리티 클래스.
            즉, 컨트롤러를 테스트할 때 사용되는 클래스
     */