package sample;

import javafx.scene.image.Image;

public class Pokemon {
    private int maxLife;
    private int actualLife;
    private int lvl;
    private String name;
    private Image imagen;

    public Pokemon(String name ,int maxLife, int actualLife, int lvl,Image imagen) {
        this.maxLife = maxLife;
        this.actualLife = actualLife;
        this.lvl = lvl;
        this.name = name;
        this.imagen = imagen;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
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

    @Override
    public String toString() {
        return "Pokemon{" +
                "maxLife=" + maxLife +
                ", actualLife=" + actualLife +
                ", lvl=" + lvl +
                ", name='" + name + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
