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
import com.example.tgsk.R;

import java.util.LinkedList;

public class DonorsLayout implements View.OnClickListener {
    private TextView name;
    private TextView surname;
    private TextView midName;
    private TextView dateBirth;
    private Spinner relationship;
    private Spinner gender;
    private TextView age;
    private TextView weight;
    private TextView height;
    private TextView idDonorMIS;
    private Context context;
    Donor donor;

    public DonorsLayout(Context context, View view) {
        name = view.findViewById(R.id.donorName);
        name.setOnClickListener(this);
        surname = view.findViewById(R.id.donorSurname);
        surname.setOnClickListener(this);
        midName = view.findViewById(R.id.donorMidName);
        midName.setOnClickListener(this);
        dateBirth = view.findViewById(R.id.donorDateBirth);
        dateBirth.setOnClickListener(this);
        relationship = view.findViewById(R.id.donorRelationship);
        gender = view.findViewById(R.id.donorGender);
        age = view.findViewById(R.id.donorAge);
        age.setOnClickListener(this);
        weight = view.findViewById(R.id.donorWeight);
        weight.setOnClickListener(this);
        height = view.findViewById(R.id.donorHeight);
        height.setOnClickListener(this);
        idDonorMIS = view.findViewById(R.id.donorMis);
        idDonorMIS.setOnClickListener(this);
        Button buttonSave = view.findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(this);
        this.context = context;
        relationship.setAdapter(setSpinnerAdapter(1));
        gender.setAdapter(setSpinnerAdapter(2));
    }

    // FIXME: rewrite with the spinners id
    private ArrayAdapter<String> setSpinnerAdapter(int idSpinner) {
        String array[];
        switch (idSpinner) {
            case 1:
                array = context.getResources().getStringArray(R.array.spinnerRelationship);
                break;
            case 2:
                array = context.getResources().getStringArray(R.array.spinnerGender);
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
        listTextView.add(name);
        listTextView.add(surname);
        listTextView.add(midName);
        listTextView.add(dateBirth);
        listTextView.add(weight);
        listTextView.add(height);
        for (TextView currentTextView : listTextView) {
            if (currentTextView.getText().toString().length() == 0) {
                currentTextView.setBackgroundColor(Color.rgb(255, 214, 223));
                Toast.makeText(context, "Заполнены не все поля", Toast.LENGTH_LONG).show();
                validationSuccess = false;
            }
        }
        if (relationship.getSelectedItem().equals("родство") ||
                gender.getSelectedItem().equals("пол")) {
            Toast.makeText(context, "Проверьте значение списка", Toast.LENGTH_SHORT).show();
            validationSuccess = false;
        }
        return validationSuccess;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSave) {
            validationCreateDonor();
            createDonor();
        } else {
            v.setBackgroundColor(Color.rgb(236, 236, 236));
        }
    }

    public void createDonor() {
        if (validationCreateDonor()) {
            Donor donor = new Donor();
            donor.setName(name.getText().toString());
            donor.setSurName(surname.getText().toString());
            donor.setMidName(midName.getText().toString());
            donor.setDateBirth(dateBirth.getText().toString());
            donor.setRelationship(relationship.getSelectedItem().toString());
            donor.setGender(gender.getSelectedItem().toString());
            donor.setAge(Integer.parseInt(age.getText().toString()));
            donor.setHeight(Double.parseDouble(height.getText().toString()));
            donor.setWeight(Double.parseDouble(weight.getText().toString()));
            donor.setIdDonorMIS(Integer.parseInt(idDonorMIS.getText().toString()));
            Toast.makeText(context, "Донор создан", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(context, "что-то пошло не так", Toast.LENGTH_SHORT).show();
    }
}
