package com.example.pandas.bean

import org.opencv.core.Mat
import org.opencv.core.Rect

data class MatRect(
    var mat: Mat,
    var rect: Rect
)
