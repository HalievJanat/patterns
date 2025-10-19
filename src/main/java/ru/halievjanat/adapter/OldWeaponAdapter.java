package ru.halievjanat.adapter;

import lombok.AllArgsConstructor;
import ru.halievjanat.builder.Hero;

@AllArgsConstructor
public class OldWeaponAdapter implements ModernWeapon {
    private OldWeapon oldWeapon;

    @Override
    public String use(Hero user, Hero target) {
        int damage = oldWeapon.getDamage();
        if (oldWeapon.getDurability() == 0) {
            return "Оружие сломано!";
        }
        oldWeapon.use();

        target.setHealth(target.getHealth() - damage);

        return String.format("%s использует %s и наносит %d урона %s!",
                user.getName(), oldWeapon.getName(), damage, target.getName());
    }
}
