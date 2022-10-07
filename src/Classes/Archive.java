package Classes;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Archive {
    private ArrayList<Item> list = new ArrayList<>();

    public Archive() {
        setList(new ArrayList<>(0));
    }

    public void setList(ArrayList<Item> list) {
        this.list = list;
    }

    public void addElement(Item obj) {
        list.add(obj);
    }

    public void searchIsbn(int isbn) {
        try {
            List<Item> searchedList = list.stream()
                    .filter(c -> c.getIsbn() == isbn)
                    .collect(Collectors.toList());

            AtomicInteger i = new AtomicInteger();
            searchedList.forEach((e) -> {
                System.out.println(e);
                i.getAndIncrement();
            });

            System.out.println(i + " Elementi Trovati");
        } catch (Exception e) {
            System.out.println("error detected pls inert a vilid paramether");
        }
    }

    public void searchAuthor(String author) {
        try {
            List<Book> searchedList = list.stream()
                    .filter(c -> c instanceof Book)
                    .map(c -> (Book) c)
                    .filter((c -> c.getAuthor() == author))
                    .collect(Collectors.toList());

            AtomicInteger i = new AtomicInteger();
            searchedList.forEach((e) -> {
                System.out.println(e);
                i.getAndIncrement();
            });

            System.out.println(i + " Elementi Trovati");
        } catch (Exception e) {
            System.out.println("error detected pls inert a vilid paramether");
        }
    }

    public void searchYear(int year) {
        try {
            List<Item> searchedList = list.stream()
                    .filter((c -> c.getYear() == year))
                    .collect(Collectors.toList());

            AtomicInteger i = new AtomicInteger();
            searchedList.forEach((e) -> {
                System.out.println(e);
                i.getAndIncrement();
            });

            System.out.println(i + " Elementi Trovati");
        } catch (Exception e) {
            System.out.println("error detected pls inert a vilid paramether");
        }
    }

    public void removeByIsbn(int isbn) {
        try {
            List<Item> searchedList = list.stream()
                    .filter(c -> c.getIsbn() != isbn)
                    .collect(Collectors.toList());

            ArrayList<Item> finalResult = ((ArrayList) searchedList);


            if (finalResult.size() == list.size()){
                System.out.println("No elemrnt with isbn: " + isbn + " found");
            }else {
                setList(finalResult);

                System.out.println("Done!");
            }


        } catch (Exception e) {
            System.out.println("error detected pls inert a vilid paramether");
        }
    }

    public void saveBackup() {
        String fileName = "docs/Backup.txt";
        File BackupFile = new File(fileName);
        String encoding = "UTF-8";

        if (BackupFile.exists()) {

            try{
                FileUtils.writeStringToFile(BackupFile,"", false);
            }catch (IOException e) {
            System.out.println("Error");
            }


            for (int i = 0; i < list.size(); i++) {

                if (list.get(i) instanceof Book) {

                    try {
                        FileUtils.writeStringToFile(BackupFile,
                                list.get(i).getIsbn()
                                        + " " +
                                        list.get(i).getTitle()
                                        + " " +
                                        list.get(i).getYear()
                                        + " " +
                                        list.get(i).getPageNumber()
                                        + " " +
                                        ((Book) list.get(i)).getAuthor()
                                        + " " +
                                        ((Book) list.get(i)).getGenre()
                                        + "\n",
                                encoding,
                                true);
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                } else {
                    try {
                        FileUtils.writeStringToFile(BackupFile,
                                list.get(i).getIsbn()
                                        + " " +
                                        list.get(i).getTitle()
                                        + " " +
                                        list.get(i).getYear()
                                        + " " +
                                        list.get(i).getPageNumber()
                                        + " " +
                                        ((Magazines) list.get(i)).getPeriodicity()
                                        + "\n"
                                ,
                                encoding,
                                true);
                    } catch (IOException e) {
                        System.out.println("Error");
                    }

                }


            }

        }
        else{
            try { // Nel caso in cui non esiste il file, viene creato automaticamente
                FileUtils.writeStringToFile(BackupFile, " ", encoding);
                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i) instanceof Book) {

                        try {
                            FileUtils.writeStringToFile(BackupFile,
                                    list.get(i).getIsbn()
                                            + " " +
                                            list.get(i).getTitle()
                                            + " " +
                                            list.get(i).getYear()
                                            + " " +
                                            list.get(i).getPageNumber()
                                            + " " +
                                            ((Book) list.get(i)).getAuthor()
                                            + " " +
                                            ((Book) list.get(i)).getGenre()
                                            + "\n",
                                    encoding,
                                    true);
                        } catch (IOException e) {
                            System.out.println("Error");
                        }
                    } else {
                        try {
                            FileUtils.writeStringToFile(BackupFile,
                                    list.get(i).getIsbn()
                                            + " " +
                                            list.get(i).getTitle()
                                            + " " +
                                            list.get(i).getYear()
                                            + " " +
                                            list.get(i).getPageNumber()
                                            + " " +
                                            ((Magazines) list.get(i)).getPeriodicity()
                                            + "\n",
                                    encoding,
                                    true);
                        } catch (IOException e) {
                            System.out.println("Error");
                        }

                    }


                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void downloadBackup(){

        String fileName = "docs/Backup.txt";
        File BackupFile = new File(fileName);
        String encoding = "UTF-8";
        String krowlerOutput;

        if( BackupFile.exists() ) {

            try {

                krowlerOutput = FileUtils.readFileToString( BackupFile, encoding );

                ArrayList<Item> arr = new ArrayList<>();


                String[] stringObj = krowlerOutput.split("\n");

                for (int i = 0; i < stringObj.length; i++) {


                    String[] el = stringObj[i].split(" ");



//                    for (int j = 0; j < el.length; j++) {
//                        System.out.println(el[i]);
//                    }

                    if(el.length == 5){
                        arr.add(new Magazines(el[1], Integer.parseInt(el[2]), Integer.parseInt(el[3]),
                                Periodicity.valueOf(el[4])));
                    }else {
                        arr.add(new Book(el[1], Integer.parseInt(el[2]), Integer.parseInt(el[3]), el[4],
                                Genres.valueOf(el[5])));
                    }
                }

                setList(arr);

            } catch( IOException e ) {
                System.out.println( "Error" );
            }

        } else {
            System.out.println("nessun backup trovato");
        }
    }

    public void printList(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
