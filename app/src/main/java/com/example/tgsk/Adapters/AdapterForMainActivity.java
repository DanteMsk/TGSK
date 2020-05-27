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

import com.example.tgsk.R;
import com.example.tgsk.Statement.Statement;

import java.util.LinkedList;

public class AdapterForMainActivity extends RecyclerView.Adapter<AdapterForMainActivity.ViewHolder> {
    private LinkedList<Statement> statementList;
    private Context context;

    public AdapterForMainActivity(LinkedList<Statement> statementList, Context context) {
        this.statementList = statementList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.statement_row_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namePatient.setText((CharSequence) statementList.get(position).getName());
        holder.surnamePatient.setText((CharSequence) statementList.get(position).getSurnamePatient());
        holder.clinicalDiagnosis.setText((CharSequence) statementList.get(position).getClinicalDiagnosis());
        holder.clinic.setText((CharSequence) statementList.get(position).getClinic());
        holder.dateCell.setText((CharSequence) statementList.get(position).getDateEvent());
        holder.currentStatus.setText((CharSequence) statementList.get(position).getStatus());
        holder.cart.setText((CharSequence) statementList.get(position).getCart());
        holder.optimalDate.setText((CharSequence) statementList.get(position).getOptimalDate());
        holder.hla_typing.setText((CharSequence) statementList.get(position).getHla_typing());
    }


    @Override
    public int getItemCount() {
        return statementList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView namePatient, surnamePatient, clinicalDiagnosis, dateCell, currentStatus,
                 optimalDate ,clinic, cart, hla_typing;
        Button showStatement;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namePatient = itemView.findViewById(R.id.nameStatementMain);
            surnamePatient = itemView.findViewById(R.id.surnameStatementMain);
            clinicalDiagnosis = itemView.findViewById(R.id.clinicalDiagnosisStatementMain);
            dateCell = itemView.findViewById(R.id.dateCellStatementMain);
            currentStatus = itemView.findViewById(R.id.currentStatusStatementMain);
            clinic = itemView.findViewById(R.id.ClinicStatementMain);
            cart = itemView.findViewById(R.id.cartStatementMain);
            optimalDate = itemView.findViewById(R.id.optimalDateMain);
            hla_typing = itemView.findViewById(R.id.hla_typingStatementMain);
            showStatement = itemView.findViewById(R.id.showStatement);

            showStatement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Изменить заявку", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
