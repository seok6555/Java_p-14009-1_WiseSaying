package com.back;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    ArrayList<WiseSaying> wiseSayingArrayList = new ArrayList<>();

    int id = 0;

    public void run() {
        System.out.println("== 명언 앱 ==");

        while ( true ) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                createWiseSaying();
            } else if (cmd.equals("목록")) {
                readWiseSaying();
            } else if (cmd.startsWith("삭제?id=")) {
                int deleteId = Integer.parseInt(cmd.substring(6));
                deleteWiseSaying(deleteId);
            }
        }

        scanner.close();
    }

    // 명언 등록
    public void createWiseSaying() {
        System.out.print("명언 : ");
        String wiseSayingContent = scanner.nextLine().trim();

        System.out.print("작가 : ");
        String wiseSayingAuthor = scanner.nextLine().trim();

        id++;
        wiseSayingArrayList.add(new WiseSaying(id, wiseSayingContent, wiseSayingAuthor));
        System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
    }

    // 명언 목록 조회
    public void readWiseSaying() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = wiseSayingArrayList.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayingArrayList.get(i);
            System.out.println(wiseSaying);
        }
    }

    // 명언 수정
    public void updateWiseSaying() {

    }

    // 명언 삭제
    public void deleteWiseSaying(int deleteId) {
        wiseSayingArrayList.removeIf(wiseSaying -> wiseSaying.getId() == deleteId);
        System.out.println("%d번 명언이 삭제되었습니다.".formatted(deleteId));
    }
}
