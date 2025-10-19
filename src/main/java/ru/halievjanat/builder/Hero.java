package ru.halievjanat.builder;

import lombok.Data;
import lombok.ToString;
import ru.halievjanat.adapter.ModernWeapon;
import ru.halievjanat.proxy.Inventory;
import ru.halievjanat.proxy.OrdinaryInventory;
import ru.halievjanat.strategy.AttackStrategy;
import ru.halievjanat.strategy.MeleeStrategy;

@Data
public class Hero {
    private String name;
    private TypeHero typeHero;
    private int health;
    private int damage;
    private Inventory inventory;

    @ToString.Exclude
    private AttackStrategy attack;
    @ToString.Exclude
    private ModernWeapon modernWeapon;

    Hero(String name, TypeHero typeHero, int health, int damage, AttackStrategy attack,
         ModernWeapon modernWeapon, Inventory inventory) {
        this.name = name;
        this.typeHero = typeHero;
        this.health = health;
        this.damage = damage;
        this.attack = attack;
        this.modernWeapon = modernWeapon;
        this.inventory = inventory;
    }

    public void performAttack(Hero target) {
        if (attack != null) {
            System.out.println(attack.attack(this, target));
        }
    }

    public static HeroBuilder builder(String name, TypeHero typeHero) {
        return new HeroBuilder(name, typeHero);
    }

    public static class HeroBuilder {
        private final String name;
        private final TypeHero typeHero;
        private int health = 100;
        private int damage = 10;
        private AttackStrategy attack = new MeleeStrategy();
        private ModernWeapon modernWeapon;
        private Inventory inventory = new OrdinaryInventory(5);

        HeroBuilder(String name, TypeHero typeHero) {
            this.name = name;
            this.typeHero = typeHero;
        }

        public HeroBuilder health(int health) {
            this.health = health;
            return this;
        }

        public HeroBuilder damage(int damage) {
            this.damage = damage;
            return this;
        }

        public HeroBuilder attack(AttackStrategy attack) {
            this.attack = attack;
            return this;
        }

        public HeroBuilder modernWeapon(ModernWeapon modernWeapon) {
            this.modernWeapon = modernWeapon;
            return this;
        }

        public HeroBuilder inventory(Inventory inventory) {
            this.inventory = inventory;
            return this;
        }

        public Hero build() {
            return new Hero(this.name, this.typeHero, this.health, this.damage, this.attack, this.modernWeapon, this.inventory);
        }
    }
}
