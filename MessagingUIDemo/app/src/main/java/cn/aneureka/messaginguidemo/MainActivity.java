package cn.aneureka.messaginguidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private List<Message> mMsgList = new ArrayList<>();

    private EditText mEditText;

    private Button mSendButton;

    private RecyclerView mMsgRecyclerView;

    private MsgAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: invoked");
        initMessages();
        Log.d(TAG, "onCreate: mMsgList: " + mMsgList.toString());

        mEditText = findViewById(R.id.edittext_chatbox);
        mSendButton = findViewById(R.id.button_chatbox_send);
        mMsgRecyclerView = findViewById(R.id.recyclerview_message_list);

        mAdapter = new MsgAdapter(mMsgList);
        mMsgRecyclerView.setAdapter(mAdapter);

        mMsgRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d(TAG, "onCreate: new adapter");

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mEditText.getText().toString();
                if (!"".equals(content)) {
                    Log.d(TAG, "onClick: sentMessage: " + content);
                    Message msg = new Message(content, Message.TYPE_SENT);
                    mMsgList.add(msg);
                    mAdapter.notifyDataSetChanged();
                    mMsgRecyclerView.scrollToPosition(mMsgList.size()-1);
                    mEditText.setText("");
                }
            }
        });
    }


    private void initMessages() {
        mMsgList.add(new Message("Hello!", Message.TYPE_RECEIVED));
        mMsgList.add(new Message("My name's Aneureka!", Message.TYPE_RECEIVED));
        mMsgList.add(new Message("Hi, there.", Message.TYPE_SENT));
        mMsgList.add(new Message("How is it going?", Message.TYPE_RECEIVED));
        mMsgList.add(new Message("Fine.", Message.TYPE_RECEIVED));
    }

}
