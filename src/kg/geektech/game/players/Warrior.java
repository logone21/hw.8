package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Warrior extends Hero {

    public Warrior(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        int umnojil = RPG_Game.random.nextInt(2) + 3;
        this.setDamage(this.getDamage() * umnojil);
        System.out.println("Варвар приумножил свой damage на: [" + umnojil + "]");

    }
}
