package enigma.enigmainterface;

import enigma.enigmamachine.EnigmaMachine;
import enigma.enigmamachine.Plug;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.KeyEvent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Interface extends Application {
    private final static int A_NUMBER = 97;
    private final static int A_NUMBER_UP = 65;
    private final static int ALPHABET_SIZE = 26;

    @Override
    public void start(Stage primaryStage) {
//        TextInputDialog dialog = new TextInputDialog("26");
//                    /*Без иконки*/
//        dialog.initStyle(StageStyle.UTILITY);
//        dialog.getDialogPane().setPrefSize(300, 150);
//        dialog.setTitle("Alphabet");
//        dialog.setHeaderText("");
//        dialog.setContentText("Please enter number of letters in the alphabet:");
//
//        Optional<String> result = dialog.showAndWait();
//        if (result.isPresent()) {
//            alphabetSize = Integer.valueOf(result.get());
//        }
        EnigmaCreator enigmaCreator = new EnigmaCreator();
        EnigmaMachine enigma = enigmaCreator.getEnigma();
        TextInputDialog dialog1 = new TextInputDialog("1");
                    /*Без иконки*/
        dialog1.initStyle(StageStyle.UTILITY);
        dialog1.getDialogPane().setPrefSize(300, 150);
        dialog1.setTitle("Rotor Order");
        dialog1.setHeaderText("");
        dialog1.setContentText("Please enter ordinal number of first rotor:");

        Optional<String> result = dialog1.showAndWait();
        if (result.isPresent()) {
            enigma.getRotors().get(0).setWiringSeed(Integer.valueOf(result.get()));
        }
        TextInputDialog dialog2 = new TextInputDialog("2");
                    /*Без иконки*/
        dialog2.initStyle(StageStyle.UTILITY);
        dialog2.getDialogPane().setPrefSize(300, 150);
        dialog2.setTitle("Rotor Order");
        dialog2.setHeaderText("");
        dialog2.setContentText("Please enter ordinal number of second rotor:");

        result = dialog2.showAndWait();
        if (result.isPresent()) {
            enigma.getRotors().get(1).setWiringSeed(Integer.valueOf(result.get()));
        }

        TextInputDialog dialog3 = new TextInputDialog("3");
                    /*Без иконки*/
        dialog3.initStyle(StageStyle.UTILITY);
        dialog3.getDialogPane().setPrefSize(300, 150);
        dialog3.setTitle("Rotor Order");
        dialog3.setHeaderText("");
        dialog3.setContentText("Please enter ordinal number of third rotor:");

        result = dialog3.showAndWait();
        if (result.isPresent()) {
            enigma.getRotors().get(2).setWiringSeed(Integer.valueOf(result.get()));
        }

        TextInputDialog dialog4 = new TextInputDialog("1");
                    /*Без иконки*/
        dialog4.initStyle(StageStyle.UTILITY);
        dialog4.getDialogPane().setPrefSize(300, 150);
        dialog4.setTitle("Rotor Position");
        dialog4.setHeaderText("");
        dialog4.setContentText("Please enter initial position of first rotor:");

        result = dialog4.showAndWait();
        if (result.isPresent()) {
            enigma.getRotors().get(0).setInitialState(Integer.valueOf(result.get()));
        }

        TextInputDialog dialog5 = new TextInputDialog("1");
                    /*Без иконки*/
        dialog5.initStyle(StageStyle.UTILITY);
        dialog5.getDialogPane().setPrefSize(300, 150);
        dialog5.setTitle("Rotor Position");
        dialog5.setHeaderText("");
        dialog5.setContentText("Please enter initial position of second rotor:");

        result = dialog5.showAndWait();
        if (result.isPresent()) {
            enigma.getRotors().get(1).setInitialState(Integer.valueOf(result.get()));
        }

        TextInputDialog dialog6 = new TextInputDialog("1");
                    /*Без иконки*/
        dialog6.initStyle(StageStyle.UTILITY);
        dialog6.getDialogPane().setPrefSize(300, 150);
        dialog6.setTitle("Rotor Position");
        dialog6.setHeaderText("");
        dialog6.setContentText("Please enter initial position of third rotor:");

        result = dialog6.showAndWait();
        if (result.isPresent()) {
            enigma.getRotors().get(2).setInitialState(Integer.valueOf(result.get()));
        }

//        int j = 0;
//        while(j < 10){
//            TextInputDialog dialog = new TextInputDialog("");
//            /*Без иконки*/
//            dialog.initStyle(StageStyle.UTILITY);
//            dialog.getDialogPane().setPrefSize(300, 150);
//            dialog.setTitle("Plugs");
//            dialog.setHeaderText("");
//            dialog.setContentText("Please enter " + j + " plug:");
//
//            result = dialog.showAndWait();
//            if (result.isPresent()) {
//                Plug currentPlug = new Plug(result.get().charAt(0), result.get().charAt(1));
//                enigma.addPlug(currentPlug);
//            }
//            j++;
//        }

        BorderPane mainPane = new BorderPane();
        StackPane logoPane = new StackPane();
        logoPane.setAlignment(Pos.CENTER);

        /*Разметка*/
        GridPane keyBoardGrid = new GridPane();
        GridPane firstLineGrid = new GridPane();
        GridPane secondLineGrid = new GridPane();
        GridPane thirdLineGrid = new GridPane();
        GridPane rotorsGrid = new GridPane();
        /*Расположение разметки*/
        keyBoardGrid.setAlignment(Pos.CENTER);
        firstLineGrid.setAlignment(Pos.CENTER);
        secondLineGrid.setAlignment(Pos.CENTER);
        thirdLineGrid.setAlignment(Pos.CENTER);
        rotorsGrid.setAlignment(Pos.CENTER);
        /*Расстояние между ячейками*/
        keyBoardGrid.setHgap(5);
        firstLineGrid.setHgap(5);
        secondLineGrid.setHgap(5);
        thirdLineGrid.setHgap(5);
        keyBoardGrid.setVgap(5);
        firstLineGrid.setVgap(5);
        secondLineGrid.setVgap(5);
        thirdLineGrid.setVgap(5);

        rotorsGrid.setHgap(10);
        rotorsGrid.setVgap(10);



        /*Расстояния от краёв ячеек*/
        keyBoardGrid.setPadding(new Insets(25, 25, 25, 25));

        Image enigmaLogo = new Image("/enigmaLogo.png");
        ImageView logoImageView = new ImageView();
        logoImageView.setImage(enigmaLogo);
        logoImageView.setFitWidth(300);
        logoImageView.setPreserveRatio(true);
        logoImageView.setSmooth(true);
        logoImageView.setCache(true);

        Font font = Font.font("", FontWeight.EXTRA_BOLD, 40);
        DecimalFormat twoDigits = new DecimalFormat("00");
        Text thirdRot = new Text(String.valueOf(twoDigits.format(enigma.getRotors().get(2).getCurrentState() + 1)));
        thirdRot.setFont(font);
        Text secondRot = new Text(String.valueOf(twoDigits.format(enigma.getRotors().get(1).getCurrentState() + 1)));
        secondRot.setFont(font);
        Text firstRot = new Text(String.valueOf(twoDigits.format(enigma.getRotors().get(0).getCurrentState() + 1)));
        firstRot.setFont(font);

        rotorsGrid.add(thirdRot, 0, 0);
        rotorsGrid.add(secondRot, 1, 0);
        rotorsGrid.add(firstRot, 2, 0);


        ArrayList<ImageView> imageViews = new ArrayList<>();
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            imageViews.add(addLetter("/" + (char) (A_NUMBER + i) + ".png"));
        }

        firstLineGrid.add(imageViews.get(16), 0, 0);
        firstLineGrid.add(imageViews.get(22), 1, 0);
        firstLineGrid.add(imageViews.get(4), 2, 0);
        firstLineGrid.add(imageViews.get(17), 3, 0);
        firstLineGrid.add(imageViews.get(19), 4, 0);
        firstLineGrid.add(imageViews.get(25), 5, 0);
        firstLineGrid.add(imageViews.get(20), 6, 0);
        firstLineGrid.add(imageViews.get(8), 7, 0);
        firstLineGrid.add(imageViews.get(14), 8, 0);

        secondLineGrid.add(imageViews.get(0), 0, 0);
        secondLineGrid.add(imageViews.get(18), 1, 0);
        secondLineGrid.add(imageViews.get(3), 2, 0);
        secondLineGrid.add(imageViews.get(5), 3, 0);
        secondLineGrid.add(imageViews.get(6), 4, 0);
        secondLineGrid.add(imageViews.get(7), 5, 0);
        secondLineGrid.add(imageViews.get(9), 6, 0);
        secondLineGrid.add(imageViews.get(10), 7, 0);

        thirdLineGrid.add(imageViews.get(15), 0, 0);
        thirdLineGrid.add(imageViews.get(24), 1, 0);
        thirdLineGrid.add(imageViews.get(23), 2, 0);
        thirdLineGrid.add(imageViews.get(2), 3, 0);
        thirdLineGrid.add(imageViews.get(21), 4, 0);
        thirdLineGrid.add(imageViews.get(1), 5, 0);
        thirdLineGrid.add(imageViews.get(13), 6, 0);
        thirdLineGrid.add(imageViews.get(12), 7, 0);
        thirdLineGrid.add(imageViews.get(11), 8, 0);

//        firstLineGrid.add(imageViews.get(0), 0, 0);
//        firstLineGrid.add(imageViews.get(1), 1, 0);
//        firstLineGrid.add(imageViews.get(2), 2, 0);
//        firstLineGrid.add(imageViews.get(3), 3, 0);
//        firstLineGrid.add(imageViews.get(4), 4, 0);
//        firstLineGrid.add(imageViews.get(5), 5, 0);

        logoPane.getChildren().add(logoImageView);
        mainPane.setTop(logoPane);
        keyBoardGrid.add(firstLineGrid, 0, 0);
        keyBoardGrid.add(secondLineGrid, 0, 1);
        keyBoardGrid.add(thirdLineGrid, 0, 2);


        mainPane.setCenter(rotorsGrid);
        mainPane.setBottom(keyBoardGrid);
        /*Иконка окна*/
        primaryStage.getIcons().add(new Image("file:resources/enigmaIcon.png"));
        /*Название окна*/
        primaryStage.setTitle("Enigma");
        /*Создание сцены с разметкой*/
        Scene scene = new Scene(mainPane);
        final Set<String> pressedKeys = new HashSet<String>();
        final ArrayList<String> currentOutput = new ArrayList<>();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String key = event.getText();
                if (!pressedKeys.contains(key) && pressedKeys.size() == 0) {
                    // you may need to introduce synchronization here
                    pressedKeys.add(key);

                    KeyCode currentKeyCode = event.getCode();
                    String outputLetter = enigma.getLetter(currentKeyCode.toString());
                    currentOutput.add(outputLetter);
                    imageViews.get((int) (outputLetter.charAt(0)) - A_NUMBER)
                            .setImage(new Image("/" + outputLetter + "h.png"));

                    DecimalFormat twoDigits = new DecimalFormat("00");
                    thirdRot.setText(String.valueOf(twoDigits.format(enigma.getRotors().get(2).getCurrentState() + 1)));
                    secondRot.setText(String.valueOf(twoDigits.format(enigma.getRotors().get(1).getCurrentState() + 1)));
                    firstRot.setText(String.valueOf(twoDigits.format(enigma.getRotors().get(0).getCurrentState() + 1)));
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(pressedKeys.remove(event.getText())) {
                    String outputLetter = currentOutput.remove(0);
                    imageViews.get((int) (outputLetter.charAt(0)) - A_NUMBER)
                            .setImage(new Image("/" + outputLetter + ".png"));
                }
            }
        });
        primaryStage.setScene(scene);
        /*Отменить возможность изменения размера*/
        primaryStage.setResizable(false);
        /*Отслеживание закрытия окна*/
        primaryStage.setOnCloseRequest(event -> Platform.exit());

        /*Показать окно*/
        primaryStage.show();


    }

    private ImageView addLetter(String imageName) {
        Image image = new Image(imageName);
        ImageView letterImageView = new ImageView();
        letterImageView.setImage(image);
        letterImageView.setFitWidth(70);
        letterImageView.setPreserveRatio(true);
        letterImageView.setSmooth(true);
        letterImageView.setCache(true);
        return letterImageView;
    }
}
