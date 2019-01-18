/*
 * JFoenix
 * Copyright (c) 2015, JFoenix and/or its affiliates., All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package JavaFX.Jfoenix.Components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;

public class DatePickerDemo  extends Application {

	
	@Override public void start(Stage stage) {

		FlowPane main = new FlowPane();
		main.setVgap(20);
		main.setHgap(20);
		
		
		DatePicker datePicker = new DatePicker();
		
		main.getChildren().add(datePicker);

        //Date and Time
		JFXDatePicker datePickerFX = new JFXDatePicker();
        JFXDatePicker blueDatePicker = new JFXDatePicker();

        datePickerFX.setOnAction(event -> {
            LocalDate date = datePickerFX.getValue();
            System.out.println(date.toString());
        });

        JFXButton btn = new JFXButton("Submit date and Time");

        btn.setOnAction(event -> {
            LocalTime x = blueDatePicker.getTime();
            LocalDate y = datePickerFX.getValue();
            System.out.println("Date : "+y.toString()+"Time : "+ x.toString());
        });

		main.getChildren().add(datePickerFX);
		datePickerFX.setPromptText("pick a date");
		blueDatePicker.setDefaultColor(Color.valueOf("#3f51b5"));
		blueDatePicker.setOverLay(true);
		blueDatePicker.setShowTime(true);

		main.getChildren().addAll(blueDatePicker,btn);
		
		
		StackPane pane = new StackPane();
		pane.getChildren().add(main);
		StackPane.setMargin(main, new Insets(100));
		pane.setStyle("-fx-background-color:WHITE");
		
		final Scene scene = new Scene(pane, 400, 700);
		scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-fonts.css").toExternalForm());
		scene.getStylesheets().add(getClass().getResource("/resources/css/jfoenix-design.css").toExternalForm());
		stage.setTitle("JFX Date Picker Demo");
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) { launch(args); }
	
}
