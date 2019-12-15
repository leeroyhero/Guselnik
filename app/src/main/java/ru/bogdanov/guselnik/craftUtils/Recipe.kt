package ru.bogdanov.guselnik.craftUtils

import ru.bogdanov.guselnik.item.Ingredient
import kotlin.math.max
import kotlin.math.min

class Recipe {
    val recipeMap = mutableMapOf<String, Ingredient>()

    init {
        fillRecipeMap()
        fillMusicalRecipeMap()
    }

    fun getNewIngredient(droppedType: String, secondType: String): Ingredient? {
        return recipeMap.get(getHash(droppedType, secondType))
    }

    private fun fillMusicalRecipeMap() {
        addToRecipeMap(Ingredient.SPOON.type, Ingredient.SPOON.type, Ingredient.SPOONS) //ложки
    }

    private fun fillRecipeMap() {
        addToRecipeMap(AXE, FOREST, Ingredient.POLENO) //полено
        addToRecipeMap(KNIFE, FOREST, Ingredient.TROSTNIK) //тростник
        addToRecipeMap(CHISEL, FOREST, Ingredient.BERESTA) //кора

        addToRecipeMap(Ingredient.BERESTA, Ingredient.BERESTA, Ingredient.SHANKUNOK)
        addToRecipeMap(Ingredient.SHEPKA, Ingredient.SHEPKA, Ingredient.TRESHETKA)
        addToRecipeMap(Ingredient.PALKA.type, AXE, Ingredient.RUBEL)
        addToRecipeMap(Ingredient.SHEPKA, Ingredient.GILA, Ingredient.VETROVIK)
        addToRecipeMap(Ingredient.SHEPKA.type, CHISEL, Ingredient.GREBEN)
        addToRecipeMap(Ingredient.SPOON, Ingredient.SPOON, Ingredient.SPOONS)
        addToRecipeMap(Ingredient.DOSKA_HOLED, Ingredient.PALKA, Ingredient.BARABANKA)
        addToRecipeMap(Ingredient.POKOVKA, Ingredient.PALKA, Ingredient.KOSA)
        addToRecipeMap(Ingredient.YAZUCHEK_METAL, Ingredient.POKOVKA, Ingredient.VARGAN)
        addToRecipeMap(Ingredient.BARABAN, Ingredient.SMYK, Ingredient.GUSACHOK)
        addToRecipeMap(Ingredient.KOST, Ingredient.GILA, Ingredient.BRUNCHALKA)
        addToRecipeMap(Ingredient.LITIE, Ingredient.KORITSE_VODA, Ingredient.ZVENIASHIE_PRIVESI)
        addToRecipeMap(Ingredient.POLENO, Ingredient.POLENO, Ingredient.DROVA)
        addToRecipeMap(Ingredient.KORPUS, Ingredient.PALKA, Ingredient.KOLOTUSHKA)
        addToRecipeMap(Ingredient.BARABAN, Ingredient.KOLOKOLCHIK, Ingredient.BUBEN)
        addToRecipeMap(Ingredient.KORITSE, Ingredient.KOGA, Ingredient.BARABAN)
        addToRecipeMap(Ingredient.RASPLAV, Ingredient.GLINA, Ingredient.KOLOKOLCHIK)
        addToRecipeMap(Ingredient.POKOVKA, Ingredient.POKOVKA, Ingredient.BRYACALO)
        addToRecipeMap(Ingredient.KORITSE, Ingredient.SHEPKA, Ingredient.BOTALO)
        addToRecipeMap(Ingredient.KOGA, Ingredient.KOLOKOLCHIK, Ingredient.OGERELOK)
        addToRecipeMap(Ingredient.POLENO, Ingredient.PALKA, Ingredient.BILO)
        addToRecipeMap(Ingredient.KORPUS_WINDOW, Ingredient.STRUNA, Ingredient.GUSLI_LIROOBR)
        addToRecipeMap(Ingredient.KORPUS, Ingredient.STRUNA, Ingredient.GUSLI_KRIL)
        addToRecipeMap(Ingredient.GUSLI_KRIL, Ingredient.STRUNA, Ingredient.GUSLI_PSALTIR)
        addToRecipeMap(Ingredient.GUSLI_PSALTIR, Ingredient.PALKA, Ingredient.CIMBALI)
        addToRecipeMap(Ingredient.GUSLI_PSALTIR, Ingredient.GRIF, Ingredient.BANDURA)
        addToRecipeMap(Ingredient.KORPUS_HOLED, Ingredient.GRIF, Ingredient.BALALAYKA)
        addToRecipeMap(Ingredient.BALALAYKA, Ingredient.KOST, Ingredient.DOMRA)
        addToRecipeMap(Ingredient.GUSLI_KRIL, Ingredient.SMYK,Ingredient.GUDOK)
        addToRecipeMap(Ingredient.GUDOK, Ingredient.GRIF,Ingredient.SKRIPKA_NARODNAYA)
        addToRecipeMap(Ingredient.TROSTNIK, Ingredient.TROSTNIK, Ingredient.KUKIGL)
        addToRecipeMap(Ingredient.TROSTNIK.type, CHISEL, Ingredient.KALUKA)
        addToRecipeMap(Ingredient.KALUKA.type, CHISEL, Ingredient.SOPEL)
        addToRecipeMap(Ingredient.SOPEL, Ingredient.SOPEL, Ingredient.SWIREL_DWOY)
        addToRecipeMap(Ingredient.GLINA.type, BONFIRE, Ingredient.SVISTULKA)
        addToRecipeMap(Ingredient.SOPEL.type, AXE, Ingredient.POSVISTEL)
        addToRecipeMap(Ingredient.TROSTNIK.type, KNIFE, Ingredient.PISHIK)
        addToRecipeMap(Ingredient.PISHIK.type, CHISEL, Ingredient.GALEYKA)
        addToRecipeMap(Ingredient.YAZICHOK, Ingredient.NEREHT_ROGOK, Ingredient.SURNA)
        addToRecipeMap(Ingredient.GALEYKA, Ingredient.SHKURA, Ingredient.VOLINKA)
        addToRecipeMap(Ingredient.ROG.type, AXE, Ingredient.ROG_SIGNALNIY)
        addToRecipeMap(Ingredient.TRUBKA, Ingredient.BERESTA, Ingredient.TRUBA_PAST)
        addToRecipeMap(Ingredient.TRUBA_PAST.type, CHISEL, Ingredient.NEREHT_ROGOK)
        addToRecipeMap(Ingredient.GUDOK, Ingredient.KOLESO, Ingredient.KOLESNAYA_LIRA)
        addToRecipeMap(Ingredient.KORPUS, Ingredient.YAZUCHEK_METAL, Ingredient.GARMONIKA)
        addToRecipeMap(Ingredient.GARMONIKA, Ingredient.MEHA, Ingredient.GARMON_HROMKA)
        addToRecipeMap(Ingredient.GARMON_HROMKA, Ingredient.KOLOKOLCHIK, Ingredient.GARMON_SARATOV)
        addToRecipeMap(Ingredient.POLENO.type, AXE, Ingredient.DOSKA)
        addToRecipeMap(Ingredient.DOSKA.type, AXE, Ingredient.SHEPKA)
        addToRecipeMap(Ingredient.POLENO.type, KNIFE, Ingredient.PALKA)
        addToRecipeMap(Ingredient.SHEPKA.type, AXE, Ingredient.SPOON)
        addToRecipeMap(Ingredient.POLENO.type, CHISEL, Ingredient.KORITSE)
        addToRecipeMap(Ingredient.DOSKA.type, KNIFE, Ingredient.DEKA)
        addToRecipeMap(Ingredient.KORITSE, Ingredient.DEKA, Ingredient.KORPUS)
        addToRecipeMap(Ingredient.DOSKA.type, CHISEL, Ingredient.DOSKA_HOLED)
        addToRecipeMap(Ingredient.DOSKA, Ingredient.PALKA, Ingredient.LOPATA)
        addToRecipeMap(Ingredient.PALKA.type, KNIFE, Ingredient.KOPIE)
        addToRecipeMap(Ingredient.KOPIE, Ingredient.KOPIE, Ingredient.KAPKAN)
        addToRecipeMap(Ingredient.SMYK, Ingredient.PERO, Ingredient.LUK)
        addToRecipeMap(Ingredient.POLENO, Ingredient.GILA, Ingredient.SILKI)
        addToRecipeMap(Ingredient.PISHIK.type, FOREST, Ingredient.PERO)
        addToRecipeMap(Ingredient.KOGA, Ingredient.KOGA, Ingredient.MEHA)
        addToRecipeMap(Ingredient.LOPATA.type, FOREST, Ingredient.ZEMLYA)
        addToRecipeMap(Ingredient.KORITSE.type, FOREST, Ingredient.KORITSE_VODA)
        addToRecipeMap(Ingredient.KORITSE_VODA, Ingredient.ZEMLYA, Ingredient.GLINA)
        addToRecipeMap(Ingredient.SHKURA.type, KNIFE, Ingredient.KOGA)
        addToRecipeMap(Ingredient.KORPUS.type, AXE, Ingredient.KORPUS_WINDOW)
        addToRecipeMap(Ingredient.KORPUS.type, CHISEL, Ingredient.KORPUS_HOLED)
        addToRecipeMap(Ingredient.KOPIE.type, FOREST, Ingredient.VOLOS)
        addToRecipeMap(Ingredient.KAPKAN.type, FOREST, Ingredient.ROG)
        addToRecipeMap(Ingredient.LUK.type, FOREST, Ingredient.SHKURA)
        addToRecipeMap(Ingredient.SILKI.type, FOREST, Ingredient.GILA)
        addToRecipeMap(Ingredient.ROG.type, KNIFE, Ingredient.KOST)
        addToRecipeMap(Ingredient.GILA, Ingredient.GILA, Ingredient.STRUNA)
        addToRecipeMap(Ingredient.PALKA, Ingredient.STRUNA, Ingredient.GRIF)
        addToRecipeMap(Ingredient.PALKA, Ingredient.VOLOS, Ingredient.SMYK)
        addToRecipeMap(Ingredient.BERESTA.type, KNIFE, Ingredient.YAZICHOK)
        addToRecipeMap(Ingredient.PALKA.type, CHISEL, Ingredient.TRUBKA)
        addToRecipeMap(Ingredient.DOSKA_HOLED.type, AXE, Ingredient.KOLESO)
        addToRecipeMap(Ingredient.ZEMLYA.type, BONFIRE, Ingredient.KRICA)
        addToRecipeMap(Ingredient.KRICA.type, BONFIRE, Ingredient.POKOVKA)
        addToRecipeMap(Ingredient.POKOVKA.type, BONFIRE, Ingredient.RASPLAV)
        addToRecipeMap(Ingredient.RASPLAV, Ingredient.YAZICHOK, Ingredient.YAZUCHEK_METAL)

    }

    private fun addToRecipeMap(type1: String, type2: String, result: Ingredient) {
        recipeMap.put(
            getHash(type1, type2),
            result
        )
    }

    private fun addToRecipeMap(type1: Ingredient, type2: Ingredient, result: Ingredient) {
        recipeMap.put(
            getHash(type1.type, type2.type),
            result
        )
    }

    private fun getHash(type1: String, type2: String): String {
        val hash1 = type1.hashCode()
        val hash2 = type2.hashCode()
        return "${max(hash1, hash2)}${min(hash1, hash2)}"
    }
}