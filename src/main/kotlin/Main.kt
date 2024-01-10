
fun main() {
    // Es dona la benvinguda a l'usuari
    menuWelcome()

    // --Recollida de dades-- //

    // Es pregunta a l'usuari per el seu consum en Litres
    val waterConsumtion:Float = menuWaterConsumtion()

    // Esbrinem quin tipus de familia té l'usuari
    val largeFamily:Boolean = menuLargeFamily()
    val singleParentFamily:Boolean = menuSingleParentFamily()

    // Si l'usuari es familia nombrosa o monomarental hem de saber de quants membres es composa el seu nucli familiar
    var numberOfMembers:Int = 0
    if (largeFamily || singleParentFamily){
        numberOfMembers = menuNumberOfMembers(largeFamily, singleParentFamily)
    }

    // Esbrinem si l'usuari disposa d'un bo social
    val hasSocialBonus:Boolean = menuSocialBonus()

    // --Processament de dades-- //

    // Determinem cuota fixa
    val fixedFee:Int = fixedFee(hasSocialBonus)

    // Determinem cuota variable
    val variableFee:Float = variableFee(waterConsumtion)

    // Determinem què calcularem en funció de si l'usuari te descomptes i quins son
    // es dona prioritat a hasSocialBonus per sobre de discountFamilyType, perque sempre es un descompte superior

    // ------------- Creació de variables utils --------------
    var finalCharge:Float = 0f
    var socialBonusDiscount:Float = 0f
    var discountFamilyType:Float = 0f
    val familyType:String = if (largeFamily || singleParentFamily) "SI"
    else "NO"
    // -------------------------------------------------------

    if (!largeFamily && !singleParentFamily && !hasSocialBonus){            // El client no te cap descompte
        finalCharge = calculateFinalChargeNoDiscount(fixedFee, variableFee) // Es calcula cuota final
        menuInvoice(finalCharge, waterConsumtion, variableFee, fixedFee)    // Sortida de dades final
    }else if (hasSocialBonus){                                              // El client te el descompte per bonus social
        socialBonusDiscount = discountSocialBonus(variableFee)              // Es calcula el descompte
        finalCharge = calculateFinalChargeWithDiscount(fixedFee, variableFee, socialBonusDiscount) // Es calcula la cuota final
        menuInvoice(finalCharge, waterConsumtion, variableFee, fixedFee, socialBonusDiscount, "SI", familyType) // Sortida de dades final
    }else{
        discountFamilyType = discountFamilyType(variableFee, numberOfMembers)// El client té o familia nombrosa o monoparental
        finalCharge = calculateFinalChargeWithDiscount(fixedFee, variableFee, discountFamilyType)// Es calcula cuota final
        menuInvoice(finalCharge, waterConsumtion, variableFee, fixedFee, discountFamilyType, "NO", familyType) // Sortida de dades final
    }

}