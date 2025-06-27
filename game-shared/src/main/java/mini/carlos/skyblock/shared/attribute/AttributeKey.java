package mini.carlos.skyblock.shared.attribute;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter(AccessLevel.MODULE)
@RequiredArgsConstructor
public enum AttributeKey {

    SPEED,
    ATTACK_SPEED,
    MANA,
    MANA_RECOVERY,
    MAX_MANA,
    HEALTH,
    HEALTH_RECOVERY,
    MAX_HEALTH,
    FORTUNE,
    STRENGTH,
    STRENGTH_RECOVERY;


    public String getKey(){
        return name().toLowerCase();
    }


}
