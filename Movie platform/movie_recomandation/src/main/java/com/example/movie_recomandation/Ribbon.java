package com.example.movie_recomandation;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class Ribbon extends Label {

    public Ribbon() {
        setTextAlignment(TextAlignment.CENTER);
        setMaxWidth(Double.MAX_VALUE);
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

}
