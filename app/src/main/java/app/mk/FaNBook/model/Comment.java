package app.mk.FaNBook.model;

import java.util.ArrayList;

/**
 * Created by Michael Kruszczynski  on 07/04/2018.
 */

public class Comment {

    public int id;
    public String book_id;
    public String date;
    public String author;
    public String comment;

    public Comment(int id, String book_id, String date, String author, String comment) {
        this.id = id;
        this.book_id = book_id;
        this.date = date;
        this.author = author;
        this.comment = comment;

    }

    public static class List extends ArrayList<Comment> {


    }
}
