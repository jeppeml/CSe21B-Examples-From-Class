/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restreaderascii;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Jeppe
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField txtSearch;
    @FXML
    private Label lblTitle;
    @FXML
    private ImageView imgPoster;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {        
        try {
                String query = txtSearch.getText();
                String apiKey="SECRET";
                String imagePath="https://image.tmdb.org/t/p/w320/";
                String uri = 
                    "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey +
                        "&language=en-US&query=" + query + 
                        "&page=1&include_adult=false";
                
		URL url = new URL(uri);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

                if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
                
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
                
                try(Reader reader = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())))){
                Gson gson = new GsonBuilder().create();
                TMDB p = gson.fromJson(reader, TMDB.class);
                Result r = p.getResults().get(0);
                lblTitle.setText(r.getTitle());
                imgPoster.imageProperty().setValue(new Image(imagePath+r.getPoster_path()));
                }

		conn.disconnect();
                

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }

        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
