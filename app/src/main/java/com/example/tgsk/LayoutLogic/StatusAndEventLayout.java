package com.example.tgsk.LayoutLogic;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tgsk.Adapters.AdapterForStatus;
import com.example.tgsk.R;
import com.example.tgsk.Status.StatusAndEvent;

import java.util.LinkedList;

public class StatusAndEventLayout implements View.OnClickListener {

    private Spinner currentStatus;
    private TextView dateStatus;
    private Context context;
    private Button deleteStatus;
    private Button addStatement;
    private StatusAndEvent statusAndEvent;
    private LinkedList<StatusAndEvent> statusList;
    private View view;

    public StatusAndEventLayout(Context context, View view) {
        statusList = new LinkedList<>();
        addStatement = view.findViewById(R.id.buttonAddStatusTest);
        addStatement.setOnClickListener(this);
        this.context = context;
        this.view = view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAddStatusTest:
                StatusAndEvent newStatus = new StatusAndEvent();
                statusList.add(newStatus);
                setRecyclerView();
                break;
            default:
                v.setBackgroundColor(Color.rgb(236, 236, 236));
        }
    }


    public void setRecyclerView() {
        RecyclerView recyclerStatement = view.findViewById(R.id.listStatusAndEvent);
        AdapterForStatus adapter = new AdapterForStatus(statusList, context);
        recyclerStatement.setAdapter(adapter);
        recyclerStatement.setLayoutManager(new LinearLayoutManager(context));
    }
}
