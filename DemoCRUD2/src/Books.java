package sample;


public class Books {
    private int Id;
    private String Title;
    private String Author;
    private int Year;
    private int Pages;


    public Books(int id, String title, String author, int year, int pages) {
        Id = id;
        Title = title;
        Author = author;
        Year = year;
        Pages = pages;
    }

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getYear() {
        return Year;
    }

    public int getPages() {
        return Pages;
    }
}
