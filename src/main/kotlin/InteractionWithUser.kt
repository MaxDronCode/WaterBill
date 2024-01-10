import org.example.*
import java.time.LocalDate


/** Funció copiada i actualitzada de David Marín que dona la benvinguda a l'usuari.
 * @author David Marin
 * @author Max Dron
 * @version 1.1
 * @since 2024/01/10
 */
fun menuWelcome(){
    val str="""
        |#############################################################################
        |# Benvingut a l'aplicació que t'ajuda a entendre la teva factura de l'aigua #
        |# Li farem unes breus preguntes.                                            #
        |# I podrà veure de manera molt fàcil el seu import i a què es dèu.          #
        |# Li desitgem una agradable experiència.                                    #
        |#                                                                           #
        |#                                                                           #
        |#############################################################################
        """.trimMargin()
    println(str)
}

/** Function that asks the user for their water consumption and receives the data in Float format using the readFloat() function.
 * @author Max Dron
 * @return  float value is returned representing the quantity of liters consumed by the user.
 * @since 2024/01/10
 * @see readFloat
 */
fun menuWaterConsumtion(): Float {
    return readFloat(
        "Indiqui el seu consum d'aigua, en Litres, del mes que volem calcular.",
        "Recordi que ha de introduir els litres.",
        "Ha introduit un valor no vàlid",
        0.0f,
        9999.9f
    )
}

/** Function that determines if the user belongs to a large family.
 * @author Max Dron
 * @since 2024/01/10
 * @return Returns a boolean value indicating whether the user belongs to a large family or not.
 * @see readYesNo
 */
fun menuLargeFamily(): Boolean {
    return readYesNo(
        "Son familia nombrosa? (S/N)",
        "S",
        "N",
        "Opció no vàlida!"
    )
}

/** Function that determines if the user belongs to a single parent family.
 * @author Max Dron
 * @since 2024/01/10
 * @return Returns a boolean value indicating whether the user belongs to a single parent family or not.
 * @see readYesNo
 */
fun menuSingleParentFamily(): Boolean {
    return readYesNo(
        "Son una familia monoparental/monomarental? (S/N)",
        "S",
        "N",
        "Opció no vàlida!"
    )
}

/** Function that determines how many members the user's family consists of.
 * @author Max Dron
 * @since 2024/01/10
 * @return An integer is returned with the number of members in the user's family nucleus.
 * @see readInt
 */
fun menuNumberOfMembers (largeFamily:Boolean, singleParentFamily:Boolean): Int {
    var numberOfMembers:Int = 0
    if (largeFamily && singleParentFamily){
            numberOfMembers = readInt("Vostè ha indicat que es familia monomarental i nombrosa a la vegada, indiqui quants membres resideixen a la vostra finca.",
            "Ha de introduir un nombre enter positiu.",
            "Valor no acceptat, Valor mínim:4 , Valor màxim:10.",
            4,
            10)
        return numberOfMembers
    }else if (singleParentFamily){
            numberOfMembers = readInt("Vostè ha indicat que pertany a una familia monomarental, indiqui quants membres resideixen a la vostra finca.",
            "Ha de introduir un nombre enter positiu.",
            "Valor no acceptat, Valor mínim:2 , Valor màxim:10.",
            2,
            10)
        return numberOfMembers
    } else {
            numberOfMembers = readInt("Vostè ha indicat que pertany a una familia nombrosa, indiqui quants membres resideixen a la vostra finca.",
            "Ha de introduir un nombre enter positiu.",
            "Valor no acceptat, Valor mínim:5 , Valor màxim:10.",
            5,
            10)
        return  numberOfMembers
    }

}


/** Function that asks the user if they have a social bonus using the readYesNo() function.
 * @author Max Dron
 * @since 2024/01/10
 * @return A boolean is returned indicating whether the user enjoys a social bonus or not
 * @see readYesNo
 */
fun menuSocialBonus(): Boolean {
    return readYesNo(
        "Introduieixi si disposa d'un bo social: (S/N).",
        "S",
        "N",
        "Opció no vàlida!"
    )
}

fun menuInvoice (finalCharge:Float, waterConsumtion:Float, variableFee:Float, fixedFee:Int, discount:Float = 0f, socialBonus:String = "NO") {
    val date:LocalDate = LocalDate.now()
    val pricePerLiter:Float = roundToTwoDecimals(variableFee / waterConsumtion)

    val invoice = """
    |###########################################################################
    |#                         FACTURA DE L'AIGUA                              #
    |###########################################################################
    |# Client: ITB                                                             #
    |# Data: $date                                                             
    |###########################################################################
    |# Resum del Consum:                                                       #
    |#   - Litres consumits: $waterConsumtion                                  
    |#   - Preu per litre: $pricePerLiter                                      
    |#   - Cuota variable: $variableFee                                        
    |#   - Cuota Fixe: $fixedFee                                               
    |###########################################################################
    |# Descomptes i Bonificacions:                                             #
    |#   - Descompte aplicat: $discount                                        
    |#   - Bo social: $socialBonus                                           
    |###########################################################################
    |# TOTAL A PAGAR: $finalCharge                                             
    |###########################################################################
    """.trimMargin()

    println(invoice)

}
