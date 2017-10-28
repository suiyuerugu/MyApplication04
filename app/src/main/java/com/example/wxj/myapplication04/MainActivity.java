package com.example.wxj.myapplication04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton
        .OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener,
        AdapterView.OnItemSelectedListener {
    private CheckBox cbSwim, cbmusic, cbbook;
    private RadioGroup rgsex;
    private Button btnconfim;
    private Spinner spnacademic;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        cbSwim = (CheckBox) findViewById(R.id.cb_swim);
        cbmusic = (CheckBox) findViewById(R.id.cb_music);
        cbbook = (CheckBox) findViewById(R.id.cb_book);
        rgsex = (RadioGroup) findViewById(R.id.rg_sex);
        btnconfim = (Button) findViewById(R.id.bt_confirm);
        spnacademic = (Spinner) findViewById(R.id.spn_academic);
        cbSwim.setOnCheckedChangeListener(this);
        cbmusic.setOnCheckedChangeListener(this);
        cbbook.setOnCheckedChangeListener(this);
        rgsex.setOnCheckedChangeListener(this);
        btnconfim.setOnClickListener(this);
        spnacademic.setOnItemSelectedListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Toast.makeText(this, compoundButton.getText().toString() + ":" + String.valueOf(b), Toast
                .LENGTH_LONG).show();

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        Toast.makeText(this, ((RadioButton) findViewById(i)).getText().toString(), Toast
                .LENGTH_LONG).show();

    }

    @Override
    public void onClick(View view) {
        String strhobby = " ";
        if (cbSwim.isChecked())
            strhobby += cbSwim.getText().toString();
        if (cbmusic.isChecked())
            strhobby += cbmusic.getText().toString();
        if (cbbook.isChecked())
            strhobby += cbbook.getText().toString();
        String strsex = ((RadioButton) findViewById(rgsex.getCheckedRadioButtonId())).getText()
                .toString();
        String stracademic = spnacademic.getSelectedItem().toString();
        Toast.makeText(this, "爱好：" + strhobby + "\n" + "性别：" + strsex + "\n" + "学历：" +
                stracademic, Toast.LENGTH_LONG)
                .show();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] academicArray = getResources().getStringArray(R.array.academic);
        Toast.makeText(this, academicArray[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        
    }
}
