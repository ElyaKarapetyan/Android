package com.example.app.taskapp;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private Activity mActivity;
    private EditText mTitle;
    //mImage - public static that set image from HomeActivity.onActivityResult() method
    public static ImageView mImage;
    private EditText mDescription;
    private ImageButton mDateBtn;
    private ImageButton mTimeBtn;
    private Button mCancelBtn;
    private Button mSaveBtn;
    private TextView txtDate;
    private TextView txtTime;

    public CustomDialog(Activity activity) {
        super(activity);

        this.mActivity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);

        initElements();
        setOnClickListener();
    }

    private void initElements() {
        mTitle = findViewById(R.id.task_title);
        mImage = findViewById(R.id.task_img);
        mDescription = findViewById(R.id.task_description);
        mDateBtn = findViewById(R.id.task_date);
        mTimeBtn = findViewById(R.id.task_time);
        mSaveBtn = findViewById(R.id.save_btn);
        mCancelBtn = findViewById(R.id.cancel_btn);
        txtDate = findViewById(R.id.dateTxt);
        txtTime = findViewById(R.id.timeTxt);
    }

    private void setOnClickListener() {
        mSaveBtn.setOnClickListener(this);
        mCancelBtn.setOnClickListener(this);
        mDateBtn.setOnClickListener(this);
        mTimeBtn.setOnClickListener(this);
        mImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_btn:
                clickSaveBtn();
                break;
            case R.id.cancel_btn:
                dismiss();
                break;
            case R.id.task_date:
                clickDateBtn();
                break;
            case R.id.task_time:
                clickTimeBtn();
                break;
            case R.id.task_img:
                chooseImage();
                break;
        }
    }

    private void chooseImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        mActivity.startActivityForResult(intent,1);
    }

    private void clickTimeBtn() {
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        txtTime.setText(hourOfDay + ":" + minute);
                        System.out.print(1);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void clickDateBtn() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        System.out.print(1);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void clickSaveBtn() {
        String title = String.valueOf(mTitle.getText());
        String description = String.valueOf(mDescription.getText());
        String date = String.valueOf(txtDate.getText());
        String time = String.valueOf(txtTime.getText());

        if (time.length() == 0 || description.length() == 0 ||
                date == "Selected Date" || time == "Selected Date") {
            Toast.makeText(mActivity, "Please fill all fields!", Toast.LENGTH_SHORT).show();
            dismiss();
        }

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        database.child(user.getUid()).child("Tasks").push().setValue(new TaskModel(title, description, String.valueOf(HomeActivity.downloadUrl), date, time));
        dismiss();
    }
}
