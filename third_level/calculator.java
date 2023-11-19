package third_level;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

public class calculator extends Application {

    private TextField textfield = new TextField();
    private float num1 = 0;
    private String  op = "";
    private boolean start = true;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //throw new UnsupportedOperationException("Unimplemented method 'start'");

        textfield.setFont(Font.font(20));
        textfield.setPrefHeight(50);
        textfield.setAlignment(Pos.CENTER_RIGHT);
        textfield.setEditable(false);

        StackPane stackPane = new StackPane();
        stackPane.setPadding(new Insets(10));
        stackPane.getChildren().add(textfield);

        TilePane tile = new TilePane();
        tile.setHgap(10);
        tile.setVgap(10);
        tile.setAlignment(Pos.TOP_CENTER);
        tile.getChildren().addAll(
            createButtonForClear("DE"),
            createButtonForOperators("^"),
            createButtonForOperators("%"),
            createButtonForOperators("/"),
            createButtonForOperators("*"),

            createButtonForNumber("7"),
            createButtonForNumber("8"),
            createButtonForNumber("9"),
            createButtonForBackSpace("C"),
            createButtonForOperators("-"),

            createButtonForNumber("4"),
            createButtonForNumber("5"),
            createButtonForNumber("6"),
            createButtonForNumber("0"),
            createButtonForOperators("+"),

            createButtonForNumber("1"),
            createButtonForNumber("2"),
            createButtonForNumber("3"),
            createButtonForOperators("="),
            createButtonForNumber(".")
                        
        );

        BorderPane root = new BorderPane();
        root.setTop(stackPane);
        root.setCenter(tile);
        Scene scene = new Scene(root,300,320);
        primaryStage.setScene(scene);
        primaryStage.setTitle("---> Calculator <---");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    private Button createButtonForNumber(String ch){
        Button button = new Button(ch);
        //button.setFont(Font.font(18));
        button.setPrefSize(50, 50);
        button.setOnAction(this::processNumbers);
        return button;
    }

    private Button createButtonForOperators(String ch){
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50, 50);
        button.setOnAction(this::processOperators);
        return button;
    }

    private Button createButtonForClear(String ch){
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50, 50);
        button.setOnAction(e->{
            textfield.setText("");
            op = "";
            start = true;
        });
        return button;
    }

    private Button createButtonForBackSpace(String ch){
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50, 50);
        button.setOnAction(e->{
            textfield.setText(textfield.getText().substring(0,textfield.getText().length()-1));
            op = "";
            start = false;
        });
        return button;
    }
    
    private void processNumbers(ActionEvent e){
        if(start){
            textfield.setText("");
            start = false;
        }
        String value = ((Button)e.getSource()).getText();
        textfield.setText(textfield.getText()+value);
    }

    private void processOperators(ActionEvent e){
        String value = ((Button)e.getSource()).getText();
        if(!value.equals("=")){
            if(!op.isEmpty())
                return;
            num1 = Float.parseFloat(textfield.getText());
            op = value;
            textfield.setText("");
        }else{
            if(op.isEmpty())
                return;
            float num2 = Float.parseFloat(textfield.getText());
            float result = calculate(num1,num2,op);
            textfield.setText(String.valueOf(result));
            start = true;
            op = "";
        }

    }

    private float calculate(float num12, float num2, String operator){
        switch(operator){
            case "+": return num1+num2;
            case "-": return num1-num2;
            case "*": return num1*num2;
            case "/": 
                if(num2==0)
                    return 0;
                return num1/num2;
            case "%":
                if(num2==0)
                    return 0;
                return num1%num2;
            case "^":
                if(num2==0)
                    return 1;
                return (float) Math.pow(num1, num2);
            default:
                return 0;

        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
