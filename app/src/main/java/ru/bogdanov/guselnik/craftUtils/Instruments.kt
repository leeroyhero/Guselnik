package ru.bogdanov.guselnik.craftUtils

import ru.bogdanov.guselnik.item.Instrument

class Instruments {
    private val opened= mutableListOf<Instrument>()
    private val count=Instrument::class.nestedClasses.size

    fun getInstruments(callback:(openedInstruments:Array<Instrument>, closedInstruments:Array<Instrument>)->Unit){

    }

    fun getCount(callback:(opened:Int, max:Int)->Unit){
        callback(opened.size, count)
    }

    fun newInstrumentOpened(instrument: Instrument):Boolean{
        opened.forEach {
            if (it.tag.equals(instrument.tag)) return false
        }

        opened.add(instrument)

        return true
    }
}