package sample;

import Batalla.PokeBatalla_controller;
import Grafico.GraficoController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Pokemon_controller {
    // botoncillo
    @FXML
    Button nextButton;
    @FXML
    Button BotonGrafico;
    @FXML
    GridPane fondoSeleccion;
    //labels de nombre

    @FXML
    ImageView pokemonImage_1;
    @FXML
    ImageView pokemonImage_2;
    @FXML
    ImageView pokemonImage_3;
    @FXML
    ImageView pokemonImage_4;
    @FXML
    ImageView pokemonImage_5;
    @FXML
    ImageView pokemonImage_6;

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

    /* Variables de ambito global para usar en todos los metodos */
    ArrayList<Label> pokeData = new ArrayList<Label>();
    public ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    public int[] vecesSeleccionPokemon = new int[6];

    /* VARIABLES USADAS PARA MANEJAR POKEMONS DEL ARRAY*/

    public String idPoke;
    public int selectedPoke;
    public ProgressBar psBarSelected;
    // Metodo de inicio.
    @FXML
    public void initialize() {
        pokemons.add(new Pokemon("Bulbasaur", 220, 220, 20,new Image("sprites/bulbasaur.png")));
        pokemons.add(new Pokemon("Ivysaur", 300, 300, 65,new Image("sprites/ivysaur.png")));
        pokemons.add(new Pokemon("Venasaur", 320, 320, 100,new Image("sprites/venusaur.png")));
        pokemons.add(new Pokemon("Charmander", 60, 60, 10,new Image("sprites/charmander.png")));
        pokemons.add(new Pokemon("Charmaleon", 200, 200, 65,new Image("sprites/charmeleon.png")));
        pokemons.add(new Pokemon("Charizard", 320, 320, 99,new Image("sprites/charizard.png")));

        // inicializacion de las celdas con los pokemons
        initializeCell(pokemonName_1, pokemonLife_1, pokemonLvl_1, pokemonImage_1, pokemons.get(0));
        initializeCell(pokemonName_2, pokemonLife_2, pokemonLvl_2, pokemonImage_2, pokemons.get(1));
        initializeCell(pokemonName_3, pokemonLife_3, pokemonLvl_3, pokemonImage_3, pokemons.get(2));
        initializeCell(pokemonName_4, pokemonLife_4, pokemonLvl_4, pokemonImage_4, pokemons.get(3));
        initializeCell(pokemonName_5, pokemonLife_5, pokemonLvl_5, pokemonImage_5, pokemons.get(4));
        initializeCell(pokemonName_6, pokemonLife_6, pokemonLvl_6, pokemonImage_6, pokemons.get(5));

    }

    public void initializeCell(Label pokeName, Label pokeLife, Label pokeLvl, ImageView imagen ,Pokemon pokemon) {
        // Set de los atributos.
        pokeName.setText(pokemon.getName());
        pokeLife.setText(pokemon.getActualLife() + "/" + pokemon.getMaxLife());
        pokeLvl.setText(Integer.toString(pokemon.getLvl()));
        imagen.setImage(pokemon.getImagen());
    }
    /*Metodos que son llamados al pulsar*/
    @FXML
    public void onClickBasura() {
        dropeo(pokemonName_1, pokemonLife_1, pokemonLvl_1);
        dropeo(pokemonName_2, pokemonLife_2, pokemonLvl_2);
        dropeo(pokemonName_3, pokemonLife_3, pokemonLvl_3);
        dropeo(pokemonName_4, pokemonLife_4, pokemonLvl_4);
        dropeo(pokemonName_5, pokemonLife_5, pokemonLvl_5);
        dropeo(pokemonName_6, pokemonLife_6, pokemonLvl_6);
        nextButton.setDisable(true);
    }

    /*
     * Metodo que "elige" al pokemon que se pincha, cambiando colores etc.
     *
     * @param  event parametro tipo MouseEvent
     */
    @FXML
    public void onClickPokemon(MouseEvent event) {
        pokeData = new ArrayList<Label>();
        VBox box = (VBox) event.getSource();
        pokeData = iterateChildrens(box);
        selectPoke((Label) pokeData.get(0), (Label) pokeData.get(1), (Label) pokeData.get(2));
        vecesSeleccionPokemon[Integer.parseInt(idPoke)]++;
    }
    public void onClickNext() throws IOException {
        getPokemonId();
        psBarSelected = (ProgressBar) fondoSeleccion.getScene().lookup("#psBar_"+String.valueOf(selectedPoke+1));
        PokeBatalla_controller controllerBatalla = startPokeBatalla(); // obtengo el controller
        controllerBatalla.getPokemon(pokemons.get(selectedPoke),this); // envio de datos

    }
    /*Metodos que se ejecutan dentro de un "listener" para obtener datos y cambiar o enviar datos.*/
    /*
     * Devuelve un array con todos los objetos tipo label dentro del vbox que conforma a los pokemon
     *
     * @param  nodo  parametro tipo VBox que es el layout que conforma Pokemon
     * @return      ArrayList de objetos tipo Label
     */
    public ArrayList<Label> iterateChildrens(VBox nodo) {
        ArrayList<Label> childrens = new ArrayList<Label>();
        for (Node node : nodo.getChildren()) {
            if (node instanceof GridPane) {
                for (Node child : ((GridPane) node).getChildren())
                    if (!(child instanceof ProgressBar) && child.getId() != null) {
                        childrens.add((Label) child);
                    }
            }
        }
        return childrens;
    }

    /*
     *  Metodo que nos permite seleccionar el pokemon sobre el cual se pincha.
     *
     * @param  porcentaje  parametro tipo Double usado para determinar el color
     * @return  ColorAdjust objeto que permite cambiar el color.
     */
    public void selectPoke(Label pokeName, Label pokeLvl, Label pokeLife) {
        onClickBasura();
        nextButton.setDisable(false);
        pokeName.setTextFill(Color.VIOLET);
        pokeLife.setTextFill(Color.VIOLET);
        pokeLvl.setTextFill(Color.VIOLET);
    }

    public void getPokemonId(){
        idPoke = pokeData.get(0).getId();
        selectedPoke = Character.getNumericValue(idPoke.charAt(idPoke.length()-1)-1);
    }

    // sacado la creacion de la nueva pantalla por comidad en caso de tener que modificar , modularicaciooonnnnn!!!!!
    public PokeBatalla_controller startPokeBatalla() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Batalla/PokeBatalla.fxml"));
        GridPane rootBatalla =  (GridPane) loader.load();
        Scene scene = new Scene(rootBatalla);
        stage.setScene(scene);
        stage.show();
        return loader.getController();
    }

    public void updatePokemon(){
        pokeData.get(2).setText(pokemons.get(selectedPoke).getMaxLife() +"/"+ pokemons.get(selectedPoke).getActualLife());

        if(pokemons.get(selectedPoke).getActualLife() == 0){
            fondoSeleccion.getScene().lookup("#pokemonLayout_"+String.valueOf(selectedPoke+1)).setDisable(true);
            psBarSelected.setProgress(0);
        }
    }

    public void dropeo(Label pokeName, Label pokeLife, Label pokeLvl) {
        pokeName.setTextFill(Color.WHITE);
        pokeLife.setTextFill(Color.WHITE);
        pokeLvl.setTextFill(Color.WHITE);
    }

    public void abrirGraficos(MouseEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BarrasGrafico.fxml"));
            HBox root = (HBox) loader.load();
            stage.show();

            GraficoController graficoController = loader.getController();
            graficoController.controlBarras(this);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
