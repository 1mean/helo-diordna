package com.luck.picture.lib;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.adapter.PublishItemDecoration;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.CloseListener;
import com.luck.picture.lib.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Objects;

public class PicturePublishFragment extends Fragment {

    public static final String TAG = PicturePublishFragment.class.getSimpleName();

    private AppCompatEditText title;
    private AppCompatEditText content;
    private ArrayList<LocalMedia> mData;
    private ConstraintLayout publishView;
    private CloseListener cListener;


    public static PicturePublishFragment newInstance() {
        PicturePublishFragment fragment = new PicturePublishFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    public void addSelectedData(ArrayList<LocalMedia> mData) {
        this.mData = mData;
    }

    public void addCloseListener(CloseListener cListener) {
        this.cListener = cListener;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ps_layout_publish_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppCompatImageButton btnBack = view.findViewById(R.id.btn_publish_back);
        title = view.findViewById(R.id.edit_publish_title);
        content = view.findViewById(R.id.edit_publish_content);
        AppCompatImageButton delete = view.findViewById(R.id.img_publish_delete);
        RecyclerView recycler = view.findViewById(R.id.recycler_publish);
        publishView = view.findViewById(R.id.clayout_publish);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recycler.addItemDecoration(new PublishItemDecoration());

        PublishAdapter mAdapter = new PublishAdapter();
        Log.e("1mean", "mData size: " + mData.size());
        if (mData != null && !mData.isEmpty()) {
            mAdapter.initData(mData);
        }
        recycler.setAdapter(mAdapter);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!title.getText().toString().isEmpty()) {
                    title.setText(null);
                    title.setHint("填写标题");
                }
            }
        });
        publishView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.getText().toString().isEmpty() || content.getText().toString().isEmpty()) {
                    ToastUtils.showToast(getContext(), "请填写标题和内容");
                } else {


                    ToastUtils.showToast(getContext(), "发布成功");
                    cListener.closeActivity();
                }
            }
        });
    }

    private static class PublishAdapter extends RecyclerView.Adapter<PublishAdapter.PublishViewHolder> {

        private ArrayList<LocalMedia> list;

        public void initData(ArrayList<LocalMedia> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public PublishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ps_adapter_publish, parent, false);
            return new PublishViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PublishViewHolder holder, int position) {
            holder.handle(position);
        }

        @Override
        public int getItemCount() {
            if (list == null) {
                return 0;
            } else
                return list.size();
        }

        public class PublishViewHolder extends RecyclerView.ViewHolder {

            public AppCompatImageView image;

            public PublishViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.img_item_publish);
            }

            public void handle(int position) {
                if (list != null && !list.isEmpty()) {
                    LocalMedia media = list.get(position);
                    Glide.with(itemView.getContext()).asBitmap().load(media.getAvailablePath()).into(image);
                }
            }
        }
    }
}
