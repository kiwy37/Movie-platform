module com.example.movie_recomandation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires java.desktop;
    requires org.postgresql.jdbc;
//    requires java.persistence;


    opens com.example.movie_recomandation to javafx.fxml;
    exports com.example.movie_recomandation;
}