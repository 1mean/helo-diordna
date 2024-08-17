package com.lxj.xpopup.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.XPopupImageLoader;
import com.lxj.xpopup.photoview.OnMatrixChangedListener;
import com.lxj.xpopup.photoview.PhotoView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;

/**
 * 支持加载超长，超大的图片，你能OOM就算我输！！！
 * 注意：默认不支持超大超长图片加载，如8000x10000，传入bigImage为true时则使用SubsamplingScaleImageView加载大图；
 * SubsamplingScaleImageView虽然能加载超大图，但是加载Gif的时候不会动
 */
public class SmartGlideImageLoader implements XPopupImageLoader {
    private int errImg;
    private boolean mBigImage;

    public SmartGlideImageLoader() {
    }

    public SmartGlideImageLoader(int errImgRes) {
        errImg = errImgRes;
    }

    public SmartGlideImageLoader(boolean bigImage, int errImgRes) {
        this(errImgRes);
        mBigImage = bigImage;
    }

    @Override
    public View loadImage(final int position, @NonNull final Object url, @NonNull ImageViewerPopupView popupView,
                          @Nullable final PhotoView snapshot, @NonNull final ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
        final View imageView = buildPhotoView(popupView, snapshot, position);
        final Context context = imageView.getContext();
        if (snapshot != null && snapshot.getDrawable() != null && ((int) snapshot.getTag()) == position) {
            if (imageView instanceof PhotoView) {
                try {
                    ((PhotoView) imageView).setImageDrawable(snapshot.getDrawable().getConstantState().newDrawable());
                } catch (Exception e) {
                }
            }
        }
        Glide.with(imageView).downloadOnly().load(url)
                .into(new ImageDownloadTarget() {
                    @Override
                    public void onLoadFailed(Drawable errorDrawable) {
                        super.onLoadFailed(errorDrawable);
                        progressBar.setVisibility(View.GONE);
                        if (imageView instanceof PhotoView) {
                            ((PhotoView) imageView).setImageResource(errImg);
                            ((PhotoView) imageView).setZoomable(true);
                        }
                    }

                    @Override
                    public void onResourceReady(@NonNull File resource, Transition<? super File> transition) {
                        super.onResourceReady(resource, transition);
                        int maxW = XPopupUtils.getAppWidth(context) * 2;
                        int maxH = XPopupUtils.getScreenHeight(context) * 2;

                        int[] size = XPopupUtils.getImageSize(resource);
                        int degree = XPopupUtils.getRotateDegree(resource.getAbsolutePath());
                        //photo view加载
                        if (imageView instanceof PhotoView) {
                            progressBar.setVisibility(View.GONE);
                            ((PhotoView) imageView).setZoomable(true);
                            if (size[0] > maxW || size[1] > maxH) {
                                //TODO: 可能导致大图GIF展示不出来
                                Bitmap rawBmp = XPopupUtils.getBitmap(resource, maxW, maxH);
                                ((PhotoView) imageView).setImageBitmap(XPopupUtils.rotate(rawBmp, degree, size[0] / 2f, size[1] / 2f));
//                                Glide.with(imageView).load(rawBmp)
//                                        .apply(new RequestOptions().error(errImg).override(size[0], size[1])).into(((PhotoView) imageView));
                            } else {
                                Glide.with(imageView).load(resource)
                                        .apply(new RequestOptions().error(errImg).override(size[0], size[1])).into(((PhotoView) imageView));
                            }
                        }
                    }
                });
        return imageView;
    }

    private PhotoView buildPhotoView(final ImageViewerPopupView popupView, final PhotoView snapshotView, final int realPosition) {
        final PhotoView photoView = new PhotoView(popupView.getContext());
        photoView.setZoomable(false);
        photoView.setOnMatrixChangeListener(new OnMatrixChangedListener() {
            @Override
            public void onMatrixChanged(RectF rect) {
                if (snapshotView != null) {
                    Matrix matrix = new Matrix();
                    photoView.getSuppMatrix(matrix);
                    snapshotView.setSuppMatrix(matrix);
                }
            }
        });
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupView.dismiss();
            }
        });
        if (popupView.longPressListener != null) {
            photoView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    popupView.longPressListener.onLongPressed(popupView, realPosition);
                    return false;
                }
            });
        }
        return photoView;
    }

    @Override
    public void loadSnapshot(@NonNull Object uri, @NonNull final PhotoView snapshot, @Nullable final ImageView srcView) {
        if (mBigImage) {
            if (srcView != null && srcView.getDrawable() != null) {
                try {
                    snapshot.setImageDrawable(srcView.getDrawable().getConstantState().newDrawable());
                } catch (Exception e) {
                }
            }
            Glide.with(snapshot).downloadOnly().load(uri)
                    .into(new ImageDownloadTarget() {
                        @Override
                        public void onLoadFailed(Drawable errorDrawable) {
                            super.onLoadFailed(errorDrawable);
                        }

                        @Override
                        public void onResourceReady(@NonNull File resource, Transition<? super File> transition) {
                            super.onResourceReady(resource, transition);
                            int degree = XPopupUtils.getRotateDegree(resource.getAbsolutePath());
                            int maxW = XPopupUtils.getAppWidth(snapshot.getContext());
                            int maxH = XPopupUtils.getScreenHeight(snapshot.getContext());
                            int[] size = XPopupUtils.getImageSize(resource);
                            if (size[0] > maxW || size[1] > maxH) {
                                //缩放加载
                                Bitmap rawBmp = XPopupUtils.getBitmap(resource, maxW, maxH);
                                snapshot.setImageBitmap(XPopupUtils.rotate(rawBmp, degree, size[0] / 2f, size[1] / 2f));
                            } else {
                                Glide.with(snapshot).load(resource).apply(new RequestOptions().override(size[0], size[1])).into(snapshot);
                            }
                        }
                    });
        } else {
            Glide.with(snapshot).load(uri).override(Target.SIZE_ORIGINAL).into(snapshot);
        }
    }


    @Override
    public File getImageFile(@NonNull Context context, @NonNull Object uri) {
        try {
            return Glide.with(context).downloadOnly().load(uri).submit().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}