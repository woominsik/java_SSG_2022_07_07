package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        int wiseSayingLastId=0;
        boolean outerCheck=false;
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();
                    int id = ++wiseSayingLastId;

                    WiseSaying wiseSaying = new WiseSaying(id,content,author);
                    System.out.println(wiseSaying);
                    System.out.println(id+"번 명언이 등록되었습니다.");
                    break;
                case "종료":
                    outerCheck = true;
                    break;
            }
            if(outerCheck){
                break ;
            }
        }

        sc.close();
    }
}