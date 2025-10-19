package ru.halievjanat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.halievjanat.builder.Hero;
import ru.halievjanat.builder.TypeHero;
import ru.halievjanat.proxy.Item;
import ru.halievjanat.proxy.SmartInventoryProxy;
import ru.halievjanat.strategy.RangedStrategy;

public class TestProxy {
    Item sword, potion, bow;
    Hero hero;
    SmartInventoryProxy smartInventoryProxy;

    @BeforeEach
    public void setup() {
        hero = Hero.builder("Легалас", TypeHero.ARCHER)
                .attack(new RangedStrategy())
                .build();

        sword = new Item(1, "Меч дракона");
        potion = new Item(2, "Зелье здоровья");
        bow = new Item(3, "Лук охотника");

        smartInventoryProxy = new SmartInventoryProxy(5);
    }

    @Test
    public void testOrdinaryInventory() {
        hero.getInventory().addItem(sword);
        hero.getInventory().addItem(potion);
        hero.getInventory().addItem(bow);

        Assertions.assertEquals(sword, hero.getInventory().getAll().getFirst());
    }

    @Test
    public void testSmartInventory() {
        smartInventoryProxy.addItem(potion);
        smartInventoryProxy.addItem(sword);
        smartInventoryProxy.addItem(bow);

        hero.setInventory(smartInventoryProxy);
        Assertions.assertEquals(potion, hero.getInventory().getAll().getFirst());
    }
}
