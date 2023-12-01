/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieproyect;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author n
 */
public class ControladorAPI {

    private String apiKey ="eba71768ad1290ad4dc8d305cef81e0a";
       
    private ArrayList<Movie> peliculas;

    public ArrayList<Movie> getPeliculas() {
        return peliculas;
    }
    public ControladorAPI(){
        peliculas = new ArrayList();
    }
    public ArrayList<Movie> obtenerPeliculas() {
        try {
            URL url = new URL("https://api.themoviedb.org/3/movie/popular?api_key="+
                    apiKey+"&language=es");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonArray results = jsonObject.getAsJsonArray("results");
            for (int i = 0; i < results.size(); i++) {

                JsonObject movie = results.get(i).getAsJsonObject();

                String title = movie.get("title").getAsString();
                String originalTitle = movie.get("original_title").getAsString();
                String overview = movie.get("overview").getAsString();
                String posterPath = movie.get("poster_path").getAsString();
                
                String movieId = movie.get("id").getAsString();

                Movie peli = new Movie(title, originalTitle, overview,
                        posterPath, movieId);
                peliculas.add(peli);
            }
            
            return peliculas;

        } catch (MalformedURLException ex) {
            Logger.getLogger(ControladorAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControladorAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    

    

}
