public class Magazine extends Item {
    private int issueNumber;
    private String month;
    private String thema;

    public Magazine(int id, String title, String author, int year, boolean isAvailable,int whoId, int issueNumber, String month, String thema) {
        super(id, title, author, year, isAvailable, whoId);
        this.issueNumber = issueNumber;
        this.month = month;
        this.thema = thema;
    }

    public String detInformation(){
        return "Numer wydania: " + issueNumber + ", miesiąc wydania " + month + ", tematyka " + thema;
    }
    public String magazinInformation(){
        return "Dodatkowe informacje o magazynie:   " + detInformation();
    }

/*    public String getInformation(){
            return super.getInformation() + "Numer wydania: " + issueNumber + ", miesiąc wydania " + month + ", tematyka " + thema;
        }*
       public void magazinInformation(){
        System.out.println("Magazyn dodatkowe informacje: " + getInformation());
    }*/
}
