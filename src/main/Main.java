package main;

import entity.AbstractPerson;
import entity.concrete.*;
import entity.enums.Category;
import entity.enums.MemberShipType;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Librarian librarian = new Librarian();
        library.setLibrarian(librarian);
        librarian.setLibrary(library);

        Author stefan = new Author(1l,"Stefan Zweig", new Address("Avusturya", 1, "Street 1"), "123456", "szweig@test.com");
        Author yuval = new Author(2l,"Yuval Noah Harari", new Address("İsrail", 2, "Street 2"), "456789", "yuval@test.com");
        Author isaac = new Author(3l,"Isaac Asimov", new Address("Rusya", 3, "Street 3"), "123789", "isaac@test.com");

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

        stefan.addBook(theRoyalGame);
        stefan.addBook(letterFromAnUnknownWoman);
        stefan.addBook(theWorldOfYesterday);
        stefan.addBook(marieAntoinette);
        stefan.addBook(maryStuart);

        yuval.addBook(sapiens);
        yuval.addBook(homoDeus);
        yuval.addBook(lessonsFor21stCentury);
        yuval.addBook(money);
        yuval.addBook(nexusoranotherTitle);

        isaac.addBook(foundation);
        isaac.addBook(iRobot);
        isaac.addBook(theintelligentMansGuidetoScience);
        isaac.addBook(theUniverse);
        isaac.addBook(asimosNewguideToScience);

        library.addBook(theRoyalGame);
        library.addBook(letterFromAnUnknownWoman);
        library.addBook(theWorldOfYesterday);
        library.addBook(marieAntoinette);
        library.addBook(maryStuart);

        library.addBook(sapiens);
        library.addBook(homoDeus);
        library.addBook(lessonsFor21stCentury);
        library.addBook(money);
        library.addBook(nexusoranotherTitle);

        library.addBook(foundation);
        library.addBook(iRobot);
        library.addBook(theintelligentMansGuidetoScience);
        library.addBook(theUniverse);
        library.addBook(asimosNewguideToScience);

        Member member1 = new Member(1l,MemberShipType.BASIC);
        Reader reader1 = new Reader(1l, "Dila", new Address("İstanbul" , 3434, "Göztepe"), "+905454658787", "dila@test.com", new Member(1L, MemberShipType.BASIC), 1000.0);
        reader1.setMember(member1);
        library.addReader(reader1);

        library.addAuthor(yuval);
        library.addAuthor(isaac);
        library.addAuthor(stefan);

        Address addressForTest = new Address("İstanbul", 34730, "Göztepe");

        Scanner userInput = new Scanner(System.in);


        while (true) {
            System.out.println("Welcome to Library Management System\n" +
                    "Select an option:\n" +
                    "1. Book Operations\n" +
                    "2. Reader Operations\n" +
                    "3. Author Operations\n" +
                    "4. Exit");
            int choice = userInput.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Add Book\n" +
                            "2. Search Book By Name\n" +
                            "3. Search Books By Category\n" +
                            "4. Search Books By Author\n" +
                            "5. List All Books\n" +
                            "6. Show Book Details\n" +
                            "7. Remove Book\n" +
                            "0. Back");
                    boolean c = true;
                    while (c) {
                        int choice2 = userInput.nextInt();
                        if (choice2 == 0) c = false;
                        switch (choice2) {
                            case 1:
                                System.out.println("Enter book id: ");
                                userInput.nextLine();
                                Long bookId = userInput.nextLong();
                                System.out.println("Enter book name: ");
                                userInput.nextLine();
                                String bookName = userInput.nextLine();
                                Book book = new Book(bookId, yuval, bookName, 34.50, "16", Category.BIOGRAPHY );
                                library.addBook(book);
                                System.out.println("The book has been added to the library");
                                break;
                            case 2:
                                System.out.println("Enter the name of the book you want to search for: ");
                                userInput.nextLine();
                                String searchedBook = userInput.nextLine();
                                System.out.println(librarian.searchBook(searchedBook));
                                break;
                            case 3:
                                System.out.println("Which type of book are you searching for? Please enter a category name: ");
                                userInput.nextLine();
                                String categoryOfBook = userInput.nextLine();
                                System.out.println(library.filterByCategory(Category.valueOf(categoryOfBook)));
                                break;
                            case 4:
                                System.out.println("Which authors book are you searching for? Please enter full name of the author: ");
                                userInput.nextLine();
                                String authorName = userInput.nextLine();
                                Author searchedA = null;
                                for (Author a : library.getAuthors()) {
                                    if (a.getName().equals(authorName)) {
                                        searchedA = a;
                                        break;
                                    }
                                }
                                System.out.println(library.filterByAuthor(searchedA));
                                break;
                            case 5:
                                System.out.println(library.getBooks());
                                break;
                            case 6:
                                System.out.println("Which book details do you want? ");
                                userInput.nextLine();
                                String bookDetail = userInput.nextLine();
                                Book bookD = null;
                                for (Book b: library.getBooks()) {
                                    if (b.getName().equals(bookDetail)) {
                                        bookD = b;
                                    }
                                }
                                if (bookD != null) {
                                    System.out.println(bookD);
                                } else {
                                    System.out.println("The book you are searching for cannot be found. ");
                                }
                                break;
                            case 7:
                                System.out.println("Which book do you want to remove from the library? ");
                                userInput.nextLine();
                                String bookR = userInput.nextLine();
                                Book bookRem = null;
                                for (Book b: library.getBooks()) {
                                    if (b.getName().equals(bookR)) {
                                        bookRem = b;
                                    }
                                }
                                if (bookRem != null) {
                                    library.removeBook(bookRem);
                                    System.out.println("The book has been removed from the library. ");
                                } else {
                                    System.out.println("The book you want to remove from the library cannot be found. ");
                                }
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("1. Add Reader\n" +
                            "2. Show Reader Information\n" +
                            "3. Borrow Book\n" +
                            "4. Return Book\n" +
                            "5. Show Reader's Books\n" +
                            "6. Verify Membership\n" +
                            "0. Back");
                    boolean c2 = true;
                    while (c2) {
                        int choice2 = userInput.nextInt();
                        if (choice2 == 0) c2 = false;
                        switch (choice2) {
                            case 1:
                                System.out.println("Enter readers id: ");
                                userInput.nextLine();
                                Long readerId = userInput.nextLong();
                                System.out.println("Enter readers name: ");
                                userInput.nextLine();
                                String readerName = userInput.nextLine();
                                System.out.println("Enter readers phone number: ");
                                String readerPhone = userInput.nextLine();
                                System.out.println("Enter readers email: ");
                                String readerEmail = userInput.nextLine();
                                System.out.println("Enter readers membership type: BASIC or PREMIUM ");
                                String readerMemberShip = userInput.nextLine();
                                System.out.println("Enter readers budget: ");
                                Double readerB = userInput.nextDouble();
                                Reader reader = new Reader(readerId, readerName, addressForTest, readerPhone, readerEmail, new Member(readerId, MemberShipType.valueOf(readerMemberShip)), readerB);
                                library.addReader(reader);
                                reader.setMember(new Member(readerId, MemberShipType.valueOf(readerMemberShip)));
                                System.out.println("Reader has been added to the library. ");
                                break;
                            case 2:
                                System.out.println("Which reader are you searching for? ");
                                userInput.nextLine();
                                String readername = userInput.nextLine();
                                Reader readerD = null;
                                for (Reader r: library.getReaders()) {
                                    if (r.getName().equals(readername)) {
                                        readerD = r;
                                    }
                                }
                                if (readerD != null) {
                                    System.out.println(readerD);
                                } else {
                                    System.out.println("The reader you are searching for cannot be found. ");
                                }
                                break;
                            case 3:
                                System.out.println("Who are you? ");
                                userInput.nextLine();
                                String rName = userInput.nextLine();
                                Reader reader3 = null;
                                for (Reader r: library.getReaders()) {
                                    if (r.getName().equals(rName)) {
                                        reader3 = r;
                                    }
                                }
                                reader3.whoYouAre();
                                System.out.println("Which book you want to lend? ");
                                String bookR = userInput.nextLine();
                                Book bookRem = null;
                                for (Book b: library.getBooks()) {
                                    if (b.getName().equals(bookR)) {
                                        bookRem = b;
                                    }
                                }
                                if (bookRem == null) {
                                    System.out.println("The book cannot be found.");
                                    break;
                                } else {

                                    library.lendBook(reader3, bookRem);
                                    librarian.createBill(reader3, bookRem);
                                    System.out.println("Reader has lended book : " + reader3.getBooks());
                                }
                                break;
                            case 4:
                                System.out.println("Who are you? ");
                                userInput.nextLine();
                                String r1 = userInput.nextLine();
                                Reader reader4 = null;
                                for (Reader r: library.getReaders()) {
                                    if (r.getName().equals(r1)) {
                                        reader4 = r;
                                    }
                                }
                                reader4.whoYouAre();
                                System.out.println("Which book you want to return? ");
                                String bookReturn = userInput.nextLine();
                                Book book1 = null;
                                for (Book b: library.getBooks()) {
                                    if (b.getName().equals(bookReturn)) {
                                        book1 = b;
                                    }
                                }
                                if (book1 == null) {
                                    System.out.println("The book cannot be found.");
                                    return;
                                } else {
                                    library.takeBook(reader4, book1);
                                    System.out.println("Reader has lended book : " + reader4.getBooks());
                                }
                                break;
                            case 5:
                                System.out.println("Who are you? ");
                                userInput.nextLine();
                                String r2 = userInput.nextLine();
                                Reader reader5 = null;
                                for (Reader r: library.getReaders()) {
                                    if (r.getName().equals(r2)) {
                                        reader5 = r;
                                    }
                                }
                                if (reader5 != null) {
                                    System.out.println("Reader has lended book : " + reader5.getBooks());
                                } else {
                                    return;
                                }
                                break;
                            case 6:
                                System.out.println("Who are you? ");
                                userInput.nextLine();
                                String r3 = userInput.nextLine();
                                Reader reader6 = null;
                                for (Reader r: library.getReaders()) {
                                    if (r.getName().equals(r3)) {
                                        reader6 = r;
                                    }
                                }
                                if (reader6 != null) {
                                    if (librarian.verifyMember(reader6)) {
                                        System.out.println("Member has been verified. ");
                                    } else {
                                        System.out.println("Member cannot be verified. ");
                                    }
                                } else {
                                    return;
                                }
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("1. Add Author\n" +
                            "2. Show Author Information\n" +
                            "3. Add Book To Author\n" +
                            "4. Show Author's Books\n" +
                            "5. List All Authors\n" +
                            "0. Back");
                    boolean c3 = true;
                    while (c3) {
                        int choice2 = userInput.nextInt();
                        if (choice2 == 0) c3 = false;
                        switch (choice2) {
                            case 1:
                                System.out.println("Enter authors id: ");
                                userInput.nextLine();
                                Long authorId = userInput.nextLong();
                                System.out.println("Enter authors name: ");
                                userInput.nextLine();
                                String authorName = userInput.nextLine();
                                System.out.println("Enter authors phone number: ");
                                String authorPhone = userInput.nextLine();
                                System.out.println("Enter authors email: ");
                                String authorEmail = userInput.nextLine();
                                Author author = new Author(authorId, authorName, addressForTest, authorPhone, authorEmail);
                                library.addAuthor(author);
                                System.out.println("Author has been added to the library.");
                                break;
                            case 2:
                                System.out.println("Which authors information do you want? ");
                                userInput.nextLine();
                                String a1 = userInput.nextLine();
                                Author author1 = null;
                                for (Author a: library.getAuthors()) {
                                    if (a.getName().equals(a1)) {
                                        author1 = a;
                                    }
                                }
                                if (author1 == null) {
                                    System.out.println("You are searching for wrong author. ");
                                } else {
                                    System.out.println(author1);
                                }
                                break;
                            case 3:
                                System.out.println("Which book you want to add to ? ");
                                String bookReturn = userInput.nextLine();
                                Book book1 = null;
                                for (Book b: library.getBooks()) {
                                    if (b.getName().equals(bookReturn)) {
                                        book1 = b;
                                    }
                                }
                                if (book1 == null) {
                                    System.out.println("The book cannot be found.");
                                    return;
                                } else {
                                    System.out.println("Which authors book is this? ");
                                    userInput.nextLine();
                                    String a2 = userInput.nextLine();
                                    Author author2 = null;
                                    for (Author a: library.getAuthors()) {
                                        if (a.getName().equals(a2)) {
                                            author2 = a;
                                        }
                                    }
                                    if (author2 != null) {
                                        author2.addBook(book1);
                                        System.out.println("The book has written by " + author2.getName());
                                    } else {
                                        return;
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Which authors books do you want to look at? ");
                                userInput.nextLine();
                                String a2 = userInput.nextLine();
                                Author author2 = null;
                                for (Author a: library.getAuthors()) {
                                    if (a.getName().equals(a2)) {
                                        author2 = a;
                                    }
                                }
                                if (author2 != null) {
                                    System.out.println("The books written by " + author2.getName() + " are " + author2.getBooks() );
                                } else {
                                    return;
                                }
                                break;
                            case 5:
                                System.out.println("There are " + library.getAuthors().size() + " authors in the library. " + library.getAuthors());
                            }
                        }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}