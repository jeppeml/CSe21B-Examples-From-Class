/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.be;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pgn
 */
public class Movie
{

    private final int id;
    private String title;
    private int year;

    private final List<Rating> ratings = new ArrayList<>();

    public Movie(int id, int year, String title)
    {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public double getAvgRating(){
        double sum = 0;
        for(Rating r : ratings){
            sum += r.getRating();
        }
        return sum/ratings.size();
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", ratings=" + getAvgRating() +
                '}';
    }
}
