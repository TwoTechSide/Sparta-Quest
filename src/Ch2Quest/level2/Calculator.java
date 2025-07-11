package Ch2Quest.level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> results = new ArrayList<>();  // 계산 결과 저장
    private int num1;
    private int num2;
    private String symbol;

    public int calculate() throws Exception {

        int result;

        try {
            // 사칙 연산 진행, 기호를 벗어난 경우 예외 처리
            char cSymbol = symbol.charAt(0);

            result = switch (cSymbol) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> num1 / num2;
                default -> throw new Exception();
            };

            results.add(result);
        } catch (Exception e) {
            throw new Exception();
        }

        return result;
    }

    // Getter
    public void setFirstNum(int n) {
        this.num1 = n;
    }
    public void setSecondNum(int n) {
        this.num2 = n;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    // Setter
    public int getFirstNum() {
        return num1;
    }
    public int getSecondNum() {
        return num2;
    }
    public String getSymbol() {
        return symbol;
    }

    // Method
    public List<Integer> getResults() {
        return results;
    }
    public void removeFirstResult() {
        if (!results.isEmpty())
            results.remove(0);
    }
}
