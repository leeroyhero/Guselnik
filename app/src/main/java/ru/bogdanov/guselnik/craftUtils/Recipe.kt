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
        addToRecipeMap(Ingredient.AXE, Ingredient.FOREST, POLENO) //полено
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
        addToRecipeMap(POLENO, POLENO, Ingredient.DROVA)
        addToRecipeMap(Ingredient.KORPUS, Ingredient.PALKA, Ingredient.KOLOTUSHKA)
        addToRecipeMap(Ingredient.BARABAN, Ingredient.KOLOKOLCHIK, Ingredient.BUBEN)
        addToRecipeMap(Ingredient.KORITSE, Ingredient.KOGA, Ingredient.BARABAN)
        addToRecipeMap(Ingredient.RASPLAV, GLINA, Ingredient.KOLOKOLCHIK)
        addToRecipeMap(Ingredient.POKOVKA, Ingredient.POKOVKA, Ingredient.BRYACALO)
        addToRecipeMap(Ingredient.KORITSE, Ingredient.SHEPKA, Ingredient.BOTALO)
        addToRecipeMap(Ingredient.KOGA, Ingredient.KOLOKOLCHIK, Ingredient.OGERELOK)
        addToRecipeMap(POLENO, Ingredient.PALKA, Ingredient.BILO)
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
        addToRecipeMap(TRUBKA_S_OTVERSTIAYAMI, PROBKA, Ingredient.POSVISTEL)
        addToRecipeMap(Ingredient.TROSTNIK, KNIFE, Ingredient.PISHIK)
        addToRecipeMap(Ingredient.PISHIK, CHISEL, Ingredient.BRELKA)
        addToRecipeMap(Ingredient.YAZICHOK, Ingredient.NEREHT_ROGOK, Ingredient.SURNA)
        addToRecipeMap(Ingredient.BRELKA, Ingredient.SHKURA, Ingredient.VOLINKA)
        addToRecipeMap(Ingredient.ROG, AXE, Ingredient.ROG_SIGNALNIY)
        addToRecipeMap(Ingredient.TRUBKA, Ingredient.BERESTA, Ingredient.TRUBA_PAST)
        addToRecipeMap(Ingredient.TRUBA_PAST, CHISEL, Ingredient.NEREHT_ROGOK)
        addToRecipeMap(Ingredient.GUDOK, Ingredient.KOLESO, Ingredient.KOLESNAYA_LIRA)
        addToRecipeMap(Ingredient.KORPUS, Ingredient.YAZUCHEK_METAL, Ingredient.GARMONIKA)
        addToRecipeMap(Ingredient.GARMONIKA, Ingredient.MEHA, Ingredient.GARMON_HROMKA)
        addToRecipeMap(Ingredient.GARMON_HROMKA, Ingredient.KOLOKOLCHIK, Ingredient.GARMON_SARATOV)
        addToRecipeMap(POLENO, AXE, Ingredient.DOSKA)
        addToRecipeMap(Ingredient.DOSKA, AXE, Ingredient.SHEPKA)
        addToRecipeMap(POLENO, KNIFE, Ingredient.PALKA)
        addToRecipeMap(Ingredient.SHEPKA, AXE, Ingredient.SPOON)
        addToRecipeMap(POLENO, CHISEL, Ingredient.KORITSE)
        addToRecipeMap(Ingredient.DOSKA, KNIFE, Ingredient.DEKA)
        addToRecipeMap(Ingredient.KORITSE, Ingredient.DEKA, Ingredient.KORPUS)
        addToRecipeMap(Ingredient.DOSKA, CHISEL, Ingredient.DOSKA_HOLED)
        addToRecipeMap(Ingredient.DOSKA, Ingredient.PALKA, Ingredient.LOPATA)
        addToRecipeMap(Ingredient.PALKA, KNIFE, Ingredient.KOPIE)
        addToRecipeMap(Ingredient.KOPIE, Ingredient.KOPIE, Ingredient.KAPKAN)
        addToRecipeMap(Ingredient.SMYK, Ingredient.PERO, Ingredient.LUK)
        addToRecipeMap(POLENO, Ingredient.GILA, Ingredient.SILKI)
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
        addToRecipeMap(TRUBKA, CHISEL, TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(DEKA, CHISEL, DEKA_S_OTVERSTIAYAMI)
        addToRecipeMap(KORITSE, AXE, KORITSE_S_OKNOM)
        addToRecipeMap(KOLESO, AXE, PROBKA)
        addToRecipeMap(BRELKA, BRELKA, GALEYKA_DVOYNAYA)
        addToRecipeMap(DOMRA,STRUNA, KOBZA)
        addToRecipeMap(TRUBKA, SOPEL, FUYARA)
        addToRecipeMap(SHEPKA, VOLOS, VETROVIK)
        addToRecipeMap(SHEPKA, STRUNA, VETROVIK)
        addToRecipeMap(DEKA, PALKA,BARABANKA)
        addToRecipeMap(DEKA_S_OTVERSTIAYAMI,PALKA,BARABANKA)
        addToRecipeMap(BARABAN,PALKA,GUSACHOK)
        addToRecipeMap(BUBEN,SMYK,GUSACHOK)
        addToRecipeMap(BUBEN, PALKA,GUSACHOK)
        addToRecipeMap(KOST,VOLOS,BRUNCHALKA)
        addToRecipeMap(KOST,STRUNA,BRUNCHALKA)
        addToRecipeMap(KORPUS_HOLED,PALKA,KOLOTUSHKA)
        addToRecipeMap(KORPUS_WINDOW,PALKA,KOLOTUSHKA)
        addToRecipeMap(BARABAN,OGERELOK, BUBEN)
        addToRecipeMap(OGERELOK,KOGA, BUBEN)
        addToRecipeMap(OGERELOK,SHKURA, BUBEN)
        addToRecipeMap(KORITSE,SHKURA,BARABAN)
        addToRecipeMap(RASPLAV,ZEMLYA, KOLOKOLCHIK)
        addToRecipeMap(KNIFE, GARMON_SARATOV, KOLOKOLCHIK)
        addToRecipeMap(KNIFE, BUBEN, KOLOKOLCHIK)
        addToRecipeMap(KNIFE, OGERELOK, KOLOKOLCHIK)
        addToRecipeMap(KORITSE, PALKA,BOTALO)
        addToRecipeMap(KORITSE,POKOVKA,BOTALO)
        addToRecipeMap(KORITSE,GILA,BOTALO)
        addToRecipeMap(KORITSE,VOLOS,BOTALO)
        addToRecipeMap(KORITSE,STRUNA,BOTALO)
        addToRecipeMap(SHKURA,KOLOKOLCHIK,OGERELOK)
        addToRecipeMap(KORPUS_WINDOW,GILA,GUSLI_LIROOBR)
        addToRecipeMap(KORPUS_HOLED,STRUNA,GUSLI_KRIL)
        addToRecipeMap(GUSLI_KRIL,PALKA,CIMBALI)
        addToRecipeMap(BALALAYKA,GUSLI_PSALTIR,BANDURA)
        addToRecipeMap(DOMRA,GUSLI_PSALTIR,BANDURA)
        addToRecipeMap(BALALAYKA, GUSLI_KRIL,BANDURA)
        addToRecipeMap(DOMRA, GUSLI_KRIL,BANDURA)
        addToRecipeMap(KOBZA,STRUNA,BANDURA)
        addToRecipeMap(KORPUS,GRIF,BALALAYKA)
        addToRecipeMap(BALALAYKA,PERO,DOMRA)
        addToRecipeMap(BALALAYKA,KOGA,DOMRA)
        addToRecipeMap(GUSLI_LIROOBR,SMYK,GUDOK)
        addToRecipeMap(BALALAYKA,SMYK,SKRIPKA_NARODNAYA)
        addToRecipeMap(DOMRA,SMYK,SKRIPKA_NARODNAYA)
        addToRecipeMap(TRUBKA,TRUBKA,KUKIGL)
        addToRecipeMap(TROSTNIK,PROBKA,KUKIGL)
        addToRecipeMap(TRUBKA,PROBKA,KUKIGL)
        addToRecipeMap(TROSTNIK,AXE,KUKIGL)
        addToRecipeMap(KUKIGL,CHISEL,KALUKA)
        addToRecipeMap(TRUBKA_S_OTVERSTIAYAMI,CHISEL,SOPEL)
        addToRecipeMap(POSVISTEL,CHISEL,SOPEL)
        addToRecipeMap(SWIREL_DWOY,AXE,SOPEL)
        addToRecipeMap(FUYARA,AXE,SOPEL)
        addToRecipeMap(SOPEL,KALUKA,SWIREL_DWOY)
        addToRecipeMap(TRUBKA,KNIFE,PISHIK)
        addToRecipeMap(YAZICHOK,TROSTNIK,PISHIK)
        addToRecipeMap(YAZICHOK,TRUBKA,PISHIK)
        addToRecipeMap(TRUBKA_S_OTVERSTIAYAMI,KNIFE,BRELKA)
        addToRecipeMap(ROG_SIGNALNIY, PISHIK,BRELKA)
        addToRecipeMap(PISHIK,BERESTA,BRELKA)
        addToRecipeMap(PISHIK,ROG,BRELKA)
        addToRecipeMap(PISHIK,KOST,BRELKA)
        addToRecipeMap(GALEYKA_DVOYNAYA,AXE,BRELKA)
        addToRecipeMap(VOLINKA,AXE,BRELKA)
        addToRecipeMap(BRELKA,YAZICHOK,SURNA)
        addToRecipeMap(BRELKA,BERESTA,SURNA)
        addToRecipeMap(BRELKA,KOGA,VOLINKA)
        addToRecipeMap(GALEYKA_DVOYNAYA,SHKURA,VOLINKA)
        addToRecipeMap(GALEYKA_DVOYNAYA,KOGA,VOLINKA)
        addToRecipeMap(SKRIPKA_NARODNAYA,KOLESO,KOLESNAYA_LIRA)
        addToRecipeMap(GUSLI_KRIL,KOLESO,KOLESNAYA_LIRA)
        addToRecipeMap(GUSLI_LIROOBR,KOLESO,KOLESNAYA_LIRA)
        addToRecipeMap(DOSKA_HOLED,PROBKA,DOSKA)
        addToRecipeMap(DEKA_S_OTVERSTIAYAMI,PROBKA,DEKA)
        addToRecipeMap(KORPUS_HOLED,PROBKA,KORPUS)
        addToRecipeMap(GUSLI_LIROOBR,AXE,KORPUS)
        addToRecipeMap(GUSLI_KRIL,AXE,KORPUS)
        addToRecipeMap(GUSLI_PSALTIR,AXE,KORPUS)
        addToRecipeMap(CIMBALI,AXE,KORPUS)
        addToRecipeMap(KOBZA,AXE,KORPUS)
        addToRecipeMap(BANDURA,AXE,KORPUS)
        addToRecipeMap(GUDOK,AXE,KORPUS)
        addToRecipeMap(SKRIPKA_NARODNAYA,AXE,KORPUS)
        addToRecipeMap(KOLESNAYA_LIRA,AXE,KORPUS)
        addToRecipeMap(BALALAYKA,AXE,KORPUS)
        addToRecipeMap(DOMRA,AXE,KORPUS)
        addToRecipeMap(SMYK,PALKA,LUK)
        addToRecipeMap(POLENO,VOLOS,SILKI)
        addToRecipeMap(POLENO,STRUNA,SILKI)
        addToRecipeMap(SHKURA,SHKURA,MEHA)
        addToRecipeMap(SHKURA,KOGA,MEHA)
        addToRecipeMap(KORITSE_S_OKNOM,FOREST,KORITSE_VODA)
        addToRecipeMap(SHKURA,AXE,KOGA)
        addToRecipeMap(BUBEN,KNIFE,KOGA)
        addToRecipeMap(BARABAN,KNIFE,KOGA)
        addToRecipeMap(GUSACHOK,KNIFE,KOGA)
        addToRecipeMap(VOLINKA,KNIFE,KOGA)
        addToRecipeMap(KORITSE_S_OKNOM,DEKA,KORPUS_WINDOW)
        addToRecipeMap(KORITSE_S_OKNOM,DEKA_S_OTVERSTIAYAMI,KORPUS_WINDOW)
        addToRecipeMap(KORITSE,DEKA_S_OTVERSTIAYAMI,KORPUS_HOLED)
        addToRecipeMap(VOLOS,VOLOS,STRUNA)
        addToRecipeMap(GUSLI_LIROOBR,KNIFE,STRUNA)
        addToRecipeMap(GUSLI_KRIL,KNIFE,STRUNA)
        addToRecipeMap(GUSLI_PSALTIR,KNIFE,STRUNA)
        addToRecipeMap(CIMBALI,KNIFE,STRUNA)
        addToRecipeMap(KOBZA,KNIFE,STRUNA)
        addToRecipeMap(BANDURA,KNIFE,STRUNA)
        addToRecipeMap(GUDOK,KNIFE,STRUNA)
        addToRecipeMap(SKRIPKA_NARODNAYA,KNIFE,STRUNA)
        addToRecipeMap(KOLESNAYA_LIRA,KNIFE,STRUNA)
        addToRecipeMap(BALALAYKA,KNIFE,STRUNA)
        addToRecipeMap(DOMRA,KNIFE,STRUNA)
        addToRecipeMap(PALKA,GILA,GRIF)
        addToRecipeMap(PERO,KNIFE,YAZICHOK)
        addToRecipeMap(SHEPKA,KNIFE,YAZICHOK)
        addToRecipeMap(KALUKA,AXE,TRUBKA)
        addToRecipeMap(PISHIK,AXE,TRUBKA)
        addToRecipeMap(TRUBA_PAST,AXE,TRUBKA)
        addToRecipeMap(DOSKA_HOLED,CHISEL,KOLESO)
        addToRecipeMap(RASPLAV,POKOVKA,YAZUCHEK_METAL)
        addToRecipeMap(SOPEL,AXE,TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(POSVISTEL,AXE,TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(BRELKA,AXE,TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(SURNA,AXE,TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(NEREHT_ROGOK,AXE,TRUBKA_S_OTVERSTIAYAMI)
        addToRecipeMap(DOSKA_HOLED,KNIFE,DEKA_S_OTVERSTIAYAMI)
        addToRecipeMap(KOLESO,AXE,PROBKA)
        addToRecipeMap(KOLESO,CHISEL,PROBKA)
        addToRecipeMap(BRELKA,PISHIK,SWIREL_DWOY)
        addToRecipeMap(PISHIK,PISHIK,SWIREL_DWOY)
        addToRecipeMap(BALALAYKA,STRUNA,KOBZA)
        addToRecipeMap(SOPEL,TROSTNIK,FUYARA)
        addToRecipeMap(KALUKA,TRUBKA_S_OTVERSTIAYAMI,FUYARA)
        addToRecipeMap(KALUKA,TRUBKA,FUYARA)
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