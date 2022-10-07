package Classes;

public class Book extends Item{

    private String author;
    private Genres genre;

    public Book(String _title, int _year, int _pageNumber, String _author, Genres _genre) {
        super(_title, _year, _pageNumber);
       setAuthor(_author);
       setGenre(_genre);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public Genres getGenre() {
        return genre;
    }

    @Override
    public String toString(){
        return getTitle() + ", " + getAuthor() +  ", " + getGenre() + ", " + getYear();
    }
}

