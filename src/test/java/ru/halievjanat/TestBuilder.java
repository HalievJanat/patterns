package ru.halievjanat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import ru.halievjanat.builder.Hero;
import ru.halievjanat.builder.TypeHero;
import ru.halievjanat.proxy.SmartInventoryProxy;
import ru.halievjanat.strategy.AttackStrategy;
import ru.halievjanat.strategy.MeleeStrategy;

class TestBuilder {
    private AttackStrategy attackStrategy;
    private SmartInventoryProxy ordinaryInventory;

    @BeforeEach
    public void setup() {
        attackStrategy = new MeleeStrategy();
        ordinaryInventory = new SmartInventoryProxy(5);
    }

    @Test
    public void testBuilder() {
        Hero hero = Hero.builder("Легалас", TypeHero.ARCHER)
                .attack(attackStrategy)
                .inventory(ordinaryInventory)
                .build();

        Assertions.assertEquals("Легалас", hero.getName());
        Assertions.assertEquals(TypeHero.ARCHER, hero.getTypeHero());
        Assertions.assertEquals(100, hero.getHealth());
        Assertions.assertEquals(10, hero.getDamage());
        Assertions.assertEquals(attackStrategy, hero.getAttack());
        Assertions.assertEquals(ordinaryInventory, hero.getInventory());
        Assertions.assertNull(hero.getModernWeapon());
    }
}
