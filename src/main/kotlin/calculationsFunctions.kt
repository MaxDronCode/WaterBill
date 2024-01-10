fun fixedFee (hasSocialBonus:Boolean): Int {
    return if (hasSocialBonus) 3
    else 6
}

fun variableFee (waterConsumtion:Float): Float {
    var feePerLiter:Float
    if (waterConsumtion < 50f) feePerLiter = 0f
    else if (waterConsumtion >= 50f && waterConsumtion < 200f) feePerLiter = 0.15f
    else feePerLiter = 0.30f

    return calculateVariableFee(feePerLiter, waterConsumtion)
}

fun calculateVariableFee (feePerLiter:Float, waterConsumtion: Float) : Float {
    return feePerLiter * waterConsumtion
}

fun discountFamilyType (variableFee:Float, membersNumber:Int): Float {
    val maxDiscount = variableFee * 50 / 100
    val actualDiscount = 10 * membersNumber.toFloat()
    return if (actualDiscount > maxDiscount) maxDiscount
    else actualDiscount
}

fun discountSocialBonus (variableFee: Float) : Float {
    return variableFee * 80 / 100
}