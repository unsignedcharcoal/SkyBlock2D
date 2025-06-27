package mini.carlos.skyblock.shared;

public interface Damageable {

    double getHealth();

    void setHealth(double health);

    double getMaxHealth();

    void setMaxHealth(double maxHealth);

    default void restoreHealth() {
        setHealth(getMaxHealth());
    }

    default void damage(double amount) {
        double newHealth = Math.max(0, getHealth() - amount);
        setHealth(newHealth);
    }

    default boolean isDead() {
        return getHealth() <= 0;
    }
}
