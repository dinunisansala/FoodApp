package com.example.devruwanrathnayake.trip_plan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class placesDetails extends AppCompatActivity {
    DatabaseReference databaseReference;
    Pvform pvform;
    EditText NIC1, NIC, customerName, email, tp, facilities, depaturedate, arrivaldate;
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
        setContentView(R.layout.activity_places_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NIC1 = findViewById(R.id.txtnic1);
        NIC = findViewById(R.id.txtnic);
        customerName = findViewById(R.id.txtName);
        email = findViewById(R.id.txtEmail);
        tp = findViewById(R.id.txtMob);
        facilities = findViewById(R.id.txtFacilities);
        arrivaldate = findViewById(R.id.txtarrival);
        depaturedate = findViewById(R.id.txtdepature);
        pvform = new Pvform();
        final Button viewdetails = (Button) findViewById(R.id.btnview);
        viewdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Places").child(NIC1.getText().toString().trim());
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(TextUtils.isEmpty(NIC1.getText().toString())){
                            Toast.makeText(getApplicationContext(), "Enter NIC to Continue", Toast.LENGTH_SHORT).show();
                        }
                        else if (dataSnapshot.hasChildren()) {
                            customerName.setText(dataSnapshot.child("customerName").getValue().toString());
                            tp.setText(dataSnapshot.child("tp").getValue().toString());
                            email.setText(dataSnapshot.child("email").getValue().toString());
                            NIC.setText(dataSnapshot.child("nic").getValue().toString());
                            facilities.setText(dataSnapshot.child("facilities").getValue().toString());
                            arrivaldate.setText(dataSnapshot.child("arrivaldate").getValue().toString());
                            depaturedate.setText(dataSnapshot.child("depaturedate").getValue().toString());

                        } else {
                            Toast.makeText(getApplicationContext(), "No such NIC", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        final Button updatedetails = (Button) findViewById(R.id.btnupdate);
        updatedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference Upref = FirebaseDatabase.getInstance().getReference().child("Places");
                Upref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(NIC1.getText().toString().trim())){
                            pvform.setCustomerName(customerName.getText().toString().trim());
                            pvform.setTp(tp.getText().toString().trim());
                            pvform.setEmail(email.getText().toString().trim());
                            pvform.setFacilities(facilities.getText().toString().trim());
                            pvform.setArrivaldate(arrivaldate.getText().toString().trim());
                            pvform.setNIC(NIC.getText().toString().trim());
                            pvform.setDepaturedate(depaturedate.getText().toString().trim());
                            databaseReference = FirebaseDatabase.getInstance().getReference().child("Places").child(NIC.getText().toString().trim());
                            databaseReference.setValue(pvform);
                            Toast.makeText(getApplicationContext(), "Your Order Updated Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        final Button deletedetails = (Button) findViewById(R.id.btndelete);
        deletedetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Places");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(NIC1.getText().toString().trim())){
                            databaseReference = FirebaseDatabase.getInstance().getReference().child("Places").child(NIC.getText().toString().trim());
                            databaseReference.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
