package app.mk.FaNBook.network;

import app.mk.FaNBook.model.Comment;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

import static android.provider.Telephony.TextBasedSmsColumns.BODY;

/**
 * Created by Michael Kruszczynski on 08/04/2018.
 */

public interface ApiInterface {

    @GET("/comments")
    Comment.List comments();

    @POST("/comments")
    Comment createNewComment(@Body Comment newComment);
}
