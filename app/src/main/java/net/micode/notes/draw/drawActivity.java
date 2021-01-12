package net.micode.notes.draw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import net.micode.notes.R;

public class drawActivity extends AppCompatActivity {

    private DrawingBoardView paintView;
    private LinearLayout llChooseColor;
    private int[] colors = new int[] {R.color.black, R.color.red, R.color.yellow, R.color.green, R.color.purple,R.color.blue};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        paintView = (DrawingBoardView)findViewById(R.id.drawingboardview);
        llChooseColor = findViewById(R.id.ll_choosecolor);
        findViewById(R.id.imageView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.clearPanel();
            }
        });

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.undo();
            }
        });

        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.redo();
            }
        });

        for (int i=0;i<llChooseColor.getChildCount();i++) {
            final int finalI = i;
            llChooseColor.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @SuppressLint("WrongConstant")
                @Override
                public void onClick(View v) {
                    paintView.setPaintColor(getResources().getColor(colors[finalI]));
                }
            });
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}