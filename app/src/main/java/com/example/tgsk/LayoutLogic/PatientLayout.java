package com.example.tgsk.LayoutLogic;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tgsk.Donor.Donor;
import com.example.tgsk.Patient.Patient;
import com.example.tgsk.R;

import java.util.LinkedList;

public class PatientLayout implements View.OnClickListener {
    private TextView name;
    private TextView surname;
    private TextView midName;
    private TextView dateBirth;
    private Spinner gender;
    private TextView age;
    private TextView idPatientMIS;
    private TextView idPatientLIS;
    private Context context;
    Patient patient;

    public PatientLayout(Context context, View view) {
        name = view.findViewById(R.id.patientName);
        name.setOnClickListener(this);
        surname = view.findViewById(R.id.patientSurname);
        surname.setOnClickListener(this);
        midName = view.findViewById(R.id.patientMidName);
        midName.setOnClickListener(this);
        dateBirth = view.findViewById(R.id.patientDateBirth);
        dateBirth.setOnClickListener(this);
        age = view.findViewById(R.id.patientAge);
        age.setOnClickListener(this);
        idPatientMIS = view.findViewById(R.id.patientMIS);
        idPatientMIS.setOnClickListener(this);
        idPatientLIS = view.findViewById(R.id.patientLIS);
        idPatientLIS.setOnClickListener(this);
        Button buttonSave = view.findViewById(R.id.buttonSavePatient);
        buttonSave.setOnClickListener(this);
        gender = view.findViewById(R.id.patientGender);
        this.context = context;
        gender.setAdapter(setSpinnerAdapter());
    }


    private ArrayAdapter<String> setSpinnerAdapter() {
        String array[];
        array = context.getResources().getStringArray(R.array.spinnerGender);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                android.R.layout.simple_selectable_list_item,
                array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }


    private boolean validationCreateDonor() {
        boolean validationSuccess = true;
        ValidationData validation = new ValidationData();
        LinkedList<TextView> listTextView = new LinkedList<>();
        listTextView.add(name);
        listTextView.add(surname);
        listTextView.add(midName);
        listTextView.add(dateBirth);
        for (TextView currentTextView : listTextView) {
            if (currentTextView.getText().toString().length() == 0) {
                currentTextView.setBackgroundColor(Color.rgb(255, 214, 223));
                Toast.makeText(context, "Заполнены не все поля", Toast.LENGTH_LONG).show();
                validationSuccess = false;
            }
        }
        if (gender.getSelectedItem().equals("пол")) {
            Toast.makeText(context, "Проверьте значение списка", Toast.LENGTH_SHORT).show();
            validationSuccess = false;
        }

//        if (validation.checkDate(dateBirth.getText().toString())){
//            validationSuccess = true;
//        }
        return validationSuccess;
    }

    public Patient createPatient() {
        if (validationCreateDonor()) {
            Patient patient = new Patient();
            patient.setName(name.getText().toString());
            patient.setSurName(surname.getText().toString());
            patient.setMidName(midName.getText().toString());
            patient.setDateBirth(dateBirth.getText().toString());
            patient.setGender(gender.getSelectedItem().toString());
            try {
                patient.setAge(Integer.parseInt(age.getText().toString()));
                patient.setIdDonorMIS(Integer.parseInt(idPatientMIS.getText().toString()));
                patient.setIdDonorLIS(Integer.parseInt(idPatientLIS.getText().toString()));
            } catch (Exception ex) {
                ex.printStackTrace();
                Toast.makeText(context, "что-то пошло не так", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(context, "Пациент создан", Toast.LENGTH_SHORT).show();
        }

        else Toast.makeText(context, "не создан", Toast.LENGTH_SHORT).show();
        return patient;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSavePatient) {
            validationCreateDonor();
            createPatient();
        } else {
            v.setBackgroundColor(Color.rgb(236, 236, 236));
        }
    }
}
