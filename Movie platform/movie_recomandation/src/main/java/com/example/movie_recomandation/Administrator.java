package com.example.movie_recomandation;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Administrator extends GeneralUser
{
    List<Movie> moviesAdded=new ArrayList<>();
    public void addMovie(Movie m) {
        moviesAdded.add(m);
    }
    public void displayMovies() {
        // Create a new stage for the movies
        Stage moviesStage = new Stage();
        moviesStage.setTitle("Filme adaugate in aceasta sesiune");

        // Create a ScrollPane to hold the movies
        ScrollPane scrollPane = new ScrollPane();

        // Create a VBox to hold the movies
        VBox moviesBox = new VBox();
        moviesBox.setSpacing(10);
        moviesBox.setPadding(new Insets(10));

        // Iterate through the ResultSet and create a grid for each movie
        for (Movie m : moviesAdded) {

            // Create a grid for the movie
            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(10));

            // Create labels for the movie's attributes
            Label movieLabel = new Label("Movie: " + m.getMovie());
            Label categoryLabel = new Label("Category: " + m.getCategory());
            Label releaseDateLabel = new Label("Release Date: " + m.getReleaseDate());
            Label likesLabel = new Label("Likes: " + m.getLikes());


            // Add the labels and button to the grid
            grid.add(movieLabel, 0, 0);
            grid.add(categoryLabel, 0, 1);
            grid.add(releaseDateLabel, 0, 2);
            grid.add(likesLabel, 0, 3);
            // Add the grid to the VBox
            moviesBox.getChildren().add(grid);
        }

        // Add the movies box to the ScrollPane
        scrollPane.setContent(moviesBox);

        // Add the ScrollPane to the scene and show the stage
        Scene scene = new Scene(scrollPane, 500, 500);
        moviesStage.setScene(scene);
        moviesStage.show();
    }
}
