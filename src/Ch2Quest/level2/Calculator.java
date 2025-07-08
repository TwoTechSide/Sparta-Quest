package Ch2Quest.level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> results = new ArrayList<>();  // 계산 결과 저장
    private int num1;
    private int num2;
    private String symbol;

    public void calculate() {

        int result;

        try {
            if (symbol.length() != 1)
                throw new RuntimeException();

            // 사칙 연산 진행, 기호를 벗어난 경우 예외 처리
            char cSymbol = symbol.charAt(0);
            result = switch (cSymbol) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> num1 / num2;
                default -> throw new RuntimeException();
            };
        } catch (ArithmeticException e) {   // 'n / 0' 형태의 오류일 경우
            System.out.println("0으로 나눌 수 없습니다. 프로그램을 종료합니다.");
            throw new RuntimeException(e);
        } catch (Exception e) {             // 사칙 연산 입력이 잘못된 경우
            System.out.println("올바른 입력이 아닙니다. 프로그램을 종료합니다.");
            throw new RuntimeException(e);
        }

        results.add(result);
    }

    public void setFirstNum(int n) {
        this.num1 = n;
    }

    public void setSecondNum(int n) {
        this.num2 = n;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getLastCalc() {
        return results.get(results.size() - 1);
    }
}
