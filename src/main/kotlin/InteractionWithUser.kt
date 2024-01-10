import org.example.readBoolean
import org.example.readFloat
import org.example.readInt

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
fun menuWaterConsumtion (): Float {
    val waterConsumtion = readFloat(
        "Indiqui el seu consum d'aigua, en Litres, del mes que volem calcular, format (XX.XX)",
        "Recordi que ha de introduir els litres en format (XX/XX)",
        "Ha introduit un valor no vàlid",
        0.0f,
        9999.9f
    )
    return waterConsumtion
}

/**
 * Function that determines if the user belongs to any type of special family, collects the data in an array of booleans, and returns it.
 * @author Max Dron
 * @since 2024/01/10
 * @return An array of booleans is returned that contains the values of whether the user belongs to a large family or a single-parent family.
 * @see readBoolean
 * @see readInt
 */
fun menuFamilyType (): Array<Boolean> {

    val largeFamily = readBoolean("Son familia nombrosa? (true/false)",
        "Valor incorrecte, recordi (true/false)")
    val singleParentFamily = readBoolean("Son una familia monoparental/monomarental? (true/false)",
    "Valor incorrecte, recordi (true/false)")

    val boolArray:Array<Boolean> = arrayOf(largeFamily, singleParentFamily)

    return boolArray


}

/** Function that determines how many members the user's family consists of.
 * @author Max Dron
 * @since 2024/01/10
 * @return An integer is returned with the number of members in the user's family nucleus.
 * @see readInt
 */
fun menuNumberOfMembers (): Int {
    val numberOfMembers = readInt("Indiqui quants membres resideixen al vostre domicil·li",
        "Ha de introduir un nombre enter positiu.",
        "Valor no acceptat, Valor mínim:2 , Valor màxim:10.",
        2,
        10)
    return numberOfMembers
}



/** Function that asks the user if they have a social bonus using the readBoolean() function.
 * @author Max Dron
 * @since 2024/01/10
 * @return A boolean is returned indicating whether the user enjoys a social bonus or not
 * @see readBoolean
 */
fun menuSocialBonus (): Boolean {
    val hasSocialBonus = readBoolean("Introduieixi si disposa d'un bo social: (true/false).",
        "Valor incorrecte, recordi que les opcions son (true/false)")
    return hasSocialBonus
}
