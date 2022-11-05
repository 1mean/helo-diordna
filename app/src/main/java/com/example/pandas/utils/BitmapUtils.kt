package com.example.pandas.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ThumbnailUtils
import android.util.Log
import java.io.*


object BitmapUtils {

    /**
     * 图片压缩：质量压缩方法
     * @param beforBitmap 要压缩的图片
     * @return 压缩后的图片
     */
    fun compressImage(beforeBitmap: Bitmap?): Bitmap? {

        // 可以捕获内存缓冲区的数据，转换成字节数组。
        val bos = ByteArrayOutputStream()
        beforeBitmap?.let {
            // 第一个参数：图片压缩的格式；第二个参数：压缩的比率；第三个参数：压缩的数据存放到bos中
            // WEBP_LOSSY有损模式 无法恢复到原格式，压缩率更大，图片更小
            it.compress(Bitmap.CompressFormat.WEBP_LOSSY, 100, bos) //100是压缩的最大数视觉质量

            // 循环判断压缩后的图片大小是否满足要求，这里限制100kb，若不满足则继续压缩，每次递减10%压缩
            var options = 100
            while (bos.toByteArray().size / 1024 > 100 && options > 0) {
                bos.reset() // 置为空
                it.compress(Bitmap.CompressFormat.WEBP_LOSSY, options, bos)
                options -= 10
            }
            // 从bos中将数据读出来 转换成图片
            val bis = ByteArrayInputStream(bos.toByteArray())
            return BitmapFactory.decodeStream(bis)
        }
        return null
    }

    /**
     * 图片压缩：获得缩略图
     * @param beforeBitmap 要压缩的图片
     * @param width 缩略图宽度
     * @param height 缩略图高度
     * @return 压缩后的图片
     */
    fun getThumbnail(beforeBitmap: Bitmap?, width: Int, height: Int): Bitmap {
        return ThumbnailUtils.extractThumbnail(beforeBitmap, width, height)
    }

    /**
     * 图片压缩: 按尺寸压缩
     * @param beforeBitmap 要压缩的图片
     * @param newWidth 压缩后的宽度
     * @param newHeight 压缩后的高度
     * @return 压缩后的图片
     */
    fun compressBitmap1(
        beforeBitmap: Bitmap,
        newWidth: Double,
        newHeight: Double
    ): Bitmap {
        // 图片原有的宽度和高度
        val beforeWidth = beforeBitmap.width.toFloat()
        val beforeHeight = beforeBitmap.height.toFloat()

        // 计算宽高缩放率
        var scaleWidth = 0f
        var scaleHeight = 0f
        if (beforeWidth > beforeHeight) {
            scaleWidth = newWidth.toFloat() / beforeWidth
            scaleHeight = newHeight.toFloat() / beforeHeight
        } else {
            scaleWidth = newWidth.toFloat() / beforeHeight
            scaleHeight = newHeight.toFloat() / beforeWidth
        }

        // 矩阵对象
        val matrix = Matrix()
        // 缩放图片动作 缩放比例
        matrix.postScale(scaleWidth, scaleHeight)
        // 创建一个新的Bitmap 从原始图像剪切图像
        return Bitmap.createBitmap(
            beforeBitmap,
            0,
            0,
            beforeWidth.toInt(),
            beforeHeight.toInt(),
            matrix,
            true
        )
    }

    /**
     * 图片压缩: 规定尺寸等比例压缩，宽高不能超过限制要求
     * @param beforBitmap 要压缩的图片
     * @param maxWidth 最大宽度限制
     * @param maxHeight 最大高度限制
     * @return 压缩后的图片
     */
    fun compressBitmap(
        beforBitmap: Bitmap,
        maxWidth: Double,
        maxHeight: Double
    ): Bitmap {

        // 图片原有的宽度和高度
        val beforeWidth = beforBitmap.width.toFloat()
        val beforeHeight = beforBitmap.height.toFloat()
        if (beforeWidth <= maxWidth && beforeHeight <= maxHeight) {
            return beforBitmap
        }

        // 计算宽高缩放率，等比例缩放
        val scaleWidth = maxWidth.toFloat() / beforeWidth
        val scaleHeight = maxHeight.toFloat() / beforeHeight
        var scale = scaleWidth
        if (scaleWidth > scaleHeight) {
            scale = scaleHeight
        }
        Log.d(
            "BitmapUtils", "before[" + beforeWidth + ", " + beforeHeight + "] max[" + maxWidth
                    + ", " + maxHeight + "] scale:" + scale
        )

        // 矩阵对象
        val matrix = Matrix()
        // 缩放图片动作 缩放比例
        matrix.postScale(scale, scale)
        // 创建一个新的Bitmap 从原始图像剪切图像
        return Bitmap.createBitmap(
            beforBitmap,
            0,
            0,
            beforeWidth.toInt(),
            beforeHeight.toInt(),
            matrix,
            true
        )
    }

    fun saveBitmap(bm: Bitmap, filePath: String) {
        val f = File(filePath)
        if (f.exists()) {
            f.delete()
        }
        try {
            val out = FileOutputStream(f)
            bm.compress(Bitmap.CompressFormat.WEBP_LOSSY, 90, out)
            out.flush()
            out.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}



