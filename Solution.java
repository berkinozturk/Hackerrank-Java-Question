import java.io.*;
import java.util.*;

interface IFilm {
    void setTitle(String title);
    String getTitle();
    void setDirector(String director);
    String getDirector();
    void setYear(int year);
    int getYear();
}

interface IFilmLibrary {
    void addFilm(IFilm film);
    void removeFilm(String title);
    List<IFilm> getFilms();
    List<IFilm> searchFilms(String query);
    int getTotalFilmCount();
}

class Film implements IFilm {

    private String title;
    private String director;
    private int year;

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDirector(){
        return director;
    }
    public void setDirector(String director){
        this.director = director;
    }



}

class FilmLibrary implements IFilmLibrary {

    private List<IFilm> films;

    public void addFilm(IFilm film){
        if(films!=null){
            films.add(film);
        }
        else{
            films = new ArrayList<>();
            films.add(film);
        }}

    public void removeFilm(String title){
        Iterator<IFilm> iterator = films.iterator();
        while(iterator.hasNext()){
            IFilm film = iterator.next();
            if(film.getTitle().equals(title)){
                iterator.remove();
                return;
            }
        }
    }

    public List<IFilm> getFilms(){
        return films;
    }

    public int getTotalFilmCount(){
        return films.size();
    }

    public List<IFilm> searchFilms(String query){
        List<IFilm> searchResults = new ArrayList<>();
        if(films!=null){
            for(IFilm film: films){
                if(film.getTitle().toLowerCase().contains(query.toLowerCase())
                        || film.getDirector().toLowerCase().contains(query.toLowerCase())){
                    searchResults.add(film);
                }
            }
        }

        return searchResults;
    }

}