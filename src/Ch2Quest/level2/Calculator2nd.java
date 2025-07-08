package Ch2Quest.level2;

import java.util.Scanner;

public class Calculator2nd {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            String input;
            int num1 = 0;
            int num2 = 0;
            int result;

            /* 숫자 입력 */
            try {
                System.out.print("첫 번째 값을 입력해주세요 : ");
                num1 = s.nextInt();
                System.out.print("두 번째 값을 입력해주세요 : ");
                num2 = s.nextInt();
            } catch (Exception e) {
                System.out.println("적절한 숫자가 아닙니다. 프로그램을 종료합니다.");
                throw new RuntimeException(e);
            }

            /* 사칙연산 기호 입력 */
            s.nextLine(); // Scanner 버퍼 비우기
            System.out.print("연산을 선택해주세요 [+, -, *, /] : ");
            String symbol = s.nextLine();

            /* Calculator 클래스에 입력 후 계산 */
            c.setFirstNum(num1);
            c.setSecondNum(num2);
            c.setSymbol(symbol);

            c.calculate();
            result = c.getLastCalc();

            /* 결과 출력 */
            c.printResultsHistory();

            /* 진행 확인 */
            System.out.print("...\n연산은 최대 5개까지 저장됩니다. 더 계산하시겠습니까? (exit 입력 시 종료) ");
            input = s.nextLine();

            if (input.equals("exit")) {
                System.out.println("exit를 입력하여 프로그램을 종료합니다.");
                break;
            }
        }
    }
}
