package com.example.testebottomsheetcorreto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.testebottomsheetcorreto.databinding.CardBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity
{

    private BottomSheetBehavior bottomSheetBehavior;
    private LinearLayout bottomSheet;

    private CardBottomSheetBinding cardInformacoesComandoBinding;
    private ConstraintLayout constraintBottomSheet;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        configurarCardLocalizacaoComandos();
    }

    private void configurarCardLocalizacaoComandos()
    {
        try
        {
            cardInformacoesComandoBinding =
                    CardBottomSheetBinding.inflate(getLayoutInflater());
            constraintBottomSheet = cardInformacoesComandoBinding.bottomSheet;
            bottomSheetBehavior = BottomSheetBehavior.from(constraintBottomSheet);

            bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {}

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset)
                {
                    if (bottomSheetBehavior.getState() == BottomSheetBehavior .STATE_EXPANDED)
                    {
                        bottomSheetBehavior.setState(bottomSheetBehavior.STATE_COLLAPSED);
                    }
                    else
                    {
                        bottomSheetBehavior.setState(bottomSheetBehavior.STATE_EXPANDED);
                    }
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}