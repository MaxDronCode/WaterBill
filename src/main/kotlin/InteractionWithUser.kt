import org.example.readFloat

/** Funció copiada i actualitzada de David Marín que dona la benvinguda a l'usuari.
 * @author David Marin
 * @author Max Dron
 * @version 1.2
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

fun menuWaterConsumtion () {
    val waterConsumtion = readFloat(
        "Indiqui el seu consum d'aigua, en Litres, del mes que volem calcular, format (XX.XX)",
        "Recordi que ha de introduir els litres en format (XX/XX)",
        "Ha introduit un valor no vàlid",
        0.0f,
        9999.9f
    )
}

