package app.mk.FaNBook.network;

import app.mk.FaNBook.model.Comment;
import retrofit.http.GET;

/**
 * Created by Michael Kruszczynski on 08/04/2018.
 */

public interface ApiInterface {

    @GET("comments")
    Comment.List coments();
}
