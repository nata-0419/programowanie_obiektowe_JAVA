public class Item {
    protected int id;
    protected String title;
    protected String author;
    protected int year;
    protected boolean isAvailable;
    protected int whoId;

    public Item(int id, String title, String author, int year, boolean isAvailable, int whoId){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = isAvailable;
        this.whoId = whoId;
    }

    public String getInformation(){
            return "ID:" + id + " Tytuł: " + title + " Autor: " + author + " Rok wydania: " + year;
    }

    public void borrowItem(int newWhoId){
        if (whoId == 0){
            whoId = newWhoId;
            isAvailable = false;
            System.out.println( title + " zostala zarezerwowana, przez " + newWhoId);
        } else {
            System.out.println("Nie udalo się zarezerwować.");
        }
    }

    public void returnItem(int newWhoId){
        if (whoId != 0){
            whoId = 0;
            isAvailable = true;
            System.out.println("Udalo się zwrócić " + title);
            } else {
            System.out.println("Nie udalo się zwrócić " + title);
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
