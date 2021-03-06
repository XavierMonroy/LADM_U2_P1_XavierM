package mx.edu.ittepic.ladm_u2_p1_xavierm

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent

class FiguraGeometrica() {
    var x = 0f
    var y = 0f
    var tipo = 1 // 1 = Circulo, 2 = Rectangulo, 3 = Triangulo
    var radio = 0f
    var ancho = 0f
    var alto = 0f
    var incY = 3
    var p1x = 0f // Punto 1 en la coordenada x del triángulo
    var p1y = 0f // Punto 1 para la coordenada y del triángulo
    var p2x = 0f // Punto 2 para la coordenada x del triángulo
    var p2y = 0f // Punto 2 para la coordenada de y del triángulo

    // Constructor para el circulo
    constructor(x: Int, y: Int, radio: Int) : this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.radio = radio.toFloat()
    }

    // Constructor para el rectángulo
    constructor(x: Int, y: Int, ancho: Int, alto: Int) : this() {
        this.x = x.toFloat()
        this.y = y.toFloat()
        this.ancho = ancho.toFloat()
        this.alto = alto.toFloat()
        tipo = 2
    }
    // Constructor para el triángulo
    constructor(coordx: Float, coordy: Float, p1x: Float, p1y: Float, p2x: Float, p2y: Float) : this() {
        this.x = coordx.toFloat()
        this.y = coordy.toFloat()
        this.p1x = p1x
        this.p1y = p1y
        this.p2x = p2x
        this.p2y = p2y
        tipo = 3
    }

    // Función para pintar la figura
    fun pintar(c: Canvas, p: Paint) {
        when (tipo) {
            1 -> {
                c.drawCircle(x, y, radio, p)
            }
            2 -> {
                c.drawRect(x, y, x + ancho, y + alto, p)
            }
            3 -> {
                var path = Path();
                path.moveTo(x, y);
                path.lineTo(p1x, p1y);
                path.lineTo(p2x, p2y);
                c.drawPath(path, p);
            }
        }
    }
    // Funcion para que caigan objetos
    fun caer(ancho: Int, alto: Int) {
        y += incY
        if (y >= alto) {
            y = -40f
        }
    }
}