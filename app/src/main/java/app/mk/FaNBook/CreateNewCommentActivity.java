package app.mk.FaNBook;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import javax.xml.validation.Validator;

import app.mk.FaNBook.model.Comment;
import app.mk.FaNBook.network.CreateNewCommentRequest;
import app.mk.FaNBook.network.InternetActivity;

public class CreateNewCommentActivity extends InternetActivity {

    @Email  (message = "You need to inser email address")
    private EditText getAuthorEditText;

    @NotEmpty (message = "You need to add comment")
    private EditText getCommentEditText;

    Validator validator = new Validator (this);

    private EditText authorEditText;
    private EditText commentEditText;

    validator.setValidationListener(new Validator.ValidationListener) {

        @Override
        public void onValidationSucceeded(){

            Comment newComment = new Comment(0, "wewewewe","", authorEditText.getText().toString(), commentEditText.getText().toString());

            CreateNewCommentRequest createNewCommentRequest = new CreateNewCommentRequest(newComment);

            spiceManager.execute(createNewCommentRequest, new RequestListener<Comment>(){

                @Override
                public  void onRequestFailure(SpiceException spiceException) {

                    Toast.makeText(CreateNewCommentActivity.this, "Error!!", Toast.LENGTH_SHORT.show());
                }

                @Override
                public void onRequestSuccess(Comment comment) {

                    finish();
                }

            });
        }

                @Override
                public void onValidationFailed(List<ValidationError> errors) {
                    for (ValidationError error : errors) {
                        View view = error.getView();
                        String message = error.getCollatedErrorMessage(CreateNewCommentActivity.this);

                        // Display error messages ;)
                        if (view instanceof EditText) {
                            ((EditText) view).setError(message);
                        } else {
                            Toast.makeText(CreateNewCommentActivity.this, message, Toast.LENGTH_LONG).show();
                        }
                    }


            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_comment);

        authorEditText =(EditText) findViewById(R.id.authorEditText);
        commentEditText = (EditText) findViewById(R.id.commentEditText);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_create_new_comment, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id = R.id.action_settings) {
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
    public  void onSendClick(View view) {

    validator.validate();


    }
}
