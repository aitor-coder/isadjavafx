package ehu.isad;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class ComboBoxExperiments extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Txanponen Balioa");

        Label txanpon_info_label=new Label("TXANPONEN BALIOA");
        txanpon_info_label.setFont(new Font("Ethnocentric",15));


        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("Aukeratu Bat");
        comboBox.getItems().add("btc");
        comboBox.getItems().add("eth");
        comboBox.getItems().add("ltc");

        comboBox.getSelectionModel().selectFirst();


        comboBox.setEditable(false);

        comboBox.setOnAction(e -> {

            String txanpon_izena= (String) comboBox.getValue();


            if (txanpon_izena != "Aukeratu Bat") {
                URI_irakurlea u=new URI_irakurlea();

                String txanpon_info=null;

                try {
                    txanpon_info = u.eman_info(txanpon_izena);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                Gson gson=new Gson();
                Float balioa=gson.fromJson(txanpon_info,Txanpona.class).price;
                txanpon_info_label.setText(txanpon_izena.toUpperCase()+"="+balioa+"\u20AC");
                System.out.println(comboBox.getValue());
            }

        });


        /* Oinarrizko egitura zerrenda egiteko leiho batean
        HBox hbox = new HBox(comboBox);

        Scene scene = new Scene(hbox, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();
        */

        //Leiho bat sortu eta ikusgarria egitea, zerrenda eta testu aldakorrarekin
        VBox kaxa= new VBox(txanpon_info_label,comboBox);
        kaxa.setAlignment(Pos.CENTER);
        kaxa.setSpacing(30);
        Scene scene=new Scene(kaxa, 250, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
