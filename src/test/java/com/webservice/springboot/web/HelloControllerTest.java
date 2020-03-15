package com.webservice.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
                            //여기서는 SpringRunner라는 스프링 실행자를 사용.
                            //즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 합니다.
@WebMvcTest(controllers = HelloController.class) //Web(Spring MVC)에 집중할 수 있는 어노테이션.
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 빈(Bean)을 주입 받는다.
    private MockMvc mvc; //웹 API를 테스트할 때 사용한다.
                        //스프링MVC 테스트의 시작점.
                        //이 클래스를 통해 HTTP GET,POST등에 대한 API를 테스트할 수 있다.

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")) // /hello 주소로 HTTP GET 요청을 한다.
                .andExpect(status().isOk()) //HTTP Header의 Status를 검증한다. 여기 OK는 200인지 아닌지를 검증한다.
                .andExpect(content().string(hello)); //mvc.perform의 결과를 검증. Controller에서 "hello"를 리턴하기 때문에
                                                    //이 값이 맞는지 검증한다.
    }
}
