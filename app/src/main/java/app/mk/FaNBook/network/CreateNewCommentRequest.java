package app.mk.FaNBook.network;

import app.mk.FaNBook.model.Comment;

/**
 * Created by Michael Kruszczynski on 08/04/2018.
 */

public class CreateNewCommentRequest extends RetrofitSpicyRequest<Comment, ApiInterface> {

    private  Comment newComment;

    public CreateNewCommentRequest(Comment newComment) {
        super();(Comment.class, ApiInterface.class);
        this.newComment = newComent;
    }

    @Override
    public Comment loadDataFromNetwork() throw Exception{
        return getService().createNewComment(newComment);
    }
}
