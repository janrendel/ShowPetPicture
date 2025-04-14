package kr.ac.kopo.ShowPetPictures;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox checkStart;
    LinearLayout linearSub;
    RadioGroup rg;
    RadioButton rbDog, rbKitty, rbGuineapig;
    ImageView imgv;

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

        checkStart = findViewById(R.id.check_start);
        linearSub = findViewById(R.id.linear_sub);
        rg = findViewById(R.id.rg);
        rbDog = findViewById(R.id.rb_dog);
        rbKitty = findViewById(R.id.rb_kitty);
        rbGuineapig = findViewById(R.id.rb_guineapig);

        Button btnDone = findViewById(R.id.btn_done);
        imgv = findViewById(R.id.imgv);

        linearSub.setVisibility(View.INVISIBLE);
        checkStart.setOnCheckedChangeListener(checkStartListener);
    }

    CompoundButton.OnCheckedChangeListener checkStartListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                linearSub.setVisibility(View.VISIBLE);
            } else {
                linearSub.setVisibility(View.INVISIBLE);
            }
        }
    };
    View.OnClickListener btnDoneListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int selectedRbID = rg.getCheckedRadioButtonId();
            if(selectedRbID == R.id.rb_dog){
                imgv.setImageResource(R.drawable.dog);
            }else if (selectedRbID == R.id.rb_kitty){
                imgv.setImageResource(R.drawable.kitty);
            }else {
                imgv.setImageResource(R.drawable.ginipig);
            }
        }
    };
}

