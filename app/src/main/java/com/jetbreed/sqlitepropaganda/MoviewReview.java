package com.jetbreed.sqlitepropaganda;

//Model
//It is a database object representation
public class MoviewReview {

    int id;
    String movie_name, pythonMovie,
    reactMovie, mssqlMovie, javaMovie;
    int year;
    int duration;
    float ratingBar;
    String female;
    String male;

    public MoviewReview
            (
                    int id, String movie_name, String pythonMovie,
                    String reactMovie, String mssqlMovie,
                    String javaMovie, int year, int duration,
                    float ratingBar, String female, String male
            )

    {
        this.id = id;
        this.movie_name = movie_name;
        this.pythonMovie = pythonMovie;
        this.reactMovie = reactMovie;
        this.mssqlMovie = mssqlMovie;
        this.javaMovie = javaMovie;
        this.year = year;
        this.duration = duration;
        this.ratingBar = ratingBar;
        this.female = female;
        this.male = male;
    }

//    public MoviewReview(int id, String movie_name, String pythonMovie, String reactMovie, String mssqlMovie, String javaMovie, int year, int duration, float ratingBar, String gender, String male) { }

    @Override
    public String toString() {
        return "MoviewReview{" +
                "id=" + id +
                ", movie_name='" + movie_name + '\'' +
                ", pythonMovie='" + pythonMovie + '\'' +
                ", reactMovie='" + reactMovie + '\'' +
                ", mssqlMovie='" + mssqlMovie + '\'' +
                ", javaMovie='" + javaMovie + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", ratingBar=" + ratingBar +
                ", female=" + female +
                ", male=" + male +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmovie_name() {
        return movie_name;
    }

    public void setmovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getPythonMovie() {
        return pythonMovie;
    }

    public void setPythonMovie(String pythonMovie) {
        this.pythonMovie = pythonMovie;
    }

    public String getReactMovie() {
        return reactMovie;
    }

    public void setReactMovie(String reactMovie) {
        this.reactMovie = reactMovie;
    }

    public String getMssqlMovie() {
        return mssqlMovie;
    }

    public void setMssqlMovie(String mssqlMovie) {
        this.mssqlMovie = mssqlMovie;
    }

    public String getJavaMovie() {
        return javaMovie;
    }

    public void setJavaMovie(String javaMovie) {
        this.javaMovie = javaMovie;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(float ratingBar) {
        this.ratingBar = ratingBar;
    }

    public String isFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public String isMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }
}
