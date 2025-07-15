package Ch2Quest.level3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArithmeticCalculator<T extends Number> {

    private final List<BigDecimal> results = new ArrayList<>();
    private BigDecimal num1;
    private BigDecimal num2;
    SymbolEnum symbol;

    public Optional<BigDecimal> calculate() {
        BigDecimal result;

        switch (symbol) {
            case ADD:
                result = num1.add(num2);
                break;
            case SUB:
                result = num1.subtract(num2);
                break;
            case MUL:
                result = num1.multiply(num2);
                break;
            case DIV:
                if (num2.compareTo(BigDecimal.ZERO) == 0) {
                    System.out.print("0으로 나눌 수 없습니다. ");
                    return Optional.empty();
                }
                result = num1.divide(num2, 10, RoundingMode.HALF_UP);
                break;
            default:
                return Optional.empty();
        }
        results.add(result);
        return Optional.of(result);
    }

    public void printResults() {
        System.out.print("지난 계산 결과 기록 : [ ");

        for (BigDecimal result : results)
            System.out.print(result + ", ");

        System.out.println("... ]");
    }

    public void removeFirstResult() {
        if (!results.isEmpty())
            results.remove(0);
    }

    public void setNum1(T num1) { this.num1 = new BigDecimal(num1.toString()); }
    public void setNum2(T num2) { this.num2 = new BigDecimal(num2.toString()); }
    public void setSymbol(SymbolEnum symbol) { this.symbol = symbol; }
}
