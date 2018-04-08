package app.mk.FaNBook.network;


import android.support.v4.app.Fragment;

import com.octo.android.robospice.SpiceManager;

/**
 * Created by Michael Kruszczynski on 08/04/2018.
 */

public class InternetFragment extends Fragment {
    protected SpiceManager spiceManager = new SpiceManager(ApiService.class);

    @Override
    public void onStart() {
        super.onStart();
        spiceManager.start(getActivity());
    }

    @Override
    public void onStop() {
        if (spiceManager.isStarted()){
            spiceManager.shouldStop();
        }
        super.onStop();

}

}
