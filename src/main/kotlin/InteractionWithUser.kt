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
 * @version 1.1
 * @since 2024/01/10
 * @see readFloat
 */
fun menuWaterConsumtion () {
    val waterConsumtion = readFloat(
        "Indiqui el seu consum d'aigua, en Litres, del mes que volem calcular, format (XX.XX)",
        "Recordi que ha de introduir els litres en format (XX/XX)",
        "Ha introduit un valor no vàlid",
        0.0f,
        9999.9f
    )
}

/**
 * Function that determines if the user belongs to a large family or single-parent family, and if so, asks how many members are in the family.
 * @author Max Dron
 * @since 2024/01/10
 * @see readBoolean
 * @see readInt
 */
fun menuFamilyType () {
    val largeFamily = readBoolean("Son familia nombrosa? (true/false)",
        "Valor incorrecte, recordi (true/false)")
    val singleParentFamily = readBoolean("Son una familia monoparental/monomarental? (true/false)",
    "Valor incorrecte, recordi (true/false)")
    if (largeFamily || singleParentFamily){
        val numberOfMembers = readInt("Indiqui quants membres resideixen al vostre domicil·li",
            "Ha de introduir un nombre enter positiu.",
            "Valor no acceptat, Valor mínim:2 , Valor màxim:10.",
            2,
            10)
    }
}
