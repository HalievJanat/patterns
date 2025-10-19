package ru.halievjanat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.halievjanat.adapter.ModernWeapon;
import ru.halievjanat.adapter.OldWeapon;
import ru.halievjanat.adapter.OldWeaponAdapter;
import ru.halievjanat.builder.Hero;
import ru.halievjanat.builder.TypeHero;
import ru.halievjanat.strategy.RangedStrategy;

public class TestAdapter {
    Hero heroOne, heroTwo;

    @BeforeEach
    public void setup() {
        heroOne = Hero.builder("Легалас", TypeHero.ARCHER)
                .attack(new RangedStrategy())
                .build();

        heroTwo = Hero.builder("Артур", TypeHero.WARRIOR)
                .build();
    }

    @Test
    public void testAdapter() {
        OldWeapon oldWeapon = new OldWeapon("Экскалибур", 25, 100);
        ModernWeapon modernWeapon = new OldWeaponAdapter(oldWeapon);
        heroTwo.setModernWeapon(modernWeapon);

        String result = modernWeapon.use(heroTwo, heroOne);

        Assertions.assertEquals("Артур использует Экскалибур и наносит 25 урона Легалас!", result);
    }
}
