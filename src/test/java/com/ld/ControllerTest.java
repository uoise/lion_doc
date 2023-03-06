package com.ld;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ControllerTest {

    @Test
    @DisplayName("step 1: init")
    public void t1() {
        String res = TestRunner.run("");
        assertThat(res)
                .contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("step 1: err")
    public void t2() {
        String res = TestRunner.run("종료1");
        assertThat(res)
                .contains("올바르지 않은 명령입니다.");
    }

    @Test
    @DisplayName("step 3: create() return id")
    public void t3() {
        String res = TestRunner.run("""
                등록
                안녕 안녕
                안녕로봇
                """);
        assertThat(res)
                .contains("명언 : ")
                .contains("작가 : ")
                .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("step 4: create() auto increment")
    public void t5() {
        String res = TestRunner.run("""
                등록
                안녕 안녕
                안녕로봇                
                등록
                안녕 안녕!
                안녕로봇                
                등록
                안녕 안녕?
                안녕로봇
                종료
                """);
        assertThat(res)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.")
                .contains("3번 명언이 등록되었습니다.");
    }

}
