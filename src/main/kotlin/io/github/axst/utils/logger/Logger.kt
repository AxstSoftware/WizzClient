package io.github.axst.utils.logger

import java.text.SimpleDateFormat
import java.util.*

open class Logger {
    private var appName: String? = null

    private val format = SimpleDateFormat("HH:mm:ss")
    private val date = Date()

    fun register(applicationName: String) {
        appName = applicationName
        System.out.format("[Main/INFO]: %s initialized\n", applicationName)
    }
    
    fun alert(message: String, alertType: AlertType) {
        if (appName != null) {
            when (alertType) {
                AlertType.ERROR -> {
                    System.out.format(
                        """
                            [${format.format(date)}] [$appName] [Main/ERROR]: $message
                            """.trimIndent()
                    )
                }
                AlertType.INFO -> {
                    System.out.format(
                        """
                                [${format.format(date)}] [$appName] [Main/INFO]: $message
                                """.trimIndent()
                    )
                }
                AlertType.WARN -> {
                    System.out.format(
                        """
                                [${format.format(date)}] [$appName] [Main/WARN]: $message
                                """.trimIndent()
                    )
                }
            }
        } else error()
    }

    private fun error() {
        System.out.format("[ERROR] [Main/FATAL]: logger will be not load.")
    }
}