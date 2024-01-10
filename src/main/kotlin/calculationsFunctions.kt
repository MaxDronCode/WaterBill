import org.example.roundToTwoDecimals

/** Function that determines what the fixed fee to be paid will be.
 * @author Max Dron
 * @since 2024/01/10
 * @param hasSocialBonus Boolean that helps us determine the fixed fee
 * @return Returns the final fee in int format
 */
fun fixedFee (hasSocialBonus:Boolean): Int {
    return if (hasSocialBonus) 3
    else 6
}

/** Function that determines which price is applied to the user's water consumption in liters, and uses another function to calculate it
 * @author Max Dron
 * @since 2024/01/10
 * @param waterConsumtion Float variable indicating the amount of liters used
 * @return Returns the variable fee to be paid in float format, after passing through a function that calculates it and another that rounds it
 * @see calculateVariableFee
 * @see roundToTwoDecimals
 */
fun variableFee (waterConsumtion:Float): Float {
    val feePerLiter:Float = if (waterConsumtion < 50f) 0f
    else if (waterConsumtion >= 50f && waterConsumtion < 200f) 0.15f
    else 0.30f

    return roundToTwoDecimals(calculateVariableFee(feePerLiter, waterConsumtion))
}

/** Function that calculates the amount to be paid in the variable fee based on the water consumption in liters and the price applied to it.
 * @author Max Dron
 * @since 2024/01/10
 * @param feePerLiter Price per liter to be applied
 * @param waterConsumtion Amount of liters consumed
 * @see roundToTwoDecimals
 */
fun calculateVariableFee (feePerLiter:Float, waterConsumtion: Float) : Float {
    return roundToTwoDecimals(feePerLiter * waterConsumtion)
}

/** Function that calculates the discount that can be applied if you belong to a special type of family, bearing in mind that the discount cannot exceed 50%.
 * @author Max Dron
 * @since 2024/01/10
 * @param variableFee Variable fee to be paid by the user
 * @param membersNumber Number of family members of the user
 * @return Returns the discount to be applied
 */
fun discountFamilyType (variableFee:Float, membersNumber:Int): Float {
    val maxDiscount:Float = variableFee * 50 / 100
    val percentage:Float = 10 * membersNumber.toFloat()
    val actualDiscount:Float = variableFee * percentage / 100
    return if (actualDiscount > maxDiscount) roundToTwoDecimals(maxDiscount)
    else roundToTwoDecimals(actualDiscount)
}

/** Function that calculates the social voucher discount based on your variable fee
 * @author Max Dron
 * @since 2024/01/10
 * @param variableFee Variable fee to be paid by the user
 * @return Returns the discount to be applied
 * @see roundToTwoDecimals
 */
fun discountSocialBonus (variableFee: Float) : Float {
    return roundToTwoDecimals(variableFee * 80 / 100)
}

/** Function that calculates the final price to pay if the user does not have a discount
 * @author Max Dron
 * @since 2024/01/10
 * @param fixedFee Fixed fee to be paid by the user
 * @param variableFee Variable fee to be paid by the user
 * @return Returns final price to pay
 * @see roundToTwoDecimals
 */
fun calculateFinalChargeNoDiscount (fixedFee: Int, variableFee:Float): Float {
    return roundToTwoDecimals(fixedFee + variableFee)
}

/** Function that calculates the final price to pay if the user does have a discount
 * @author Max Dron
 * @since 2024/01/10
 * @param fixedFee Fixed fee to be paid by the user
 * @param variableFee Variable fee to be paid by the user
 * @param discount Discount to be applied to the user
 * @return Returns final price to pay
 * @see roundToTwoDecimals
 */
fun calculateFinalChargeWithDiscount (fixedFee: Int, variableFee:Float, discount: Float): Float {
    return roundToTwoDecimals(fixedFee + variableFee - discount)
}