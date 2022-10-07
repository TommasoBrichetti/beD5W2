package Classes;

import java.time.LocalDate;

public abstract class Item {
    private int isbn;
    private String title;
    private int year;
    private int pageNumber;

    private static int id = 0;

    public Item(String _title, int _year, int _pageNumber){
        setIsbn();
        setTitle(_title);
        setYear(_year);
        setPageNumber(_pageNumber);
    }

    public void setIsbn() {
        this.isbn = id++ ;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getTitle() {
        return title;
    }
}
