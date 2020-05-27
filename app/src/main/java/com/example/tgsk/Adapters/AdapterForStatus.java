package com.example.tgsk.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tgsk.R;
import com.example.tgsk.Status.StatusAndEvent;

import java.util.LinkedList;

public class AdapterForStatus extends RecyclerView.Adapter<AdapterForStatus.ViewHolder> {

    LinkedList<StatusAndEvent> statusList;
    Context context;
    private int currentPosition;

    public AdapterForStatus(LinkedList<StatusAndEvent> statementList, Context context) {
        this.statusList = statementList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.status_and_date_statement, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        currentPosition = holder.getAdapterPosition();
    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dateStatus;
        Spinner currentStatus;
        Button deleteStatus;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            currentStatus = itemView.findViewById(R.id.spinnerCurrentStatus);
            currentStatus.setAdapter(setSpinnerAdapter());
            dateStatus = itemView.findViewById(R.id.statusDateText);
            deleteStatus = itemView.findViewById(R.id.buttonDeleteStatus);

            deleteStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, String.valueOf(currentPosition), Toast.LENGTH_LONG).show();
                       statusList.remove(currentPosition);
                    notifyDataSetChanged();
                }
            });
        }

        private ArrayAdapter<String> setSpinnerAdapter() {
            String array[] = context.getResources().getStringArray(R.array.spinnerCurrentStatus);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                    android.R.layout.simple_selectable_list_item,
                    array);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            return adapter;
        }


    }
}
