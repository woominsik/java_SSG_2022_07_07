package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

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
}