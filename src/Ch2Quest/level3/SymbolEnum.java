package Ch2Quest.level3;

import java.util.Optional;

public enum SymbolEnum {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private final String symbol;

    SymbolEnum(String symbol) {
        this.symbol = symbol;
    }

    public static Optional<SymbolEnum> findSymbol(String str) {
        for (SymbolEnum s : SymbolEnum.values()) {
            if (s.symbol.equals(str))
                return Optional.of(s);
        }
        return Optional.empty();
    }
}


