package com.backend.bakckend.designpattern.struct;

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Aggregate {
    public abstract Iterator iterator(int type);

    public int getLength();
}

class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Constant {
    public static final int FORWARD = 0;
    public static final int REVERSE = 1;
}

abstract class Factory {
    public final Iterator create(Aggregate list, int type) {
        Iterator iterator = createProduct(list, type);
        return iterator;
    }

    protected abstract Iterator createProduct(Aggregate list, int type);
}

class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;
    Factory f = ItertorFactory.getInstance();

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    public Iterator iterator(int type) {
        if (type == 0) {
            return new BookShelfIterator(this);
        } else {
            return new BookShelfReverseIterator(this);
        }
    }
}

class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}

class ItertorFactory extends Factory {
    private static ItertorFactory factory = new ItertorFactory();

    private ItertorFactory() {
    }

    public static ItertorFactory getInstance() {
        if (factory == null) {
            factory = new ItertorFactory();
        }
        return factory;
    }

    @Override
    protected Iterator createProduct(Aggregate list, int type) {
        if (type == Constant.FORWARD) {
            return new BookShelfIterator((BookShelf) list);
        } else {
            return new BookShelfReverseIterator((BookShelf) list);
        }
    }
}

class BookShelfReverseIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfReverseIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = bookShelf.getLength() - 1;
    }

    public boolean hasNext() {
        if (index >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index--;
        return book;
    }
}

public class IteratorTest {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));

        Iterator it = bookShelf.iterator(Constant.FORWARD);
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println("" + book.getName());
        }

        System.out.println("============");

        it = bookShelf.iterator(Constant.REVERSE);
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println("" + book.getName());
        }


    }

}
