package ru.bogdanov.guselnik.craftUtils

import ru.bogdanov.guselnik.item.Ingredient
import ru.bogdanov.guselnik.item.Ingredient.*
import ru.bogdanov.guselnik.item.RecipeItem
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.max
import kotlin.math.min

val NONE = "none"

@Singleton
class Recipe @Inject constructor() {
    val recipeMap = mutableMapOf<String, Ingredient>()
    val recipeItemList = mutableListOf<RecipeItem>()

    init {
        fillRecipeMap()
    }

    fun getNewIngredient(droppedType: String, secondType: String): Ingredient? {
        return recipeMap.get(getHash(droppedType, secondType))
    }

    private fun fillRecipeMap() {
        addToRecipeMap(AXE, FOREST, POLENO) //полено
        addToRecipeMap(KNIFE, FOREST, TROSTNIK) //тростник
        addToRecipeMap(CHISEL, FOREST, BERESTA) //кора

        addToRecipeMap(BERESTA, BERESTA, SHANKUNOK)
        addToRecipeMap(SHEPKA, SHEPKA, TRESHETKA)
        addToRecipeMap(PALKA, AXE, RUBEL)
        addToRecipeMap(SHEPKA, GILA, VETROVIK)
        addToRecipeMap(SHEPKA, CHISEL, GREBEN)
        addToRecipeMap(SPOON, SPOON, SPOONS)
        addToRecipeMap(DOSKA_HOLED, PALKA, BARABANKA)
        addToRecipeMap(POKOVKA, PALKA, KOSA)
        addToRecipeMap(YAZUCHEK_METAL, POKOVKA, VARGAN)
        addToRecipeMap(BARABAN, SMYK, GUSACHOK)
        addToRecipeMap(KOST, GILA, BRUNCHALKA)
        addToRecipeMap(RASPLAV, KORITSE_VODA, ZVENIASHIE_PRIVESI)
        addToRecipeMap(POLENO, POLENO, DROVA)
        addToRecipeMap(KORPUS, PALKA, KOLOTUSHKA)
        addToRecipeMap(BARABAN, KOLOKOLCHIK, BUBEN)
        addToRecipeMap(KORITSE, KOGA, BARABAN)
        addToRecipeMap(RASPLAV, GLINA, KOLOKOLCHIK)
        addToRecipeMap(POKOVKA, POKOVKA, BRYACALO)
        addToRecipeMap(KORITSE, SHEPKA, BOTALO)
        addToRecipeMap(KOGA, KOLOKOLCHIK, OGERELOK)
        addToRecipeMap(POLENO, PALKA, BILO)
        addToRecipeMap(KORPUS_WINDOW, STRUNA, GUSLI_LIROOBR)
        addToRecipeMap(KORPUS, STRUNA, GUSLI_KRIL)
        addToRecipeMap(GUSLI_KRIL, STRUNA, GUSLI_PSALTIR)
        addToRecipeMap(GUSLI_PSALTIR, PALKA, CIMBALI)
        addToRecipeMap(GUSLI_PSALTIR, GRIF, BANDURA)
        addToRecipeMap(KORPUS_HOLED, GRIF, BALALAYKA)
        addToRecipeMap(BALALAYKA, KOST, DOMRA)
        addToRecipeMap(GUSLI_KRIL, SMYK, GUDOK)
        addToRecipeMap(GUDOK, GRIF, SKRIPKA_NARODNAYA)
        addToRecipeMap(TROSTNIK, TROSTNIK, KUKIGL)
        addToRecipeMap(TROSTNIK, CHISEL, KALUKA)
        addToRecipeMap(KALUKA, CHISEL, SOPEL)
        addToRecipeMap(SOPEL, SOPEL, SWIREL_DWOY)
        addToRecipeMap(GLINA, BONFIRE, SVISTULKA)
        addToRecipeMap(TRUBKA_S_OTVERSTIAYAMI, PROBKA, POSVISTEL)
        addToRecipeMap(TROSTNIK, KNIFE, PISHIK)
        addToRecipeMap(PISHIK, CHISEL, BRELKA)
        addToRecipeMap(YAZICHOK, NEREHT_ROGOK, SURNA)
        addToRecipeMap(BRELKA, SHKURA, VOLINKA)
        addToRecipeMap(ROG, AXE, ROG_SIGNALNIY)
        addToRecipeMap(TRUBKA, BERESTA, TRUBA_PAST)
        addToRecipeMap(TRUBA_PAST, CHISEL, NEREHT_ROGOK)
        addToRecipeMap(GUDOK, KOLESO, KOLESNAYA_LIRA)
        addToRecipeMap(KORPUS, YAZUCHEK_METAL, GARMONIKA)
        addToRecipeMap(GARMONIKA, MEHA, GARMON_HROMKA)
        addToRecipeMap(GARMON_HROMKA, KOLOKOLCHIK, GARMON_SARATOV)
        addToRecipeMap(POLENO, AXE, DOSKA)
        addToRecipeMap(DOSKA, AXE, SHEPKA)
        addToRecipeMap(POLENO, KNIFE, PALKA)
        addToRecipeMap(SHEPKA, AXE, SPOON)
        addToRecipeMap(POLENO, CHISEL, KORITSE)
        addToRecipeMap(DOSKA, KNIFE, DEKA)
        addToRecipeMap(KORITSE, DEKA, KORPUS)
        addToRecipeMap(DOSKA, CHISEL, DOSKA_HOLED)
        addToRecipeMap(DOSKA, PALKA, LOPATA)
        addToRecipeMap(PALKA, KNIFE, KOPIE)
        addToRecipeMap(KOPIE, KOPIE, KAPKAN)
        addToRecipeMap(SMYK, PERO, LUK)
        addToRecipeMap(POLENO, GILA, SILKI)
        addToRecipeMap(PISHIK, FOREST, PERO)
        addToRecipeMap(KOGA, KOGA, MEHA)
        addToRecipeMap(LOPATA, FOREST, ZEMLYA)
        addToRecipeMap(KORITSE, FOREST, KORITSE_VODA)
        addToRecipeMap(KORITSE_VODA, ZEMLYA, GLINA)
        addToRecipeMap(SHKURA, KNIFE, KOGA)
        addToRecipeMap(KORPUS, AXE, KORPUS_WINDOW)
        addToRecipeMap(KORPUS, CHISEL, KORPUS_HOLED)
        addToRecipeMap(KOPIE, FOREST, VOLOS)
        addToRecipeMap(KAPKAN, FOREST, ROG)
        addToRecipeMap(LUK, FOREST, SHKURA)
        addToRecipeMap(SILKI, FOREST, GILA)
        addToRecipeMap(ROG, KNIFE, KOST)
        addToRecipeMap(GILA, GILA, STRUNA)
        addToRecipeMap(PALKA, STRUNA, GRIF)
        addToRecipeMap(PALKA, VOLOS, SMYK)
        addToRecipeMap(BERESTA, KNIFE, YAZICHOK)
        addToRecipeMap(PALKA, CHISEL, TRUBKA)
        addToRecipeMap(DOSKA_HOLED, AXE, KOLESO)
        addToRecipeMap(ZEMLYA, BONFIRE, KRICA)
        addToRecipeMap(KRICA, BONFIRE, POKOVKA)
        addToRecipeMap(POKOVKA, BONFIRE, RASPLAV)
        addToRecipeMap(RASPLAV, YAZICHOK, YAZUCHEK_METAL)
        addToRecipeMap(TRUBKA, CHISEL, TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(DEKA, CHISEL, DEKA_S_OTVERSTIAYAMI)
        addToRecipeMap(KORITSE, AXE, KORITSE_S_OKNOM)
        addToRecipeMap(KOLESO, AXE, PROBKA)
        addToRecipeMap(BRELKA, BRELKA, GALEYKA_DVOYNAYA)
        addToRecipeMap(DOMRA, STRUNA, KOBZA)
        addToRecipeMap(TRUBKA, SOPEL, FUYARA)
        addToRecipeMap(SHEPKA, VOLOS, VETROVIK)
        addToRecipeMap(SHEPKA, STRUNA, VETROVIK)
        addToRecipeMap(DEKA, PALKA, BARABANKA)
        addToRecipeMap(DEKA_S_OTVERSTIAYAMI, PALKA, BARABANKA)
        addToRecipeMap(BARABAN, PALKA, GUSACHOK)
        addToRecipeMap(BUBEN, SMYK, GUSACHOK)
        addToRecipeMap(BUBEN, PALKA, GUSACHOK)
        addToRecipeMap(KOST, VOLOS, BRUNCHALKA)
        addToRecipeMap(KOST, STRUNA, BRUNCHALKA)
        addToRecipeMap(KORPUS_HOLED, PALKA, KOLOTUSHKA)
        addToRecipeMap(KORPUS_WINDOW, PALKA, KOLOTUSHKA)
        addToRecipeMap(BARABAN, OGERELOK, BUBEN)
        addToRecipeMap(OGERELOK, KOGA, BUBEN)
        addToRecipeMap(OGERELOK, SHKURA, BUBEN)
        addToRecipeMap(KORITSE, SHKURA, BARABAN)
        addToRecipeMap(RASPLAV, ZEMLYA, KOLOKOLCHIK)
        addToRecipeMap(KNIFE, GARMON_SARATOV, KOLOKOLCHIK)
        addToRecipeMap(KNIFE, BUBEN, KOLOKOLCHIK)
        addToRecipeMap(KNIFE, OGERELOK, KOLOKOLCHIK)
        addToRecipeMap(KORITSE, PALKA, BOTALO)
        addToRecipeMap(KORITSE, POKOVKA, BOTALO)
        addToRecipeMap(KORITSE, GILA, BOTALO)
        addToRecipeMap(KORITSE, VOLOS, BOTALO)
        addToRecipeMap(KORITSE, STRUNA, BOTALO)
        addToRecipeMap(SHKURA, KOLOKOLCHIK, OGERELOK)
        addToRecipeMap(KORPUS_WINDOW, GILA, GUSLI_LIROOBR)
        addToRecipeMap(KORPUS_HOLED, STRUNA, GUSLI_KRIL)
        addToRecipeMap(GUSLI_KRIL, PALKA, CIMBALI)
        addToRecipeMap(BALALAYKA, GUSLI_PSALTIR, BANDURA)
        addToRecipeMap(DOMRA, GUSLI_PSALTIR, BANDURA)
        addToRecipeMap(BALALAYKA, GUSLI_KRIL, BANDURA)
        addToRecipeMap(DOMRA, GUSLI_KRIL, BANDURA)
        addToRecipeMap(KOBZA, STRUNA, BANDURA)
        addToRecipeMap(KORPUS, GRIF, BALALAYKA)
        addToRecipeMap(BALALAYKA, PERO, DOMRA)
        addToRecipeMap(BALALAYKA, KOGA, DOMRA)
        addToRecipeMap(GUSLI_LIROOBR, SMYK, GUDOK)
        addToRecipeMap(BALALAYKA, SMYK, SKRIPKA_NARODNAYA)
        addToRecipeMap(DOMRA, SMYK, SKRIPKA_NARODNAYA)
        addToRecipeMap(TRUBKA, TRUBKA, KUKIGL)
        addToRecipeMap(TROSTNIK, PROBKA, KUKIGL)
        addToRecipeMap(TRUBKA, PROBKA, KUKIGL)
        addToRecipeMap(TROSTNIK, AXE, KUKIGL)
        addToRecipeMap(KUKIGL, CHISEL, KALUKA)
        addToRecipeMap(TRUBKA_S_OTVERSTIAYAMI, CHISEL, SOPEL)
        addToRecipeMap(POSVISTEL, CHISEL, SOPEL)
        addToRecipeMap(SWIREL_DWOY, AXE, SOPEL)
        addToRecipeMap(FUYARA, AXE, SOPEL)
        addToRecipeMap(SOPEL, KALUKA, SWIREL_DWOY)
        addToRecipeMap(TRUBKA, KNIFE, PISHIK)
        addToRecipeMap(YAZICHOK, TROSTNIK, PISHIK)
        addToRecipeMap(YAZICHOK, TRUBKA, PISHIK)
        addToRecipeMap(TRUBKA_S_OTVERSTIAYAMI, KNIFE, BRELKA)
        addToRecipeMap(ROG_SIGNALNIY, PISHIK, BRELKA)
        addToRecipeMap(PISHIK, BERESTA, BRELKA)
        addToRecipeMap(PISHIK, ROG, BRELKA)
        addToRecipeMap(PISHIK, KOST, BRELKA)
        addToRecipeMap(GALEYKA_DVOYNAYA, AXE, BRELKA)
        addToRecipeMap(VOLINKA, AXE, BRELKA)
        addToRecipeMap(BRELKA, YAZICHOK, SURNA)
        addToRecipeMap(BRELKA, BERESTA, SURNA)
        addToRecipeMap(BRELKA, KOGA, VOLINKA)
        addToRecipeMap(GALEYKA_DVOYNAYA, SHKURA, VOLINKA)
        addToRecipeMap(GALEYKA_DVOYNAYA, KOGA, VOLINKA)
        addToRecipeMap(SKRIPKA_NARODNAYA, KOLESO, KOLESNAYA_LIRA)
        addToRecipeMap(GUSLI_KRIL, KOLESO, KOLESNAYA_LIRA)
        addToRecipeMap(GUSLI_LIROOBR, KOLESO, KOLESNAYA_LIRA)
        addToRecipeMap(DOSKA_HOLED, PROBKA, DOSKA)
        addToRecipeMap(DEKA_S_OTVERSTIAYAMI, PROBKA, DEKA)
        addToRecipeMap(KORPUS_HOLED, PROBKA, KORPUS)
        addToRecipeMap(GUSLI_LIROOBR, AXE, KORPUS)
        addToRecipeMap(GUSLI_KRIL, AXE, KORPUS)
        addToRecipeMap(GUSLI_PSALTIR, AXE, KORPUS)
        addToRecipeMap(CIMBALI, AXE, KORPUS)
        addToRecipeMap(KOBZA, AXE, KORPUS)
        addToRecipeMap(BANDURA, AXE, KORPUS)
        addToRecipeMap(GUDOK, AXE, KORPUS)
        addToRecipeMap(SKRIPKA_NARODNAYA, AXE, KORPUS)
        addToRecipeMap(KOLESNAYA_LIRA, AXE, KORPUS)
        addToRecipeMap(BALALAYKA, AXE, KORPUS)
        addToRecipeMap(DOMRA, AXE, KORPUS)
        addToRecipeMap(SMYK, PALKA, LUK)
        addToRecipeMap(POLENO, VOLOS, SILKI)
        addToRecipeMap(POLENO, STRUNA, SILKI)
        addToRecipeMap(SHKURA, SHKURA, MEHA)
        addToRecipeMap(SHKURA, KOGA, MEHA)
        addToRecipeMap(KORITSE_S_OKNOM, FOREST, KORITSE_VODA)
        addToRecipeMap(SHKURA, AXE, KOGA)
        addToRecipeMap(BUBEN, KNIFE, KOGA)
        addToRecipeMap(BARABAN, KNIFE, KOGA)
        addToRecipeMap(GUSACHOK, KNIFE, KOGA)
        addToRecipeMap(VOLINKA, KNIFE, KOGA)
        addToRecipeMap(KORITSE_S_OKNOM, DEKA, KORPUS_WINDOW)
        addToRecipeMap(KORITSE_S_OKNOM, DEKA_S_OTVERSTIAYAMI, KORPUS_WINDOW)
        addToRecipeMap(KORITSE, DEKA_S_OTVERSTIAYAMI, KORPUS_HOLED)
        addToRecipeMap(VOLOS, VOLOS, STRUNA)
        addToRecipeMap(GUSLI_LIROOBR, KNIFE, STRUNA)
        addToRecipeMap(GUSLI_KRIL, KNIFE, STRUNA)
        addToRecipeMap(GUSLI_PSALTIR, KNIFE, STRUNA)
        addToRecipeMap(CIMBALI, KNIFE, STRUNA)
        addToRecipeMap(KOBZA, KNIFE, STRUNA)
        addToRecipeMap(BANDURA, KNIFE, STRUNA)
        addToRecipeMap(GUDOK, KNIFE, STRUNA)
        addToRecipeMap(SKRIPKA_NARODNAYA, KNIFE, STRUNA)
        addToRecipeMap(KOLESNAYA_LIRA, KNIFE, STRUNA)
        addToRecipeMap(BALALAYKA, KNIFE, STRUNA)
        addToRecipeMap(DOMRA, KNIFE, STRUNA)
        addToRecipeMap(PALKA, GILA, GRIF)
        addToRecipeMap(PERO, KNIFE, YAZICHOK)
        addToRecipeMap(SHEPKA, KNIFE, YAZICHOK)
        addToRecipeMap(KALUKA, AXE, TRUBKA)
        addToRecipeMap(PISHIK, AXE, TRUBKA)
        addToRecipeMap(TRUBA_PAST, AXE, TRUBKA)
        addToRecipeMap(DOSKA_HOLED, CHISEL, KOLESO)
        addToRecipeMap(RASPLAV, POKOVKA, YAZUCHEK_METAL)
        addToRecipeMap(SOPEL, AXE, TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(POSVISTEL, AXE, TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(BRELKA, AXE, TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(SURNA, AXE, TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(NEREHT_ROGOK, AXE, TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(DOSKA_HOLED, KNIFE, DEKA_S_OTVERSTIAYAMI)
        addToRecipeMap(KOLESO, AXE, PROBKA)
        addToRecipeMap(KOLESO, CHISEL, PROBKA)
        addToRecipeMap(BRELKA, PISHIK, SWIREL_DWOY)
        addToRecipeMap(PISHIK, PISHIK, SWIREL_DWOY)
        addToRecipeMap(BALALAYKA, STRUNA, KOBZA)
        addToRecipeMap(SOPEL, TROSTNIK, FUYARA)
        addToRecipeMap(KALUKA, TRUBKA_S_OTVERSTIAYAMI, FUYARA)
        addToRecipeMap(KALUKA, TRUBKA, FUYARA)
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