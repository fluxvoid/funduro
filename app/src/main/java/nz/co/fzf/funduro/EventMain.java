package nz.co.fzf.funduro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by fung on 2017-07-09.
 */
public class EventMain extends Activity {
    private Button addEvent;
    private ListView listView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_main);

        initiliseAddEvent();
    }

    public void initiliseAddEvent(){

        Button addEvent = (Button)findViewById(R.id.addEvent);

        addEvent.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent(view.getContext(), EventCreator.class);
                startActivityForResult(myIntent,0);
            }
        });
    }
}
