import kotlin.math.round
fun roundToTwoDecimals(number: Float): Float {
    return round(number * 100) / 100
}

fun fixedFee (hasSocialBonus:Boolean): Int {
    return if (hasSocialBonus) 3
    else 6
}

fun variableFee (waterConsumtion:Float): Float {
    val feePerLiter:Float = if (waterConsumtion < 50f) 0f
    else if (waterConsumtion >= 50f && waterConsumtion < 200f) 0.15f
    else 0.30f

    return roundToTwoDecimals(calculateVariableFee(feePerLiter, waterConsumtion))
}

fun calculateVariableFee (feePerLiter:Float, waterConsumtion: Float) : Float {
    return roundToTwoDecimals(feePerLiter * waterConsumtion)
}

fun discountFamilyType (variableFee:Float, membersNumber:Int): Float {
    val maxDiscount:Float = variableFee * 50 / 100
    val percentage:Float = 10 * membersNumber.toFloat()
    val actualDiscount:Float = variableFee * percentage / 100
    return if (actualDiscount > maxDiscount) roundToTwoDecimals(maxDiscount)
    else roundToTwoDecimals(actualDiscount)
}

fun discountSocialBonus (variableFee: Float) : Float {
    return roundToTwoDecimals(variableFee * 80 / 100)
}


fun calculateFinalChargeNoDiscount (fixedFee: Int, variableFee:Float): Float {
    return roundToTwoDecimals(fixedFee + variableFee)
}

fun calculateFinalChargeWithDiscount (fixedFee: Int, variableFee:Float, discount: Float): Float {
    return roundToTwoDecimals(fixedFee + variableFee - discount)
}