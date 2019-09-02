package com.example.book.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.book.model.Chapter;
import com.example.book.view.activity.Description;
import com.example.book.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.MyHolder> {
    private Context context;
    private List<Chapter> chapters;

    public ChapterAdapter(Context context, List<Chapter> chapters) {
        this.context = context;
        this.chapters = chapters;
    }

    @NonNull
    @Override
    public ChapterAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyHolder(LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterAdapter.MyHolder myHolder, int i) {
        myHolder.textView.setText(chapters.get(i).getTitle());
        try {
            InputStream in = context.getAssets().open("images/" + chapters.get(i).getImage());
            Drawable drawable = Drawable.createFromStream(in, Integer.toString(i));
            Glide.with(context).load(drawable).into(myHolder.imageView);
        } catch (IOException e) {
            e.printStackTrace();
        }


        myHolder.layout.setOnClickListener(v -> {
            Intent intent = new Intent(context, Description.class);
            intent.putExtra("title", chapters.get(i).getTitle());
            intent.putExtra("image", chapters.get(i).getImage());
            intent.putExtra("content", chapters.get(i).getContent());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        RelativeLayout layout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_imageView);
            textView = itemView.findViewById(R.id.item_title);
            layout = itemView.findViewById(R.id.item_view);
        }
    }
}
