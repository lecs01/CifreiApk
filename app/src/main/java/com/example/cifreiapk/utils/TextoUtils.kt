package com.example.cifreiapk.utils

import java.io.BufferedReader
import java.io.ByteArrayInputStream

class TextoUtils {
    companion object {
        fun convertWithBlankLines(text: String): String {
            val inputStream = ByteArrayInputStream(text.toByteArray())
            val reader = BufferedReader(inputStream.reader())
            val content = StringBuilder()
            try {
                var line = reader.readLine()
                var sizeLine = line.length
                while (line != null) {
                    content.append(fillBlankLine(sizeLine))
                    content.append("\n")
                    content.append(line)
                    line = reader.readLine()
                    content.append("\n")
                }
                return content.toString()
            } finally {
                inputStream.close()
                reader.close()
            }
        }

        fun fillBlankLine(size: Int) : String{
            var blankLine = " "
            for (x in 0 until size) {
                blankLine += "                        "
            }
            return blankLine
        }
    }
}