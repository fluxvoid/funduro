package nz.co.fzf.funduro;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.Calendar;

public class FitnessRater extends Activity {

    private Spinner fitnessTypeSpinner;
    private Spinner abilityTypeSpinner;
    private Spinner genderTypeSpinner;
    private EditText ageText;
    private EditTextDatePicker agePickerText;

    private Calendar myCalendar = Calendar.getInstance();


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        initiliseFitnessTypeSpinner();
        initiliseAbilityTypeSpinner();
        initiliseGenderTypeSpinner();
        initiliseSaveButton();
        initiliseAgePicker();

    }

    public void initiliseAgePicker(){
        ageText = (EditText) findViewById(R.id.ageText);

        // set previous value if known
        SharedPreferences sharedPref = getSharedPreferences("Funduro",0);
        String value = sharedPref.getString("agePickerText", "");

        if(value != ""){
            ageText.setText(value);
        }

        agePickerText = new EditTextDatePicker(this, findViewById(R.id.ageText).getId());

        ageText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SharedPreferences sharedPref = getSharedPreferences("Funduro", 0);
                SharedPreferences.Editor prefEditor = sharedPref.edit();
                prefEditor.putString("agePickerText", agePickerText.editText.getText().toString());
                prefEditor.commit();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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
