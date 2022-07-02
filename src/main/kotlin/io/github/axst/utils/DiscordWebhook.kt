package io.github.axst.utils

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.URL
import java.net.URLEncoder

class DiscordWebhook {
    companion object {
        @JvmStatic
        fun sendMessage(message: String) {
            val out: PrintWriter?
            val `in`: BufferedReader?
            val result = StringBuilder()
            val realUrl = URL("https://discord.com/api/webhooks/992850938815594547/Zi1GgI-8x3x1t8Yl7aFXOvYZQWuraklqmTYKiEnDmvL6iapn0-hBseq6EvHVsNBFGPNW")
            val conn = realUrl.openConnection()
            conn.setRequestProperty("accept", "*/*")
            conn.setRequestProperty("connection", "Keep-Alive")
            conn.setRequestProperty("user-agent", "WizzClient(Version 0.1.0 - Minecraft)")
            conn.doOutput = true
            conn.doInput = true
            out = PrintWriter(conn.getOutputStream())
            val postData = URLEncoder.encode("content", "UTF-8") + "=" + URLEncoder.encode(message, "UTF-8")
            out.print(postData)
            out.flush()
            `in` = BufferedReader(InputStreamReader(conn.getInputStream()))
            var line: String?
            while (`in`.readLine().also { line = it } != null) {
                result.append("/n").append(line)
            }
        }
    }
}