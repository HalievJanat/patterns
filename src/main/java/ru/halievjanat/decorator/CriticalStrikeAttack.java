package ru.halievjanat.decorator;

import ru.halievjanat.builder.Hero;
import ru.halievjanat.strategy.AttackStrategy;

public class CriticalStrikeAttack extends AttackStrategyDecorator {
    public CriticalStrikeAttack(AttackStrategy attackStrategy) {
        super(attackStrategy);
    }

    @Override
    public String attack(Hero attackerHero, Hero targetHero) {
        String attack = this.decoratorStrategy.attack(attackerHero, targetHero);

        return attack.replace("удар", "+ критический удары");
    }
}
