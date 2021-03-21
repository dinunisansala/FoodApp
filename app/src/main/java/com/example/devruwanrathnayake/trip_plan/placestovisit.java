package com.example.devruwanrathnayake.trip_plan;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class placestovisit extends AppCompatActivity {
    DatabaseReference databaseReference;
    Pvform pvform;
    EditText NIC, customerName, email, tp, arrivaldate, depaturedate, facilities;
    Button btnSave;

    private void clearControls() {
        NIC.setText("");
        customerName.setText("");
        email.setText("");
        tp.setText("");
        arrivaldate.setText("");
        depaturedate.setText("");
        facilities.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placestovisit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NIC = findViewById(R.id.txtnic);
        customerName = findViewById(R.id.txtName);
        email = findViewById(R.id.txtEmail);
        tp = findViewById(R.id.txtMob);
        facilities = findViewById(R.id.txtFacilities);
        arrivaldate = findViewById(R.id.txtarrival);
        depaturedate = findViewById(R.id.txtdepature);
        pvform = new Pvform();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final Button send = (Button) findViewById(R.id.btnSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Places");
                {
                    try {
                        if (TextUtils.isEmpty(customerName.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Plase Enter Your Name", Toast.LENGTH_SHORT).show();
                        } else if (TextUtils.isEmpty(NIC.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Plase Enter Your NIC", Toast.LENGTH_SHORT).show();
                        } else if (TextUtils.isEmpty(tp.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Plase Enter Your Telephone number", Toast.LENGTH_SHORT).show();
                        } else if (TextUtils.isEmpty(email.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Plase Enter Your email", Toast.LENGTH_SHORT).show();
                        } else {
                            pvform.setCustomerName(customerName.getText().toString().trim());
                            pvform.setEmail(email.getText().toString().trim());
                            pvform.setNIC(NIC.getText().toString().trim());
                            pvform.setTp(tp.getText().toString().trim());
                            pvform.setArrivaldate(arrivaldate.getText().toString().trim());
                            pvform.setFacilities(facilities.getText().toString().trim());
                            pvform.setDepaturedate(depaturedate.getText().toString().trim());
                            databaseReference.push().setValue(pvform);
                            databaseReference.child(NIC.getText().toString().trim()).setValue(pvform);
                            Toast.makeText(getApplicationContext(), "Your Order Added Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                    finally {
                        clearControls();
                    }
                }

            }
        });
    }
}
