package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run(){
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);
        while(true){
            boolean outerBreak =false;
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();
            switch (cmd){
                case "종료":
                    outerBreak = true;
                    break ;


            }
            if(outerBreak){
                break;
            }
        }
    }

}
