
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

    // determinem descompte 1 si escau
    var discountFamilyType:Float = 0f
    if (largeFamily || singleParentFamily){
        discountFamilyType = discountFamilyType(variableFee, numberOfMembers)
    }

    // determinem descompte 2 si escau
    var socialBonusDiscount:Float = 0f
    if (hasSocialBonus){
        socialBonusDiscount = discountSocialBonus(variableFee)
    }

    // en cas de que l'usuati tingui els 2 descomptes, ens quedem amb el mes alt
    var has2discounts:Boolean = false
    var actualDiscount:Float = 0f
    if (socialBonusDiscount > 0f && discountFamilyType > 0f){
        has2discounts = true
        if (socialBonusDiscount >= discountFamilyType) actualDiscount = socialBonusDiscount
        else actualDiscount = discountFamilyType
    }
}