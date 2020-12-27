package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.awt.event.MouseEvent;


public class Pokemon_controller {
    // botoncillo
    @FXML
    Button nextButton;

    //labels de nombre
    @FXML
    Label pokemonName_1;
    @FXML
    Label pokemonName_2;
    @FXML
    Label pokemonName_3;
    @FXML
    Label pokemonName_4;
    @FXML
    Label pokemonName_5;
    @FXML
    Label pokemonName_6;

    //labels de nivel
    @FXML
    Label pokemonLvl_1;
    @FXML
    Label pokemonLvl_2;
    @FXML
    Label pokemonLvl_3;
    @FXML
    Label pokemonLvl_4;
    @FXML
    Label pokemonLvl_5;
    @FXML
    Label pokemonLvl_6;

    //progresbar vida
    @FXML
    ProgressBar psBar_1;
    @FXML
    ProgressBar psBar_2;
    @FXML
    ProgressBar psBar_3;
    @FXML
    ProgressBar psBar_4;
    @FXML
    ProgressBar psBar_5;
    @FXML
    ProgressBar psBar_6;


    //label vida
    @FXML
    Label pokemonLife_1;
    @FXML
    Label pokemonLife_2;
    @FXML
    Label pokemonLife_3;
    @FXML
    Label pokemonLife_4;
    @FXML
    Label pokemonLife_5;
    @FXML
    Label pokemonLife_6;

    int porcentaje = 0;
    //INICIO DE PROGRAMA, SETEAMOS
    @FXML
    public void initialize(){
        // nombre vidamaxima vidaactual lvl
        Pokemon poke1 = new Pokemon("Bulbasaur",220,130,20);
        Pokemon poke2 = new Pokemon("Ivysaur",300,300,65);
        Pokemon poke3 = new Pokemon("Venasaur",320,200,100);
        Pokemon poke4 = new Pokemon("Charmander",60,20,10);
        Pokemon poke5 = new Pokemon("Charmaleon",200,180,65);
        Pokemon poke6 = new Pokemon("Charizard",320,320,99);
        initializeCell(pokemonName_1,pokemonLife_1,pokemonLvl_1,psBar_1,poke1);
        initializeCell(pokemonName_2,pokemonLife_2,pokemonLvl_2,psBar_2,poke2);
        initializeCell(pokemonName_3,pokemonLife_3,pokemonLvl_3,psBar_3,poke3);
        initializeCell(pokemonName_4,pokemonLife_4,pokemonLvl_4,psBar_4,poke4);
        initializeCell(pokemonName_5,pokemonLife_5,pokemonLvl_5,psBar_5,poke5);
        initializeCell(pokemonName_6,pokemonLife_6,pokemonLvl_6,psBar_6,poke6);


    }
    public void initializeCell(Label pokeName,Label pokeLife, Label pokeLvl, ProgressBar pokePsBar , Pokemon pokemon){
        pokeName.setText(pokemon.getName());
        pokeLife.setText(pokemon.getActualLife()+"/"+pokemon.getMaxLife());
        pokeLvl.setText(Integer.toString(pokemon.getLvl()));
        porcentaje = (pokemon.getActualLife()*100)/pokemon.getMaxLife();
        ColorAdjust color = new ColorAdjust();
        color.setSaturation(0);
        if(porcentaje <= 50){
            color.setHue(0.80);
        }else if(porcentaje<=30){
            color.setHue(1);
        }else if(porcentaje <= 0){
            color.setSaturation(-1.0);
        }else{
            color.setHue(-0.60);
        }
        pokePsBar.setEffect(color);
        System.out.println((pokemon.getActualLife()*100)/pokemon.getMaxLife());
    }
    public void dropeo(Label pokeName,Label pokeLife,Label pokeLvl){
        pokeName.setTextFill(Color.WHITE);
        pokeLife.setTextFill(Color.WHITE);
        pokeLvl.setTextFill(Color.WHITE);
    }
    @FXML
    public void onClickBasura(){
        dropeo(pokemonName_1,pokemonLife_1,pokemonLvl_1);
        dropeo(pokemonName_2,pokemonLife_2,pokemonLvl_2);
        dropeo(pokemonName_3,pokemonLife_3,pokemonLvl_3);
        dropeo(pokemonName_4,pokemonLife_4,pokemonLvl_4);
        dropeo(pokemonName_5,pokemonLife_5,pokemonLvl_5);
        dropeo(pokemonName_6,pokemonLife_6,pokemonLvl_6);
        nextButton.setDisable(true);
    }
    public void selectPoke(Label pokeName,Label pokeLife,Label pokeLvl){
        onClickBasura();
        nextButton.setDisable(false);
        pokeName.setTextFill(Color.VIOLET);
        pokeLife.setTextFill(Color.VIOLET);
        pokeLvl.setTextFill(Color.VIOLET);
    }

    @FXML
    public void onClickPokemon_1(){
        selectPoke(pokemonName_1,pokemonLife_1,pokemonLvl_1);
    }

    @FXML
    public void onClickPokemon_2(){
        selectPoke(pokemonName_2,pokemonLife_2,pokemonLvl_2);
    }

    @FXML
    public void onClickPokemon_3(){
        selectPoke(pokemonName_3,pokemonLife_3,pokemonLvl_3);
    }

    @FXML
    public void onClickPokemon_4(){
        selectPoke(pokemonName_4,pokemonLife_4,pokemonLvl_4);
    }

    @FXML
    public void onClickPokemon_5(){
        selectPoke(pokemonName_5,pokemonLife_5,pokemonLvl_5);
    }

    @FXML
    public void onClickPokemon_6(){
        selectPoke(pokemonName_6,pokemonLife_6,pokemonLvl_6);
    }

}
