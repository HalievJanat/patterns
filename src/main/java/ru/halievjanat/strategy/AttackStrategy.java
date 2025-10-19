package ru.halievjanat.strategy;

import ru.halievjanat.builder.Hero;

public interface AttackStrategy {
    String attack(Hero attackerHero, Hero targetHero);
}
