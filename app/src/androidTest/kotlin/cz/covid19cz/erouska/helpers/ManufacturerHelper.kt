package cz.covid19cz.erouska.helpers

object ManufacturerHelper {
        private val BATTERY_OPTIMIZATION_MANUFACTURERS = setOf("huawei", "asus", "lenovo", "samsung", "sony", "xiaomi")
        private val PHONE_MANUFACTURER: String = android.os.Build.MANUFACTURER.toLowerCase()

    fun isBatteryTutorialNeeded(): Boolean = BATTERY_OPTIMIZATION_MANUFACTURERS.contains(PHONE_MANUFACTURER)
}
