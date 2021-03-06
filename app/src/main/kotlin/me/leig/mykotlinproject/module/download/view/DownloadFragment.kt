package me.leig.mykotlinproject.module.download.view

import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_download.*
import kotlinx.android.synthetic.main.fragment_download.view.*
import me.leig.mykotlinproject.R
import me.leig.mykotlinproject.base.fragment.BaseFragment
import me.leig.mykotlinproject.base.tool.HttpHandler
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */
 
class DownloadFragment: BaseFragment("下载页面") {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_download, container, false)

        val mHandler = Handler(Handler.Callback {

            when(it.what) {
                0 -> {
                    println("下载失败咯...")
                }
                1 -> {

                    try {
                        val filePath = it.obj as String

                        view.ap_view.fromFile(File(filePath))
                                .enableSwipe(true) // allows to block changing pages using swipe
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .defaultPage(0)
                                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                                .password(null)
                                .scrollHandle(null)
                                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                                // spacing between pages in dp. To define spacing color, set view background
                                .spacing(0)
                                .load()
                    } catch (e: Exception) {
                        println("文件格式错误: ${e.message}")
                    }
                }
                else -> {

                }
            }
            return@Callback false
        })

        initView(view.submit, mHandler)

        return view
    }

    private fun initView(button: Button, handler: Handler) {

        button.setOnClickListener({

            val httpHandler = HttpHandler()

            val request = Request
                    .Builder()
                    .url(et_url.text.toString())
                    .build()

            httpHandler.newCall(request).enqueue(object : Callback {

                override fun onFailure(call: Call, e: IOException) {
                    Log.i("HttpHandler", "下载失败: " + e.message)
                }

                override fun onResponse(call: Call, response: Response) {

                    val inputStream = response.body()!!.byteStream()

                    val fileOutputStream: FileOutputStream

                    val file: File

                    try {

                        val strs = et_url.text.toString().split("/")

                        file = File("${Environment.getExternalStorageDirectory().absolutePath}/${strs[strs.size - 1]}")

                        if (file.exists()) {
                            file.delete()
                        }

                        fileOutputStream = FileOutputStream(file)

                        val buffer = ByteArray(1024)

                        var len: Int = inputStream.read(buffer)

                        while (-1 != len) {

                            fileOutputStream.write(buffer, 0, len)

                            len = inputStream.read(buffer)

                        }

                        fileOutputStream.flush()

                        fileOutputStream.close()

                        Log.d("HttpHandler", "文件下载成功")

                        handler.obtainMessage(1, file.absolutePath).sendToTarget()

                    } catch (e: IOException) {
                        Log.i("HttpHandler", "IOException: " + e.message)
                        e.printStackTrace()
                    }
                }
            })
        })
    }
}