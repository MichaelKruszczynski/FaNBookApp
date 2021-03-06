package app.mk.FaNBook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import app.mk.FaNBook.MainActivity;
import app.mk.FaNBook.R;
import app.mk.FaNBook.model.Comment;
import app.mk.FaNBook.network.CommentsRequest;
import app.mk.FaNBook.network.InternetFragment;

/**
 * Created by Michael Kruszczynski on 07/04/2018.
 */


/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends InternetFragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private RecyclerView recyclerView;
    private CommentAdapter commentAdapter;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MainFragment newInstance(int sectionNumber) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
    }

    @Override
   public void onStart() {
        super.onStart();

        CommentsRequest commentsRequest = new CommentsRequest();
        spiceManager.execute(commentsRequest, new RequestListener<Comment.List>() {

        @Override
        public void onRequestFailure (SpiceException spiceException){
            Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show()
        }

        @Override
        public void onRequestSuccess (Comment.List comments){
            commentAdapter.addNewComments(comments);
        }
     });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        commentAdapter = new CommentAdapter();
        recyclerView.setAdapter(commentAdapter);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
