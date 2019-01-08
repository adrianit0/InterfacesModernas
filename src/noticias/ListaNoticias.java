/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Adrián
 */
public class ListaNoticias {
    // HACER: TOMAR NOTICIAS DE UNA BBDD
    public static List<Noticia> getNoticias() {
        return Arrays.asList( 
                new Noticia(
                        "La baja natalidad en España obliga este año a celebrar el sorteo de la Lotería con un solo niño de San Ildefonso",
                        "Hace unas semanas, se supo que España había registrado la cifra más baja de nacimientos desde 1941. Nada ilustra más crudamente esta realidad que los premios de la Lotería de Navidad de este año, cantados por primera vez en la historia por El Niño de San Ildefonso.\n" +
                        "\n" +
                        "Adolfo Martín, natural de Torrelodones, es ya el único alumno del colegio madrileño de San Ildefonso y, por lo tanto, sobre él recae la tarea de cantar los premios este año y transmitir la ilusión que antes transmitían más de treinta alumnos. “Tendrá que cambiar un poco la voz cuando cante el número y cuando cante el premio, pero lo hará bien, llevamos todo el año ensayando”, comentan desde la dirección del centro escolar.",
                        "./imagenes/noticia1.jpg"),
                
                new Noticia(
                        "Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos",
                        "Nuestros expertos de Idealista te traen una serie de trucos de decoración para que no parezca que vives en casa de tus padres teniendo más de treinta años.\n" +
                        "\n" +
                        "Sustituye las fotos de la familia por cajas vacías de pizza. Si llevas a un ligue a casa y en lugar de cajas de pizza tiradas por el salón ve fotos familiares perfectamente alineadas, enseguida se dará cuenta de que vives con tus padres y se marchará corriendo.\n" +
                        "\n" +
                        "Coloca polvo en los muebles y tira ropa por toda la casa. Tus amigos no se creerán que vives solo si, cuando vayan a jugar a la consola a tu casa, ven que lo tienes todo limpio y ordenado. Ve al piso en el que vivías, recoge todo el polvo acumulado y mételo en casa de tus padres. Nadie se dará cuenta de que vives con ellos.\n" +
                        "\n" +
                        "Trata de mear por fuera de la taza para que queden gotas en el suelo del baño. Nada echa más para atrás que un baño limpio, ese es el principal indicador de que te has divorciado, has perdido tu trabajo y te has mudado con tus padres. Intenta dejar caer algunas gotas en el suelo cada vez que hagas pis, tus visitas te verán como una persona independiente que definitivamente no vive con sus padres.\n" +
                        "\n" +
                        "Tira toda la comida de la nevera y deja solo yogures caducados y un limón. Si, durante una reunión en tu casa, alguien va a la nevera y la ve llena, lo más normal es que quedes como un perdedor. Vacíala y deja solo yogures caducados y un limón, nada dará más sensación de éxito que eso. “Es que no tengo tiempo de llenarla, todo el día fuera currando”, podrás argumentar.",
                        "./imagenes/noticia2.jpg"),
                
                new Noticia(
                        "Felipe VI no dará el Mensaje de Navidad de este año porque no quiere “encasillarse”",
                        "Tras cuatro años en el trono, Su Majestad el Rey Felipe VI ha decidido que este año no dará el discurso de Navidad porque empieza a sentirse “muy encasillado”. En una entrevista ofrecida a este medio, Felipe VI confesaba que “el primer año te hace ilusión por la novedad, pero ahora ya no tanto”.\n" +
                        "\n" +
                        "Más de ocho millones de espectadores asistieron al Mensaje de Navidad del último año, alcanzando el 65,6% de cuota de pantalla y otorgándole así la máxima audiencia desde 2014; unos datos que Felipe VI agradece “enormemente”, aunque también comenta que eso “no te da la felicidad”. Su Majestad afirma que al final solo le conocen como el que da el mensaje de Navidad y que, a la larga, “te limita mucho”. Su padre, el Rey Juan Carlos I, ha estado casi cuarenta años al frente de este espacio, pero su sucesor ya ha tenido suficiente y está pensando en tomarse un año sabático para estudiar diseño o interpretación en el extranjero. ",
                        "./imagenes/noticia3.jpg"),
                
                new Noticia(
                        "Torra dice que no dialogará con Sánchez hasta que no se hayan bebido juntos tres botellas de ratafia",
                        "Diciendo que los catalanes lo considerarían “una falta de respeto”, Quim Torra ha exigido hoy que Pedro Sánchez y él bebieran juntos tres botellas de ratafia antes de iniciar su reunión, que ha empezado hace unos minutos en el Palau de Pedralbes entre fuertes medidas de seguridad y gran expectación. “Aquí se hace así, primero se bebe ratafía y luego ya se verá”, ha explicado Torra entre risas.\n" +
                        "\n" +
                        "“¡Vamos, vamos! Je, je, je”, ha dicho el president llenando el vaso de Sánchez al inicio de un encuentro que busca afianzar la distensión entre el Gobierno español y el Govern de la Generalitat.\n" +
                        "\n" +
                        "“Primero se bebe y se dice força al canut y luego se eructa y se rompe uno el vaso en la frente”, ha explicado Torra amablemente. “Vamos, vamos, que quedan aún dos botellas… ¡No te duermas!”, ha insistido.",
                        "./imagenes/noticia4.jpg"),
                
                new Noticia(
                        "“Llevé a mi perro al veterinario y lo atendió un Golden Retriever”",
                        "«Muy limpia»\n" +
                        "\n" +
                        "★★\n" +
                        "\n" +
                        "(Traducción automática) Durante el paseo de la mañana me llevaron por esta esquina y no pude resistirme a mear en ella por su limpieza y buena accesibilidad. Solté un chorrito al lado de un árbol, que ahora me pertenece, y después también meé en un edificio, que ahora es mío. La esquina está en una zona muy buena, así que he empezado a alquilar los pisos a mil euros mensuales cada uno.\n" +
                        "\n" +
                        "SULTÁN",
                        "./imagenes/noticia5.jpg")
                
        );
    }
}
