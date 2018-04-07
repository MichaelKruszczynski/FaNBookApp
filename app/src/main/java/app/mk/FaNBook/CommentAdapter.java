package app.mk.FaNBook;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import app.mk.FaNBook.model.Comment;

/**
 * Created by Michael Kruszczynski on 07/04/2018.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private Comment.List commentList;

    public CommentAdapter() {

        commentList = new Comment.List();

        commentList.add(new Comment(0,"eeewesdsdde","3.02.1985","wqwqw","dsdsd"));
        commentList.add(new Comment(1,"eedde","3.02.1985","wqwqw","dsdsd"));
        commentList.add(new Comment(2,"eedfffde","3.02.1985","wqwqw","dsdsd"));
        commentList.add(new Comment(3,"ee33dde","3.02.1985","wqwqw","dsdsd"));


    }


    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView dateTextView;
        public TextView commentTextView;

        public CommentViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            commentTextView = (TextView) itemView.findViewById(R.id.commentTextView);

            }
        }
    }
