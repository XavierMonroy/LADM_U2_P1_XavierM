package mx.edu.ittepic.ladm_u2_p1_xavierm

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo(p: MainActivity) : View(p) {
    var puntero = p

    //sol
    var sol = FiguraGeometrica(150, 150, 100)

    // Dibujar nube
    var nube1 = FiguraGeometrica(50, 150, 50)
    var nube2 = FiguraGeometrica(100, 152, 50)
    var nube3 = FiguraGeometrica(150, 150, 50)
    var nube4 = FiguraGeometrica(150, 198, 50)
    var nube5 = FiguraGeometrica(200, 198, 50)
    var nube6 = FiguraGeometrica(250, 198, 50)

    // Dibujar casa
    var casa = FiguraGeometrica(370, 900, 500, 400)
    var ventana = FiguraGeometrica(450, 1070, 50)
    var puerta = FiguraGeometrica(600, 1160, 100, 140)

    // Dibujar el techo
    var techo = FiguraGeometrica(630f, 650f, 310f, 900f, 930f, 900f)
    var punteroFiguraGeometrica: FiguraGeometrica? = null

    // Dibujar árbol
    var tronco = FiguraGeometrica(80, 1110, 130, 180)
    var hojas = FiguraGeometrica(140, 1050, 100)
    var hojas2 = FiguraGeometrica(140, 920, 100)

    // Dibujar nieve
    var nieve: Array<FiguraGeometrica> =
        Array(300) { FiguraGeometrica((0..1050).random(), (-1900..0).random(), 17) }

    // Dibujar pasto
    var pasto = FiguraGeometrica(0,1000,1200,2000)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        // Fondo
        canvas.drawColor(Color.CYAN)

        // Pasto
        paint.color = Color.rgb(39, 208, 77)
        pasto.pintar(canvas,paint)

        // Sol
        paint.color = Color.YELLOW
        sol.pintar(canvas, paint)

        // Nube
        paint.color = Color.rgb( 173, 183, 184)
        nube1.pintar(canvas, paint)
        nube2.pintar(canvas, paint)
        nube3.pintar(canvas, paint)
        paint.color = Color.rgb(214, 222, 216)
        nube4.pintar(canvas, paint)
        nube5.pintar(canvas, paint)
        nube6.pintar(canvas, paint)

        // Casa
        paint.color = Color.rgb( 20, 141, 149)
        casa.pintar(canvas, paint)

        // Ventana
        paint.color = Color.rgb( 213, 216, 220)
        ventana.pintar(canvas, paint)

        // Techo
        paint.color = Color.rgb( 227, 107, 62)
        techo.pintar(canvas, paint)

        // Puerta
        paint.style = Paint.Style.FILL
        paint.color = Color.rgb(128, 64, 0)
        puerta.pintar(canvas, paint)

        // Arbol
        paint.color = Color.rgb(128, 64, 0)
        tronco.pintar(canvas, paint)
        paint.color = Color.rgb(0, 64, 0)
        hojas.pintar(canvas, paint)
        hojas2.pintar(canvas, paint)

        // Copos de nieve
        paint.color = Color.WHITE

        (nieve.indices).forEach() {
            nieve[it].pintar(canvas, paint)
        }
    }

    // Caer nieve
    fun caerNieve() {
        (nieve.indices).forEach() {
            nieve[it].caer(width, height)
        }
        invalidate()
    }
}