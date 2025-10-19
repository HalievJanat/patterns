package ru.halievjanat.decorator;

import ru.halievjanat.builder.Hero;
import ru.halievjanat.strategy.AttackStrategy;

public abstract class AttackStrategyDecorator implements AttackStrategy {
    protected AttackStrategy decoratorStrategy;

    public AttackStrategyDecorator(AttackStrategy attackStrategy) {
        this.decoratorStrategy = attackStrategy;
    }

    @Override
    public abstract String attack(Hero attackerHero, Hero targetHero);
}
