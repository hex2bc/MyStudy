package hex2bc.mystudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
/**
 *   Android Socket 服务端，pc可以通过设置 adb forward tcp:6666 tcp:8888; telnet 127.0.0.1 6666 连接
 *   Created by hex2bc on 2019/5/21.
*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Handler mHandler;
    private ExecutorService mThreadPool;

    private Button mConnect, mDisconnect;
    private TextView mTv;
    boolean mStop = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConnect = findViewById(R.id.connect);
        mDisconnect = findViewById(R.id.disconnect);
        mTv = findViewById(R.id.tv);
        mConnect.setOnClickListener(this);
        mDisconnect.setOnClickListener(this);
        mThreadPool = Executors.newCachedThreadPool();
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0) {
                    String cur = mTv.getText().toString();
                    String display = msg.getData().getString("text");
                    if (display.equals("clear")) {
                        mTv.setText("");
                    } else {
                        mTv.setText(cur + "\n" + display);
                    }
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        if (v == mConnect) {
            mThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    mStop = false;
                    socketSever();
                }
            });

        } else if (v == mDisconnect) {
            mStop = true;
            sentString("clear");
        }
    }

    private void socketSever() {
        try {
            ServerSocket s = new ServerSocket(8888);
            s.setReuseAddress(true);

            try (Socket incoming = s.accept()) {
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                try (Scanner in = new Scanner(inputStream)) {
                    PrintWriter out = new PrintWriter(outputStream, true);
                    out.println("hello! Enter BYE to exit.");
                    sentString("connect: " + incoming.getInetAddress());
                    while (!mStop && in.hasNextLine()) {
                        String line = in.nextLine();
                        sentString(line);
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE"))
                            mStop = true;
                    }
                }
                inputStream.close();
                outputStream.close();
                s.close();
            } finally {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sentString(String text) {
        Message msg = Message.obtain();
        msg.what = 0;
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        msg.setData(bundle);
        mHandler.sendMessage(msg);
    }

    private void socketConnect() {
        try (Socket s = new Socket("0.0.0.0", 8189)) {
            InputStream inputStream = s.getInputStream();
            Scanner in = new Scanner(inputStream);

            while (in.hasNextLine() && !mStop) {
                String line = in.nextLine();
                Message msg = Message.obtain();
                msg.what = 0;
                Bundle bundle = new Bundle();
                bundle.putString("text", line);
                msg.setData(bundle);
                mHandler.sendMessage(msg);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
