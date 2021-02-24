package Batalla;

import Grafico.GraficoController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.Pokemon;
import sample.Pokemon_controller;

import java.util.Random;

public class PokeBatalla_controller {
    Pokemon pokemon;
    Pokemon enemigo = new Pokemon("Bulbasaur", 220, 220, 20,new Image("sprites/bulbasaur.png"));
    GraficoController controllerGrafico;

    @FXML
    ImageView imagen_pokemon;
    @FXML
    Label name_poke;
    @FXML
    Label lvl_poke;
    @FXML
    ImageView image_enemigo;
    @FXML
    Label name_enemigo;
    @FXML
    Label lvl_enemigo;

    @FXML
    ProgressBar ps_enemy;
    @FXML
    ProgressBar ps_self;

    @FXML
    GridPane ataques_grid;
    Pokemon_controller pokemon_controller;

    Random rand = new Random();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public void getPokemon(Pokemon pokemon,Pokemon_controller pokemon_controller){
        this.pokemon = pokemon;
        setPokemonStats(imagen_pokemon,name_poke,lvl_poke,pokemon);
        setPokemonStats(image_enemigo,name_enemigo,lvl_enemigo,enemigo);

        this.pokemon_controller = pokemon_controller;
    }

    public void setPokemonStats(ImageView imagen,Label name,Label lvl,Pokemon pokemon){
        imagen.setImage(pokemon.getImagen()); // de momento es un bulbasaur de mierda
        name.setText(pokemon.getName());
        lvl.setText("Lvl:"+Integer.toString(pokemon.getLvl()));
    }

    // FUNCIONES MODIFICACION DE LA PANTALLA
    public void onClickAtaque(){
        ataques_grid.setVisible(true);
    }

    public void onClickCancelar(){
        ataques_grid.setVisible(false);
    }

    // FUNCIONES MODIFICACION DE DATOS.
    public void heal(){
        int toHeal = rand.nextInt(55)+25;

        if(pokemon.getActualLife() > 0 && enemigo.getActualLife() > 0){
            // guarrindongero pero...
            if(pokemon.getActualLife()+toHeal < pokemon.getMaxLife()){
                pokemon.setActualLife(pokemon.getActualLife()+rand.nextInt(55)+25);
            }else{
                pokemon.setActualLife(pokemon.getMaxLife());
            }
            if(enemigo.getActualLife()+toHeal < enemigo.getMaxLife()){
                enemigo.setActualLife(pokemon.getActualLife()+rand.nextInt(55)+25);
            }else{
                enemigo.setActualLife(enemigo.getMaxLife());
            }
        }
        changePsBar(enemigo,ps_enemy);
        changePsBar(pokemon,ps_self);
    }


    // - - - Ataques - - -
    public void attack(){
        executeAttack(pokemon,enemigo,20);
    }

    public void riskAttack(){
        executeAttack(pokemon,enemigo,rand.nextInt(15)+10);
    }

    public void veryRiskyAttack(){
        executeAttack(pokemon,enemigo,rand.nextInt(50));
    }

    public void executeAttack(Pokemon pokemon, Pokemon pokemon_enemigo,int damage){
        int lifeAfterDamage_poke = pokemon.getActualLife() - damage;
        int lifeAfterDamage_pokeEnemigo = pokemon_enemigo.getActualLife() - damage;

        if(lifeAfterDamage_poke > 0){
            pokemon_enemigo.setActualLife(lifeAfterDamage_pokeEnemigo);
            if(lifeAfterDamage_pokeEnemigo > 0){
                pokemon.setActualLife(lifeAfterDamage_poke);
            }else{
                alert.setContentText("Enhorabuena! has ganado a ese miserable pokemon roñoso enemigo !!"+
                                        "Muerte a esos malditos niños pescadores que siempre molestaban con sus batallitas");
                alert.showAndWait();
            }
        }else{
            pokemon.setActualLife(0);
            alert.setContentText("Diablos ha derrotado a tu pokemon...");
            alert.showAndWait();
        }
        changePsBar(enemigo,ps_enemy);
        changePsBar(pokemon,ps_self);
        /*Para testeo*/
        pokemon_controller.updatePokemon();
        updateDanoGrafico(damage,damage);
    }

    public void changePsBar(Pokemon pokemonToChange,ProgressBar psBar){
        Double porcentaje=(double) ((pokemonToChange.getActualLife() * 100) / pokemonToChange.getMaxLife()) / 100;
        psBar.setProgress(porcentaje);
    }

    public void updateDanoGrafico(int danoEnemigo,int danoMio){
        controllerGrafico.danoUpdate(danoEnemigo,danoMio);
    }
}
