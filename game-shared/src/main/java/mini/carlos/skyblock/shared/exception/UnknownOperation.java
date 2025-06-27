package mini.carlos.skyblock.shared.exception;

import mini.carlos.skyblock.shared.Operation;

public class UnknownOperation extends RuntimeException {

    public UnknownOperation(Operation operation) {
        super("Operação desconhecida: " + operation.name());
    }

}
