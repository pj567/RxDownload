package zlc.season.rxdownload4.task

import zlc.season.rxdownload4.*
import zlc.season.rxdownload4.downloader.Mapper
import zlc.season.rxdownload4.validator.Validator

open class Task(
        val url: String,
        val saveName: String = "",
        val savePath: String = DEFAULT_SAVE_PATH,
        val rangeSize: Long = DEFAULT_RANGE_SIZE,
        val maxConCurrency: Int = DEFAULT_MAX_CONCURRENCY,
        val header: Map<String, String> = RANGE_CHECK_HEADER,
        val validator: Validator = DEFAULT_VALIDATOR,
        val mapper: Mapper = DEFAULT_MAPPER
) {
    init {
        require(rangeSize > 1024 * 1024) { "rangeSize must be greater than 1M" }
        require(maxConCurrency > 0) { "maxConCurrency must be greater than 0" }
    }

    open fun tag(): String {
        return url
    }
}