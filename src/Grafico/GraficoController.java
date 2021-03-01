package Grafico;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import sample.Pokemon_controller;

public class GraficoController {

    @FXML
    public PieChart PieDano;
    @FXML
    public BarChart barPokemon;

    public static int danoEnemigo = 0;

    public static int danoMio = 0;

    @FXML
    public void initialize(){
        ObservableList<PieChart.Data> pieData
                = FXCollections.observableArrayList(
                new PieChart.Data("Daño enemigo",danoEnemigo),
                new PieChart.Data("Daño Mio",danoMio)
        );
        PieDano.setData(pieData);
    }

    public void danoUpdate(int danoEnemigo,int danoMio){
        danoEnemigo += danoEnemigo;
        danoMio += danoMio;

        ObservableList<PieChart.Data> pieData
                = FXCollections.observableArrayList(
                new PieChart.Data("Daño enemigo",danoEnemigo),
                new PieChart.Data("Daño Mio",danoMio)
        );
    }
    public void controlBarras(Pokemon_controller pokemonController){
        XYChart.Series pokemon1 = new XYChart.Series<>();
        pokemon1.setName(pokemonController.pokemons.get(0).name);
        pokemon1.getData().add(new XYChart.Data("",pokemonController.vecesSeleccionPokemon[0]));
        barPokemon.getData().addAll(pokemon1);

        XYChart.Series pokemon2 = new XYChart.Series<>();
        pokemon2.setName(pokemonController.pokemons.get(1).name);
        pokemon2.getData().add(new XYChart.Data("",pokemonController.vecesSeleccionPokemon[1]));
        barPokemon.getData().addAll(pokemon2);

        XYChart.Series pokemon3 = new XYChart.Series<>();
        pokemon3.setName(pokemonController.pokemons.get(2).name);
        pokemon3.getData().add(new XYChart.Data("",pokemonController.vecesSeleccionPokemon[2]));
        barPokemon.getData().addAll(pokemon3);

        XYChart.Series pokemon4 = new XYChart.Series<>();
        pokemon4.setName(pokemonController.pokemons.get(3).name);
        pokemon4.getData().add(new XYChart.Data("",pokemonController.vecesSeleccionPokemon[3]));
        barPokemon.getData().addAll(pokemon4);

        XYChart.Series pokemon5 = new XYChart.Series<>();
        pokemon5.setName(pokemonController.pokemons.get(4).name);
        pokemon5.getData().add(new XYChart.Data("",pokemonController.vecesSeleccionPokemon[4]));
        barPokemon.getData().addAll(pokemon5);

        XYChart.Series pokemon6 = new XYChart.Series<>();
        pokemon6.setName(pokemonController.pokemons.get(5).name);
        pokemon6.getData().add(new XYChart.Data("",pokemonController.vecesSeleccionPokemon[5]));
        barPokemon.getData().addAll(pokemon6);
    }

}
