package com.example.jsontry02.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.style.LineHeightSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jsontry02.R;
import com.example.jsontry02.branchDetails.allBranchSubjectCode;
import com.example.jsontry02.branchDetails.FirstYear;
import com.example.jsontry02.utilities.CalculatorSGPA;
import com.example.jsontry02.utilities.GradePointsCheck;
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;
import com.skydoves.powerspinner.PowerSpinnerView;

import org.jetbrains.annotations.Nullable;

public class SgpaCaluActivity extends AppCompatActivity {
    EditText mark1,mark2,mark3,mark4,mark5,mark6,mark7,mark8,mark9;
    TextView totalText,percentageText,sgpaText;
    TextView subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9;
    Button reset,calcuSgpa;
    PowerSpinnerView semesterList, branchList;
    CardView cardView;
    Toolbar toolbar;
    int sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9,total;
    double sgpa,percentage;
    String selectedSem, selectedBranch;
    CalculatorSGPA calculatorSGPA= new CalculatorSGPA(SgpaCaluActivity.this);
    GradePointsCheck gradePointsCheck= new GradePointsCheck();
    boolean checkValidInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgpa_calu);
        initializeView();
        semesterList.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<String>() {
            @Override
            public void onItemSelected(int i, @Nullable String s, int i1, String t1) {
                selectedSem =t1;
                if (selectedSem.equals("1st Sem") || selectedSem.equals("2nd Sem")){
                    branchList.setItems(R.array.FirstYear);
                } else {
                    branchList.setItems(R.array.AllBranch);
                }
                branchList.setVisibility(View.VISIBLE);
                branchList.clearSelectedItem();
            }
        });
        branchList.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<String>() {
            @Override
            public void onItemSelected(int i, @Nullable String s, int i1, String t1) {
                selectedBranch= t1;
                updateTextOfSubject();

            }
        });
    }
    public void initializeView() {
        toolbar = findViewById(R.id.sgpa_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mark1=findViewById(R.id.mark1);
        mark2=findViewById(R.id.mark2);
        mark3=findViewById(R.id.mark3);
        mark4=findViewById(R.id.mark4);
        mark5=findViewById(R.id.mark5);
        mark6=findViewById(R.id.mark6);
        mark7=findViewById(R.id.mark7);
        mark8=findViewById(R.id.mark8);
        mark9=findViewById(R.id.mark9);

        reset=findViewById(R.id.resetButton);
        calcuSgpa=findViewById(R.id.calculateButton);

        totalText=findViewById(R.id.totalMarks);
        percentageText=findViewById(R.id.percentageMarks);
        sgpaText=findViewById(R.id.sgpaMarks);

        cardView=findViewById(R.id.final_card);

        semesterList=findViewById(R.id.semesterSpinnerView);
        branchList=findViewById(R.id.branchSpinnerView);

        subject1=findViewById(R.id.subject1);
        subject2=findViewById(R.id.subject2);
        subject3=findViewById(R.id.subject3);
        subject4=findViewById(R.id.subject4);
        subject5=findViewById(R.id.subject5);
        subject6=findViewById(R.id.subject6);
        subject7=findViewById(R.id.subject7);
        subject8=findViewById(R.id.subject8);
        subject9=findViewById(R.id.subject9);
    }
    public void updateTextOfSubject(){
        allBranchSubjectCode allBranchSubjectCode = new allBranchSubjectCode(this);
        FirstYear firstYear= new FirstYear(this);
        switch (selectedSem){
            case "1st Sem":
                switch (selectedBranch){
                    case "Physics Cycle":
                        resetEightSubjects();
                        firstYear.FirstSemPhy();
                            calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                        firstYear();
                                }
                            });
                        reset.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                resetEightSubjects();
                            }
                        });
                        break;
                    case "Chemistry Cycle":
                        resetEightSubjects();
                        firstYear.FirstSemChem();
                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                firstYear();
                            }
                        });
                        reset.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                resetEightSubjects();
                            }
                        });
                        break;

                }
                break;
            case "2nd Sem":
                switch (selectedBranch) {
                    case "Physics Cycle":
                        resetEightSubjects();
                        firstYear.SecondSemPhy();
                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                firstYear();
                            }
                        });
                        reset.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                resetEightSubjects();
                            }
                        });
                        break;
                    case "Chemistry Cycle":
                        resetEightSubjects();
                        firstYear.SecondSemChem();
                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                firstYear();
                            }
                        });
                        reset.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                resetEightSubjects();
                            }
                        });
                        break;
                }
                break;
                case "3rd Sem":
                        switch (selectedBranch) {
                            case "AI":
                            case "IS":
                            case "CS":
                                resetNineSubjects();
                                allBranchSubjectCode.semThreeCs();
                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME();
                                    }
                                });
                                reset.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        resetNineSubjects();
                                    }
                                });
                                break;
                            case "BT":
                                resetNineSubjects();
                                allBranchSubjectCode.semThreeBt();
                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME();
                                    }
                                });
                                reset.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        resetNineSubjects();
                                    }
                                });
                                break;
                            case "CV":
                                resetNineSubjects();
                                allBranchSubjectCode.semThreeCv();
                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME();
                                    }
                                });
                                reset.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        resetNineSubjects();
                                    }
                                });
                                break;
                            case "EC":
                                resetNineSubjects();
                                allBranchSubjectCode.semThreeEc();
                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME();
                                    }
                                });
                                reset.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        resetNineSubjects();
                                    }
                                });
                                break;
                            case "EE":
                                resetNineSubjects();
                                allBranchSubjectCode.semThreeEe();
                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME();
                                    }
                                });
                                reset.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        resetNineSubjects();
                                    }
                                });
                                break;
                            case "EI":
                                resetNineSubjects();
                                allBranchSubjectCode.semThreeEi();
                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        semThreeSGPAForEI();
                                    }
                                });
                                reset.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        resetNineSubjects();
                                    }
                                });
                                break;
                            case "ME":
                                resetNineSubjects();
                                allBranchSubjectCode.semThreeMe();
                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME();
                                    }
                                });
                                reset.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        resetNineSubjects();
                                    }
                                });
                                break;
                            case "TX":
                                resetNineSubjects();
                                allBranchSubjectCode.semThreeTx();
                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        semThreeAndFourSGPAForTX();
                                    }
                                });
                                reset.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        resetNineSubjects();
                                    }
                                });
                                break;
                        }
                            break;
                            case "4th Sem":
                                switch (selectedBranch) {
                                    case "AI":
                                    case "IS":
                                    case "CS":
                                        resetNineSubjects();
                                        allBranchSubjectCode.semFourCs();
                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME();
                                            }
                                        });
                                        reset.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                resetNineSubjects();
                                            }
                                        });
                                        break;
                                    case "BT":
                                        resetNineSubjects();
                                        allBranchSubjectCode.semFourBt();
                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME();
                                            }
                                        });
                                        reset.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                resetNineSubjects();
                                            }
                                        });
                                        break;
                                    case "CV":
                                        resetNineSubjects();
                                        allBranchSubjectCode.semFourCv();
                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME();
                                            }
                                        });
                                        reset.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                resetNineSubjects();
                                            }
                                        });
                                        break;
                                    case "EC":
                                        resetNineSubjects();
                                        allBranchSubjectCode.semFourEc();
                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME();
                                            }
                                        });
                                        reset.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                resetNineSubjects();
                                            }
                                        });
                                        break;
                                    case "EE":
                                        resetNineSubjects();
                                        allBranchSubjectCode.semFourEe();
                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                semFourSGPAForEE();
                                            }
                                        });
                                        reset.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                resetNineSubjects();
                                            }
                                        });
                                        break;
                                    case "EI":
                                        resetNineSubjects();
                                        allBranchSubjectCode.semFourEi();
                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                semFourSGPAForEI();
                                            }
                                        });
                                        reset.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                resetNineSubjects();
                                            }
                                        });
                                        break;
                                    case "ME":
                                        resetNineSubjects();
                                        allBranchSubjectCode.semFourMe();
                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME();
                                            }
                                        });
                                        reset.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                resetNineSubjects();
                                            }
                                        });
                                        break;
                                    case "TX":
                                        resetNineSubjects();
                                        allBranchSubjectCode.semFourTx();
                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                semThreeAndFourSGPAForTX();
                                            }
                                        });
                                        reset.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                resetNineSubjects();
                                            }
                                        });
                                        break;
                                }
                                    break;
                                    case "5th Sem":
                                        switch (selectedBranch) {
                                            case "AI":
                                                resetNineSubjects();
                                                allBranchSubjectCode.semFiveAi();
                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        semFiveSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME_EI();
                                                    }
                                                });
                                                reset.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        resetNineSubjects();
                                                    }
                                                });
                                                break;
                                            case "BT":
                                                resetNineSubjects();
                                                allBranchSubjectCode.semFiveBt();
                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        semFiveSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME_EI();
                                                    }
                                                });
                                                reset.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        resetNineSubjects();
                                                    }
                                                });
                                                break;
                                            case "CS":
                                            case "IS":
                                                resetNineSubjects();
                                                allBranchSubjectCode.semFiveCs();
                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        semFiveSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME_EI();
                                                    }
                                                });
                                                reset.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        resetNineSubjects();
                                                    }
                                                });
                                                break;
                                            case "CV":
                                                resetNineSubjects();
                                                allBranchSubjectCode.semFiveCv();
                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        semFiveSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME_EI();
                                                    }
                                                });
                                                reset.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        resetNineSubjects();
                                                    }
                                                });
                                                break;
                                            case "EC":
                                                resetNineSubjects();
                                                allBranchSubjectCode.semFiveEc();
                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        semFiveSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME_EI();
                                                    }
                                                });
                                                reset.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        resetNineSubjects();
                                                    }
                                                });
                                                break;
                                            case "EE":
                                                resetNineSubjects();
                                                allBranchSubjectCode.semFiveEe();
                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        semFiveSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME_EI();
                                                    }
                                                });
                                                reset.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        resetNineSubjects();
                                                    }
                                                });
                                                break;
                                            case "EI":
                                                resetNineSubjects();
                                                allBranchSubjectCode.semFiveEi();
                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        semFiveSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME_EI();
                                                    }
                                                });
                                                reset.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        resetNineSubjects();
                                                    }
                                                });
                                                break;
                                            case "ME":
                                                resetNineSubjects();
                                                allBranchSubjectCode.semFiveMe();
                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        semFiveSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME_EI();
                                                    }
                                                });
                                                reset.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        resetNineSubjects();
                                                    }
                                                });
                                                break;
                                            case "TX":
                                                resetNineSubjects();
                                                allBranchSubjectCode.semFiveTx();
                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        semFiveSGPAForTX();
                                                    }
                                                });
                                                reset.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        resetNineSubjects();
                                                    }
                                                });
                                                break;
                                        }
                                            break;
                                            case "6th Sem":
                                                switch (selectedBranch) {
                                                    case "AI":
                                                        resetEightSubjects();
                                                        allBranchSubjectCode.semSixAi();
                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                            }
                                                        });
                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                resetEightSubjects();
                                                            }
                                                        });
                                                        break;
                                                    case "BT":
                                                        resetEightSubjects();
                                                        allBranchSubjectCode.semSixBt();
                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                            }
                                                        });
                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                resetEightSubjects();
                                                            }
                                                        });
                                                        break;
                                                    case "CS":
                                                        resetEightSubjects();
                                                        allBranchSubjectCode.semSixCs();
                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                            }
                                                        });
                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                resetEightSubjects();
                                                            }
                                                        });
                                                        break;
                                                    case "CV":
                                                        resetEightSubjects();
                                                        allBranchSubjectCode.semSixCv();
                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                            }
                                                        });
                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                resetEightSubjects();
                                                            }
                                                        });
                                                        break;
                                                    case "EC":
                                                        resetEightSubjects();
                                                        allBranchSubjectCode.semSixEc();
                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                            }
                                                        });
                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                resetEightSubjects();
                                                            }
                                                        });
                                                        break;
                                                    case "EE":
                                                        resetEightSubjects();
                                                        allBranchSubjectCode.semSixEe();
                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                            }
                                                        });
                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                resetEightSubjects();
                                                            }
                                                        });
                                                        break;
                                                    case "EI":
                                                        resetEightSubjects();
                                                        allBranchSubjectCode.semSixEi();
                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                            }
                                                        });
                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                resetEightSubjects();
                                                            }
                                                        });
                                                        break;
                                                    case "IS":
                                                        resetEightSubjects();
                                                        allBranchSubjectCode.semSixIs();
                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                            }
                                                        });
                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                resetEightSubjects();
                                                            }
                                                        });
                                                        break;
                                                    case "ME":
                                                        resetEightSubjects();
                                                        allBranchSubjectCode.semSixMe();
                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                            }
                                                        });
                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                resetEightSubjects();
                                                            }
                                                        });
                                                        break;
                                                    case "TX":
                                                        resetEightSubjects();
                                                        allBranchSubjectCode.semSixTx();
                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                            }
                                                        });
                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                resetEightSubjects();
                                                            }
                                                        });
                                                        break;
                                                }

                                                    break;
                                                    case "7th Sem":
                                                        switch (selectedBranch) {
                                                            case "AI":
                                                                resetSevenSubjects();
                                                                allBranchSubjectCode.semSevenAi();
                                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        semSevenSGPAFor_AI();
                                                                    }
                                                                });
                                                                reset.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        resetSevenSubjects();
                                                                    }
                                                                });
                                                                break;
                                                            case "BT":
                                                                resetSevenSubjects();
                                                                allBranchSubjectCode.semSevenBt();
                                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        semSevenSGPAFor_BT_CS_IS();
                                                                    }
                                                                });
                                                                reset.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        resetSevenSubjects();
                                                                    }
                                                                });
                                                                break;
                                                            case "CS":
                                                            case "IS":
                                                                resetSevenSubjects();
                                                                allBranchSubjectCode.semSevenCs();
                                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        semSevenSGPAFor_BT_CS_IS();
                                                                    }
                                                                });
                                                                reset.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        resetSevenSubjects();
                                                                    }
                                                                });
                                                                break;
                                                            case "CV":
                                                                resetEightSubjects();
                                                                allBranchSubjectCode.semSevenCv();
                                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        semSevenSGPAFor_CV_EC_EE_EI_ME_TX();
                                                                    }
                                                                });
                                                                reset.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        resetEightSubjects();
                                                                    }
                                                                });
                                                                break;
                                                            case "EC":
                                                                resetEightSubjects();
                                                                allBranchSubjectCode.semSevenEc();
                                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        semSevenSGPAFor_CV_EC_EE_EI_ME_TX();
                                                                    }
                                                                });
                                                                reset.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        resetEightSubjects();
                                                                    }
                                                                });
                                                                break;
                                                            case "EE":
                                                                resetEightSubjects();
                                                                allBranchSubjectCode.semSevenEe();
                                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        semSevenSGPAFor_CV_EC_EE_EI_ME_TX();
                                                                    }
                                                                });
                                                                reset.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        resetEightSubjects();
                                                                    }
                                                                });
                                                                break;
                                                            case "EI":
                                                                resetEightSubjects();
                                                                allBranchSubjectCode.semSevenEi();
                                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        semSevenSGPAFor_CV_EC_EE_EI_ME_TX();
                                                                    }
                                                                });
                                                                reset.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        resetEightSubjects();
                                                                    }
                                                                });
                                                                break;
                                                            case "ME":
                                                                resetEightSubjects();
                                                                allBranchSubjectCode.semSevenMe();
                                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        semSevenSGPAFor_CV_EC_EE_EI_ME_TX();
                                                                    }
                                                                });
                                                                reset.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        resetEightSubjects();
                                                                    }
                                                                });
                                                                break;
                                                            case "TX":
                                                                resetEightSubjects();
                                                                allBranchSubjectCode.semSevenTx();
                                                                calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        semSevenSGPAFor_CV_EC_EE_EI_ME_TX();
                                                                    }
                                                                });
                                                                reset.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        resetEightSubjects();
                                                                    }
                                                                });
                                                                break;
                                                        }
                                                            break;
                                                            case "8th Sem":
                                                                switch (selectedBranch) {
                                                                    case "AI":
                                                                        resetFiveSubjects();
                                                                        allBranchSubjectCode.semEightAi();
                                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                                            }
                                                                        });
                                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                resetFiveSubjects();
                                                                            }
                                                                        });
                                                                        break;
                                                                    case "BT":
                                                                        resetFiveSubjects();
                                                                        allBranchSubjectCode.semEightBt();
                                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                                            }
                                                                        });
                                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                resetFiveSubjects();
                                                                            }
                                                                        });
                                                                        break;
                                                                    case "IS":
                                                                    case "CS":
                                                                        resetFiveSubjects();
                                                                        allBranchSubjectCode.semEightCs();
                                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                                            }
                                                                        });
                                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                resetFiveSubjects();
                                                                            }
                                                                        });
                                                                        break;
                                                                    case "CV":
                                                                        resetFiveSubjects();
                                                                        allBranchSubjectCode.semEightCv();
                                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                                            }
                                                                        });
                                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                resetFiveSubjects();
                                                                            }
                                                                        });
                                                                        break;
                                                                    case "EC":
                                                                        resetFiveSubjects();
                                                                        allBranchSubjectCode.semEightEc();
                                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                                            }
                                                                        });
                                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                resetFiveSubjects();
                                                                            }
                                                                        });
                                                                        break;
                                                                    case "EE":
                                                                        resetFiveSubjects();
                                                                        allBranchSubjectCode.semEightEe();
                                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                                            }
                                                                        });
                                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                resetFiveSubjects();
                                                                            }
                                                                        });
                                                                        break;
                                                                    case "EI":
                                                                        resetFiveSubjects();
                                                                        allBranchSubjectCode.semEightEi();
                                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                                            }
                                                                        });
                                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                resetFiveSubjects();
                                                                            }
                                                                        });
                                                                        break;
                                                                    case "ME":
                                                                        resetFiveSubjects();
                                                                        allBranchSubjectCode.semEightMe();
                                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                                            }
                                                                        });
                                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                resetFiveSubjects();
                                                                            }
                                                                        });
                                                                        break;
                                                                    case "TX":
                                                                        resetFiveSubjects();
                                                                        allBranchSubjectCode.semEightTx();
                                                                        calcuSgpa.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX();
                                                                            }
                                                                        });
                                                                        reset.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                resetFiveSubjects();
                                                                            }
                                                                        });
                                                                        break;
                                                                }
                                                                    break;


        }
    }


    public void gettingInputFromNineSubject(){
        sub1=Integer.parseInt(mark1.getText().toString());
        sub2=Integer.parseInt(mark2.getText().toString());
        sub3=Integer.parseInt(mark3.getText().toString());
        sub4=Integer.parseInt(mark4.getText().toString());
        sub5=Integer.parseInt(mark5.getText().toString());
        sub6=Integer.parseInt(mark6.getText().toString());
        sub7=Integer.parseInt(mark7.getText().toString());
        sub8=Integer.parseInt(mark8.getText().toString());
        sub9=Integer.parseInt(mark9.getText().toString());

        total = calculatorSGPA.TotalForNineSubject(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9);
        percentage = calculatorSGPA.PercentageForNineSubject(total);

        sub1=gradePointsCheck.checkingPoints(sub1);
        sub2=gradePointsCheck.checkingPoints(sub2);
        sub3=gradePointsCheck.checkingPoints(sub3);
        sub4=gradePointsCheck.checkingPoints(sub4);
        sub5=gradePointsCheck.checkingPoints(sub5);
        sub6=gradePointsCheck.checkingPoints(sub6);
        sub7=gradePointsCheck.checkingPoints(sub7);
        sub8=gradePointsCheck.checkingPoints(sub8);
        sub9=gradePointsCheck.checkingPoints(sub9);
    }
    public void gettingInputFromEightSubject(){
        sub1=Integer.parseInt(mark1.getText().toString());
        sub2=Integer.parseInt(mark2.getText().toString());
        sub3=Integer.parseInt(mark3.getText().toString());
        sub4=Integer.parseInt(mark4.getText().toString());
        sub5=Integer.parseInt(mark5.getText().toString());
        sub6=Integer.parseInt(mark6.getText().toString());
        sub7=Integer.parseInt(mark7.getText().toString());
        sub8=Integer.parseInt(mark8.getText().toString());

        total = calculatorSGPA.TotalForEightSubject(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8);
        percentage = calculatorSGPA.PercentageForEightSubject(total);

        sub1=gradePointsCheck.checkingPoints(sub1);
        sub2=gradePointsCheck.checkingPoints(sub2);
        sub3=gradePointsCheck.checkingPoints(sub3);
        sub4=gradePointsCheck.checkingPoints(sub4);
        sub5=gradePointsCheck.checkingPoints(sub5);
        sub6=gradePointsCheck.checkingPoints(sub6);
        sub7=gradePointsCheck.checkingPoints(sub7);
        sub8=gradePointsCheck.checkingPoints(sub8);
    }
    public void gettingInputFromSevenSubject(){
        sub1=Integer.parseInt(mark1.getText().toString());
        sub2=Integer.parseInt(mark2.getText().toString());
        sub3=Integer.parseInt(mark3.getText().toString());
        sub4=Integer.parseInt(mark4.getText().toString());
        sub5=Integer.parseInt(mark5.getText().toString());
        sub6=Integer.parseInt(mark6.getText().toString());
        sub7=Integer.parseInt(mark7.getText().toString());

        total = calculatorSGPA.TotalForSevenSubject(sub1,sub2,sub3,sub4,sub5,sub6,sub7);
        percentage = calculatorSGPA.PercentageForSevenSubject(total);

        sub1=gradePointsCheck.checkingPoints(sub1);
        sub2=gradePointsCheck.checkingPoints(sub2);
        sub3=gradePointsCheck.checkingPoints(sub3);
        sub4=gradePointsCheck.checkingPoints(sub4);
        sub5=gradePointsCheck.checkingPoints(sub5);
        sub6=gradePointsCheck.checkingPoints(sub6);
        sub7=gradePointsCheck.checkingPoints(sub7);
    }
    public void gettingInputFromFiveSubject(){
        sub1=Integer.parseInt(mark1.getText().toString());
        sub2=Integer.parseInt(mark2.getText().toString());
        sub3=Integer.parseInt(mark3.getText().toString());
        sub4=Integer.parseInt(mark4.getText().toString());
        sub5=Integer.parseInt(mark5.getText().toString());


        total = calculatorSGPA.TotalForFiveSubject(sub1,sub2,sub3,sub4,sub5);
        percentage = calculatorSGPA.PercentageForFiveSubject(total);

        sub1=gradePointsCheck.checkingPoints(sub1);
        sub2=gradePointsCheck.checkingPoints(sub2);
        sub3=gradePointsCheck.checkingPoints(sub3);
        sub4=gradePointsCheck.checkingPoints(sub4);
        sub5=gradePointsCheck.checkingPoints(sub5);
    }
    public void resetNineSubjects(){
        mark1.setText("");
        mark2.setText("");
        mark3.setText("");
        mark4.setText("");
        mark5.setText("");
        mark6.setText("");
        mark7.setText("");
        mark8.setText("");
        mark9.setText("");
        cardView.setVisibility(View.GONE);

    }
    public void resetEightSubjects(){
        mark1.setText("");
        mark2.setText("");
        mark3.setText("");
        mark4.setText("");
        mark5.setText("");
        mark6.setText("");
        mark7.setText("");
        mark8.setText("");
        cardView.setVisibility(View.GONE);
    }
    public void resetSevenSubjects(){
        mark1.setText("");
        mark2.setText("");
        mark3.setText("");
        mark4.setText("");
        mark5.setText("");
        mark6.setText("");
        mark7.setText("");
        cardView.setVisibility(View.GONE);
    }
    public void resetFiveSubjects(){
        mark1.setText("");
        mark2.setText("");
        mark3.setText("");
        mark4.setText("");
        mark5.setText("");
        cardView.setVisibility(View.GONE);
    }
    public void showingFinalResult(){
        cardView.setVisibility(View.VISIBLE);
        totalText.setText(String.valueOf(total));
        percentageText.setText(String.valueOf(percentage));
        sgpaText.setText(String.valueOf(sgpa));
    }
    public void semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME(){
        gettingInputFromNineSubject();
        sgpa = calculatorSGPA.semThreeAndFourSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9);
        showingFinalResult();
    }
    public void semThreeAndFourSGPAForTX(){
        gettingInputFromNineSubject();
        sgpa=calculatorSGPA.semThreeAndFourSGPAForTX(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9);
        showingFinalResult();
    }
    public void semThreeSGPAForEI(){
        gettingInputFromNineSubject();
        sgpa=calculatorSGPA.semThreeSGPAForEI(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9);
        showingFinalResult();
    }
    public void semFourSGPAForEI(){
        gettingInputFromNineSubject();
        sgpa=calculatorSGPA.semFourSGPAForEI(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9);
        showingFinalResult();
    }
    public void semFourSGPAForEE(){
        gettingInputFromNineSubject();
        sgpa=calculatorSGPA.semFourSGPAForEE(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9);
        showingFinalResult();
    }
    public void semFiveSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME_EI(){
        gettingInputFromNineSubject();
        sgpa=calculatorSGPA.semFiveSGPAFor_AI_BT_CS_CV_EC_EE_IS_ME_EI(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9);
        showingFinalResult();
    }
    public void semFiveSGPAForTX(){
        gettingInputFromNineSubject();
        sgpa=calculatorSGPA.semFiveSGPAForTX(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9);
        showingFinalResult();
    }
    public void semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX(){
        gettingInputFromEightSubject();
        sgpa=calculatorSGPA.semSixSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8);
        showingFinalResult();
    }public void semSevenSGPAFor_BT_CS_IS(){
        gettingInputFromSevenSubject();
        sgpa=calculatorSGPA.semSevenSGPAFor_BT_CS_IS(sub1,sub2,sub3,sub4,sub5,sub6,sub7);
        showingFinalResult();
    }
    public void semSevenSGPAFor_CV_EC_EE_EI_ME_TX(){
        gettingInputFromEightSubject();
        sgpa=calculatorSGPA.semSevenSGPAFor_CV_EC_EE_EI_ME_TX(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8);
        showingFinalResult();
    }
    public void semSevenSGPAFor_AI(){
        gettingInputFromEightSubject();
        sgpa=calculatorSGPA.semSevenSGPAFor_AI(sub1,sub2,sub3,sub4,sub5,sub6,sub7);
        showingFinalResult();
    }
    public void semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX(){
        gettingInputFromFiveSubject();
        sgpa=calculatorSGPA.semEightSGPAFor_AI_BT_CS_CV_EC_EE_EI_IS_ME_TX(sub1,sub2,sub3,sub4,sub5);
        showingFinalResult();
    }
    public void firstYear(){
        gettingInputFromEightSubject();
        sgpa=calculatorSGPA.firstYear(sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8);
        showingFinalResult();
    }
}
