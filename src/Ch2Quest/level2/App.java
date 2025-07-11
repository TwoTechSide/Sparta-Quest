package Ch2Quest.level2;

import java.util.HashSet;
import java.util.List;
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

        while (true) {
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            /* 숫자 입력 */
            while (true) {
                try {
                    System.out.print("첫 번째 값을 입력해주세요 : ");
                    int num1 = Integer.parseInt(s.nextLine());
                    System.out.print("두 번째 값을 입력해주세요 : ");
                    int num2 = Integer.parseInt(s.nextLine());

                    if (num1 < 0 || num2 < 0)
                        throw new Exception();

                    c.setFirstNum(num1);
                    c.setSecondNum(num2);
                    break;
                } catch (Exception e) {
                    System.out.println("적절한 입력이 아닙니다. 다시 입력해주세요.");
                }
            }

            int lastCalculated;

            /* 사칙연산 기호 입력 후 연산 */
            while (true) {
                System.out.print("연산을 선택해주세요 [+, -, *, /] : ");
                String sign = s.nextLine();

                // 정해진 사칙연산을 사용하지 않는 경우 예외 처리
                try {
                    if (!symbolSet.contains(sign))
                        throw new Exception();

                    c.setSymbol(sign);
                    lastCalculated = c.calculate(); // Calculator 클래스에서 계산
                    break;
                } catch (Exception e) {
                    System.out.println("0으로 나눌 수 없거나 잘못된 입력입니다.");
                }
            }

            // 최근 연산 결과 확인
            int num1 = c.getFirstNum();
            int num2 = c.getSecondNum();
            String symbol = c.getSymbol();

            System.out.println("계산 결과 : " + num1 + " " + symbol + " " + num2 + " = " + lastCalculated);

            boolean isFinish = false;

            /* 진행 확인 */
            while (true) {

                // 이전 기록들 확인
                List<Integer> results = c.getResults();
                System.out.print("지난 계산 결과 기록 : [ ");

                for (int result : results)
                    System.out.print(result + ", ");

                System.out.println("... ]");

                System.out.println("이전 기록을 지우려면 'delete' 를, 계산을 끝내려면 'exit' 를, 이어서 계산을 진행하려면 엔터를 눌러주세요 : ");
                String input = s.nextLine();

                if (input.equals("delete")) {
                    c.removeFirstResult();
                    continue;
                }
                else if (input.equals("exit")) {
                    System.out.println("exit를 입력하여 프로그램을 종료합니다.");
                    isFinish = true;
                }
                break;
            }

            // exit 를 입력하면 프로그램 종료
            if (isFinish)
                break;
        }
    }
}
