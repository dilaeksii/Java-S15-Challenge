package main;

import entity.AbstractPerson;
import entity.concrete.Address;
import entity.concrete.Author;
import entity.concrete.Book;
import entity.enums.Category;


public class Main {
    public static void main(String[] args) {
        AbstractPerson stefan = new Author(1l,"Stefan Zweig", new Address("Avusturya", 1, "Street 1"), "123456", "szweig@test.com");
        AbstractPerson yuval = new Author(2l,"Yuval Noah Harari", new Address("İsrail", 2, "Street 2"), "456789", "yuval@test.com");
        AbstractPerson isaac = new Author(3l,"Isaac Asimov", new Address("Rusya", 3, "Street 3"), "123789", "isaac@test.com");

        Book theRoyalGame = new Book(1l,(Author) stefan,"The Royal Game", 250.0, "16", Category.FICTION);
        Book letterFromAnUnknownWoman = new Book(2l,(Author) stefan,"Letter from an Unknown Woman", 200.0, "14", Category.FICTION);
        Book theWorldOfYesterday = new Book(3l,(Author) stefan,"The World of Yesterday", 240.0, "14", Category.HISTORY);
        Book marieAntoinette = new Book(4l,(Author) stefan,"Marie Antoinette", 180.0, "10", Category.BIOGRAPHY);
        Book maryStuart = new Book(5l,(Author) stefan,"Mary Stuart", 200.5, "8", Category.BIOGRAPHY);

        Book sapiens = new Book(6l,(Author) yuval,"sapiens", 200.5, "10", Category.NON_FICTION);
        Book homoDeus = new Book(7l,(Author) yuval,"Homo Deus", 250.5, "8", Category.NON_FICTION);
        Book lessonsFor21stCentury = new Book(8l,(Author) yuval,"21 Lessons for 21st Century", 260.0, "14", Category.HISTORY);
        Book money = new Book(9l,(Author) yuval,"Money", 170.5, "4", Category.NON_FICTION);
        Book nexusoranotherTitle = new Book(10l,(Author) yuval,"Nexus or Another Title", 270.5, "8", Category.NON_FICTION);

        Book foundation = new Book(11l,(Author) isaac,"Foundation", 280.5, "2", Category.FICTION);
        Book iRobot = new Book(12l,(Author) isaac,"I, Robot", 280.0, "10", Category.FICTION);
        Book theintelligentMansGuidetoScience = new Book(13l,(Author) isaac,"The Intelligent Man’s Guide to Science", 200.5, "8", Category.SCIENCE);
        Book theUniverse = new Book(14l,(Author) isaac,"The Universe", 150.5, "10", Category.SCIENCE);
        Book asimosNewguideToScience = new Book(15l,(Author) isaac,"Asimov’s New Guide to Science", 200.5, "8", Category.SCIENCE);

        ((Author) stefan).addBook(theRoyalGame);
        ((Author) stefan).addBook(letterFromAnUnknownWoman);
        ((Author) stefan).addBook(theWorldOfYesterday);
        ((Author) stefan).addBook(marieAntoinette);
        ((Author) stefan).addBook(maryStuart);

        ((Author) yuval).addBook(sapiens);
        ((Author) yuval).addBook(homoDeus);
        ((Author) yuval).addBook(lessonsFor21stCentury);
        ((Author) yuval).addBook(money);
        ((Author) yuval).addBook(nexusoranotherTitle);

        ((Author) isaac).addBook(foundation);
        ((Author) isaac).addBook(iRobot);
        ((Author) isaac).addBook(theintelligentMansGuidetoScience);
        ((Author) isaac).addBook(theUniverse);
        ((Author) isaac).addBook(asimosNewguideToScience);




    }
}