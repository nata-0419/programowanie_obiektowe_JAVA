public class Wynik {
    public static void main(String[] args){
        Book b1 = new Book("Dziady", "Adam Mickiewicz", 1850);
        Book b2 = new Book("Elita", "zaws", 2015);

        System.out.println(b1);
        System.out.println(b2);

        System.out.println("Czy 'Dziady' są starsze niż 'Elita'? " + b1.isOlderThan(b2));
        }
}
