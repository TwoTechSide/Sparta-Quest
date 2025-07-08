package kotlinCh2Quest.level1;

import java.util.Scanner;

public class Calculator1st {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // 반복 진행
        while (true) {
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            String input;
            int value1, value2;

            /* 숫자 입력 */
            try {
                System.out.print("첫 번째 값을 입력해주세요 : ");
                value1 = s.nextInt();
                System.out.print("두 번째 값을 입력해주세요 : ");
                value2 = s.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("적절한 입력이 아닙니다. 프로그램을 종료합니다.");
                break;
            }

            /* 사칙연산 기호 입력 */
            s.nextLine(); // Scanner 버퍼 비우기
            System.out.print("연산을 선택해주세요 [+, -, *, /] : ");
            String sign = s.nextLine();

            // 사칙연산 입력이 잘못 된 경우 예외 처리
            try {
                if (sign.length() != 1)
                    throw new RuntimeException();

                // 사칙 연산 진행, 기호를 벗어난 경우 예외 처리
                char cSign = sign.charAt(0);
                int result = switch (cSign) {
                    case '+' -> value1 + value2;
                    case '-' -> value1 - value2;
                    case '*' -> value1 * value2;
                    case '/' -> value1 / value2;
                    default -> throw new RuntimeException();
                };

                // 결과 출력
                System.out.println("계산 결과 : " + value1 + " " + sign + " " + value2 + " = "  + result);
            } catch (ArithmeticException e) {   // 'n / 0' 형태의 오류일 경우
                System.out.println("0으로 나눌 수 없습니다. 프로그램을 종료합니다.");
                break;
            } catch (Exception e) {             // 사칙 연산 입력이 잘못된 경우
                System.out.println("올바른 입력이 아닙니다. 프로그램을 종료합니다.");
                break;
            }

            /* 진행 확인 */
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            input = s.nextLine();

            if (input.equals("exit")) {
                System.out.println("exit를 입력하여 프로그램을 종료합니다.");
                break;
            }
        }

        s.close();
    }
}