package brad.tw.myupload2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void upload(View v){
        try {
            URL url = new URL("");
            HttpURLConnection conn = ()url.openConnection();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
