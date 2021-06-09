package com.github.glomadrian.sample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.glomadrian.dashedcircularprogress.DashedCircularProgress;
import com.github.glomadrian.sample.R;

/**
 * @author Adrián García Lomas
 */
public class Simple extends Fragment {

    private Button restartButton;
    private DashedCircularProgress dashedCircularProgress;
    private TextView numbers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.simple, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        restartButton = (Button) view.findViewById(R.id.restart);
        dashedCircularProgress = view.findViewById(R.id.simple);
        numbers = view.findViewById(R.id.number);
        animate();

        restartButton.setOnClickListener(view1 -> restart());

        dashedCircularProgress.setOnValueChangeListener(
                value -> numbers.setText((int) value + ""));
    }

    public static Simple getInstance() {
        return new Simple();
    }

    private void restart() {
        dashedCircularProgress.reset();
        animate();
    }

    private void animate() {
        dashedCircularProgress.setValue(999);
    }
}
