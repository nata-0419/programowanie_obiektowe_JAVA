public class Book extends Item {
    private int pageCount;
    private String genre;
    private String language;

    public Book(int id, String title, String author, int year, boolean isAvailable,int whoId, int pageCount, String genre, String language) {
        super(id, title, author, year, isAvailable, whoId);
        this.pageCount = pageCount;
        this.genre = genre;
        this.language = language;
    }

    public String detInformation() {
            return "liczba stron " + pageCount + ", gatunek " + genre + ", język " + language;
    }

   public String datInformation(){
       return "Dodatkowe informacje o książce:   " + detInformation();
    }

//    public String getInformation(){
//        return super.getInformation() + "liczba stron " + pageCount + ", gatunek " + genre + ", język " + language;
//    }
}