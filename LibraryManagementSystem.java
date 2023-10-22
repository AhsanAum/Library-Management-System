import java.util.Scanner;

class LibraryItem {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void checkOut() {
        isCheckedOut = true;
    }

    public void checkIn() {
        isCheckedOut = false;
    }

    public String toString() {
        String status = isCheckedOut ? "Checked Out" : "Available";
        return "Title: " + title + "\nAuthor: " + author + "\nStatus: " + status;
    }
}

class Book extends LibraryItem {
    private int pageCount;

    public Book(String title, String author, int pageCount) {
        super(title, author);
        this.pageCount = pageCount;
    }

  
    public String toString() {
        return super.toString() + "\nPage Count: " + pageCount;
    }
}


class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_LIBRARY_ITEMS = 100; // Set a maximum limit of library items
        LibraryItem[] libraryItems = new LibraryItem[MAX_LIBRARY_ITEMS];
        int itemCount = 0; // Keep track of the number of items in the library

        while (true) {
            System.out.println("1. Add a book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. List available books");
            System.out.println("5. List checked out books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter page count: ");
					
                    int pageCount = scanner.nextInt();
                    Book book = new Book(title, author, pageCount);
                    libraryItems[itemCount] = book;
                    itemCount++;
                    System.out.println();
                    System.out.println();
                    break;
					
                case 2:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    boolean bookFound = false; // Add a boolean flag to track if the book is found

                    for (int i = 0; i < itemCount; i++) {
                        if (libraryItems[i] != null && libraryItems[i].getTitle().equals(borrowTitle) && !libraryItems[i].isCheckedOut()) {
                            libraryItems[i].checkOut();
                            System.out.println("You have successfully borrowed the book.");
                            bookFound = true; // Set the flag to true
							System.out.println();
							System.out.println();
                           
							break; // Exit the loop when a book is found
                        }
                    }

                    if (!bookFound) {
							System.out.println("---------------------------------------------------------------------------------------------------------\n");
							System.out.println("You Can not borrow this book Because We do not have this book , Please Enter the Correct Book\'s Title Name");
							System.out.println("---------------------------------------------------------------------------------------------------------\n");
                    }
                    break;
                case 3:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    boolean bookReturned = false; // Add a boolean flag to track if the book is returned

                    for (int i = 0; i < itemCount; i++) {
                        if (libraryItems[i] != null && libraryItems[i].getTitle().equals(returnTitle) && libraryItems[i].isCheckedOut()) {
                            libraryItems[i].checkIn();
                            System.out.println("You have successfully returned the book.");
                            bookReturned = true; // Set the flag to true
							System.out.println();
							System.out.println();
                           
							break; // Exit the loop when a book is returned
                        }
                    }

                    if (!bookReturned) {
							System.out.println("---------------------------------------------------------------------------------------------------------\n");
							System.out.println("You Can not return this book Because You did not Return this book  , Please Enter the Correct Book\'s Title Name");
							System.out.println("---------------------------------------------------------------------------------------------------------\n");
                    }
                    break;
                case 4:
                    boolean availableBooksExist = false;

                    System.out.println("\nAvailable Library Items:");
                    for (int i = 0; i < itemCount; i++) {
                        if (libraryItems[i] != null && !libraryItems[i].isCheckedOut()) {
                            System.out.println(libraryItems[i]);
                            availableBooksExist = true;
							System.out.println();


                        }
                    }

                    if (!availableBooksExist) {
						System.out.println("---------------------------------");
						System.out.println("No available books at the moment.");
						System.out.println("---------------------------------");
                  
				  }
                    break;
                case 5:
                    boolean checkedOutBooksExist = false;

                    System.out.println("Checked Out Library Items:");
						System.out.println("---------------------------------");

                    for (int i = 0; i < itemCount; i++) {
                        if (libraryItems[i] != null && libraryItems[i].isCheckedOut()) {
                            System.out.println(libraryItems[i]);
                            checkedOutBooksExist = true;
							System.out.println("--------------------------\n");

                        }
                    }

                    if (!checkedOutBooksExist) {
						System.out.println();
						System.out.println("No books have been checked out.  ");
						System.out.println("---------------------------------");
                    	}
					
					break;
                case 6:
                    System.out.println("Goodbye! ");
                    System.out.println("Thankyou So much.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("Please Enter 1 to 6:\n\n");
            }
        }
    }
}
