package com.example.tgsk.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tgsk.MainActivity;
import com.example.tgsk.R;
import com.example.tgsk.Statement.Statement;

import java.util.LinkedList;

public class AdapterForCalendar extends RecyclerView.Adapter<AdapterForCalendar.ViewHolder> {

    LinkedList<Statement> statementList;
    Context context;

    public AdapterForCalendar(LinkedList<Statement> statementList, Context context) {
        this.statementList = statementList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.statement_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namePatient.setText((CharSequence) statementList.get(position).getName());
        holder.typeDonor.setText((CharSequence) statementList.get(position).getType());
        holder.dateCell.setText((CharSequence) statementList.get(position).getDateEvent());
    }

    @Override
    public int getItemCount() {
        return statementList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView namePatient, surnamePatient, clinicalDiagnosis, dateCell, currentStatus, typeDonor;
        Button editStatement;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namePatient = itemView.findViewById(R.id.nameStatement);
            surnamePatient = itemView.findViewById(R.id.surnameStatement);
            clinicalDiagnosis = itemView.findViewById(R.id.clinicalDiagnosisStatement);
            dateCell = itemView.findViewById(R.id.dateCellStatement);
            currentStatus = itemView.findViewById(R.id.currentStatusStatement);
            typeDonor = itemView.findViewById(R.id.typeDonorStatement);
            editStatement = itemView.findViewById(R.id.editStatement);

            editStatement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"Изменить заявку", Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
