package com.assignment.myresume.homescreen.testutils

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Class to read json file from resources.
 */
class JsonReaderUtil {

    companion object {

        fun readJsonFile(stream: InputStream): String {
            val bufferReader = BufferedReader(InputStreamReader(stream))
            var content = bufferReader.readLine()
            val stringBuilder = StringBuilder()
            while (content != null) {
                stringBuilder.append(content)
                content = bufferReader.readLine()
            }
            return stringBuilder.toString()
        }
    }
}
