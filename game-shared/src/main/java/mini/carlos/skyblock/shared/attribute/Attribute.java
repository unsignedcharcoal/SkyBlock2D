package mini.carlos.skyblock.shared.attribute;

import lombok.Getter;
import mini.carlos.skyblock.shared.Operation;
import mini.carlos.skyblock.shared.exception.UnknownOperation;

@Getter
public class Attribute {

    private final String key;
    private final double baseValue;
    private double currentValue;

    public Attribute(AttributeKey base) {
        this.key = base.getKey();
        this.baseValue = 100.0;
        this.currentValue = baseValue;
    }

    /**
     * Aplica uma operação sobre o valor atual.
     */
    public void operateValue(Operation operation, double value) {
        switch (operation) {
            case ADD -> currentValue += value;
            case MULTIPLY -> currentValue *= value;
            case SET -> currentValue = value;
            case REMOVE -> currentValue -= value;
            default -> throw new UnknownOperation(operation);
        }
    }

    /**
     * Restaura o valor atual para o valor base.
     */
    public void resetValue() {
        currentValue = baseValue;
    }
}
