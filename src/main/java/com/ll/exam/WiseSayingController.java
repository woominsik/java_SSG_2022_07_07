package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private List<WiseSaying> wiseSayings;
    private int wiseSayingLastId;
    private Scanner sc;
    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }

    public void modify(Rq rq){
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
        System.out.println("명언(기존) : "+foundWiseSaying.content);
        System.out.print("명언 : ");
        foundWiseSaying.content = sc.nextLine();
        System.out.println("작가(기존) : "+foundWiseSaying.author);
        System.out.print("작가 : ");
        foundWiseSaying.author = sc.nextLine();

        System.out.println(paramId+"번 명언이 수정되었습니다.");
    }
    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying_ = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
        }
    }

    public void remove(Rq rq) {
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

    public void write() {
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
