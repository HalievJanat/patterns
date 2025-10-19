package ru.halievjanat.strategy;

import ru.halievjanat.builder.Hero;

public class MeleeStrategy implements AttackStrategy {

    @Override
    public String attack(Hero attackerHero, Hero targetHero) {
        return "Герой " + attackerHero.getName() + " нанес ближний удар по герою " + targetHero.getName();
    }
}
