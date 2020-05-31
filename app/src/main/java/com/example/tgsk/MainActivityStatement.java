package com.example.tgsk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tgsk.Adapters.AdapterForMainActivity;
import com.example.tgsk.RequestLogic.SentRequest;
import com.example.tgsk.Statement.Statement;
import com.google.gson.Gson;

import java.util.LinkedList;

public class MainActivityStatement extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Button dialogCreateButton;
    Button createButton;
    Button filterButton;
    Spinner spinner;
    LinkedList<Statement> statementsAll;
    TextView countStatement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButton = findViewById(R.id.createNewStatementButton);
        createButton.setOnClickListener(this);
        countStatement = findViewById(R.id.countStatement);
        filterButton = findViewById(R.id.filterButton);
        filterButton.setOnClickListener(this);

        RecyclerView recyclerStatement = findViewById(R.id.listStatementMain);
        AdapterForMainActivity adapter = new AdapterForMainActivity(getStatementList(), this);
        recyclerStatement.setAdapter(adapter);
        recyclerStatement.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_statement:
                break;
            case R.id.action_condition:
                intent = new Intent(MainActivityStatement.this, StatusGraphActivity.class);
                startActivity(intent);
                break;
            case R.id.action_calendar:
                intent = new Intent(MainActivityStatement.this, CalendarActivity.class);
                startActivity(intent);
                break;
            case R.id.action_settings:
                Toast.makeText(MainActivityStatement.this, getString(R.string.menu_settings), Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public LinkedList<Statement> getStatementList() {

        Statement statement = new Statement("daduuuuuuuuuuduuuuuuuuuuuuuuuuuuuuuua", "Алло", "12/04/2020");
        Statement statement2 = new Statement("dad", "Алло", "12/04/2020");
        Statement statement3 = new Statement("dadda", "Алло", "15/04/2020");
        Statement statement4 = new Statement("daaa", "Алло", "12/04/2020");
        Statement statement5 = new Statement("daaaassssssssssssssssssssssssssssssssssss", "Ауто", "12/04/2020");
        Statement statement6 = new Statement("daaa", "Алло", "19/06/2020");

        statementsAll = new LinkedList<>();
        statementsAll.add(statement);
        statementsAll.add(statement2);
        statementsAll.add(statement3);
        statementsAll.add(statement4);
        statementsAll.add(statement5);
        statementsAll.add(statement6);
        setCountStatement();
        return statementsAll;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialogCreateButton:
                Intent intent = new Intent(MainActivityStatement.this, CreateStatementActivity.class);
                startActivity(intent);
                break;
            case R.id.createNewStatementButton:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityStatement.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_layout_create, null);
                spinner = dialogView.findViewById(R.id.typeOfCellTherapy);
                spinner.setAdapter(getAdapterForSpinner());
                dialogCreateButton = dialogView.findViewById(R.id.dialogCreateButton);
                dialogCreateButton.setOnClickListener(this);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
            case R.id.filterButton:
                SentRequest sentRequest = new SentRequest();
                sentRequest.setContext(this);
                String JSONobj = new Gson().toJson("John");
                sentRequest.execute("https://mmit.fccho-moscow.ru:4000/requests#", "name", JSONobj);
                break;
        }
    }

    private ArrayAdapter<String> getAdapterForSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivityStatement.this,
                android.R.layout.simple_selectable_list_item,
                getResources().getStringArray(R.array.dialogCreateStatement));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    private void setCountStatement() {
        if (statementsAll != null) {
            String countStatementSt = countStatement.getText() + "  " + statementsAll.size();
            countStatement.setText(countStatementSt);
        }
    }
}
