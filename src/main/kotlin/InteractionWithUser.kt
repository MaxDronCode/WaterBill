import org.example.*
import java.time.LocalDate


/** Funció copiada i actualitzada de David Marín que dona la benvinguda a l'usuari.
 * @author David Marin
 * @author Max Dron
 * @version 1.1
 * @since 2024/01/10
 */
fun menuWelcome(){
    val str=""" $BLUE_BOLD
        |#############################################################################
        |#$GREEN_BOLD Benvingut a l'aplicació que t'ajuda a entendre la teva factura de l'aigua $BLUE_BOLD#
        |#$GREEN_BOLD Li farem unes breus preguntes.                                            $BLUE_BOLD#
        |#$GREEN_BOLD I podrà veure de manera molt fàcil el seu import i a què es dèu.          $BLUE_BOLD#
        |#$GREEN_BOLD Li desitgem una agradable experiència.                                    $BLUE_BOLD#
        |#                                                                           #
        |#############################################################################
        $RESET
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
        "${CYAN_BOLD}Indiqui el seu consum d'aigua, en Litres, del mes que volem calcular.$RESET",
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
        "${CYAN_BOLD}Son familia nombrosa? (S/N)$RESET",
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
        "${CYAN_BOLD}Son una familia monoparental/monomarental? (S/N)$RESET",
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
            numberOfMembers = readInt("${CYAN_BOLD}Vostè ha indicat que es familia monomarental i nombrosa a la vegada, indiqui quants membres resideixen a la vostra finca.$RESET",
            "Ha de introduir un nombre enter positiu.",
            "Valor no acceptat, Valor mínim:4 , Valor màxim:10.",
            4,
            10)
        return numberOfMembers
    }else if (singleParentFamily){
            numberOfMembers = readInt("${CYAN_BOLD}Vostè ha indicat que pertany a una familia monomarental, indiqui quants membres resideixen a la vostra finca.$RESET",
            "Ha de introduir un nombre enter positiu.",
            "Valor no acceptat, Valor mínim:2 , Valor màxim:10.",
            2,
            10)
        return numberOfMembers
    } else {
            numberOfMembers = readInt("${CYAN_BOLD}Vostè ha indicat que pertany a una familia nombrosa, indiqui quants membres resideixen a la vostra finca.$RESET",
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
        "${CYAN_BOLD}Introduieixi si disposa d'un bo social: (S/N).$RESET",
        "S",
        "N",
        "Opció no vàlida!"
    )
}

/** Function that finally shows the user the result of all processes, an invoice with all the detailed data.
 * @author Max Dron
 * @since 2024/01/10
 * @param finalCharge The amount of money the user has to pay at the end, with discounts applied if there were any.
 * @param waterConsumtion Amount of liters consumed
 * @param variableFee Variable fee to be paid by the user
 * @param fixedFee Fixed fee to be paid by the user
 * @param discount Discount applied to the user, if no parameter is passed, 0 is assigned by default
 * @param socialBonus Parameter that indicates whether there has been a discount for social bonus, by default, its value is 'NO'
 * @param familyType Parameter that indicates whether there has been a discount for familyType, by default, its value is 'NO'
 *
 */
fun menuInvoice (finalCharge:Float, waterConsumtion:Float, variableFee:Float, fixedFee:Int, discount:Float = 0f, socialBonus:String = "NO", familyType:String = "NO") {
    val date:LocalDate = LocalDate.now()
    val pricePerLiter:Float = roundToTwoDecimals(variableFee / waterConsumtion)

    val invoice = """ $GREEN
    |###########################################################################
    |#                         ${GREEN_BOLD_BRIGHT}FACTURA DE L'AIGUA$GREEN                              #
    |###########################################################################
    |# ${GREEN_UNDERLINED}Client$RESET: ${WHITE}ITB$GREEN                                                             #
    |# ${GREEN_UNDERLINED}Data$RESET: $WHITE$date$GREEN                                                             
    |###########################################################################
    |# ${GREEN_BOLD_BRIGHT}Resum del Consum: $GREEN                                                      #
    |#   - ${GREEN_UNDERLINED}Litres consumits$RESET: $waterConsumtion L $GREEN                                 
    |#   - ${GREEN_UNDERLINED}Preu per litre$RESET: $pricePerLiter €/L   $GREEN                                   
    |#   - ${GREEN_UNDERLINED}Cuota variable$RESET: $variableFee €     $GREEN                                   
    |#   - ${GREEN_UNDERLINED}Cuota Fixe$RESET: $fixedFee €          $GREEN                                     
    |###########################################################################
    |# ${GREEN_BOLD_BRIGHT}Descomptes i Bonificacions: $GREEN                                            #
    |#   - ${GREEN_UNDERLINED}Bo social$RESET: $socialBonus $GREEN                                           
    |#   - ${GREEN_UNDERLINED}Familia nombrosa / monoparental$RESET: $familyType  $GREEN                                          
    |#   - ${GREEN_UNDERLINED}Descompte aplicat$RESET: $discount €  $GREEN                                      
    |###########################################################################
    |# ${GREEN_BOLD_BRIGHT}TOTAL A PAGAR: $WHITE_BOLD_BRIGHT$finalCharge €$GREEN                                            
    |###########################################################################
    """.trimMargin()

    println(invoice)

}
