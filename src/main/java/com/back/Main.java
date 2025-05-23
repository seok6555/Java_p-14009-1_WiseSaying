package  com.back;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int id = 0;

        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);
        ArrayList<WiseSaying> wiseSayingArrayList = new ArrayList<>();

        while ( true ) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSayingContent = scanner.nextLine().trim();

                System.out.print("작가 : ");
                String wiseSayingAuthor = scanner.nextLine().trim();

                id++;
                wiseSayingArrayList.add(new WiseSaying(id, wiseSayingContent, wiseSayingAuthor));
                System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = wiseSayingArrayList.size() - 1; i >= 0; i--) {
                    WiseSaying wiseSaying = wiseSayingArrayList.get(i);
                    System.out.println(wiseSaying);
                }
            }
        }

        scanner.close();
    }
}
