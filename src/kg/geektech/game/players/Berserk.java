package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {

    private int savedDamage;

    public Berserk(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    public int getSavedDamage() {
        return savedDamage;
    }

    public void setSavedDamage(int savedDamage) {
        this.savedDamage = savedDamage;
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        int block = RPG_Game.random.nextInt(50) + 1;
        this.setHealth(this.getHealth() + block);
        boss.setHealth(boss.getHealth() - block);
        System.out.println("Берсеерк Поглотил: [" + block + "] damage!");

    }
}
