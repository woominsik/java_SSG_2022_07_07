package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run(){
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);
        int sayCount=1;
        while(true){
            boolean outerBreak =false;
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            switch (cmd){
                case "종료":
                    outerBreak = true;
                    break ;

                case "등록" :
                    등록();
                    System.out.println(sayCount+"번 명언이 등록되었습니다.");
                    sayCount++;
                    break;
            }
            if(outerBreak){
                break;
            }
        }
    }
    static void 등록(){
        Scanner sc = new Scanner(System.in);
        System.out.print("명언 : ");
        String say =sc.nextLine();
        System.out.print("작가 : ");
        String person = sc.nextLine();

    }
}