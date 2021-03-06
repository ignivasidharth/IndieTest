package com.igniva.indiecore.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.igniva.indiecore.R;
import com.igniva.indiecore.utils.Validation;

/**
 * Created by igniva-andriod-05 on 2/6/16.
 */
public class EnterMobileActivity extends BaseActivity{

    private LinearLayout mLlTopNextEvent;
    private Button mButtonNext;
    String countryId;
    private EditText mEtMobileNumber, mEtCountryCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_mobile_number_activity);

        setUpLayout();
        setDataInViewObjects();

    }

    @Override
    protected void setUpLayout() {


        try {

//        String locale = getApplicationContext().getResources().getConfiguration().locale.getCountry();

            TelephonyManager manager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
            if (manager.getSimState() != TelephonyManager.SIM_STATE_ABSENT) {

                countryId = manager.getSimCountryIso().toUpperCase();

            } else {


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mLlTopNextEvent = (LinearLayout) findViewById(R.id.ll_next);
        //mLlTopNextEvent.setOnClickListener(onClick());

        mButtonNext = (Button) findViewById(R.id.btn_next);
       // mButtonNext.setOnClickListener(this);

        mEtMobileNumber = (EditText) findViewById(R.id.et_mobile_number);
        mEtMobileNumber.requestFocus();

        mEtCountryCode = (EditText) findViewById(R.id.et_country_code);
      //  mEtCountryCode.setText(countryId);

    }

    @Override
    protected void setDataInViewObjects() {



        if(Validation.isValidMobile(this,mEtCountryCode,mEtMobileNumber)){
            Intent in = new Intent(EnterMobileActivity.this, OtpVerificationActivity.class);
            startActivity(in);
            finish();
        }

//        if (countryCode.isEmpty()) {
//            Utility.showAlertDialog("Please Enter Country Code!", mEtCountryCode, this);
//            return;
//        } else if (mobileNumber.isEmpty()) {
//
//            Utility.showAlertDialog("Please Enter Mobile Number!", mEtMobileNumber, this);
//            return;
//        } else {
//
//            Intent in = new Intent(EnterMobileActivity.this, OtpVerificationActivity.class);
//            startActivity(in);
//            finish();
//        }
    }

    public void registerMobileNumber() {
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.ll_next:
//                Intent intent= new Intent(EnterMobileActivity.this,OtpVerificationActivity.class);
//                startActivity(intent);
//                finish();
                break;
            case R.id.btn_next:

                break;

            default:
                break;
        }

    }
}
