package com.life.publish.lib_selector.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pandas.R;
import com.life.publish.lib_selector.entity.LocalMedia;

import java.util.ArrayList;
import java.util.Iterator;

public class PictuteSelectedAdapter extends RecyclerView.Adapter<PictuteSelectedAdapter.PictureSelectorViewHolder> {

    private ArrayList<LocalMedia> mData;
    private PictureDeleteListener pictureDeleteListener;

    public PictuteSelectedAdapter() {
    }

    public void setData(ArrayList<LocalMedia> list) {
        this.mData = list;
    }

    public void setOnPictureDeleteListener(PictureDeleteListener listener) {
        this.pictureDeleteListener = listener;
    }

    public ArrayList<LocalMedia> getData() {
        return mData;
    }

    @SuppressLint("NotifyDataSetChanged")
    public int addOne(LocalMedia localMedia) {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        mData.add(localMedia);
        notifyDataSetChanged();
        return mData.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public int removeOne(LocalMedia localMedia) {
        int size = mData.size();
        if (size > 0) {
            Iterator<LocalMedia> iterator = mData.iterator();
            while (iterator.hasNext()) {
                LocalMedia next = iterator.next();
                if (next.position == localMedia.position) {
                    mData.remove(next);
                    notifyDataSetChanged();
                    break;
                }
            }
        }
        return mData.size();
    }


    @NonNull
    @Override
    public PictureSelectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ps_item_selector_adapter, parent, false);
        return new PictureSelectorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PictureSelectorViewHolder holder, int position) {
        holder.handle(position);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class PictureSelectorViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView imgSelector;
        private ConstraintLayout deleteView;

        public PictureSelectorViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSelector = itemView.findViewById(R.id.img_selector);
            deleteView = itemView.findViewById(R.id.clayout_delete_selector);
        }

        public void handle(int position) {
            LocalMedia media = mData.get(position);

            Glide.with(itemView.getContext()).asBitmap().load(media.getAvailablePath()).into(imgSelector);

            deleteView.setOnClickListener(v -> {
                pictureDeleteListener.delete(position, media);
            });
        }
    }

    public interface PictureDeleteListener {
        void delete(int position, LocalMedia localMedia);
    }
}
