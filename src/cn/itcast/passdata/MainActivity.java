package cn.itcast.passdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	private RadioButton manRadio;
	private RadioButton womanRadio;
	private EditText et_password;
	private Button btn_send;
	private EditText et_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity01);
        et_name=(EditText) findViewById(R.id.et_name);
        et_password=(EditText) findViewById(R.id.et_password);
        btn_send=(Button) findViewById(R.id.btn_send);
        manRadio=(RadioButton) findViewById(R.id.radioMale);
        womanRadio=(RadioButton) findViewById(R.id.radioFemale);
        btn_send.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		passDate();
        	}
        });
    }
    public void passDate(){
    	Intent intent = new Intent(this,Activity02.class);
    	intent.putExtra("name",et_name.getText().toString().trim());
    	intent.putExtra("password",et_password.getText().toString().trim());
    	String str="";
    	if(manRadio.isChecked()){
    		str="ÄÐ";
    	}else if(womanRadio.isChecked()){
    		str="Å®";
    	}
    	intent.putExtra("sex",str);
    	startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
