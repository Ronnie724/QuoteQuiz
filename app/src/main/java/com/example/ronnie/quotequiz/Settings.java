package com.example.ronnie.quotequiz;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by ronnie on 01.05.16.
 */
public class Settings extends MainActivity {
    MainActivity parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if( parent == null ) System.out.println( "From settings, parent is null" );
        else System.out.println( "From settings, parent is not null" );
        setContentView(R.layout.settings);
        if ( parent.binary_mode == true ) { ((RadioButton)findViewById(R.id.mode_binary)).setChecked(true); }
        else { ((RadioButton)findViewById(R.id.mode_multiple_choice)).setChecked(true); }
    }

    public void select_mode(View view) {
        if ( ((RadioButton)findViewById(R.id.mode_binary)).isChecked() == true ) { parent.binary_mode=true ; }
        else { parent.binary_mode=false; }
    }
}
