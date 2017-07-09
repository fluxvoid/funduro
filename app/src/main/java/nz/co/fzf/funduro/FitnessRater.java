package nz.co.fzf.funduro;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FitnessRater extends Activity {

    private Spinner fitnessTypeSpinner;
    private Spinner abilityTypeSpinner;
    private Spinner genderTypeSpinner;
    private EditText ageText;

    private Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        initiliseFitnessTypeSpinner();
        initiliseAbilityTypeSpinner();
        initiliseGenderTypeSpinner();
        initiliseSaveButton();

        ageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(FitnessRater.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel(){
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());

        ageText.setText(sdf.format(myCalendar.getTime()));
    }

    public void initiliseFitnessTypeSpinner(){
        fitnessTypeSpinner = (Spinner) findViewById(R.id.fitnessSpinner);

        ArrayAdapter<CharSequence> fitnessTypeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.fitness_types, android.R.layout.simple_spinner_item);

        fitnessTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fitnessTypeSpinner.setAdapter(fitnessTypeSpinnerAdapter);

        // set previous value if known
        SharedPreferences sharedPref = getSharedPreferences("Funduro",0);
        int spinnerValue = sharedPref.getInt("fitnessTypeSpinner", -1);

        if(spinnerValue != -1){
            fitnessTypeSpinner.setSelection(spinnerValue);
        }

        // save selected item to shared preferences
        fitnessTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3){
                SharedPreferences sharedPref = getSharedPreferences("Funduro", 0);
                SharedPreferences.Editor prefEditor = sharedPref.edit();
                prefEditor.putInt("fitnessTypeSpinner",pos);
                prefEditor.commit();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO maybe add something here later
            }
        });
    }

    public void initiliseAbilityTypeSpinner(){
        abilityTypeSpinner = (Spinner) findViewById(R.id.abilitySpinner);

        ArrayAdapter<CharSequence> abilityTypeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.ability_types, android.R.layout.simple_spinner_item);

        abilityTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        abilityTypeSpinner.setAdapter(abilityTypeSpinnerAdapter);

        // set previous value if known
        SharedPreferences sharedPref = getSharedPreferences("Funduro",0);
        int spinnerValue = sharedPref.getInt("abilityTypeSpinner", -1);

        if(spinnerValue != -1){
            abilityTypeSpinner.setSelection(spinnerValue);
        }

        // save selected item to shared preferences
        abilityTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3){
                SharedPreferences sharedPref = getSharedPreferences("Funduro",0);
                SharedPreferences.Editor prefEditor = sharedPref.edit();
                prefEditor.putInt("abilityTypeSpinner",pos);
                prefEditor.commit();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO maybe add something here later
            }
        });
    }
    
    public void initiliseGenderTypeSpinner(){
        genderTypeSpinner = (Spinner) findViewById(R.id.genderSpinner);

        ArrayAdapter<CharSequence> genderTypeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender_types, android.R.layout.simple_spinner_item);

        genderTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderTypeSpinner.setAdapter(genderTypeSpinnerAdapter);

        // set previous value if known
        SharedPreferences sharedPref = getSharedPreferences("Funduro",0);
        int spinnerValue = sharedPref.getInt("genderTypeSpinner", -1);

        if(spinnerValue != -1){
            genderTypeSpinner.setSelection(spinnerValue);
        }

        // save selected item to shared preferences
        genderTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                SharedPreferences sharedPref = getSharedPreferences("Funduro", 0);
                SharedPreferences.Editor prefEditor = sharedPref.edit();
                prefEditor.putInt("genderTypeSpinner", pos);
                prefEditor.commit();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO maybe add something here later
            }
        });
    }

    public void initiliseSaveButton(){

        Button saveButton = (Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
