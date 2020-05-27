package com.example.tgsk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tgsk.LayoutLogic.DonorsLayout;
import com.example.tgsk.LayoutLogic.PatientLayout;
import com.example.tgsk.LayoutLogic.StatementLayout;
import com.example.tgsk.LayoutLogic.StatusAndEventLayout;
import com.example.tgsk.Status.StatusAndEvent;

import java.util.LinkedList;

public class CreateStatementActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonStatement, buttonStatusAndEvent, buttonFiles, buttonUploadFiles, buttonDonors, buttonPatient;
    LinearLayout mainContent, statusAndEventContent,
            statementContainer, filesContainer, donorContainer, patientContainer;
    int idColorButton;
    LinkedList<StatusAndEvent> statusList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_statement);
        mainContent = findViewById(R.id.MainContentLayout);
        buttonStatement = findViewById(R.id.buttonStatement);
        buttonStatusAndEvent = findViewById(R.id.buttonStatusAndEvent);
        buttonFiles = findViewById(R.id.buttonFiles);
        buttonDonors = findViewById(R.id.buttonDonors);
        buttonPatient = findViewById(R.id.buttonPatient);
        idColorButton = buttonStatement.getCurrentTextColor();
        buttonStatement.setOnClickListener(this);
        buttonStatusAndEvent.setOnClickListener(this);
        buttonFiles.setOnClickListener(this);
        buttonDonors.setOnClickListener(this);
        buttonPatient.setOnClickListener(this);

        buttonStatement.setTextColor(Color.GRAY);
        setInflater();
        onClick(buttonStatement);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_statement:
                Toast.makeText(CreateStatementActivity.this, getString(R.string.menu_statement), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_condition:
                Toast.makeText(CreateStatementActivity.this, getString(R.string.menu_condition), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_calendar:
                Toast.makeText(CreateStatementActivity.this, getString(R.string.menu_calendar), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_settings:
                Toast.makeText(CreateStatementActivity.this, getString(R.string.menu_settings), Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonStatement:
                setColorTextButton(buttonStatement);
                if (mainContent.getRootView().equals(statementContainer.getRootView())) {
                    Toast.makeText(CreateStatementActivity.this, "Вы в этом разделе", Toast.LENGTH_LONG).show();
                } else {
                    mainContent.removeAllViews();
                    mainContent.addView(statementContainer);
                    StatementLayout statementLayout = new StatementLayout(this, mainContent.getRootView());
                }
                break;

            case R.id.buttonStatusAndEvent:
                setColorTextButton(buttonStatusAndEvent);
                if (mainContent.getRootView().equals(statusAndEventContent.getRootView())) {
                    Toast.makeText(CreateStatementActivity.this, "Вы в этом разделе", Toast.LENGTH_LONG).show();
                } else {

                    mainContent.removeAllViews();
                    mainContent.addView(statusAndEventContent);
                    StatusAndEventLayout status = new StatusAndEventLayout(this, mainContent.getRootView());
                }
                break;

            case R.id.buttonFiles:
                setColorTextButton(buttonFiles);
                if (mainContent.getRootView().equals(filesContainer.getRootView())) {
                    Toast.makeText(CreateStatementActivity.this, "Вы в этом разделе", Toast.LENGTH_LONG).show();
                } else {
                    mainContent.removeAllViews();
                    mainContent.addView(filesContainer);
                    buttonUploadFiles = findViewById(R.id.buttonUploadFiles);
                    buttonUploadFiles.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent fileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                            fileIntent.setType("*/*");
                            startActivityForResult(fileIntent, 1);
                        }
                    });
                }
                break;

            case R.id.buttonDonors:
                setColorTextButton(buttonDonors);
                if (mainContent.getRootView().equals(donorContainer.getRootView())) {
                    Toast.makeText(CreateStatementActivity.this, "Вы в этом разделе", Toast.LENGTH_LONG).show();
                } else {
                    mainContent.removeAllViews();
                    mainContent.addView(donorContainer);
                    DonorsLayout donorsLayout = new DonorsLayout(this, mainContent.getRootView());
                }
                break;
            case R.id.buttonPatient:
                setColorTextButton(buttonPatient);
                if (mainContent.getRootView().equals(patientContainer.getRootView())) {
                    Toast.makeText(CreateStatementActivity.this, "Вы в этом разделе", Toast.LENGTH_LONG).show();
                } else {
                    mainContent.removeAllViews();
                    mainContent.addView(patientContainer);
                    PatientLayout patientLayout = new PatientLayout(this, mainContent.getRootView());
                }
                break;

        }
    }


    public void setInflater() {
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        statusAndEventContent = (LinearLayout) inflater.inflate(R.layout.container_statuses_and_events, null);
        statementContainer = (LinearLayout) inflater.inflate(R.layout.statement_layout, null);
        filesContainer = (LinearLayout) inflater.inflate(R.layout.files_layout, null);
        donorContainer = (LinearLayout) inflater.inflate(R.layout.donors_layout, null);
        patientContainer = (LinearLayout) inflater.inflate(R.layout.patient_layout, null);

    }


    public void setColorTextButton(Button button) {
        button.setTextColor(Color.LTGRAY);
        switch (button.getId()) {
            case R.id.buttonStatement:
                buttonStatusAndEvent.setTextColor(idColorButton);
                buttonFiles.setTextColor(idColorButton);
                buttonDonors.setTextColor(idColorButton);
                buttonPatient.setTextColor(idColorButton);
                break;
            case R.id.buttonStatusAndEvent:
                buttonStatement.setTextColor(idColorButton);
                buttonFiles.setTextColor(idColorButton);
                buttonDonors.setTextColor(idColorButton);
                buttonPatient.setTextColor(idColorButton);
                break;
            case R.id.buttonFiles:
                buttonStatement.setTextColor(idColorButton);
                buttonStatusAndEvent.setTextColor(idColorButton);
                buttonDonors.setTextColor(idColorButton);
                buttonPatient.setTextColor(idColorButton);
                break;
            case R.id.buttonDonors:
                buttonStatement.setTextColor(idColorButton);
                buttonStatusAndEvent.setTextColor(idColorButton);
                buttonFiles.setTextColor(idColorButton);
                buttonPatient.setTextColor(idColorButton);
                break;
            case R.id.buttonPatient:
                buttonStatement.setTextColor(idColorButton);
                buttonStatusAndEvent.setTextColor(idColorButton);
                buttonFiles.setTextColor(idColorButton);
                buttonDonors.setTextColor(idColorButton);
                break;
        }
    }
}
