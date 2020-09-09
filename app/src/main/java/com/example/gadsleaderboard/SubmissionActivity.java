package com.example.gadsleaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gadsleaderboard.data.GoogleFormService;
import com.example.gadsleaderboard.data.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionActivity extends AppCompatActivity {
    EditText firstNameEt, lastNameEt, emailAddressEt, gitLinkEt;
    ImageButton backBtn;
    private static final String GOOGLE_FORM_URL = "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";

    private AlertDialog confirmationAlertDialog;
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mGitLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        initViews();

    }

    private void initViews() {
        firstNameEt = findViewById(R.id.etFirstNameId);
        lastNameEt = findViewById(R.id.etLastNameId);
        emailAddressEt = findViewById(R.id.etEmailAddressId);
        gitLinkEt = findViewById(R.id.etGitHubLinkId);
        gitLinkEt.setText("https://github.com/mohamedzizo127-eng/GADS_Leaderboard.git");
        backBtn = findViewById(R.id.backImageButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void submit(View view) {
        mFirstName = firstNameEt.getText().toString();
        mLastName = lastNameEt.getText().toString();
        mEmail = emailAddressEt.getText().toString();
        mGitLink = gitLinkEt.getText().toString();
        boolean isEmpty = checkFields(mFirstName, mLastName, mEmail, mGitLink);
        if (isEmpty) return;
        confermDialoge();


    }

    private void confermDialoge() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.alert_layout, null);
        builder.setView(view);
        final Button yesBtn = view.findViewById(R.id.btnYesID);
        final ImageButton cancelBtn = view.findViewById(R.id.btnCancelId);
        confirmationAlertDialog = builder.create();
        confirmationAlertDialog.setCanceledOnTouchOutside(false);
        confirmationAlertDialog.show();
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmationAlertDialog.dismiss();

            }
        });
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitRequest();
                confirmationAlertDialog.dismiss();

            }
        });


    }

    private boolean checkFields(String firstName, String lastName, String email, String gitLink) {
        if (TextUtils.isEmpty(firstName) ||
                TextUtils.isEmpty(lastName) ||
                TextUtils.isEmpty(email) ||
                TextUtils.isEmpty(gitLink)) {
            Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_LONG).show();
            return true;

        } else {
            return false;
        }
    }

    private void submitRequest() {
        GoogleFormService formService = ServiceBuilder.buildService(GoogleFormService.class);
            Call<Void> voidCall = formService.postGoogleForm(GOOGLE_FORM_URL, mEmail, mFirstName, mLastName, mGitLink);
            voidCall.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    showResultMessage(R.layout.success_dialog);
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                       showResultMessage(R.layout.error_dialog);
                }
            });




 }



    private void showResultMessage(int layoutId) {
        View view = LayoutInflater.from(this).inflate(layoutId,  null);
        AlertDialog.Builder alerBuilder = new AlertDialog.Builder(this);
        alerBuilder.setView(view)
         .create()
                .show();



    }


}

