import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.sql.SQLOutput;

public class App extends Application {
    public TextArea txtOutput;
    public TextArea txtInput;

    public static void main(String[] args){
        System.out.println("Running main");
        App.launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("App.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void clickGo(ActionEvent actionEvent) {
        String input = txtInput.getText();
        System.out.println("you clicked a button, bastard!");
        txtOutput.setText(reverseString(input));
    }
    private String reverseString(String input){
        String output = "";
        for (int i = input.length()-1; i >= 0; i--) {
            output += input.charAt(i);
        }
        return output;
    }
    private String atSeparator(String input){
        String output = "";
        for(int i=0;i<input.length();i++){
            output += input.charAt(i);
            if(input.charAt(i)!=' '){
                output += "@";
            }
        }
        return output.substring(0,output.length()-1);
    }

    private String howManyChars(String input){
        return Integer.toString(input.length());
    }

    private String tagIt(String input){
        return "<" + input + ">";
    }
}
