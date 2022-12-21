package com.learnat.demofragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String IS_EDITING_KEY = "IS_EDITING_KEY";
    private static final String RANDOM_GOOD_DEED_KEY = "RANDOM_GOOD_DEED_KEY";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private boolean isEditing;
    private String randomGoodDeed;

    public Frag3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag3.
     */
    // TODO: Rename and change types and number of parameters
    private static final String TAG = "Frag3";
    public static Frag3 newInstance(String param1, String param2) {
        Frag3 fragment = new Frag3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String name=requireArguments().getString("name");
        int age=requireArguments().getInt("age");
        Log.e(TAG, "onCreate: "+name );
        Log.e(TAG, "onCreate: "+age );

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    private EditText editText;
    private TextView textViewCounter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_frag3,container,false);
        editText=view.findViewById(R.id.edit_frag3);
        textViewCounter=view.findViewById(R.id.textView);

        checkSharedPref();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence!=null ){
                    if(textViewCounter!=null){
                        int x=100-charSequence.length();
                        textViewCounter.setText(String.valueOf(x));
                        storeEditTextData(charSequence.toString());
                    }

                    Log.e(TAG, "onTextChanged: "+charSequence.length() );
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }

    private void checkSharedPref() {
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("SharedPref", MODE_PRIVATE);
        String data=sharedPreferences.getString("editTextData","");
        editText.setText(data);
    }

    private void storeEditTextData(String s) {
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("SharedPref", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("editTextData",s);
        editor.commit();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e(TAG, "onViewStateRestored: " );
        checkSharedPref();
    }



}