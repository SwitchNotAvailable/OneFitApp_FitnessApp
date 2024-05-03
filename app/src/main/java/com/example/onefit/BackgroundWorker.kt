package com.example.onefit

import android.app.AlertDialog
import android.content.Context
import android.os.AsyncTask
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder

class BackgroundWorker(private val context: Context) : AsyncTask<String, Void, String>() {
    private lateinit var alertDialog: AlertDialog

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: String): String? {
        val type = params[0]
        val loginUrl = "http://31.94.36.173/login.php"
        return if (type == "login") {
            try {
                val username = params[1]
                val password = params[2]
                val url = URL(loginUrl)
                val httpURLConnection = url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod = "POST"
                httpURLConnection.doOutput = true
                httpURLConnection.doInput = true
                val outputStream = httpURLConnection.outputStream
                val bufferedWriter = BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
                val postData = "${URLEncoder.encode("username", "UTF-8")}=${ URLEncoder.encode(username, "UTF-8")}&${URLEncoder.encode("password", "UTF-8")}=${URLEncoder.encode(password, "UTF-8")}"
                bufferedWriter.write(postData)
                bufferedWriter.flush()
                bufferedWriter.close()
                outputStream.close()
                val inputStream = httpURLConnection.inputStream
                val bufferedReader = BufferedReader(InputStreamReader(inputStream, "iso-8859-1"))
                var result = ""
                var line: String?
                while (bufferedReader.readLine().also { line = it } != null) {
                    result += line
                }
                bufferedReader.close()
                inputStream.close()
                httpURLConnection.disconnect()
                result
            } catch (e: MalformedURLException) {
                e.printStackTrace()
                null
            } catch (e: IOException) {
                e.printStackTrace()
                null
            }
        } else {
            null
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onPreExecute() {
        alertDialog = AlertDialog.Builder(context).create()
        alertDialog.setTitle("Login Status")
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: String?) {
        alertDialog.setMessage(result)
        alertDialog.show()
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("super.onProgressUpdate(*values)", "android.os.AsyncTask")
    )
    override fun onProgressUpdate(vararg values: Void) {
        super.onProgressUpdate(*values)
    }
}

