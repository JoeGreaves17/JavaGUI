
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Pane root = new Pane();
        Scene scene = new Scene(root,1024,768);
        scene.getStylesheets().add("stylesheet.css");
        stage.setTitle("JavaGUI");
        stage.setScene(scene);
        stage.setResizable(false);
        Button myButton = new Button("Click me!");
        myButton.setPrefSize(100,35);
        myButton.setOnAction((ActionEvent ae)-> openNewStage(root));
        myButton.getStyleClass().add("funky_button");
        //root.getChildren().add(myButton);

        VBox boxOfButtons = new VBox(10);
        boxOfButtons.getChildren().add(myButton);
        Button[] myButtons = new Button[5];
        String[] numbers = {"one","two","three","four","five"};
        for(int i=0;i<5;i++){
            String number = numbers[i];
            myButtons[i] = new Button("Button number "+number);
            myButtons[i].setPrefSize(200, 50);
            myButtons[i].setOnAction((ActionEvent ae) -> doSomething(number));
        }
        boxOfButtons.getChildren().addAll(myButtons);

        root.getChildren().add(boxOfButtons);

        stage.show();
    }
    public static void doSomething(String number) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("header");
        alert.setContentText("Button " + number + " clicked");
        alert.showAndWait();
    }
    public static void main(String[] args){launch(args);}
    public static void openNewStage(Pane parent) {
        StageTwo newStage = new StageTwo(parent);
    }
}