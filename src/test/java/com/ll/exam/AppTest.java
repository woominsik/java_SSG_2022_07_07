package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void 파일에_내용쓰기() {
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용");
    }

    @Test
    public void 테스트_실험(){
        int rs = 10+20;
        assertEquals(30, rs);
    }

    @Test
    public void 테스트_스캐너(){
        String input= """
            등록
            명언1
            작가1
            """.stripIndent();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();

        assertEquals(cmd,"등록");
        assertEquals(content,"명언1");
        assertEquals(author,"작가1");
    }

    @Test
    public void 표준출력을_리다이렉션하여_결과를_문자열로_받기() throws IOException {
        // 표준출력을 리다이렉션 함
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");

        String rs = output.toString().trim();

        //표준 출력 원상복구
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();

        assertEquals(rs,"안녕");
    }
    @Test
    public void Rq__getIntParam() {
        Rq rq = new Rq("삭제?id=1");

        int id = rq.getIntParam("id", 0);

        assertEquals(1, id);
    }

    @Test
    public void Rq__getIntParam__2() {
        Rq rq = new Rq("검색?id=10&no=1");

        int id = rq.getIntParam("id", 0);
        int no = rq.getIntParam("no", 0);

        assertEquals(10, id);
        assertEquals(1, no);
    }

    @Test
    public void Rq__getPath() {
        Rq rq = new Rq("삭제?id=1");

        String path = rq.getPath();

        assertEquals("삭제", path);
    }
}