package com.example.kryptonote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onEncrypt(View v)
    {

        try
        {
            String key = (((EditText)findViewById(R.id.key)).getText().toString());
            String data = (((EditText)findViewById(R.id.data)).getText().toString());
            Cipher c = new Cipher(key);
            String result =  c.encrypt(data);
            (((EditText) findViewById(R.id.data))).setText(result);
        }


        catch (Exception e)
        {
            Toast label = Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT);
            label.show();
        }

    }


    public void onDecrypt(View v)
    {
        try
        {
            String key = (((EditText)findViewById(R.id.key)).getText().toString());
            String data = (((EditText)findViewById(R.id.data)).getText().toString());
            Cipher c = new Cipher(key);
            String result =  c.decrypt(data);
            (((EditText) findViewById(R.id.data))).setText(result);

        }


        catch (Exception e)
        {
            Toast label = Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT);
            label.show();
        }


    }

    public void onSave(View v)
    {
        try
        {
            String file = (((EditText)findViewById(R.id.file)).getText().toString());
            File dir = this.getFilesDir();
            File f = new File(dir,file);
            FileWriter fw = new FileWriter(f);
            fw.write(((EditText)findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast.makeText(this,"Note Saved",Toast.LENGTH_SHORT).show();
        }


        catch (Exception e)
        {
            Toast.makeText(this,"Note could not be saved",Toast.LENGTH_SHORT).show();

        }



    }


    public void onLoad(View v)
    {
        try
        {
            String file = (((EditText)findViewById(R.id.file)).getText().toString());
            File dir = this.getFilesDir();
            File f = new File(dir,file);
            FileReader fr = new FileReader(f);
            String show = "" ;
            for (int c = fr.read(); c!= -1; c = fr.read())
            {
                show +=(char)c;
            }

            fr.close();
            (((EditText) findViewById(R.id.data))).setText(show);

        }


        catch (Exception e)
        {
            Toast.makeText(this,"File not found",Toast.LENGTH_SHORT).show();
        }
    }

}