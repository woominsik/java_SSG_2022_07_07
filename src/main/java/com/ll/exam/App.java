package com.ll.exam;

import jdk.jfr.StackTrace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
    private Scanner sc;

    public App(){
        sc = new Scanner(System.in);
    }
    public void run() {

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        System.out.println("== 명언 SSG ==");
        boolean outerCheck=false;
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    wiseSayingController.write();
                    break;

                case "삭제" :
                    wiseSayingController.remove(rq);
                    break;

                case "종료":
                    outerCheck = true;
                    break;

                case "수정":
                    wiseSayingController.modify(rq);
                    break;

                case "목록":
                    wiseSayingController.list(rq);
                    break;
            }
            if(outerCheck){
                break ;
            }
        }

        sc.close();
    }

}