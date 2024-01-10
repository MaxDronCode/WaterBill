
fun main() {
    // es dona la benvinguda a l'usuari
    menuWelcome()

    // Recollida de dades

    // es pregunta a l'usuari per el seu consum en Litres
    val waterConsumtion:Float = menuWaterConsumtion()

    // esbrinem quin tipus de familia té l'usuari
    val largeFamily:Boolean = menuLargeFamily()
    val singleParentFamily:Boolean = menuSingleParentFamily()

    // si l'usuari es familia nombrosa o monomarental hem de saber de quants membres es composa el seu nucli familiar
    if (largeFamily || singleParentFamily){
        val numberOfMembers = menuNumberOfMembers(largeFamily, singleParentFamily)
    }

    // esbrinem si l'usuari disposa d'un bo social
    val hasSocialBonus:Boolean = menuSocialBonus()

    // Processament de dades


}