package com.example.automaticvalidationappp;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView title, label;
    EditText password;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setting linear layout
        linearLayout = new LinearLayout(this);
        linearLayout.setPadding(5,5,5,5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //setting the width and height of the linear layout
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
      linearLayout.setLayoutParams(layoutParams);





        //title attributes
        title = new TextView(this);
        title.setText(R.string.title);
        title.setTextColor(getResources().getColor(R.color.hint_color));
        title.setGravity(Gravity.CENTER);
        title.setPadding(5,10,5,10);
        title.setTextColor(getResources().getColor(R.color.hint_color));

        //label attributes
        label = new TextView(this);
        label.setGravity(Gravity.CENTER);
        label.setPadding(20,10,20,10);
        label.setTextColor(getResources().getColor(R.color.quite_color));
        label.setTypeface(Typeface.DEFAULT);

        //password attributes
        password = new EditText(this);
        password.setGravity(Gravity.CENTER);
        password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        password.setHint("Enter password");
        password.setPadding(20,10,20,10);
        password.setHintTextColor(getResources().getColor(R.color.hint_color));
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());

        //setting an image view
        imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.pass12);


        //setting the password to inherit the text-watcher functionality
        password.addTextChangedListener(textWatcher);

        //adding the child views to display the views
        linearLayout.addView(title);
        linearLayout.addView(imageView);
        linearLayout.addView(password);
        linearLayout.addView(label);

        //setting the content view which takes in the linear layout -
        setContentView(linearLayout);

    }

    // implementing the text-watcher
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            label.setVisibility(View.VISIBLE);
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() < 8){
                label.setText("Weak Password");
                label.setBackgroundColor(getResources().getColor(R.color.error));
                label.setVisibility(View.VISIBLE);
            } else if (s.length() >8){
                label.setText("Strong Password");
                label.setVisibility(View.VISIBLE);
                label.setBackgroundColor(getResources().getColor(R.color.correct));

            }
        }
    };
}
