
fun main() {
    // es dona la benvinguda a l'usuari
    menuWelcome()

    // es pregunta a l'usuari per el seu consum en Litres
    val waterConsumtion:Float = menuWaterConsumtion()

    // esbrinem quin tipus de familia té l'usuari
    val specialFamily:Array<Boolean> = menuFamilyType()

    // si l'usuari forma part d'una tipus de familia especial, se li preguntarà de quants membres esta format el seu nucli familiar
    if (true in specialFamily) {
        val numberOfMembers = menuNumberOfMembers()
    }

    // esbrinem si l'usuari disposa d'un bo social
    val hasSocialBonus:Boolean = menuSocialBonus()
}