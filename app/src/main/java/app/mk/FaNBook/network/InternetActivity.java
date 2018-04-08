package app.mk.FaNBook.network;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

import com.octo.android.robospice.SpiceManager;

/**
 * Created by Michael Kruszczynski on 08/04/2018.
 */

public class InternetActivity extends AppCompatActivity {

    //------------------------------------------------------------------------
//this block can be pushed up into a common base class for all activities
//------------------------------------------------------------------------

    //if you use a pre-set service,
//use JacksonSpringAndroidSpiceService.class instead of JsonSpiceService.class
    protected SpiceManager spiceManager = new SpiceManager(ApiService.class);


    @Override
    protected void onStart() {
        super.onStart();
        spiceManager.start(this);
    }

    @Override
    protected void onStop() {
        spiceManager.shouldStop();
        super.onStop();
    }
}
