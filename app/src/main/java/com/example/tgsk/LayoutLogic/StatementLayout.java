package com.example.tgsk.LayoutLogic;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tgsk.R;

import java.util.LinkedList;

public class StatementLayout implements View.OnClickListener {
    private Spinner typeTherapy;
    private Spinner numberTherapy;
    private Spinner departmentTgsk;
    private Spinner optimalDateMount;
    private Spinner optimalDateYear;
    private Spinner planingDateMount;
    private Spinner planingDateYear;
    private TextView dateTherapy;
    private TextView dateHospitalization;
    private Button buttonSave;
    private Context context;

    public StatementLayout(Context context, View view) {
        typeTherapy = view.findViewById(R.id.typeOfCellTherapy);
        numberTherapy = view.findViewById(R.id.numberOfCellTherapy);
        departmentTgsk = view.findViewById(R.id.departmentTGSK);
        optimalDateMount = view.findViewById(R.id.mountOptimal);
        optimalDateYear = view.findViewById(R.id.yearOptimal);
        planingDateMount = view.findViewById(R.id.planingMount);
        planingDateYear = view.findViewById(R.id.planingYear);
        dateTherapy = view.findViewById(R.id.dateTherapy);
        dateHospitalization = view.findViewById(R.id.dateHospitalizationCart);
        buttonSave = view.findViewById(R.id.buttonSaveStatement);
        this.context = context;
        typeTherapy.setAdapter(setSpinnerAdapter(1));
        numberTherapy.setAdapter(setSpinnerAdapter(2));
        departmentTgsk.setAdapter(setSpinnerAdapter(3));
        optimalDateMount.setAdapter(setSpinnerAdapter(4));
        optimalDateYear.setAdapter(setSpinnerAdapter(5));
        planingDateMount.setAdapter(setSpinnerAdapter(4));
        planingDateYear.setAdapter(setSpinnerAdapter(5));
        buttonSave.setOnClickListener(this);
        dateHospitalization.setOnClickListener(this);
        dateTherapy.setOnClickListener(this);

    }

    private ArrayAdapter<String> setSpinnerAdapter(int idSpinner) {
        String array[];
        Context d = context;
        switch (idSpinner) {
            case 1:
                array = context.getResources().getStringArray(R.array.spinnerType);
                break;
            case 2:
                array = context.getResources().getStringArray(R.array.spinnerNumberTherapy);
                break;
            case 3:
                array = context.getResources().getStringArray(R.array.spinnerDepartment);
                break;
            case 4:
                array = context.getResources().getStringArray(R.array.spinnerMount);
                break;
            case 5:
                array = context.getResources().getStringArray(R.array.spinnerYear);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + idSpinner);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                android.R.layout.simple_selectable_list_item,
                array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }


    public boolean validationCreateDonor() {
        boolean validationSuccess = true;
        LinkedList<TextView> listTextView = new LinkedList<>();
        listTextView.add(dateTherapy);
        listTextView.add(dateHospitalization);
        for (TextView currentTextView : listTextView) {
            if (currentTextView.getText().toString().length() == 0) {
                currentTextView.setBackgroundColor(Color.rgb(255, 214, 223));
                Toast.makeText(context, "Заполнены не все поля", Toast.LENGTH_LONG).show();
                validationSuccess = false;
            }
        }
        return validationSuccess;
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSaveStatement) {
            validationCreateDonor();
        } else {
            v.setBackgroundColor(Color.rgb(236, 236, 236));
        }
    }
}
