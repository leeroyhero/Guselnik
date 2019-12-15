package ru.bogdanov.guselnik.craftUtils

import ru.bogdanov.guselnik.item.Ingredient
import ru.bogdanov.guselnik.item.Ingredient.*
import ru.bogdanov.guselnik.item.RecipeItem
import kotlin.math.max
import kotlin.math.min

val NONE="none"

class Recipe {
    val recipeMap = mutableMapOf<String, Ingredient>()
    val recipeItemList= mutableListOf<RecipeItem>()

    init {
        fillRecipeMap()
    }

    fun getNewIngredient(droppedType: String, secondType: String): Ingredient? {
        return recipeMap.get(getHash(droppedType, secondType))
    }

    private fun fillRecipeMap() {
        addToRecipeMap(Ingredient.AXE, Ingredient.FOREST, Ingredient.POLENO) //полено
        addToRecipeMap(Ingredient.KNIFE, Ingredient.FOREST, Ingredient.TROSTNIK) //тростник
        addToRecipeMap(Ingredient.CHISEL, Ingredient.FOREST, Ingredient.BERESTA) //кора

        addToRecipeMap(Ingredient.BERESTA, Ingredient.BERESTA, Ingredient.SHANKUNOK)
        addToRecipeMap(Ingredient.SHEPKA, Ingredient.SHEPKA, Ingredient.TRESHETKA)
        addToRecipeMap(Ingredient.PALKA, Ingredient.AXE, Ingredient.RUBEL)
        addToRecipeMap(Ingredient.SHEPKA, Ingredient.GILA, Ingredient.VETROVIK)
        addToRecipeMap(Ingredient.SHEPKA, Ingredient.CHISEL, Ingredient.GREBEN)
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
        addToRecipeMap(Ingredient.RASPLAV, GLINA, Ingredient.KOLOKOLCHIK)
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
        addToRecipeMap(Ingredient.TROSTNIK, CHISEL, Ingredient.KALUKA)
        addToRecipeMap(Ingredient.KALUKA, CHISEL, Ingredient.SOPEL)
        addToRecipeMap(Ingredient.SOPEL, Ingredient.SOPEL, Ingredient.SWIREL_DWOY)
        addToRecipeMap(GLINA, BONFIRE, Ingredient.SVISTULKA)
        addToRecipeMap(Ingredient.SOPEL, AXE, Ingredient.POSVISTEL)
        addToRecipeMap(Ingredient.TROSTNIK, KNIFE, Ingredient.PISHIK)
        addToRecipeMap(Ingredient.PISHIK, CHISEL, Ingredient.GALEYKA)
        addToRecipeMap(Ingredient.YAZICHOK, Ingredient.NEREHT_ROGOK, Ingredient.SURNA)
        addToRecipeMap(Ingredient.GALEYKA, Ingredient.SHKURA, Ingredient.VOLINKA)
        addToRecipeMap(Ingredient.ROG, AXE, Ingredient.ROG_SIGNALNIY)
        addToRecipeMap(Ingredient.TRUBKA, Ingredient.BERESTA, Ingredient.TRUBA_PAST)
        addToRecipeMap(Ingredient.TRUBA_PAST, CHISEL, Ingredient.NEREHT_ROGOK)
        addToRecipeMap(Ingredient.GUDOK, Ingredient.KOLESO, Ingredient.KOLESNAYA_LIRA)
        addToRecipeMap(Ingredient.KORPUS, Ingredient.YAZUCHEK_METAL, Ingredient.GARMONIKA)
        addToRecipeMap(Ingredient.GARMONIKA, Ingredient.MEHA, Ingredient.GARMON_HROMKA)
        addToRecipeMap(Ingredient.GARMON_HROMKA, Ingredient.KOLOKOLCHIK, Ingredient.GARMON_SARATOV)
        addToRecipeMap(Ingredient.POLENO, AXE, Ingredient.DOSKA)
        addToRecipeMap(Ingredient.DOSKA, AXE, Ingredient.SHEPKA)
        addToRecipeMap(Ingredient.POLENO, KNIFE, Ingredient.PALKA)
        addToRecipeMap(Ingredient.SHEPKA, AXE, Ingredient.SPOON)
        addToRecipeMap(Ingredient.POLENO, CHISEL, Ingredient.KORITSE)
        addToRecipeMap(Ingredient.DOSKA, KNIFE, Ingredient.DEKA)
        addToRecipeMap(Ingredient.KORITSE, Ingredient.DEKA, Ingredient.KORPUS)
        addToRecipeMap(Ingredient.DOSKA, CHISEL, Ingredient.DOSKA_HOLED)
        addToRecipeMap(Ingredient.DOSKA, Ingredient.PALKA, Ingredient.LOPATA)
        addToRecipeMap(Ingredient.PALKA, KNIFE, Ingredient.KOPIE)
        addToRecipeMap(Ingredient.KOPIE, Ingredient.KOPIE, Ingredient.KAPKAN)
        addToRecipeMap(Ingredient.SMYK, Ingredient.PERO, Ingredient.LUK)
        addToRecipeMap(Ingredient.POLENO, Ingredient.GILA, Ingredient.SILKI)
        addToRecipeMap(Ingredient.PISHIK, FOREST, Ingredient.PERO)
        addToRecipeMap(Ingredient.KOGA, Ingredient.KOGA, Ingredient.MEHA)
        addToRecipeMap(Ingredient.LOPATA, FOREST, Ingredient.ZEMLYA)
        addToRecipeMap(Ingredient.KORITSE, FOREST, Ingredient.KORITSE_VODA)
        addToRecipeMap(Ingredient.KORITSE_VODA, Ingredient.ZEMLYA, GLINA)
        addToRecipeMap(Ingredient.SHKURA, KNIFE, Ingredient.KOGA)
        addToRecipeMap(Ingredient.KORPUS, AXE, Ingredient.KORPUS_WINDOW)
        addToRecipeMap(Ingredient.KORPUS, CHISEL, Ingredient.KORPUS_HOLED)
        addToRecipeMap(Ingredient.KOPIE, FOREST, Ingredient.VOLOS)
        addToRecipeMap(Ingredient.KAPKAN, FOREST, Ingredient.ROG)
        addToRecipeMap(Ingredient.LUK, FOREST, Ingredient.SHKURA)
        addToRecipeMap(Ingredient.SILKI, FOREST, Ingredient.GILA)
        addToRecipeMap(Ingredient.ROG, KNIFE, Ingredient.KOST)
        addToRecipeMap(Ingredient.GILA, Ingredient.GILA, Ingredient.STRUNA)
        addToRecipeMap(Ingredient.PALKA, Ingredient.STRUNA, Ingredient.GRIF)
        addToRecipeMap(Ingredient.PALKA, Ingredient.VOLOS, Ingredient.SMYK)
        addToRecipeMap(Ingredient.BERESTA, KNIFE, Ingredient.YAZICHOK)
        addToRecipeMap(Ingredient.PALKA, CHISEL, Ingredient.TRUBKA)
        addToRecipeMap(Ingredient.DOSKA_HOLED, AXE, Ingredient.KOLESO)
        addToRecipeMap(Ingredient.ZEMLYA, BONFIRE, Ingredient.KRICA)
        addToRecipeMap(Ingredient.KRICA, BONFIRE, Ingredient.POKOVKA)
        addToRecipeMap(Ingredient.POKOVKA, BONFIRE, Ingredient.RASPLAV)
        addToRecipeMap(Ingredient.RASPLAV, Ingredient.YAZICHOK, Ingredient.YAZUCHEK_METAL)
    }

    private fun addToRecipeMap(type1: Ingredient, type2: Ingredient, result: Ingredient) {
        recipeMap.put(
            getHash(type1.type, type2.type),
            result
        )
        recipeItemList.add(RecipeItem(type1, type2, result))
    }

    private fun getHash(type1: String, type2: String): String {
        val hash1 = type1.hashCode()
        val hash2 = type2.hashCode()
        return "${max(hash1, hash2)}${min(hash1, hash2)}"
    }
}