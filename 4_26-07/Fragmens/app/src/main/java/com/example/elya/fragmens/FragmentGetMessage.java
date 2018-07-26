package com.example.elya.fragmens;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGetMessage extends Fragment {
    private EditText editText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_get_message, container, false);

        editText = v.findViewById(R.id.edit_text);

        return v;
    }

    public void updateEditText(CharSequence newText) {
        editText.setText(newText);
        System.out.println("ok");
    }

}
