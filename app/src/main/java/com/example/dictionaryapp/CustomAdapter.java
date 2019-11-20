package com.example.dictionaryapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.RecyclerViewHolder>{

    private List<String> data ;
    private Context mContext;


    public CustomAdapter(Context mContext,List<String> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.txtUserName.setText(data.get(position));
        holder.line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = holder.txtUserName.getText().toString();
                Intent intent = new Intent(mContext,WebviewMain.class);
                Bundle bundle = new Bundle();
                bundle.putString("chuoi",s );
                intent.putExtra("package",bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void filterList(ArrayList<String> newvocabulary) {
        data = newvocabulary;
        notifyDataSetChanged();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView txtUserName;
        LinearLayout line;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            txtUserName =  itemView.findViewById(R.id.tv_Name);
            line =  itemView.findViewById(R.id.line);

        }
    }
    public interface OnItemClickedListener {
        void onItemClick(String username);
    }

    private OnItemClickedListener onItemClickedListener;

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }
}

