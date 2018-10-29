package cn.aneureka.messaginguidemo;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hiki on 2018/10/28.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private static final String TAG = "MsgAdapter";

    private List<Message> mMsgList;

    public MsgAdapter(List<Message> msgList) {
        mMsgList = msgList;
        Log.d(TAG, "MsgAdapter: mMsgList size: " + mMsgList.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: invoked");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: invoked");
        Message msg = mMsgList.get(position);
        Log.d(TAG, "onBindViewHolder: position: " + position);
        Log.d(TAG, "onBindViewHolder: msg: " + msg.getType() + " - " + msg.getContent());
        holder.bind(msg);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: mMsgList size: " + mMsgList.size());
        return mMsgList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layoutReceive;

        LinearLayout layoutSend;

        TextView msgReceive;

        TextView msgSend;

        ViewHolder(View itemView) {
            super(itemView);
            layoutReceive = itemView.findViewById(R.id.layout_receive);
            layoutSend = itemView.findViewById(R.id.layout_send);
            msgReceive = itemView.findViewById(R.id.msg_receive);
            msgSend = itemView.findViewById(R.id.msg_send);
        }

        void bind(Message msg) {
            if (msg.getType() == Message.TYPE_RECEIVED) {
                Log.d(TAG, "onBindViewHolder: Message: " + msg.getContent());
                layoutReceive.setVisibility(View.VISIBLE);
                msgReceive.setText(msg.getContent());
                layoutSend.setVisibility(View.GONE);
            } else {
                Log.d(TAG, "onBindViewHolder: Message: " + msg.getContent());
                layoutReceive.setVisibility(View.GONE);
                layoutSend.setVisibility(View.VISIBLE);
                msgSend.setText(msg.getContent());
            }
        }

    }
}
