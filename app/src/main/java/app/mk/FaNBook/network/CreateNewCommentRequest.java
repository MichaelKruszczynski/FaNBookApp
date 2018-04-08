package app.mk.FaNBook.network;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import app.mk.FaNBook.model.Comment;

/**
 * Created by Michael Kruszczynski on 08/04/2018.
 */

public class CreateNewCommentRequest extends RetrofitSpiceRequest<Comment, ApiInterface> {

    private  Comment newComment;

    public CreateNewCommentRequest(Comment newComment) {
        super(Comment.class, ApiInterface.class);
        this.newComment = newComment;
    }

    @Override
    public Comment loadDataFromNetwork() throws Exception{
        return getService().createNewComment(newComment);
    }
}
