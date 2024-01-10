
fun main() {
    // es dona la benvinguda a l'usuari
    menuWelcome()

    // --Recollida de dades-- //

    // es pregunta a l'usuari per el seu consum en Litres
    val waterConsumtion:Float = menuWaterConsumtion()

    // esbrinem quin tipus de familia té l'usuari
    val largeFamily:Boolean = menuLargeFamily()
    val singleParentFamily:Boolean = menuSingleParentFamily()

    // si l'usuari es familia nombrosa o monomarental hem de saber de quants membres es composa el seu nucli familiar
    var numberOfMembers:Int = 0
    if (largeFamily || singleParentFamily){
        numberOfMembers = menuNumberOfMembers(largeFamily, singleParentFamily)
    }

    // esbrinem si l'usuari disposa d'un bo social
    val hasSocialBonus:Boolean = menuSocialBonus()

    // --Processament de dades-- //

    // determinem cuota fixa
    val fixedFee:Int = fixedFee(hasSocialBonus)

    // determinem cuota variable
    val variableFee:Float = variableFee(waterConsumtion)

    // determinem què calcularem en funció de si l'usuari te descomptes i quins son
    // es dona prioritat a hasSocialBonus per sobre de discountFamilyType, perque sempre es un descompte superior

    var finalCharge:Float = 0f
    var socialBonusDiscount:Float = 0f
    var discountFamilyType:Float = 0f

    if (!largeFamily && !singleParentFamily && !hasSocialBonus){
        finalCharge = calculateFinalChargeNoDiscount(fixedFee, variableFee)
    }else if (hasSocialBonus){
        socialBonusDiscount = discountSocialBonus(variableFee)
        finalCharge = calculateFinalChargeWithDiscount(fixedFee, variableFee, socialBonusDiscount)
    }else{
        discountFamilyType = discountFamilyType(variableFee, numberOfMembers)
        finalCharge = calculateFinalChargeWithDiscount(fixedFee, variableFee, discountFamilyType)
    }
    println(finalCharge)

}