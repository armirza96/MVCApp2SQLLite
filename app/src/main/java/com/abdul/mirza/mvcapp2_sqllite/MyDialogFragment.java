package com.abdul.mirza.mvcapp2_sqllite;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.abdul.mirza.mvcapp2_sqllite.Controller.DialogController;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;
import com.abdul.mirza.mvcapp2_sqllite.View.OnNotifyChild;
import com.abdul.mirza.mvcapp2_sqllite.View.OnNotifyParent;
import com.abdul.mirza.mvcapp2_sqllite.databinding.FragmentDialogBinding;

public class MyDialogFragment extends DialogFragment {
    public static String TAG = "DIALOG_FRAG";
    private FragmentDialogBinding binding;

    DialogController controller;

    OnNotifyParent parent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDialogBinding.inflate(inflater, container, false);

        controller = new DialogController(getActivity());

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String surname = binding.etSurname.getText().toString();
                String name = binding.etName.getText().toString();
                String id = binding.etStudentId.getText().toString();
                String gpa = binding.etStudentGpa.getText().toString();


                if(!(surname.isEmpty() && name.isEmpty() && id.isEmpty() && gpa.isEmpty())) {
                    int intID = Integer.parseInt(id);
                    if(intID >= 10000000 && intID <= 99999999) {

                        float floatGPA = Float.parseFloat(gpa);
                        if(floatGPA >= 0.0 && floatGPA <= 4.3) {
                            Profile item = new Profile(name, surname, id, gpa);
                            boolean result = controller.onSaveData(item);

                            if(!result) {
                                showToast("Duplicate student ids.");
                            } else {
                                parent.onNotify();
                                dismiss();
                            }
                        } else {
                            showToast("GPA is invalid.");
                        }

                    } else {
                        showToast("StudentID is invalid.");
                    }
                } else {
                    showToast("Some fields are empty!");
                }
            }
        });

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    public void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void setListener(OnNotifyParent parent) {
        this.parent = parent;
    }
}