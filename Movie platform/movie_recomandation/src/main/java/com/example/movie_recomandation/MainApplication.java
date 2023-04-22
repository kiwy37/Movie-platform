package com.example.movie_recomandation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.sql.*;
import java.time.LocalDate;
import java.util.Set;

import javafx.scene.text.Font;
public class MainApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Movie recommendation");
        primaryStage.setWidth(750); // Set the width of the primary stage to 500 pixels

        // Create the "User" button
        Button btnUser = new Button();
        btnUser.setText("User");
        btnUser.setOnAction(event -> showUserLoginScene(primaryStage));
        btnUser.setFont(new Font(17));
        btnUser.setPrefWidth(200);
        btnUser.setPrefHeight(100);
        btnUser.setPadding(new Insets(10)); // Add 10 pixels of padding around the "User" button

        // Create the "Administrator" button
        Button btnAdmin = new Button();
        btnAdmin.setText("Administrator");
        btnAdmin.setOnAction(event -> showAdministratorLoginScene(primaryStage));
        btnAdmin.setFont(new Font(17));
        btnAdmin.setPrefWidth(200);
        btnAdmin.setPrefHeight(100);
        btnAdmin.setPadding(new Insets(10)); // Add 10 pixels of padding around the "Administrator" button

        // Add the buttons to a HBox and set the alignment to center
        HBox buttonContainer = new HBox();
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setSpacing(10); // Add 10 pixels of space between the buttons
        buttonContainer.getChildren().addAll(btnAdmin, btnUser);

        // Add the HBox to the root pane
        BorderPane root = new BorderPane();
        root.setCenter(buttonContainer);

        // Set the scene and show the primary stage
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void addUser(String name, String password,String role) {
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            String sql = "SELECT COUNT(*) FROM userr";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Create the Prepared Statement
            String insertSql = "INSERT INTO userr (name,password,role) VALUES (?,?,?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);

            insertStatement.setString(1, name);
            insertStatement.setString(2, password);
            insertStatement.setString(3, role);

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
    public boolean isUser(String name, String password) {
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            // Create the Prepared Statement
            String sql = "SELECT COUNT(*) FROM userr WHERE name = ? AND password = ? AND role = 'user'";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values for the placeholders in the Prepared Statement
            statement.setString(1, name);
            statement.setString(2, password);

            // Execute the Prepared Statement and get the result set
            ResultSet resultSet = statement.executeQuery();

            // Check if the result set has at least one row
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    // User with given name and password is an administrator
                    return true;
                } else {
                    // User with given name and password is not an administrator
                    return false;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Print the error message if an exception is thrown
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Print the error message if an exception is thrown
                e.printStackTrace();
            }
        }

        // Return false by default
        return false;
    }
    public boolean isAdmin(String name, String password) {
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            // Create the Prepared Statement
            String sql = "SELECT COUNT(*) FROM userr WHERE name = ? AND password = ? AND role = 'admin'";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values for the placeholders in the Prepared Statement
            statement.setString(1, name);
            statement.setString(2, password);

            // Execute the Prepared Statement and get the result set
            ResultSet resultSet = statement.executeQuery();

            // Check if the result set has at least one row
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    // User with given name and password is an administrator
                    return true;
                } else {
                    // User with given name and password is not an administrator
                    return false;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Print the error message if an exception is thrown
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Print the error message if an exception is thrown
                e.printStackTrace();
            }
        }

        // Return false by default
        return false;
    }
    public void checkUser(String name, String password) {
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            // Create the Prepared Statement
            String sql = "SELECT COUNT(*) FROM userr WHERE name = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values for the placeholders in the Prepared Statement
            statement.setString(1, name);
            statement.setString(2, password);

            // Execute the Prepared Statement and get the result set
            ResultSet resultSet = statement.executeQuery();

            boolean isUser = isUser(name, password);
            if (isUser)
            {
                // User with given name and password exists in the database
                // Open a new stage to welcome the user back
                Stage stage = new Stage();
                stage.setWidth(400);
                stage.setHeight(150);
                stage.setTitle("Welcome back");
                Label label = new Label("Welcome back, " + name + "!");
                label.setStyle("-fx-font-size: 20pt;");
                VBox root = new VBox();
                root.setAlignment(Pos.CENTER);
                root.getChildren().add(label);
                Scene scene = new Scene(root, 300, 250);
                stage.setScene(scene);
                stage.show();
            }
            else
            {
                // User with given name and password does not exist in the database
                // Open a new stage to welcome the new user
                addUser(name,password,"user");
                Stage stage = new Stage();
                stage.setWidth(500);
                stage.setHeight(150);
                stage.setTitle("Hello new user");
                Label label = new Label("Hello new user. I hope you like my platform!");
                label.setStyle("-fx-font-size: 15pt;");
                VBox root = new VBox();
                root.setAlignment(Pos.CENTER);
                root.getChildren().add(label);
                Scene scene = new Scene(root, 300, 250);
                stage.setScene(scene);
                stage.show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            // Print the error message if an exception is thrown
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Print the error message if an exception is thrown
                e.printStackTrace();
            }
        }
    }
    public void checkAdministrator(String name, String password) {
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            // Create the Prepared Statement
            String sql = "SELECT COUNT(*) FROM userr WHERE name = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the values for the placeholders in the Prepared Statement
            statement.setString(1, name);
            statement.setString(2, password);

            // Execute the Prepared Statement and get the result set
            ResultSet resultSet = statement.executeQuery();

            boolean isAdmin = isAdmin(name, password);
            if (isAdmin)
            {
                // User with given name and password exists in the database
                // Open a new stage to welcome the user back
                Stage stage = new Stage();
                stage.setWidth(300);
                stage.setHeight(150);
                stage.setTitle("Welcome back");
                Label label = new Label("Welcome back, " + name + "!");
                label.setStyle("-fx-font-size: 20pt;");
                VBox root = new VBox();
                root.setAlignment(Pos.CENTER);
                root.getChildren().add(label);
                Scene scene = new Scene(root, 300, 250);
                stage.setScene(scene);
                stage.show();
            }
            else
            {
                // User with given name and password does not exist in the database
                // Open a new stage to welcome the new user
                addUser(name,password,"admin");
                Stage stage = new Stage();
                stage.setWidth(500);
                stage.setHeight(150);
                stage.setTitle("Hello new admin");
                Label label = new Label("Hello new administrator. I hope you like my platform!");
                label.setStyle("-fx-font-size: 15pt;");
                VBox root = new VBox();
                root.setAlignment(Pos.CENTER);
                root.getChildren().add(label);
                Scene scene = new Scene(root, 300, 250);
                stage.setScene(scene);
                stage.show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Print the error message if an exception is thrown
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Print the error message if an exception is thrown
                e.printStackTrace();
            }
        }
    }
    private void showUserLoginScene(Stage primaryStage) {
        User u = new User();
        // Create a new stage for the user login scene
        Stage userLoginStage = new Stage();
        userLoginStage.setTitle("User Login");
        userLoginStage.setWidth(400);

        // Create the name label and text field
        Label lblName = new Label("Name:");
        TextField txtName = new TextField();
        txtName.setMinWidth(150);
        txtName.setMaxWidth(200);
        txtName.setMinHeight(25);
        txtName.setMaxHeight(50);

        // Create the password label and text field
        Label lblPassword = new Label("Password:");
        PasswordField txtPassword = new PasswordField();
        txtPassword.setMinWidth(150);
        txtPassword.setMaxWidth(200);
        txtPassword.setMinHeight(25);
        txtPassword.setMaxHeight(50);

        // Create the submit button
        Button btnSubmit = new Button();
        btnSubmit.setText("Submit");
        btnSubmit.setMinSize(100, 25);

        btnSubmit.setOnAction(event -> {
            String name = txtName.getText();
            String password = txtPassword.getText();
            u.setName(name);
            u.setPasword(password);
            u.getMovies();
            showUserScene(primaryStage,u); // Call the showAdminScene method
            checkUser(name, password);
            userLoginStage.close(); // Close the "User Login" stage
            txtName.clear();
            txtPassword.clear();
        });

        // Add the name label and text field to a VBox
        VBox nameContainer = new VBox();
        nameContainer.setSpacing(10);
        nameContainer.getChildren().addAll(lblName, txtName);

        // Add the password label and text field to a VBox
        VBox passwordContainer = new VBox();
        passwordContainer.setSpacing(10);
        passwordContainer.getChildren().addAll(lblPassword, txtPassword);

        // Create a HBox to hold the name and password VBoxes
        HBox formFieldsContainer = new HBox();
        formFieldsContainer.setSpacing(10);
        formFieldsContainer.setAlignment(Pos.CENTER);
        formFieldsContainer.getChildren().addAll(nameContainer, passwordContainer);

        // Add the form fields HBox and the submit button to a VBox and set the alignment to center
        VBox formContainer = new VBox();
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setSpacing(10);
        formContainer.getChildren().addAll(formFieldsContainer, btnSubmit);

        // Add the VBox to the root pane
        BorderPane root = new BorderPane();
        root.setCenter(formContainer);

        // Set the scene and show the stage
        Scene scene = new Scene(root, 300, 250);
        userLoginStage.setScene(scene);
        userLoginStage.show();
    }
    private void showAdministratorLoginScene(Stage primaryStage) {
        // Create a new stage for the user login scene
        Stage userLoginStage = new Stage();
        userLoginStage.setTitle("User Login");
        userLoginStage.setWidth(400);

        // Create the name label and text field
        Label lblName = new Label("Name:");
        TextField txtName = new TextField();
        txtName.setMinWidth(150);
        txtName.setMaxWidth(200);
        txtName.setMinHeight(25);
        txtName.setMaxHeight(50);

        // Create the password label and text field
        Label lblPassword = new Label("Password:");
        PasswordField txtPassword = new PasswordField();
        txtPassword.setMinWidth(150);
        txtPassword.setMaxWidth(200);
        txtPassword.setMinHeight(25);
        txtPassword.setMaxHeight(50);

        // Create the submit button
        Button btnSubmit = new Button();
        btnSubmit.setText("Submit");
        btnSubmit.setMinSize(100, 25);

        btnSubmit.setOnAction(event -> {
            String name = txtName.getText();
            String password = txtPassword.getText();
            Administrator a=new Administrator();
            a.setName(name);
            a.setPasword(password);
            showAdminScene(primaryStage,a); // Call the showAdminScene method
            checkAdministrator(name, password);
            userLoginStage.close(); // Close the "User Login" stage
            txtName.clear();
            txtPassword.clear();
        });

        // Add the name label and text field to a VBox
        VBox nameContainer = new VBox();
        nameContainer.setSpacing(10);
        nameContainer.getChildren().addAll(lblName, txtName);

        // Add the password label and text field to a VBox
        VBox passwordContainer = new VBox();
        passwordContainer.setSpacing(10);
        passwordContainer.getChildren().addAll(lblPassword, txtPassword);

        // Create a HBox to hold the name and password VBoxes
        HBox formFieldsContainer = new HBox();
        formFieldsContainer.setSpacing(10);
        formFieldsContainer.setAlignment(Pos.CENTER);
        formFieldsContainer.getChildren().addAll(nameContainer, passwordContainer);

        // Add the form fields HBox and the submit button to a VBox and set the alignment to center
        VBox formContainer = new VBox();
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setSpacing(10);
        formContainer.getChildren().addAll(formFieldsContainer, btnSubmit);

        // Add the VBox to the root pane
        BorderPane root = new BorderPane();
        root.setCenter(formContainer);

        // Set the scene and show the stage
        Scene scene = new Scene(root, 300, 250);
        userLoginStage.setScene(scene);
        userLoginStage.show();
    }
    private void showFeed(Stage stage, User u) {
        // Create the buttons
        Button button1 = new Button();
        button1.setText("Sortare dupa Like-uri");
        button1.setPrefWidth(200);
        button1.setPrefHeight(100);

        Button button2 = new Button();
        button2.setText("Sortare dupa Release date");
        button2.setPrefWidth(200);
        button2.setPrefHeight(100);

        // Add an event handler to the button1
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                u.displayCategoryByLike();
            }
        });

        // Add an event handler to the button2
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                u.displayCategoryByDate();
            }
        });

        // Add the buttons to a layout pane
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.getChildren().add(button1);
        layout.getChildren().add(button2);

        // Add the layout pane to a scene
        Scene scene = new Scene(layout, 500, 250);
        // Create a new stage for the window
        Stage buttonStage = new Stage();
        buttonStage.setTitle("Selectare sortare");
        buttonStage.setScene(scene);
        buttonStage.show();
    }


    private void addLikeMovieInDB(User u, Movie m){
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

            insertStatement.setString(1, u.getName());
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
    private void deleteLikeMovieFromDB(User u, Movie m){
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

            insertStatement.setString(1, u.getName());
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
    private void searchMovie(Stage parentStage,User u) {
        // Create a new stage for the movie list scene
        Stage movieListStage = new Stage();
        movieListStage.setTitle("Search movie");
        movieListStage.setWidth(300);

        // Create a search bar
        TextField searchBar = new TextField();
        searchBar.setPromptText("Enter movie title");

        // Create a search button
        Button searchButton = new Button("Search");
        searchButton.setOnAction((event) ->{
            Connection connection = null;
            String searchTerm = searchBar.getText();
            // Try-with-resources block to automatically close the connection when done
            try {
                // Load the JDBC driver
                Class.forName("org.postgresql.Driver");

                // Create the connection using the URL, username, and password
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

                // Create the Prepared Statement
                String selectSql = "SELECT * FROM movies WHERE movie LIKE '%" + searchTerm + "%'";
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
                    Set<String> listaAprrecieri=u.returnList();
                    if (listaAprrecieri.contains(movie))
                    {
                        likeButton.setSelected(true);
                        likeButton.setTextFill(Color.BLUE);
                    }
                    likeButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            if (likeButton.isSelected()) {
                                likeButton.setTextFill(Color.BLUE);
                                Movie m=new Movie();
                                m.setMovie(movie);
                                addLikeMovieInDB(u,m);
                                u.addLikeToDB(movie);
                                u.addMovie(movie);

                            } else {
                                likeButton.setTextFill(Color.GRAY);
                                Movie m=new Movie();
                                m.setMovie(movie);
                                deleteLikeMovieFromDB(u,m);
                                u.deleteLikeToDB(movie);
                                u.deleteMovie(movie);
                            }
                        }
                    });
                    grid.add(movieLabel, 0, 0);
                    grid.add(categoryLabel, 0, 1);
                    grid.add(releaseDateLabel, 0, 2);
                    grid.add(likesLabel, 0, 3);
                    grid.add(likeButton, 1, 0, 1, 4);
                    moviesBox.getChildren().add(grid);
                }
                scrollPane.setContent(moviesBox);

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
        });

        // Create the search bar and button layout container
        HBox searchContainer = new HBox();
        searchContainer.setAlignment(Pos.CENTER);
        searchContainer.getChildren().addAll(searchBar, searchButton);

        // Create a VBox layout container
        VBox container = new VBox();
        container.setAlignment(Pos.CENTER);

        // Add the search container to the VBox container
        container.getChildren().add(searchContainer);

        // Set the scene and show the stage
        Scene scene = new Scene(container, 300, 250);
        movieListStage.setScene(scene);
        movieListStage.show();
    }


    private void showUserScene(Stage primaryStage,User u) {
        // Create a new stage for the user scene
        Stage userStage = new Stage();
        userStage.setTitle("User");
        userStage.setWidth(300);

        // Create the "Show movie list" button
        Button btnShowMovieList = new Button();
        btnShowMovieList.setText("Search movie");
        btnShowMovieList.setOnAction(event -> searchMovie(userStage,u));
        btnShowMovieList.setPrefWidth(150);
        btnShowMovieList.setPrefHeight(60);
        btnShowMovieList.setFont(new Font(17));
        btnShowMovieList.setPadding(new Insets(10)); // Add 10 pixels of padding around the "Show movie list" button

        // Create the "Show feed" button
        Button btnShowFeed = new Button();
        btnShowFeed.setText("Show feed");
        btnShowFeed.setOnAction(event -> showFeed(userStage,u));
        btnShowFeed.setPrefWidth(150);
        btnShowFeed.setPrefHeight(60);
        btnShowFeed.setFont(new Font(17));
        btnShowFeed.setPadding(new Insets(10)); // Add 10 pixels of padding around the "Show feed" button

        // Create the "Exit" button
        Button btnExit = new Button();
        btnExit.setText("Exit");
        btnExit.setOnAction(event -> {
            u.displayLikes();
            userStage.close();
        }); // Close the user stage when the button is clicked
        btnExit.setPrefWidth(150);
        btnExit.setPrefHeight(60);
        btnExit.setFont(new Font(17));
        btnExit.setPadding(new Insets(10)); // Add 10 pixels of padding around the "Exit" button

        // Create the VBox layout container
        VBox buttonContainer = new VBox();
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setSpacing(10); // Add 10 pixels of space between the buttons

        // Add the buttons to the VBox
        buttonContainer.getChildren().addAll(btnShowMovieList, btnShowFeed, btnExit);

        // Set the scene and show the stage
        Scene scene = new Scene(buttonContainer, 300, 250);
        userStage.setScene(scene);
        userStage.show();

        // Disable the main window
        primaryStage.setResizable(false);
    }


    private void showButtonClickedScene(Stage parentStage, String buttonName) {
        // Create a new stage for the button clicked scene
        Stage buttonClickedStage = new Stage();
        buttonClickedStage.setTitle("Button clicked");
        buttonClickedStage.setWidth(750);

        // Create a label that displays the button name
        Label lbl = new Label("You clicked on button " + buttonName);

        // Set the scene and show the stage
        Scene scene = new Scene(lbl, 300, 250);
        buttonClickedStage.setScene(scene);
        buttonClickedStage.show();

        // Disable the parent stage
        parentStage.setResizable(false);
    }

    private void addMovie(String movie, String category, LocalDate releaseDate, long likes) {
        // Declare a variable for the connection
        Connection connection = null;

        // Try-with-resources block to automatically close the connection when done
        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create the connection using the URL, username, and password
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies_database", "postgres", "31071980");

            // Create the Prepared Statement
            String insertSql = "INSERT INTO movies (movie, category, release_date, likes) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);

            // Set the values for the placeholders in the Prepared Statement
            insertStatement.setString(1, movie);
            insertStatement.setString(2, category);
            insertStatement.setDate(3, java.sql.Date.valueOf(releaseDate));
            insertStatement.setLong(4, likes);

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
    private void showAdminScene(Stage primaryStage,Administrator a) {
        // Create a new stage for the admin scene
        Stage adminStage = new Stage();
        adminStage.setTitle("Administrator");
        adminStage.setWidth(500);

        // Create labels
        Label lblMovie = new Label("Movie:");
        Label lblCategory = new Label("Category:");
        Label lblReleaseDate = new Label("Release date:");
        Label lblLikes = new Label("Likes:");

        // Create text fields
        TextField txtMovie = new TextField();
        txtMovie.setMinWidth(150);
        txtMovie.setMaxWidth(200);
        txtMovie.setMinHeight(25);
        txtMovie.setMaxHeight(50);
        TextField txtCategory = new TextField();
        txtCategory.setMinWidth(150);
        txtCategory.setMaxWidth(200);
        txtCategory.setMinHeight(25);
        txtCategory.setMaxHeight(50);
        DatePicker txtReleaseDate = new DatePicker();
        txtReleaseDate.setMinWidth(150);
        txtReleaseDate.setMaxWidth(200);
        txtReleaseDate.setMinHeight(25);
        txtReleaseDate.setMaxHeight(50);
        TextField txtLikes = new TextField();
        txtLikes.setMinWidth(150);
        txtLikes.setMaxWidth(200);
        txtLikes.setMinHeight(25);
        txtLikes.setMaxHeight(50);

        // Create a submit button
        Button btnSubmit = new Button();
        btnSubmit.setText("Submit");
        btnSubmit.setMinSize(100, 25);
        btnSubmit.setOnAction(event -> {
            // Check if any of the text fields are empty
            if (txtMovie.getText().isEmpty() || txtCategory.getText().isEmpty() || txtReleaseDate.getValue() == null || txtLikes.getText().isEmpty()) {
                // Display an error message if any of the text fields are empty
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Input Error");
                alert.setContentText("Please fill out all fields before submitting.");
                alert.showAndWait();
            } else {
                // If all the fields are filled out, get the text from the text fields and print it to the console
                String movie = txtMovie.getText();
                String category = txtCategory.getText();
                LocalDate releaseDate = txtReleaseDate.getValue();
                int likes = Integer.parseInt(txtLikes.getText());

                Movie m=new Movie();
                m.setMovie(movie);
                m.setCategory(category);
                m.setReleaseDate(releaseDate);
                m.setLikes(likes);
                a.addMovie(m);
                addMovie(movie, category, releaseDate, likes);

                // Clear the text fields
                txtMovie.clear();
                txtCategory.clear();
                txtReleaseDate.setValue(null);
                txtLikes.clear();
            }
        });

        // Create an exit button
        Button btnExit = new Button();
        btnExit.setText("Exit");
        btnExit.setMinSize(100, 25);
        btnExit.setOnAction(event -> {
            // Close the stage when the exit button is clicked
            //toimplementdisplay
            a.displayMovies();
            adminStage.close();
        });

        // Create an HBox to hold submit and exit buttons
        HBox hBox = new HBox();
        hBox.setSpacing(10); // Add 10 pixels of space between the buttons
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btnSubmit, btnExit);

        // Create a vertical box to hold the labels, text fields, and buttons
        VBox vBox = new VBox();
        vBox.setSpacing(10); // Add 10 pixels of space between elements
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(lblMovie, txtMovie, lblCategory, txtCategory, lblReleaseDate, txtReleaseDate, lblLikes, txtLikes, hBox);

        // Set the scene and show the stage
        Scene scene = new Scene(vBox, 500, 300);
        adminStage.setScene(scene);
        adminStage.show();

        // Disable the main window
        primaryStage.setResizable(false);
    }
}