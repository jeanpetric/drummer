package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Window;

/**
 * Created by jean on 05/03/17.
 */
public class ConfigurationWindow extends Window {
    @FXML
    ChoiceBox playerMode;

    private final int RUNNING = 0;
    private final int STATIC = 1;

    private int newPlayerMode = -1;

    @FXML
    public void initialize() {
        String playerModeProperty = DrummerProperties.getProperty("playerMode");
        playerMode.getSelectionModel().select(playerModeProperty.equals("running") ? RUNNING : STATIC);
        playerMode.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                newPlayerMode = newValue.intValue();
                setPlayerMode();
            }
        });
    }

    public void setPlayerMode() {
        String result = "";
        if (newPlayerMode == 0) {
            result = "running";
        } else {
            result = "static";
        }
        DrummerProperties.saveProperty("playerMode", result);
    }
}
