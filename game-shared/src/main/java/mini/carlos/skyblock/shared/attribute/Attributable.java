package mini.carlos.skyblock.shared.attribute;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.Optional;

public interface Attributable {

    @Unmodifiable
    List<Attribute> getAttributes();

    @Nullable
    Attribute getAttribute(AttributeKey key);

    Optional<Attribute> getAttributeOptional(AttributeKey key);
}
