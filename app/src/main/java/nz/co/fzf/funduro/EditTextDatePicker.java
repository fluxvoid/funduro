package nz.co.fzf.funduro;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by fung on 2017-07-09.
 */
public class EditTextDatePicker implements DatePickerDialog.OnDateSetListener, View.OnClickListener {

    public EditText editText;
    private int day;
    private int month;
    private int birthYear;
    private Context context;

    public EditTextDatePicker(Context context, int editTextViewID){
        Activity activity = (Activity)context;
        editText = (EditText)activity.findViewById(editTextViewID);
        editText.setOnClickListener(EditTextDatePicker.this);
        this.context = context;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        this.birthYear = year;
        this.month = monthOfYear;
        this.day = dayOfMonth;

        updateDisplay();
    }

    @Override
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        DatePickerDialog dialog = new DatePickerDialog(context, this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        dialog.show();
    }

    private void updateDisplay(){
        editText.setText(new StringBuilder()
        .append(day).append("/").append(month + 1).append("/").append(birthYear).append(" "));
    }
}
