(ns practicaI

  (:require [clojure.set :as set]))

;; 0. Declare una variable con su nombre y apellido. Escriba en un comentario qué 
;;    tipo de dato ha empleado.
(def mi_nombre "Lucas")
(def mi_apellido "González")
;; Se utilizó el tipo "string" porque son secuencias de carácteres

;; 1. Cree un vector de números positivos impares hasta el número 21

(vec (filter odd? (range 1 22)))

;; 2. Registre los jugadores de dos equipos de basket y dos de fútbol 5. 
;;    Al menos 3 jugadores juegan fútbol y basket. Utilice conjuntos
(use 'clojure.set)
(def equipo-basket1 #{"pepe" "lucas" "luciano" "ana" "marcos"})
(def equipo-basket2 #{"pablo" "marta" "ana" "martin" "rober"})
(def equipo-futbol1 #{"pepe" "lucas" "luciano" "sofi" "adrian"})
(def equipo-futbol2 #{"ezequiel" "lucas" "ana" "enrique" "carlos"})


;; 2.1 Desde la Dirección de Deportes nos piden una lista (lo que no implica 
;;     devolver esta estructura de datos) de todos los jugadores de ambos
;;     deportes. PISTA: utilizar la función (set/union) -ya el namespace está
;;     requerido arriba con el alias 'set'.

(def todos-los-jugadores (set/union equipo-basket1 equipo-basket2 equipo-futbol1 equipo-futbol2))

(println "Todos los jugadores de basket y fútbol:")
(println todos-los-jugadores)


;; 2.2 Identifique los jugadores que participan en ambas disciplinas. PISTA: 
;;     Existe una función de conjuntos en el namespace 'clojure.set' para resolver este problema.

(def jugadores-ambos-basket (clojure.set/intersection equipo-basket1 equipo-basket2))
(def jugadores-ambos-futbol (clojure.set/intersection equipo-futbol1 equipo-futbol2))


;; 2.3 Identifique los jugadores que juegan fútbol, pero no basket. PISTA:
;;     Existe una función de conjuntos en el namespace 'clojure.set' para resolver este problema.

(def jugadores-futbol1 (clojure.set/difference equipo-futbol1 jugadores-ambos-futbol))
(def jugadores-futbol2 (clojure.set/difference equipo-futbol2 jugadores-ambos-futbol))

;; 3. Cree un mapa con los 5 principales indicadores provistos en la página del INDEC
;;    (https://www.indec.gob.ar/), a saber, población, desocupación, etc. 

(def datos-economicos {:poblacion 46044703
                       :tasa-de-desocupacion 6.3
                       :precios-al-consumidor 7.7
                       :indice-de-produccion-industrial-manufacturero -1.3
                       :actividad-economica 0.3})

(println datos-economicos)


;; 3.1 Utilice la función (juxt) para obtener los valores correspondientes a las llaves 
;;     que haya elegido para los indicadores 'Tasa de desocupación' e 'Índice de producción industrial 
;;     manufacturero'. 
;;     NOTA: Al ubicar el cursor sobre la función, podrá ver una ventana con la documentación y ejemplos.

(def obtener-indicadores (juxt (partial get :tasa-de-desocupacion)
                               (partial get :indice-de-produccion-industrial-manufacturero)))

(println (obtener-indicadores datos-economicos))

;; 3.2 Utilice la función (select-keys) para obtener un mapa con el par llave-valor 
;;     con las llaves que haya elegido para los indicadores 'Población' y 'Precios al consumidor'.

(def indicadores (select-keys datos-economicos [:poblacion :precios-al-consumidor]))
(println indicadores)

;; 4. Cree una función que, recibiendo un nombre como argumento, devuelva un saludo. Ejemplo:
;;    (saludar "Juan") => "¡Hola, Juan!"

(defn saludar [nombre]
  (str "¡Hola, " nombre "!"))

(comment 
;; Utilice este espacio para experimentar con el código. Luego, cuando esté seguro que el 
;; código trabaja correctamente, cópielo a su lugar correspondiente arriba.   
 
  (def mi_nombre "Lucas")
  (def mi_apellido "González")

  )
(
 (def equipo-basket1 #{"pepe" "lucas" "luciano" "ana" "marcos"})
 (def equipo-basket2 #{"pablo" "marta" "ana" "martin" "rober"})
 (def equipo-futbol1 #{"pepe" "lucas" "luciano" "sofi" "adrian"})
 (def equipo-futbol2 #{"ezequiel" "lucas" "ana" "enrique" "carlos"})

 (def todos-los-jugadores (set/union equipo-basket1 equipo-basket2 equipo-futbol1 equipo-futbol2))

(println "Todos los jugadores de basket y fútbol:")
(println todos-los-jugadores)

 (def jugadores-ambos-basket (clojure.set/intersection equipo-basket1 equipo-basket2))
(def jugadores-ambos-futbol (clojure.set/intersection equipo-futbol1 equipo-futbol2))
 )