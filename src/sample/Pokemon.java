package sample;

public class Pokemon {
    private int maxLife;
    private int actualLife;
    private int lvl;
    private String name;

    public Pokemon(String name ,int maxLife, int actualLife, int lvl) {
        this.maxLife = maxLife;
        this.actualLife = actualLife;
        this.lvl = lvl;
        this.name = name;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getActualLife() {
        return actualLife;
    }

    public void setActualLife(int actualLife) {
        this.actualLife = actualLife;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
