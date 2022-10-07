import Classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Item> arr = new ArrayList<>();

        arr.add(new Book("pierville", 2001, 120, "mary", Genres.SCIFI));
        arr.add(new Book("moldova", 2001, 120, "lollo", Genres.ACTION));
        arr.add(new Book("sssas", 2001, 120, "pollo", Genres.ROMANCE));
        arr.add (new Book("sadsadsadsa", 2001, 120, "mary", Genres.ACTION));
        arr.add(new Book("pieerwee", 2001, 120, "mary", Genres.ACTION));
        arr.add(new Book("ttrvrev", 2001, 120, "lillo", Genres.ADVENTURE));
        arr.add(new Book("errty", 2001, 120, "strillo", Genres.ACTION));
        arr.add(new Book("rrrr", 2001, 120, "dasd", Genres.ACTION));
        arr.add(new Book("hhhhh", 2001, 120, "0", Genres.KIDS));

        arr.add(new Magazines("asdsad", 2022, 32, Periodicity.SEMESTER));
        arr.add(new Magazines("ggggg", 2022, 32, Periodicity.MONTH));
        arr.add(new Magazines("re", 2022, 32, Periodicity.SEMESTER));
        arr.add(new Magazines("kings", 2022, 32, Periodicity.WEEK));


        Archive archivio = new Archive();

//        archivio.setList(arr);

//        archivio.removeByIsbn(0);

//        archivio.searchAuthor("mary");

//        archivio.searchIsbn(7);

//        archivio.searchYear(2022);

//        archivio.saveBackup();

//        archivio.downloadBackup();

//        archivio.printList();

        Scanner scanner = new Scanner(System.in);




    }
}