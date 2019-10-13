package com.example.emicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class EmiActivity extends  AppCompatActivity
{

    Button emical;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            final EditText P = findViewById(R.id.principal);
            final EditText I = findViewById(R.id.interest);
            final EditText Y = findViewById(R.id.years);
            final EditText TI = findViewById(R.id.totalinterest);
            final EditText result = findViewById(R.id.emi);
             emical = findViewById(R.id.calculate_button);

            emical.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String st1 = P.getText().toString();
                    String st2 = I.getText().toString();
                    String st3 = Y.getText().toString();
                    float p = Float.parseFloat(st1);
                    float i = Float.parseFloat(st2);
                    float y = Float.parseFloat(st3);

                    float Principal = calPrice(p);

                    float Rate = calInt(i);

                    float Months = calMonth(y);

                    float Dvdnt = calDvdnt(Rate, Months);

                    float FD = calFinalDvdnt(Principal, Rate, Dvdnt);

                    float D = calDivider(Dvdnt);

                    float emi = calEmi(FD, D);

                    float TA = calTa(emi, Months);

                    float ti = calTotalInt(TA, Principal);

                    result.setText(String.valueOf(emi));

                    TI.setText(String.valueOf(ti));

                }
            });
        }



        public  float calPrice(float p) {

            return (p);

        }

        public  float calInt(float i) {

            return (i/12/100);

        }

        public  float calMonth(float y) {

            return (y * 12);

        }

        public  float calDvdnt(float Rate, float Months) {

            return (float) (Math.pow(1+Rate, Months));

        }

        public  float calFinalDvdnt(float Principal, float Rate, float Dvdnt) {

            return (Principal * Rate * Dvdnt);

        }

        public  float calDivider(float Dvdnt) {

            return (Dvdnt-1);

        }

        public  float calEmi(float FD, Float D) {

            return (FD/D);

        }

        public  float calTa(float emi, Float Months) {

            return (emi*Months);

        }

        public  float calTotalInt(float TA, float Principal) {

            return (TA - Principal);

        }


    }



