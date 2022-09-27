package local.hal.st42.android.originalapp90014.util

import local.hal.st42.android.originalapp90014.features.ramen.model.Ramen
import java.sql.Date

fun initRamen(): Ramen {
    return Ramen(
        id = 0,
        name = "",
        address = "",
        visitDate = Date(System.currentTimeMillis()),
        category = "",
        note = "",
        registryDate = Date(System.currentTimeMillis()),
        updateDate = Date(System.currentTimeMillis()),
    )
}