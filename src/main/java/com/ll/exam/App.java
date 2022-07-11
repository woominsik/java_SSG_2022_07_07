package com.ll.exam;

import jdk.jfr.StackTrace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public void run() {
        System.out.println("== 명언 SSG ==");
        List<WiseSaying> wiseSayings = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int wiseSayingLastId=0;
        boolean outerCheck=false;
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();
                    int id = ++wiseSayingLastId;

                    WiseSaying wiseSaying = new WiseSaying(id,content,author);
                    System.out.println(wiseSaying);
                    wiseSayings.add(wiseSaying);
                    System.out.println(id+"번 명언이 등록되었습니다.");
                    break;

                case "삭제" :
                    int paramId = rq.getIntParam("id",0);

                    if(paramId==0){
                        System.out.println("id를 입력해주세요");
                        continue;
                    }

                    WiseSaying wiseSaying__ = null;

                    for (WiseSaying wiseSaying___ : wiseSayings) {
                        if(wiseSaying___.id == paramId){
                            wiseSaying__ = wiseSaying___;
                        }
                    }

                    if(wiseSaying__ == null){
                        System.out.println(paramId+"번 명언은 존재하지 않습니다..");
                        continue;
                    }

                    wiseSayings.remove(wiseSaying__);

                    System.out.println(paramId+"번 명언이 삭제되었습니다.");
                    break;
                case "종료":
                    outerCheck = true;
                    break;

                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("-------------------");
                    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying_ = wiseSayings.get(i);
                        System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
                    }
                    break;
            }
            if(outerCheck){
                break ;
            }
        }

        sc.close();
    }
}