package com.example.lab3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;

public class ClientController {
    public int port = 8102;

    @FXML
    private TextArea playerAnswer;
    @FXML
    private TextArea playerNick;

    @FXML
    private Button sendAnswer;


    @FXML
    public void sendAnswer(javafx.event.ActionEvent actionEvent) {

        try (Socket socket = new Socket("localhost", port)) {
            String clientAnswer = playerNick.getText()+";"+playerAnswer.getText();
            System.out.println(clientAnswer);
            socket.getOutputStream().write(clientAnswer.getBytes());
        }
        catch(IOException e) {
            Alert connectionError = new Alert(Alert.AlertType.ERROR, "Nie mozna polaczyc sie z serwerem.");
            connectionError.showAndWait();
        }
    }

}