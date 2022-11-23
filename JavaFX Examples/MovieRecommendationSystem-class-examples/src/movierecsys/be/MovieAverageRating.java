package movierecsys.be;

public class MovieAverageRating {
    private Movie movie;
    private int total;
    private int amount;

    public MovieAverageRating(Movie movie, int total, int amount) {
        this.movie = movie;
        this.total = total;
        this.amount = amount;
    }

    public int getAverageRating(){
        return total/amount;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
