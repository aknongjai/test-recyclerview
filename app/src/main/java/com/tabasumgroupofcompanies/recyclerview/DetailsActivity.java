package com.tabasumgroupofcompanies.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView title,description;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        extras=getIntent().getExtras();
        title=findViewById(R.id.title);
        description=findViewById(R.id.thedescription);

        if(extras!=null){
            title.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
        }
    }
}
