package nz.co.fzf.funduro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class FitnessRater extends Activity {

    private Spinner fitnessTypeSpinner;
    private Spinner abilityTypeSpinner;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        initiliseFitnessTypeSpinner();
        initiliseAbilityTypeSpinner();
        initiliseSaveButton();
    }

    public void initiliseFitnessTypeSpinner(){
        fitnessTypeSpinner = (Spinner) findViewById(R.id.fitnessSpinner);

        ArrayAdapter<CharSequence> fitnessTypeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.fitness_types, android.R.layout.simple_spinner_item);

        fitnessTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fitnessTypeSpinner.setAdapter(fitnessTypeSpinnerAdapter);

        fitnessTypeSpinner = (Spinner) findViewById(R.id.fitnessSpinner);
        fitnessTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                String itemSelectedInSpinner = parent.getItemAtPosition(pos).toString();

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
