package com.ll.exam;

import jdk.jfr.StackTrace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
    private Scanner sc;
    private List<WiseSaying> wiseSayings;
    private int wiseSayingLastId;

    public App(){
        sc = new Scanner(System.in);
        wiseSayings = new ArrayList<>();
        wiseSayingLastId=0;
    }
    public void run() {
        System.out.println("== 명언 SSG ==");

        boolean outerCheck=false;
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    write();
                    break;

                case "삭제" :
                    remove(rq);
                    break;

                case "종료":
                    outerCheck = true;
                    break;

                case "목록":
                    list(rq);
                    break;
            }
            if(outerCheck){
                break ;
            }
        }

        sc.close();
    }

    private void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying_ = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
        }
    }

    private void remove(Rq rq) {
        int paramId = rq.getIntParam("id",0);

        if(paramId==0){
            System.out.println("id를 입력해주세요");
            return;
        }

        WiseSaying foundWiseSaying = findById(paramId);

        if(foundWiseSaying == null){
            System.out.println(paramId+"번 명언은 존재하지 않습니다..");
            return;
        }

        wiseSayings.remove(foundWiseSaying);

        System.out.println(paramId+"번 명언이 삭제되었습니다.");
    }

    private void write() {
        System.out.printf("명언 : ");
        String content = sc.nextLine().trim();
        System.out.printf("작가 : ");
        String author = sc.nextLine().trim();
        int id = ++wiseSayingLastId;

        WiseSaying wiseSaying = new WiseSaying(id,content,author);
        System.out.println(wiseSaying);
        wiseSayings.add(wiseSaying);
        System.out.println(id+"번 명언이 등록되었습니다.");
    }

    private WiseSaying findById(int paramId){
        for (WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.id == paramId){
                return wiseSaying;
            }
        }
        return null;
    }
}