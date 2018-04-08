package app.mk.FaNBook.network;

import org.w3c.dom.Comment;

/**
 * Created by Michael Kruszczynski on 08/04/2018.
 */

public class CommentsRequest extends RetrofitSpiceRequest<Comment.List, ApiInterface>{


    public  CommentsRequest() {
        super(Comment.List.class, ApiInterface.class);
    }

    @Override
    public Comment.List loadDataFromNetwork() throws Exception {
        return getServices().comments();
    }
}
