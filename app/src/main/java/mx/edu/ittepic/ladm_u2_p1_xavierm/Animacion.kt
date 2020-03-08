package mx.edu.ittepic.ladm_u2_p1_xavierm

class Animacion(p: MainActivity) : Thread() {
    var puntero = p

    override fun run() {
        super.run()
        sleep(5000)
        while (true) {
            sleep(90)
            puntero.runOnUiThread {
                puntero.lienzo!!.caerNieve()
            }
        }
    }
}