/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieproyect;

/**
 *
 * @author n
 */
public class Movie {

    private String titulo;
    private String originalTitle;
    private String overview;
    private String posterPath;
    private String movieId;
    private String posterUrl;

    public Movie(String titulo, String originalTitle, String overview,
            String posterPath, String movieId) {
        this.titulo = titulo;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.posterPath = posterPath;
        this.movieId = movieId;
        this.posterUrl = "https://image.tmdb.org/t/p/w500" + posterPath; // Utiliza la URL base y agrega el posterPath

    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the originalTitle
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * @param originalTitle the originalTitle to set
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    /**
     * @return the overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @param overview the overview to set
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * @return the posterPath
     */
    public String getPosterPath() {
        return posterPath;
    }

    /**
     * @param posterPath the posterPath to set
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    /**
     * @return the movieId
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     * @param movieId the movieId to set
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;

    }

    public String getPosterUrl() {
        return posterUrl;
    }

    @Override
    public String toString() {
        return "Pelicula:" + "titulo=" + titulo + "\n originalTitle="
                + originalTitle + "\n overview=" + formatOverview(overview) + "\n posterPath="
                + posterPath + "\n movieId=" + movieId + '}';
    }
    
    private String formatOverview(String overview) {
    // Define la longitud máxima de línea deseada
    int maxLineLength = 80;

    // Divide el texto en líneas más cortas
    StringBuilder formattedOverview = new StringBuilder();
    String[] words = overview.split("\\s+"); // Divide por espacios en blanco
    int currentLineLength = 0;

    for (String word : words) {
        if (currentLineLength + word.length() + 1 <= maxLineLength) {
            // Agrega la palabra a la línea actual
            formattedOverview.append(word).append(" ");
            currentLineLength += word.length() + 1;
        } else {
            // Inicia una nueva línea
            formattedOverview.append("\n    ").append(word).append(" ");
            currentLineLength = word.length() + 5; // 5 es la longitud de "\n    "
        }
    }

    return formattedOverview.toString().trim();
}
    
}
