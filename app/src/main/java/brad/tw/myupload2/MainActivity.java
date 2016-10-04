package brad.tw.myupload2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private File sdroot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sdroot = Environment.getExternalStorageDirectory();
    }

    public void newFile(View v){
        File newFile = new File(sdroot.getAbsolutePath() + "/brad.txt");
        try {
            FileOutputStream fout =
                    new FileOutputStream(newFile);
            fout.write("Hello, World".getBytes());
            fout.flush();
            fout.close();
            Toast.makeText(this,"Write OK", Toast.LENGTH_SHORT).show();
        }catch (Exception ee){

        }
    }

    public void upload(View v){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    MultipartUtility mu =
                            new MultipartUtility("http://www.brad.tw/iii2003/upload.php", "UTF-8");
                    mu.addFilePart("upload", new File(sdroot.getAbsolutePath() + "/brad.txt"));
                    List<String> ret = mu.finish();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    public void test1(View v){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    MultipartUtility mu =
                            new MultipartUtility("http://m.coa.gov.tw/OpenData/FarmerMarketData.aspx", "UTF-8");
                    List<String> ret = mu.finish();
                    for (String line : ret){
                        Log.v("brad", line.length() + ":" + line);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

}
