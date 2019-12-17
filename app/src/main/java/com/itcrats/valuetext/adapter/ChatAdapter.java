package com.itcrats.valuetext.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.itcrats.valuetext.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by JANI SHAIK on 17/12/2019
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private Context mContext;
    private List<String> chatNames;
    private List<String> chatDescriptions;
    private List<String> chatDates;

    public ChatAdapter(@NonNull Context context, List<String> chatNames, ArrayList<String> chatDescriptionList,
                             ArrayList<String> chatDatesList) {
        this.mContext = context;
        this.chatNames = chatNames;
        this.chatDescriptions = chatDescriptionList;
        this.chatDates = chatDatesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View billLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_chat, parent, false);
        return new ViewHolder(billLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.chatNameText.setText(chatNames.get(position));
        holder.chatDescriptionText.setText(chatDescriptions.get(position));
        holder.chatDateText.setText(chatDates.get(position));
        if(getRandomNumber()<2){
            holder.chatDateText.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
            holder.chatNotifsText.setVisibility(View.VISIBLE);
        }else
            holder.chatNotifsText.setVisibility(View.INVISIBLE);
        // change the icon for Windows and iPhone
        if(position==4){
            holder.chatDescriptionText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_check, 0, 0, 0);
        }
        if(position==5){
            holder.chatDescriptionText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_photo_camera, 0, 0, 0);
        }
        String s = chatNames.get(position);
    }

    @Override
    public int getItemCount() {
        return chatNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView chatNameText, chatDateText, chatNotifsText, chatDescriptionText;
        CircleImageView icon;
        View container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView;
            container.setClickable(true);
            container.setOnClickListener(this);
            icon = itemView.findViewById(R.id.icon);
            chatNameText = itemView.findViewById(R.id.chat_name_txt);
            chatDateText = itemView.findViewById(R.id.chat_date_txt);
            chatNotifsText = itemView.findViewById(R.id.chat_notifs_txt);
            chatDescriptionText = itemView.findViewById(R.id.chat_description);

        }

        @Override
        public void onClick(View v) {

        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        int x = random.nextInt(5);
        if(x==0){
            return 0;
        }else if(x==1){
            return 1;
        }
        else if(x==2){
            return 2;
        }else
            return 3;

    }
}
