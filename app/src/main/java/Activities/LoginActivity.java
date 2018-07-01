package Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.santillanj.rplife_z.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mBtnLogin = findViewById(R.id.mBtnLogin);
        mBtnLogin.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mBtnLogin:
                startActivity(new Intent(LoginActivity.this, InitializationActivity.class));
        }
    }
}
