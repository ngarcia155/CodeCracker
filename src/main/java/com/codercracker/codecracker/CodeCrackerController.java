package com.codercracker.codecracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Hashtable;

public class CodeCrackerController {
    @FXML
    private TextField TimerDisplay;

    @FXML
    private RadioButton bruteForceRadio;

    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private RadioButton dictRadio;

    @FXML
    private Button down0Button;

    @FXML
    private Button down1Button;

    @FXML
    private Button down2Button;

    @FXML
    private Button down3Button;

    @FXML
    private Button down4Button;

    @FXML
    private RadioButton hybridRadio;

    @FXML
    private ToggleGroup options;

    @FXML
    private RadioButton patternRadio;

    @FXML
    private Button startButton;

    @FXML
    private Button up0Button;

    @FXML
    private Button up1Button;

    @FXML
    private Button up2Button;

    @FXML
    private Button up3Button;

    @FXML
    private Button up4Button;

    private Hashtable<String, Button> buttonHashtable;

    @FXML
    public void initialize() {
        // Initialize the Hashtable in the initialize method
        buttonHashtable = new Hashtable<>();
        buttonHashtable.put("button0", button0);
        buttonHashtable.put("button1", button1);
        buttonHashtable.put("button2", button2);
        buttonHashtable.put("button3", button3);
        buttonHashtable.put("button4", button4);
        buttonHashtable.put("up0Button", up0Button);
        buttonHashtable.put("down0Button", down0Button);
        buttonHashtable.put("up1Button", up1Button);
        buttonHashtable.put("down1Button", down1Button);
        buttonHashtable.put("up2Button", up2Button);
        buttonHashtable.put("down2Button", down2Button);
        buttonHashtable.put("up3Button", up3Button);
        buttonHashtable.put("down3Button", down3Button);
        buttonHashtable.put("up4Button", up4Button);
        buttonHashtable.put("down4Button", down4Button);
    }

    @FXML
    void buttonClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        // Get the button's name from the Hashtable
        String buttonName = "";
        for (String key : buttonHashtable.keySet()) {
            if (buttonHashtable.get(key) == clickedButton) {
                buttonName = key;
                break;
            }
        }
        String num;

        // Perform actions based on the button name
        switch (buttonName) {
            case "up0Button":
                if (validIncrease(button0, button0.getText())){
                    int currentValue = Integer.parseInt(button0.getText());
                    button0.setText(currentValue + 1 +"");
                }
                break;
            case "down0Button":
                 num = button0.getText();
                if (validDecrease(button0, num)){
                    int currentVal = Integer.parseInt(num);
                    button0.setText(currentVal - 1 +"");
                }
                break;
            case "up1Button":
                if (validIncrease(button1, button1.getText())){
                    int currentValue = Integer.parseInt(button1.getText());
                    button1.setText(currentValue + 1 + "");
                }
                break;
            case "down1Button":
                 num = button1.getText();
                if (validDecrease(button1, num)){
                    int currentVal = Integer.parseInt(num);
                    button1.setText(currentVal - 1 +"");
                }
                break;
            case "up2Button":
                if (validIncrease(button2, button2.getText())){
                    int currentValue = Integer.parseInt(button2.getText());
                    button2.setText(currentValue + 1 + "");
                }
                break;
            case "down2Button":
                 num = button2.getText();
                if (validDecrease(button2, num)){
                    int currentVal = Integer.parseInt(num);
                    button2.setText(currentVal - 1 +"");
                }
                break;
            case "up3Button":
                if (validIncrease(button3, button3.getText())){
                    int currentValue = Integer.parseInt(button3.getText());
                    button3.setText(currentValue + 1 + "");
                }
                break;
            case "down3Button":
                 num = button3.getText();
                if (validDecrease(button3, num)){
                    int currentVal = Integer.parseInt(num);
                    button3.setText(currentVal - 1 +"");
                }
                break;
            case "up4Button":
                if (validIncrease(button4, button4.getText())){
                    int currentValue = Integer.parseInt(button4.getText());
                    button4.setText(currentValue + 1 + "");
                }
                break;
            case "down4Button":
                 num = button4.getText();
                if (validDecrease(button4, num)){
                    int currentVal = Integer.parseInt(num);
                    button4.setText(currentVal - 1 +"");
                }
                break;
            default:
                TimerDisplay.setText(getCodeEntered()+"");
                break;
        }
    }


    @FXML
    void radioButton(ActionEvent event) {

    }

    private boolean validIncrease(Button b, String num){
        int number = Integer.parseInt(num);
        if ( number +1 > 9){
            return false;
        }
        return true;
    }

    private boolean validDecrease(Button b, String num) {
        int number = Integer.parseInt(num);
        if (number - 1 < 0) {
            return false;
        }
        return true;
    }

    private String getCodeEntered() {
        String code = "";

        code += button0.getText();
        code += button1.getText();
        code += button2.getText();
        code += button3.getText();
        code += button4.getText();

        return code;
    }


    private String getSelectedRadioButtonName(ToggleGroup toggleGroup) {
        Toggle selectedToggle = toggleGroup.getSelectedToggle();
        if (selectedToggle != null && selectedToggle instanceof RadioButton) {
            RadioButton selectedRadioButton = (RadioButton) selectedToggle;
            return selectedRadioButton.getId();
        }
        return null;
    }




}