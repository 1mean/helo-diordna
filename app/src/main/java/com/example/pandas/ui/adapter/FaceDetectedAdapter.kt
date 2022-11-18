package com.example.pandas.ui.adapter

import android.graphics.Bitmap
import android.util.Log
import com.example.pandas.R
import com.example.pandas.base.adapter.BaseCommonAdapter
import com.example.pandas.base.adapter.BaseViewHolder
import de.hdodenhof.circleimageview.CircleImageView
import org.opencv.android.Utils
import org.opencv.core.Mat

/**
 * @description: FaceDetectedAdapter
 * @author: dongyiming
 * @date: 8/19/22 11:11 上午
 * @version: v1.0
 */
public class FaceDetectedAdapter(
    private val list: MutableList<Mat> = mutableListOf()
) :
    BaseCommonAdapter<Mat>(list) {

    fun getList(): MutableList<Mat> = list

    override fun getLayoutId(): Int = R.layout.adapter_item_face

    override fun convert(holder: BaseViewHolder, data: Mat, position: Int) {

        val bitmap = Bitmap.createBitmap(data.width(), data.height(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(data, bitmap)
        val header = holder.getWidget<CircleImageView>(R.id.img_face_capture)
        Log.e("sdas221edasd","bitmap: $bitmap")
        header.setImageBitmap(bitmap)
    }
}