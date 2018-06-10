package com.proyectoprogramacion4.parcial1progra

/**
 * Created by Fredy on 02/03/2018.
 */

class RegistroCalles {

    var IdCalles: Int = 0
    var NombreCalle: String = ""
    var CantidadCarros: Int = 0
    var NumeroPeatones: Int = 0
    var NumeroDeAccidentes: Int = 0
    var CantidadMotos: Int = 0

    constructor( NombreCalle: String, CantidadCarros: Int, NumeroPeatones: Int, NumeroDeAccidentes: Int, CantidadMotos: Int) {

        this.NombreCalle = NombreCalle
        this.CantidadCarros = CantidadCarros
        this.NumeroPeatones = NumeroPeatones
        this.NumeroDeAccidentes = NumeroDeAccidentes
        this.CantidadMotos = CantidadMotos
    }
    constructor()


}