package ru.bogdanov.guselnik.item

enum class Ingredient(val type: String, val label: String, val image: Int? = null, isInstrument: Boolean=false){
    POLENO("poleno", "Полено"),
    TROSTNIK("trostnik","Тростник"),
    KORA("kora","Кора"),

    PALKA("palka", "Палка"),

    SPOON("spoon", "Ложка"),

    SPOONS("spoons", "Ложки", isInstrument = true)
}