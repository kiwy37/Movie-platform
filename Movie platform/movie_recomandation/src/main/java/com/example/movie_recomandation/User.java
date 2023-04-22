package com.example.movie_recomandation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class User extends GeneralUser{
    Set<String> moviesLiked=new HashSet<>();
    public void deleteLikeToDB(String m){
    // Declare a variable for the connection
    Connection connection = null;

    // Try-with-resources block to automatically close the connection when done
        try {
        // Load the JDBC driver
        Class.forName("org.postgresql.Driver");

        // Create the connection using the URL, username, and password
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

        // Create the UPDATE statement with a WHERE clause to specify the movie to update
        String sql = "UPDATE movies SET likes = likes-1 WHERE movie = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, m);

        // Execute the UPDATE statement
        statement.executeUpdate();

    } catch (SQLException | ClassNotFoundException e) {
        // Print the error message if an exception is thrown
        System.err.println(e.getMessage());
    } finally {
        // Close the connection if it is not null
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Print the error message if an exception is thrown
                System.err.println(e.getMessage());
            }
        }
    }
}
    public void addLikeToDB(String m){
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            // Create the UPDATE statement with a WHERE clause to specify the movie to update
            //ccc
            String sql = "UPDATE movies SET likes = likes+1 WHERE movie = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, m);

            // Execute the UPDATE statement
            statement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            // Print the error message if an exception is thrown
            System.err.println(e.getMessage());
        } finally {
            // Close the connection if it is not null
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Print the error message if an exception is thrown
                    System.err.println(e.getMessage());
                }
            }
        }
    }


    public void addLikeMovie(Movie m){
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            String sql = "SELECT COUNT(*) FROM userlikes";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Create the Prepared Statement
            String insertSql = "INSERT INTO userlikes (username,movie) VALUES (?,?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);

            insertStatement.setString(1, getName());
            insertStatement.setString(2, m.getMovie());

            // Execute the Prepared Statement
            insertStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            // Print the error message if an exception is thrown
            System.err.println(e.getMessage());
        } finally {
            // Close the connection if it is not null
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Print the error message if an exception is thrown
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    private void addLikeMovieInDB(Movie m){
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            String sql = "SELECT COUNT(*) FROM userlikes";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Create the Prepared Statement
            String insertSql = "INSERT INTO userlikes (username,movie) VALUES (?,?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);

            insertStatement.setString(1, getName());
            insertStatement.setString(2, m.getMovie());

            // Execute the Prepared Statement
            insertStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            // Print the error message if an exception is thrown
            System.err.println(e.getMessage());
        } finally {
            // Close the connection if it is not null
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Print the error message if an exception is thrown
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    private void deleteLikeMovieFromDB(Movie m){
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            String sql = "SELECT COUNT(*) FROM userlikes";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Create the Prepared Statement
            String insertSql = "DELETE FROM userlikes WHERE username = ? AND movie = ?";
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);

            insertStatement.setString(1, getName());
            insertStatement.setString(2, m.getMovie());

            // Execute the Prepared Statement
            insertStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            // Print the error message if an exception is thrown
            System.err.println(e.getMessage());
        } finally {
            // Close the connection if it is not null
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Print the error message if an exception is thrown
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    public Set<String> getCategoryLiked() {
        Set<String> lista = new HashSet<>();
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            // Create the Prepared Statement
            String selectSql = "SELECT distinct m.category FROM movies m JOIN userlikes ul ON ul.movie = m.movie JOIN userr u ON u.name = ul.username WHERE u.name = '"+getName()+"' GROUP BY m.category";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);

            // Execute the Prepared Statement and retrieve the ResultSet
            ResultSet resultSet = selectStatement.executeQuery();

            // Iterate through the ResultSet and create a grid for each movie
            while (resultSet.next()) {
                String gen = resultSet.getString("category");
                lista.add(gen);
            }

        } catch (SQLException | ClassNotFoundException e) {
            // Print the error message if an exception is thrown
            System.err.println(e.getMessage());
        } finally {
            // Close the connection if it is not null
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Print the error message if an exception is thrown
                    System.err.println(e.getMessage());
                }
            }
        }
        return lista;
    }
    public void displayCategoryByDate(){
        // Declare a variable for the connection
        Connection connection = null;

        Set<String> genapreciat=getCategoryLiked();

        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            // Create the Prepared Statement
            String selectSql = "SELECT * FROM movies ORDER BY category, release_date desc";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);

            // Execute the Prepared Statement and retrieve the ResultSet
            ResultSet resultSet = selectStatement.executeQuery();

            // Create a new stage for the movies
            Stage moviesStage = new Stage();
            moviesStage.setTitle("Movies");

            // Create a ScrollPane to hold the movies
            ScrollPane scrollPane = new ScrollPane();

            // Create a VBox to hold the movies
            VBox moviesBox = new VBox();
            moviesBox.setSpacing(10);
            moviesBox.setPadding(new Insets(10));

            // Iterate through the ResultSet and create a grid for each movie
            while (resultSet.next()) {
                String movie = resultSet.getString("movie");
                String category = resultSet.getString("category");
                Date releaseDate = resultSet.getDate("release_date");
                long likes = resultSet.getLong("likes");

                if(genapreciat.contains(category)) {
                    // Create a grid for the movie
                    GridPane grid = new GridPane();
                    grid.setHgap(10);
                    grid.setVgap(10);
                    grid.setPadding(new Insets(10));

                    // Create labels for the movie's attributes
                    Label movieLabel = new Label("Movie: " + movie);
                    Label categoryLabel = new Label("Category: " + category);
                    Label releaseDateLabel = new Label("Release Date: " + releaseDate);
                    Label likesLabel = new Label("Likes: " + likes);

                    // Create a "Like" button
                    ToggleButton likeButton = new ToggleButton("Like");
                    likeButton.setSelected(false);
                    likeButton.setTextFill(Color.GRAY);

                    Set<String> listaAprrecieri = returnList();
                    if (listaAprrecieri.contains(movie)) {
                        likeButton.setSelected(true);
                        likeButton.setTextFill(Color.BLUE);
                    }

                    likeButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if (likeButton.isSelected()) {
                                likeButton.setTextFill(Color.BLUE);
                                Movie m = new Movie();
                                m.setMovie(movie);
                                addLikeMovieInDB(m);
                                addLikeToDB(movie);
                                addMovie(movie);

                            } else {
                                likeButton.setTextFill(Color.GRAY);
                                Movie m = new Movie();
                                m.setMovie(movie);
                                deleteLikeMovieFromDB(m);
                                deleteLikeToDB(movie);
                                deleteMovie(movie);
                            }
                        }
                    });

                    // Add the labels and button to the grid
                    grid.add(movieLabel, 0, 0);
                    grid.add(categoryLabel, 0, 1);
                    grid.add(releaseDateLabel, 0, 2);
                    grid.add(likesLabel, 0, 3);
                    grid.add(likeButton, 1, 0, 1, 4);
                    // Add the grid to the VBox
                    moviesBox.getChildren().add(grid);
                }
            }


            resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                String movie = resultSet.getString("movie");
                String category = resultSet.getString("category");
                Date releaseDate = resultSet.getDate("release_date");
                long likes = resultSet.getLong("likes");

                if(!genapreciat.contains(category)) {
                    // Create a grid for the movie
                    GridPane grid = new GridPane();
                    grid.setHgap(10);
                    grid.setVgap(10);
                    grid.setPadding(new Insets(10));

                    // Create labels for the movie's attributes
                    Label movieLabel = new Label("Movie: " + movie);
                    Label categoryLabel = new Label("Category: " + category);
                    Label releaseDateLabel = new Label("Release Date: " + releaseDate);
                    Label likesLabel = new Label("Likes: " + likes);

                    // Create a "Like" button
                    ToggleButton likeButton = new ToggleButton("Like");
                    likeButton.setSelected(false);
                    likeButton.setTextFill(Color.GRAY);

                    Set<String> listaAprrecieri = returnList();
                    if (listaAprrecieri.contains(movie)) {
                        likeButton.setSelected(true);
                        likeButton.setTextFill(Color.BLUE);
                    }

                    likeButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if (likeButton.isSelected()) {
                                likeButton.setTextFill(Color.BLUE);
                                Movie m = new Movie();
                                m.setMovie(movie);
                                addLikeMovieInDB(m);
                                addMovie(movie);

                            } else {
                                likeButton.setTextFill(Color.GRAY);
                                Movie m = new Movie();
                                m.setMovie(movie);
                                deleteLikeMovieFromDB(m);
                                deleteMovie(movie);
                            }
                        }
                    });

                    // Add the labels and button to the grid
                    grid.add(movieLabel, 0, 0);
                    grid.add(categoryLabel, 0, 1);
                    grid.add(releaseDateLabel, 0, 2);
                    grid.add(likesLabel, 0, 3);
                    grid.add(likeButton, 1, 0, 1, 4);
                    // Add the grid to the VBox
                    moviesBox.getChildren().add(grid);
                }
            }
            // Add the movies box to the ScrollPane
            scrollPane.setContent(moviesBox);

            // Add the ScrollPane to the scene and show the stage
            Scene scene = new Scene(scrollPane, 500, 500);
            moviesStage.setScene(scene);
            moviesStage.show();
        } catch (SQLException | ClassNotFoundException e) {
            // Print the error message if an exception is thrown
            System.err.println(e.getMessage());
        } finally {
            // Close the connection if it is not null
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Print the error message if an exception is thrown
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    public void displayCategoryByLike(){
        // Declare a variable for the connection
        Connection connection = null;

        Set<String> genapreciat=getCategoryLiked();

        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            // Create the Prepared Statement
            String selectSql = "SELECT * FROM movies ORDER BY category, likes desc";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);

            // Execute the Prepared Statement and retrieve the ResultSet
            ResultSet resultSet = selectStatement.executeQuery();

            // Create a new stage for the movies
            Stage moviesStage = new Stage();
            moviesStage.setTitle("Movies");

            // Create a ScrollPane to hold the movies
            ScrollPane scrollPane = new ScrollPane();

            // Create a VBox to hold the movies
            VBox moviesBox = new VBox();
            moviesBox.setSpacing(10);
            moviesBox.setPadding(new Insets(10));

            // Iterate through the ResultSet and create a grid for each movie
            while (resultSet.next()) {
                String movie = resultSet.getString("movie");
                String category = resultSet.getString("category");
                Date releaseDate = resultSet.getDate("release_date");
                long likes = resultSet.getLong("likes");

                if(genapreciat.contains(category)) {
                    // Create a grid for the movie
                    GridPane grid = new GridPane();
                    grid.setHgap(10);
                    grid.setVgap(10);
                    grid.setPadding(new Insets(10));

                    // Create labels for the movie's attributes
                    Label movieLabel = new Label("Movie: " + movie);
                    Label categoryLabel = new Label("Category: " + category);
                    Label releaseDateLabel = new Label("Release Date: " + releaseDate);
                    Label likesLabel = new Label("Likes: " + likes);

                    // Create a "Like" button
                    ToggleButton likeButton = new ToggleButton("Like");
                    likeButton.setSelected(false);
                    likeButton.setTextFill(Color.GRAY);

                    Set<String> listaAprrecieri = returnList();
                    if (listaAprrecieri.contains(movie)) {
                        likeButton.setSelected(true);
                        likeButton.setTextFill(Color.BLUE);
                    }

                    likeButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if (likeButton.isSelected()) {
                                likeButton.setTextFill(Color.BLUE);
                                Movie m = new Movie();
                                m.setMovie(movie);
                                addLikeMovieInDB(m);
                                addLikeToDB(movie);
                                addMovie(movie);

                            } else {
                                likeButton.setTextFill(Color.GRAY);
                                Movie m = new Movie();
                                m.setMovie(movie);
                                deleteLikeMovieFromDB(m);
                                deleteLikeToDB(movie);
                                deleteMovie(movie);
                            }
                        }
                    });

                    // Add the labels and button to the grid
                    grid.add(movieLabel, 0, 0);
                    grid.add(categoryLabel, 0, 1);
                    grid.add(releaseDateLabel, 0, 2);
                    grid.add(likesLabel, 0, 3);
                    grid.add(likeButton, 1, 0, 1, 4);
                    // Add the grid to the VBox
                    moviesBox.getChildren().add(grid);
                }
            }


            resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                String movie = resultSet.getString("movie");
                String category = resultSet.getString("category");
                Date releaseDate = resultSet.getDate("release_date");
                long likes = resultSet.getLong("likes");

                if(!genapreciat.contains(category)) {
                    // Create a grid for the movie
                    GridPane grid = new GridPane();
                    grid.setHgap(10);
                    grid.setVgap(10);
                    grid.setPadding(new Insets(10));

                    // Create labels for the movie's attributes
                    Label movieLabel = new Label("Movie: " + movie);
                    Label categoryLabel = new Label("Category: " + category);
                    Label releaseDateLabel = new Label("Release Date: " + releaseDate);
                    Label likesLabel = new Label("Likes: " + likes);

                    // Create a "Like" button
                    ToggleButton likeButton = new ToggleButton("Like");
                    likeButton.setSelected(false);
                    likeButton.setTextFill(Color.GRAY);

                    Set<String> listaAprrecieri = returnList();
                    if (listaAprrecieri.contains(movie)) {
                        likeButton.setSelected(true);
                        likeButton.setTextFill(Color.BLUE);
                    }

                    likeButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if (likeButton.isSelected()) {
                                likeButton.setTextFill(Color.BLUE);
                                Movie m = new Movie();
                                m.setMovie(movie);
                                addLikeMovieInDB(m);
                                addMovie(movie);

                            } else {
                                likeButton.setTextFill(Color.GRAY);
                                Movie m = new Movie();
                                m.setMovie(movie);
                                deleteLikeMovieFromDB(m);
                                deleteMovie(movie);
                            }
                        }
                    });

                    // Add the labels and button to the grid
                    grid.add(movieLabel, 0, 0);
                    grid.add(categoryLabel, 0, 1);
                    grid.add(releaseDateLabel, 0, 2);
                    grid.add(likesLabel, 0, 3);
                    grid.add(likeButton, 1, 0, 1, 4);
                    // Add the grid to the VBox
                    moviesBox.getChildren().add(grid);
                }
            }
            // Add the movies box to the ScrollPane
            scrollPane.setContent(moviesBox);

            // Add the ScrollPane to the scene and show the stage
            Scene scene = new Scene(scrollPane, 500, 500);
            moviesStage.setScene(scene);
            moviesStage.show();
        } catch (SQLException | ClassNotFoundException e) {
            // Print the error message if an exception is thrown
            System.err.println(e.getMessage());
        } finally {
            // Close the connection if it is not null
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Print the error message if an exception is thrown
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    public void pushInList(String s){
        moviesLiked.add(s);
    }
    public Set<String> returnList(){
        return moviesLiked;
    }
    public void addMovie(String m){
        moviesLiked.add(m);
    }
    public void deleteMovie(String m){
        moviesLiked.remove(m);
    }
    public void displayLikes() {
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            // Create the Prepared Statement
            String selectSql = "SELECT * FROM movies";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);

            // Execute the Prepared Statement and retrieve the ResultSet
            ResultSet resultSet = selectStatement.executeQuery();

            // Create a new stage for the movies
            Stage moviesStage = new Stage();
            moviesStage.setTitle("Filme apreciate de dvs");

            // Create a ScrollPane to hold the movies
            ScrollPane scrollPane = new ScrollPane();

            // Create a VBox to hold the movies
            VBox moviesBox = new VBox();
            moviesBox.setSpacing(10);
            moviesBox.setPadding(new Insets(10));

            // Iterate through the ResultSet and create a grid for each movie
            while (resultSet.next()) {
                String movie = resultSet.getString("movie");
                String category = resultSet.getString("category");
                Date releaseDate = resultSet.getDate("release_date");
                long likes = resultSet.getLong("likes");

                    if (moviesLiked.contains(movie)) {
                        // Create a grid for the movie
                        GridPane grid = new GridPane();
                        grid.setHgap(10);
                        grid.setVgap(10);
                        grid.setPadding(new Insets(10));

                        // Create labels for the movie's attributes
                        Label movieLabel = new Label("Movie: " + movie);
                        Label categoryLabel = new Label("Category: " + category);
                        Label releaseDateLabel = new Label("Release Date: " + releaseDate);
                        Label likesLabel = new Label("Likes: " + likes);

                        // Add the labels and button to the grid
                        grid.add(movieLabel, 0, 0);
                        grid.add(categoryLabel, 0, 1);
                        grid.add(releaseDateLabel, 0, 2);
                        grid.add(likesLabel, 0, 3);
                        // Add the grid to the VBox
                        moviesBox.getChildren().add(grid);
                    }
            }


            // Add the movies box to the ScrollPane
            scrollPane.setContent(moviesBox);

            // Add the ScrollPane to the scene and show the stage
            Scene scene = new Scene(scrollPane, 500, 500);
            moviesStage.setScene(scene);
            moviesStage.show();
        } catch (SQLException | ClassNotFoundException e) {
            // Print the error message if an exception is thrown
            System.err.println(e.getMessage());
        } finally {
            // Close the connection if it is not null
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Print the error message if an exception is thrown
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    public void getMovies() {
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            // Create the Prepared Statement
            String selectSql = "SELECT * FROM userlikes WHERE username='"+getName()+"'";
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);

            // Execute the Prepared Statement and retrieve the ResultSet
            ResultSet resultSet = selectStatement.executeQuery();

            // Iterate through the ResultSet and create a grid for each movie
            while (resultSet.next()) {
                String moviename = resultSet.getString("movie");
                moviesLiked.add(moviename);
            }

        } catch (SQLException | ClassNotFoundException e) {
            // Print the error message if an exception is thrown
            System.err.println(e.getMessage());
        } finally {
            // Close the connection if it is not null
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Print the error message if an exception is thrown
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
