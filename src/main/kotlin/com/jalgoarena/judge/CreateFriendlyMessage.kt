package com.jalgoarena.judge

internal class CreateFriendlyMessage {

    private val JAVA_EXT = ".java:"

    fun from(errorMessage: String): String {
        val lines = errorMessage
                .split("\n")
                .dropLastWhile(String::isEmpty)
                .toTypedArray()

        val errorFriendlyMessage = StringBuilder()
        for (line in lines) {
            processLine(errorFriendlyMessage, line)
        }

        return errorFriendlyMessage.toString()
    }

    private fun processLine(sb: StringBuilder, line: String) {
        val pos = line.indexOf(JAVA_EXT)

        if (pos > 0) {
            appendFriendlyMessage(sb, line, pos)
        } else {
            sb.append(line).append('\n')
        }
    }

    private fun appendFriendlyMessage(errorFriendlyMessage: StringBuilder, line: String, pos: Int) {
        val pos2 = line.indexOf(':', pos + JAVA_EXT.length)
        val friendlyMessage = "Line:${getLineNumber(line, pos, pos2)}${line.substring(pos2)}"
        errorFriendlyMessage.append(friendlyMessage).append('\n')
    }

    private fun getLineNumber(line: String, pos: Int, pos2: Int): Int {
        val numberStr = line.substring(pos + JAVA_EXT.length, pos2)
        return Integer.valueOf(numberStr)
    }
}
