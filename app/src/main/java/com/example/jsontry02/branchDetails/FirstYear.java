package com.example.jsontry02.branchDetails;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jsontry02.R;

public class FirstYear {
    Context mContext;

    public FirstYear(Context mContext) {
        this.mContext = mContext;
    }

    public void FirstSemPhy(){
        TextView subject1 =(TextView) ((Activity)mContext).findViewById(R.id.subject1);
        TextView subject2 = ((Activity)mContext).findViewById(R.id.subject2);
        TextView subject3 = ((Activity)mContext).findViewById(R.id.subject3);
        TextView subject4 = ((Activity)mContext).findViewById(R.id.subject4);
        TextView subject5 = ((Activity)mContext).findViewById(R.id.subject5);
        TextView subject6 = ((Activity)mContext).findViewById(R.id.subject6);
        TextView subject7 = ((Activity)mContext).findViewById(R.id.subject7);
        TextView subject8 = ((Activity)mContext).findViewById(R.id.subject8);
        TextView subject9 = ((Activity)mContext).findViewById(R.id.subject9);

        //EditText mark1 = ((Activity)mContext).findViewById(R.id.mark1);
        //EditText mark2 = ((Activity)mContext).findViewById(R.id.mark2);
        //EditText mark3 = ((Activity)mContext).findViewById(R.id.mark3);
        //EditText mark4 = ((Activity)mContext).findViewById(R.id.mark4);
        //EditText mark5 = ((Activity)mContext).findViewById(R.id.mark5);
        EditText mark6 = ((Activity)mContext).findViewById(R.id.mark6);
        EditText mark7 = ((Activity)mContext).findViewById(R.id.mark7);
        EditText mark8 = ((Activity)mContext).findViewById(R.id.mark8);
        EditText mark9 = ((Activity)mContext).findViewById(R.id.mark9);


        subject6.setVisibility(View.VISIBLE);
        subject7.setVisibility(View.VISIBLE);
        subject8.setVisibility(View.VISIBLE);
        subject9.setVisibility(View.VISIBLE);

        mark6.setVisibility(View.VISIBLE);
        mark7.setVisibility(View.VISIBLE);
        mark8.setVisibility(View.VISIBLE);
        mark9.setVisibility(View.VISIBLE);

        subject1.setText(R.string.mat11);
        subject2.setText(R.string.phy12);
        subject3.setText(R.string.ele13);
        subject4.setText(R.string.civ14);
        subject5.setText(R.string.egdl15);
        subject6.setText(R.string.phyl16);
        subject7.setText(R.string.elel17);
        subject8.setText(R.string.egh18);

        subject9.setVisibility(View.GONE);
        mark9.setVisibility(View.GONE);

    }
    public void SecondSemPhy(){
        TextView subject1 =(TextView) ((Activity)mContext).findViewById(R.id.subject1);
        TextView subject2 = ((Activity)mContext).findViewById(R.id.subject2);
        TextView subject3 = ((Activity)mContext).findViewById(R.id.subject3);
        TextView subject4 = ((Activity)mContext).findViewById(R.id.subject4);
        TextView subject5 = ((Activity)mContext).findViewById(R.id.subject5);
        TextView subject6 = ((Activity)mContext).findViewById(R.id.subject6);
        TextView subject7 = ((Activity)mContext).findViewById(R.id.subject7);
        TextView subject8 = ((Activity)mContext).findViewById(R.id.subject8);
        TextView subject9 = ((Activity)mContext).findViewById(R.id.subject9);

        //EditText mark1 = ((Activity)mContext).findViewById(R.id.mark1);
        //EditText mark2 = ((Activity)mContext).findViewById(R.id.mark2);
        //EditText mark3 = ((Activity)mContext).findViewById(R.id.mark3);
        //EditText mark4 = ((Activity)mContext).findViewById(R.id.mark4);
        //EditText mark5 = ((Activity)mContext).findViewById(R.id.mark5);
        EditText mark6 = ((Activity)mContext).findViewById(R.id.mark6);
        EditText mark7 = ((Activity)mContext).findViewById(R.id.mark7);
        EditText mark8 = ((Activity)mContext).findViewById(R.id.mark8);
        EditText mark9 = ((Activity)mContext).findViewById(R.id.mark9);


        subject6.setVisibility(View.VISIBLE);
        subject7.setVisibility(View.VISIBLE);
        subject8.setVisibility(View.VISIBLE);
        subject9.setVisibility(View.VISIBLE);

        mark6.setVisibility(View.VISIBLE);
        mark7.setVisibility(View.VISIBLE);
        mark8.setVisibility(View.VISIBLE);
        mark9.setVisibility(View.VISIBLE);

        subject1.setText(R.string.mat21);
        subject2.setText(R.string.phy22);
        subject3.setText(R.string.ele23);
        subject4.setText(R.string.civ24);
        subject5.setText(R.string.egdl25);
        subject6.setText(R.string.phyl26);
        subject7.setText(R.string.elel27);
        subject8.setText(R.string.egh28);

        subject9.setVisibility(View.GONE);
        mark9.setVisibility(View.GONE);

    }

    public void FirstSemChem(){
        TextView subject1 =(TextView) ((Activity)mContext).findViewById(R.id.subject1);
        TextView subject2 = ((Activity)mContext).findViewById(R.id.subject2);
        TextView subject3 = ((Activity)mContext).findViewById(R.id.subject3);
        TextView subject4 = ((Activity)mContext).findViewById(R.id.subject4);
        TextView subject5 = ((Activity)mContext).findViewById(R.id.subject5);
        TextView subject6 = ((Activity)mContext).findViewById(R.id.subject6);
        TextView subject7 = ((Activity)mContext).findViewById(R.id.subject7);
        TextView subject8 = ((Activity)mContext).findViewById(R.id.subject8);
        TextView subject9 = ((Activity)mContext).findViewById(R.id.subject9);

        //EditText mark1 = ((Activity)mContext).findViewById(R.id.mark1);
        //EditText mark2 = ((Activity)mContext).findViewById(R.id.mark2);
        //EditText mark3 = ((Activity)mContext).findViewById(R.id.mark3);
        //EditText mark4 = ((Activity)mContext).findViewById(R.id.mark4);
        //EditText mark5 = ((Activity)mContext).findViewById(R.id.mark5);
        EditText mark6 = ((Activity)mContext).findViewById(R.id.mark6);
        EditText mark7 = ((Activity)mContext).findViewById(R.id.mark7);
        EditText mark8 = ((Activity)mContext).findViewById(R.id.mark8);
        EditText mark9 = ((Activity)mContext).findViewById(R.id.mark9);


        subject6.setVisibility(View.VISIBLE);
        subject7.setVisibility(View.VISIBLE);
        subject8.setVisibility(View.VISIBLE);
        subject9.setVisibility(View.VISIBLE);

        mark6.setVisibility(View.VISIBLE);
        mark7.setVisibility(View.VISIBLE);
        mark8.setVisibility(View.VISIBLE);
        mark9.setVisibility(View.VISIBLE);

        subject1.setText(R.string.mat11);
        subject2.setText(R.string.che12);
        subject3.setText(R.string.cpc13);
        subject4.setText(R.string.eln14);
        subject5.setText(R.string.me15);
        subject6.setText(R.string.chel16);
        subject7.setText(R.string.cpcl17);
        subject8.setText(R.string.egh18);

        subject9.setVisibility(View.GONE);
        mark9.setVisibility(View.GONE);

    }
    public void SecondSemChem(){
        TextView subject1 =(TextView) ((Activity)mContext).findViewById(R.id.subject1);
        TextView subject2 = ((Activity)mContext).findViewById(R.id.subject2);
        TextView subject3 = ((Activity)mContext).findViewById(R.id.subject3);
        TextView subject4 = ((Activity)mContext).findViewById(R.id.subject4);
        TextView subject5 = ((Activity)mContext).findViewById(R.id.subject5);
        TextView subject6 = ((Activity)mContext).findViewById(R.id.subject6);
        TextView subject7 = ((Activity)mContext).findViewById(R.id.subject7);
        TextView subject8 = ((Activity)mContext).findViewById(R.id.subject8);
        TextView subject9 = ((Activity)mContext).findViewById(R.id.subject9);

        //EditText mark1 = ((Activity)mContext).findViewById(R.id.mark1);
        //EditText mark2 = ((Activity)mContext).findViewById(R.id.mark2);
        //EditText mark3 = ((Activity)mContext).findViewById(R.id.mark3);
        //EditText mark4 = ((Activity)mContext).findViewById(R.id.mark4);
        //EditText mark5 = ((Activity)mContext).findViewById(R.id.mark5);
        EditText mark6 = ((Activity)mContext).findViewById(R.id.mark6);
        EditText mark7 = ((Activity)mContext).findViewById(R.id.mark7);
        EditText mark8 = ((Activity)mContext).findViewById(R.id.mark8);
        EditText mark9 = ((Activity)mContext).findViewById(R.id.mark9);


        subject6.setVisibility(View.VISIBLE);
        subject7.setVisibility(View.VISIBLE);
        subject8.setVisibility(View.VISIBLE);
        subject9.setVisibility(View.VISIBLE);

        mark6.setVisibility(View.VISIBLE);
        mark7.setVisibility(View.VISIBLE);
        mark8.setVisibility(View.VISIBLE);
        mark9.setVisibility(View.VISIBLE);

        subject1.setText(R.string.mat21);
        subject2.setText(R.string.che22);
        subject3.setText(R.string.cpc23);
        subject4.setText(R.string.eln24);
        subject5.setText(R.string.me25);
        subject6.setText(R.string.chel26);
        subject7.setText(R.string.cpcl27);
        subject8.setText(R.string.egh28);

        subject9.setVisibility(View.GONE);
        mark9.setVisibility(View.GONE);

    }
}
