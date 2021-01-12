package com.jackie.testdialog

import android.util.Base64
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

/**
 * Description:
 * @author feifei5292190@gmail.com
 * @date 2020/12/14
 */
object AlgorithmUtils {
    fun hmacSHA256(content: String): String {
        val mac = Mac.getInstance("HmacSHA256")
        val secretKeyByteArray = Base64.decode("QHHKFumIOntQVRGx4ERNqA==", Base64.NO_WRAP)
        val secret = SecretKeySpec(
                secretKeyByteArray, mac.algorithm
        )
        mac.init(secret)
        val abc = content.toByteArray(Charsets.UTF_8)
        print("=============jackie=====:"+abc)
        val hash = mac.doFinal(abc)
        return Base64.encodeToString(hash, Base64.NO_WRAP)
    }
}