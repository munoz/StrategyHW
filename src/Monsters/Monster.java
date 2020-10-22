package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public abstract class Monster {

    private Integer hp;
    private Integer xp;
    Integer agi = 5;
    Integer def = 5;
    Integer str = 5;
    Attack attack;
    private Integer maxHP;
    private HashMap<String, Integer> items;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
    }

    public Integer getAgi() { return agi; }

    public Integer getDef() { return def; }

    public Integer getStr() { return str; }

    public Integer getXp() {
        return xp;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    public Integer attackTarget(Monster target) {
        return attack.attack(target);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return hp.equals(monster.hp) &&
                xp.equals(monster.xp) &&
                agi.equals(monster.agi) &&
                def.equals(monster.def) &&
                str.equals(monster.str) &&
                attack.equals(monster.attack) &&
                maxHP.equals(monster.maxHP) &&
                items.equals(monster.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, xp, agi, def, str, attack, maxHP, items);
    }

    @Override
    public String toString() {
        return "hp=" + hp + "/" + maxHP;
    }

    //toString() output
    //Monsters.Imp has : hp=15/15
    //Monsters.Kobold has : hp=1/1


    /**
     * This method returns an integer value between min and max.
     * This is goofy. rand.nextInt(n) returns a number between 0-n
     * to get the value we want, a value between str - maxStr,
     * We need to get a random number from maxStr-str and
     * add str back in.
     * @param min an integer
     * @param max an integer
     * @return a random integer between min and max
     */

    Integer getAttribute(Integer min, Integer max) {
        Random rand = new Random();
        if(min > max) {
            Integer temp = min;
            min = max;
            max = temp;
        }
        //returns a random number between min and max inclusive
        return rand.nextInt(max-min) + min;
    }

}
