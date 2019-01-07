package com.example.twtech.materialdesign;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

/*import com.tsongkha.spinnerdatepicker.DatePicker;
import com.tsongkha.spinnerdatepicker.DatePickerDialog;*/
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity /*implements DatePickerDialog.OnDateSetListener, NavigationView.OnNavigationItemSelectedListener*/ {


    CustomDateTimePicker custom;
    TextView btnEventDateTime;
    DatePicker datePicker;
     TimePicker timePicker ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/
        btnEventDateTime = ((TextView) findViewById(R.id.btnEventDateTime));




        custom = new CustomDateTimePicker(this,
                new CustomDateTimePicker.ICustomDateTimeListener() {

                    @SuppressLint("SetTextI18n")
                    @Override


                    public void onSet(Dialog dialog, Calendar calendarSelected,
                                      Date dateSelected, int year, String monthFullName,
                                      String monthShortName, int monthNumber, int date,
                                      String weekDayFullName, String weekDayShortName,
                                      int hour24, int hour12, int min, int sec,
                                      String AM_PM) {
                        //                        ((TextInputEditText) findViewById(R.id.edtEventDateTime))
                        btnEventDateTime.setText("");
                        btnEventDateTime.setText(year
                                + "-" + (monthNumber + 1) + "-" + calendarSelected.get(Calendar.DAY_OF_MONTH)
                                + " " + hour24 + ":" + min
                                + ":" + sec);
                    }

                    @Override
                    public void onCancel() {

                    }
                });
        /**
         * Pass Directly current time format it will return AM and PM if you set
         * false
         */
        custom.set24HourFormat(true);
        /**
         * Pass Directly current data and time to show when it pop up
         */
        custom.setDate(Calendar.getInstance());
        btnEventDateTime.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {



                        open3(v);


                      /*  new SpinnerDatePickerDialogBuilder()
                                .context(MainActivity.this)
                                .callback(MainActivity.this)
                                .spinnerTheme(R.style.NumberPickerStyle)
                                .showTitle(true)
                                .showDaySpinner(true)
                                .defaultDate(2017, 0, 1)
                                .maxDate(2020, 0, 1)
                                .minDate(2000, 0, 1)
                                .build()
                                .show();*/

                      /*  datepickerDialog_object.getDatePicker().setSpinnersShown(true);
                        datepickerDialog_object.getDatePicker().setCalendarViewShown(false);*/
/*
                        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog, onTimeSetListener, hour, minute, is24Hour);
*/



                        //custom.showDialog();
                        //dialogue();
                    }
                });
    }


/*
    void showDialog() {
        DialogFragment newFragment = MyAlertDialogFragment
                .newInstance("Dialog");
      //  FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        newFragment.show(getFragmentManager(), "dialog");
    }

    public void doPositiveClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Positive click!");
    }

    public void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
    }

    public static class MyAlertDialogFragment extends DialogFragment {

        public static MyAlertDialogFragment newInstance(String title) {
            MyAlertDialogFragment frag = new MyAlertDialogFragment();
            Bundle args = new Bundle();
            args.putInt("title", 1);
            frag.setArguments(args);
            return frag;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int title = getArguments().getInt("title");

            return new AlertDialog.Builder(getActivity())
                    .setIcon(R.drawable.ic_cake_black_24dp)
                    .setTitle(title)
                    .setPositiveButton("ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
                                    ((MainActivity) getActivity())
                                            .doPositiveClick();
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
                                    ((MainActivity) getActivity())
                                            .doNegativeClick();
                                }
                            }).create();
        }
    }*/


public void dialogue()
{
    LayoutInflater factory = LayoutInflater.from(this);
    final View deleteDialogView = factory.inflate(R.layout.date_time_picker, null);
    final AlertDialog deleteDialog = new AlertDialog.Builder(this).create();
    deleteDialog.setView(deleteDialogView);
    deleteDialogView.findViewById(R.id.date).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //your business logic
           // deleteDialog.dismiss();
        }
    });
    deleteDialogView.findViewById(R.id.time).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           // deleteDialog.dismiss();
        }
    });

    deleteDialog.show();
}


   /* @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

    }*/

    public void open3(View view)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View rootView = layoutInflater.inflate(R.layout.dialogbox, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(rootView);

        /*datePicker = (DatePicker) rootView.findViewById(R.id.date1);
        timePicker = (TimePicker) rootView.findViewById(R.id.time1);*/

        datePicker=(DatePicker) rootView.findViewById(R.id.date1);
        timePicker=(TimePicker) rootView.findViewById(R.id.time1);

        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {

                        datePicker.getYear();
                        datePicker.getMonth();
                        datePicker.getDayOfMonth();


                        timePicker.getCurrentHour();
                        timePicker.getCurrentMinute();


                        int hour, minute;
                        String am_pm;
                        if (Build.VERSION.SDK_INT >= 23 ){
                            hour = timePicker.getHour();
                            minute = timePicker.getMinute();
                        }
                        else{
                            hour = timePicker.getCurrentHour();
                            minute = timePicker.getCurrentMinute();
                        }
                        if(hour > 12) {
                            am_pm = "PM";
                            hour = hour - 12;
                        }
                        else
                        {
                            am_pm="AM";
                        }
                        btnEventDateTime.setText(datePicker.getDayOfMonth()+"-"+datePicker.getMonth()+"-"+datePicker.getYear()+" ,"+ hour +":"+ minute+" "+am_pm);

                        Log.e("DATEPICKERVALUE", String.valueOf(timePicker.getCurrentHour())+"-"+timePicker.getCurrentMinute());



                        //Log.e("DATEPICKERVALUE", String.valueOf(datePicker.getYear())+"-"+datePicker.getMonth()+"-"+datePicker.getDayOfMonth());
//***********************************************Volley Starts Here*****************************
                   //     String name3 = yourEditText2.getText().toString().substring(0,1).toUpperCase() + yourEditText2.getText().toString().substring(1).toLowerCase();
                     /*   Config.city=yourEditText2.getText().toString();
                        Config.n=name.getText().toString();
                        Config.a=address.getText().toString();
                        Config.e=etEmailAddrss.getText().toString();
                        Config.p=etPhoneNumber.getText().toString();
                        Config.c=cpass.getText().toString();
                        Config.pa=password.getText().toString();
                        Config.busname=bname.getText().toString();

                        students2.add(yourEditText2.getText().toString());

                        city.setAdapter(new ArrayAdapter<String>(SignUpActivity.this, android.R.layout.simple_spinner_dropdown_item, students2));

                        city.setSelection(students2.indexOf(yourEditText2.getText().toString()));*/

                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {



                                dialog.cancel();
                            }
                        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

        //*******************************Allert Ends Here********************************
    }

   /* @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }*/
}

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/

