import org.example.roundToTwoDecimals
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculationsFunctionsKtTest () {
    // FixedFee function test
    @Test
    fun checkCalculateFixedFee() {
        var expected:Int = 3
        var hasSocialBonus:Boolean = true
        assertEquals(expected, fixedFee(hasSocialBonus))

        expected = 6
        hasSocialBonus = false
        assertEquals(expected, fixedFee(hasSocialBonus))
    }

    // VariableFee function test, using a for loop to test many values, in this case between 1 and 500
    @Test
    fun checkCalculateVariableFee() {
        var expected:Float = 0f
        for (i in 1..500){
            if (i in 1..49) expected = 0f
            else if (i in 50..199) expected = roundToTwoDecimals(0.15f * i)
            else expected = roundToTwoDecimals(0.30f * i)
            assertEquals(expected, variableFee(i.toFloat()))
        }

        assertTrue(variableFee(30f) is Float)
    }

    // DiscountFamilyType function test. Testing differnet values with a for loop.
    @Test
    fun checkDiscountFamilyType() {
        var variableFee:Float = 50f
        val membersNumber:Int = 5
        var expected:Float = 25f
        assertEquals(expected, discountFamilyType(variableFee, membersNumber))

        for (i in 2..10){
            variableFee = 100f
            expected = when (i){
                2 -> variableFee * 20 / 100
                3 -> variableFee * 30 / 100
                4 -> variableFee * 40 / 100
                else -> variableFee * 50 / 100
            }
            assertEquals(expected, discountFamilyType(variableFee, i))
        }
        assertTrue(discountFamilyType(100f, 5) is Float)
    }

    // DiscountSocialBonus function test. Try different values with a for loop.
    @Test
    fun checkDiscountSocialBonus() {
        assertTrue(discountSocialBonus(50f) is Float)

        for (i in 1..500){
            val expected:Float = i * 80 / 100f
            assertEquals(expected, discountSocialBonus(i.toFloat()))
        }
    }

    // calculateFinalChargeNoDiscount function test. As above, through a for loop.
    @Test
    fun checkComputeFinalPriceWithoutDiscount() {
        val fixedFee:Int = 6
        for (i in 1..500){
            val variableFee:Float = i.toFloat()
            val expected:Float = variableFee + fixedFee
            assertEquals(expected, calculateFinalChargeNoDiscount(fixedFee, variableFee))
        }

        assertTrue(calculateFinalChargeNoDiscount(6, 6f) is Float)
    }

    // calculateFinalChargeWithDiscount function test. As above, through a for loop.
    @Test
    fun checkComputeFinalPriceWithDiscount() {

        assertTrue(calculateFinalChargeWithDiscount(6, 50f, 50f) is Float)

        val fixedFee:Int = 6
        val variableFee:Float = 50f
        for (i in 1..50){
            val discount:Float = i.toFloat()
            val expected:Float = variableFee + fixedFee - discount
            assertEquals(expected, calculateFinalChargeWithDiscount(fixedFee, variableFee, discount))
        }
    }
}