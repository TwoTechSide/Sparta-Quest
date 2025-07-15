package Ch2Quest.level3;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();
        SymbolEnum sb;

        Scanner s = new Scanner(System.in);
        Optional<BigDecimal> result;

        while (true) {
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            double num1, num2;

            /* 숫자 입력 */
            try {
                System.out.print("첫 번째 값을 입력해주세요 : ");
                num1 = s.nextDouble();
                calculator.setNum1(num1);
                System.out.print("두 번째 값을 입력해주세요 : ");
                num2 = s.nextDouble();
                calculator.setNum2(num2);
            } catch (Exception e) {
                System.out.println("적절한 입력이 아닙니다. 다시 입력해주세요.");
            }
            s.nextLine(); // Scanner 버퍼 비우기

            /* 사칙연산 기호 입력 */
            while (true) {
                System.out.print("연산을 선택해주세요 [+, -, *, /] : ");
                Optional<SymbolEnum> symbol = SymbolEnum.findSymbol(s.nextLine());

                if (symbol.isPresent()) {
                    sb = symbol.get();
                    calculator.setSymbol(sb);
                    result = calculator.calculate();

                    if (result.isPresent())
                        break;
                } else {
                    System.out.print("잘못된 입력입니다. ");
                }

                System.out.println("사칙연산을 다시 선택해주세요.");
            }

            boolean isFinish = false;

            while (true) {
                calculator.printResults();

                System.out.println("이전 기록을 지우려면 'delete' 를, 계산을 끝내려면 'exit' 를, 이어서 계산을 진행하려면 엔터를 눌러주세요 : ");
                String input = s.nextLine();

                if (input.equals("delete")) {
                    calculator.removeFirstResult();
                    continue;
                } else if (input.equals("exit")) {
                    System.out.println("exit를 입력하여 프로그램을 종료합니다.");
                    isFinish = true;
                }
                break;
            }

            if (isFinish)
                break;
        }
    }
}
