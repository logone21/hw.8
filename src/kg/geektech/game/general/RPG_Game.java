package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int round_number;
    public static Random random = new Random();

    public static void startGame() {
        Boss boss = new Boss("Thanos", 1000, 50);

        Warrior warrior = new Warrior("Hercules", 270, 10);
        Medic doc = new Medic("Aibolot", 250, 5, 15);
        Magic magic = new Magic("Strange", 260, 20);
        Berserk berserk = new Berserk("Heracle", 240, 15);
        Medic assistant = new Medic("Vasya", 280, 10, 5);
        Hero[] heroes = {warrior, doc, magic, berserk, assistant};

        printStatistics(heroes, boss);

        while (!isGameFinished(heroes, boss)) {
            round(heroes, boss);
        }
    }

    private static void round(Hero[] heroes, Boss boss) {
        round_number++;
        fighting(heroes, boss);
        printStatistics(heroes, boss);
    }

    private static void fighting(Hero[] heroes, Boss boss) {
        boss.hit(heroes);
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].hit(boss);
            heroes[i].applySuperPower(heroes, boss);
        }
    }

    private static void printStatistics(Hero[] heroes, Boss boss) {
        if (round_number == 0) {
            System.out.println("BEFORE GAME START ______________");
        } else {
            System.out.println(round_number + " ROUND ______________");
        }
        System.out.println(boss.getName() + " BOSS health: " + boss.getHealth() + " ("
                + boss.getDamage() + ")");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName()
                    + " " + heroes[i].getClass().getSimpleName().toUpperCase()
                    + " health: " + heroes[i].getHealth() + " ("
                    + heroes[i].getDamage() + ")");
        }
    }

    private static boolean isGameFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}
