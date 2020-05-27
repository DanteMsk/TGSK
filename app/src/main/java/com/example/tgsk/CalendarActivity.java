package com.example.tgsk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.util.TimingLogger;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tgsk.Adapters.AdapterForCalendar;
import com.example.tgsk.Statement.Statement;
import java.util.LinkedList;

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener {

    private LinkedList<Statement> statementsAll;
    private LinkedList<Statement> statementsOnCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calendar);
        CalendarView calendar = findViewById(R.id.calendarView);
        final TextView currentDay = findViewById(R.id.currentDateText);
        final Button buttonShow = findViewById(R.id.buttonShowStatement);
        buttonShow.setOnClickListener(this);


        final String textCurrentDayTextView = currentDay.getText().toString();
        statementsAll = GetStatementList();
        statementsOnCurrentDate = new LinkedList<>();
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String choiceDate = getMonth(dayOfMonth, month, year);
                int count = 0;
                int allo = 0;
                int ayto = 0;
                buttonShow.setVisibility(View.INVISIBLE);

                if (statementsOnCurrentDate.size() > 0) {
                    statementsOnCurrentDate.clear();
                }
                for (Statement currentStatement : statementsAll) {

                    if (currentStatement.getDateEvent().equals(choiceDate)) {
                        buttonShow.setVisibility(View.VISIBLE);
                        count++;
                        statementsOnCurrentDate.add(currentStatement);
                        if (currentStatement.getType().equals("Алло")) {
                            allo++;
                        } else {
                            ayto++;
                        }
                    }
                }
                String textCountTransplantation = textCurrentDayTextView + "  " + count + "\n\nАЛЛО:  " + allo + "  АУТО:  " + ayto;
                currentDay.setText(textCountTransplantation);
            }
        });

    }

    public LinkedList<Statement> GetStatementList() {

        Statement statement = new Statement("dada", "Алло", "12/04/2020");
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
        return statementsAll;
    }

    @Override
    public void onClick(View v) {
        Dialog dialog = new Dialog(CalendarActivity.this);
        dialog.setContentView(R.layout.dialog_layout_calender);
        dialog.show();
        RecyclerView recyclerStatement = dialog.findViewById(R.id.listStatement);
        AdapterForCalendar adapter = new AdapterForCalendar(statementsOnCurrentDate, this);
        recyclerStatement.setAdapter(adapter);
        recyclerStatement.setLayoutManager(new LinearLayoutManager(this));
    }

    private String getMonth(int day, int month, int year) {

        String mountString;
        if (month + 1 < 10) {
            mountString = 0 + String.valueOf(month + 1);
        } else {
            mountString = String.valueOf(month + 1);
        }
        return day + "/" + (mountString) + "/" + year;
    }
}