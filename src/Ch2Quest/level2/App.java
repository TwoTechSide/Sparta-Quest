package Ch2Quest.level2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        Scanner s = new Scanner(System.in);

        // 사칙 연산이 포함된 Set
        Set<String> symbolSet = new HashSet<>();
        symbolSet.add("+");
        symbolSet.add("-");
        symbolSet.add("*");
        symbolSet.add("/");

        String symbol;

        while (true) {
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            String input;
            int num1, num2;

            /* 숫자 입력 */
            while (true) {
                try {
                    System.out.print("첫 번째 값을 입력해주세요 : ");
                    num1 = Integer.parseInt(s.nextLine());
                    System.out.print("두 번째 값을 입력해주세요 : ");
                    num2 = Integer.parseInt(s.nextLine());

                    if (num1 < 0 || num2 < 0)
                        throw new Exception();

                    break;
                } catch (Exception e) {
                    System.out.println("적절한 입력이 아닙니다. 다시 입력해주세요.");
                }
            }

            /* 사칙연산 기호 입력 */
            while (true) {
                System.out.print("연산을 선택해주세요 [+, -, *, /] : ");
                String sign = s.nextLine();

                // 정해진 사칙연산을 사용하지 않는 경우 예외 처리
                try {
                    if (!symbolSet.contains(sign)) throw new Exception();
                    symbol = sign;
                    break;
                } catch (Exception e) {             // 사칙 연산 입력이 잘못된 경우
                    System.out.println("올바른 입력이 아닙니다. 사칙연산을 선택해주세요.");
                }
            }

            /* Calculator 클래스에 입력 후 계산 */
            c.setFirstNum(num1);
            c.setSecondNum(num2);
            c.setSymbol(symbol);

            c.calculate();
            c.getLastCalc();

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
