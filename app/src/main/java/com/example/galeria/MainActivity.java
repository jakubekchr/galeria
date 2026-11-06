package com.example.galeria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button dalej = findViewById(R.id.dalej);
        Button wstecz = findViewById((R.id.wstecz));
        ImageView zdj = findViewById(R.id.zdj);
        int zdjecia[] = new int[]{R.drawable.images,R.drawable.img1, R.drawable.img2,R.drawable.img3,R.drawable.img4};

        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a++;
                zdj.setImageResource(zdjecia[a]);
                if (zdjecia.length < zdjecia[a]){
                    a =0;
                }
            }
        });
        wstecz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zdj.setImageResource(zdjecia[a--]);
            }
        });

    }
}