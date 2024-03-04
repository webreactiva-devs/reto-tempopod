# Reto TempoPod: Ganando a la IA

Esta es la primera parte de un reto que espero que nos dé muchos “comederos de tarro” ;)

🎧 Lo conté con detalle en [WRP 286. Después de la calma viene la tempestad (nuevo reto)](https://premium.danielprimo.io/podcast/premium/despues-de-la-calma).

El propósito es crear un “Stack de decisiones” alrededor de una funcionalidad. 

Cada uno de vosotros tomará las que quiera y del tamaño que quiera, lo extra y más enriquecedor será compartirlo. Empezamos por algo muy pequeño para ir escalando durante los próximos meses.

> ☝️ Cualquier mejora será fruto de una decisión correcta.



🔥 Además, por primera vez en uno de nuestros retos, incluiremos las Pull Requests!

### Índice

  * [🎧 Requisito funcional](#-requisito-funcional)
    + [👀 Ojo, que ya está resuelto](#-ojo-que-ya-está-resuelto)
  * [📋 Requisitos del reto](#-requisitos-del-reto)
  * [👩‍💻 ¿Cómo participas en el reto?](#-c%C3%B3mo-participas-en-el-reto)
  * [↗️ 1 Pull Request para cada proyecto](#%EF%B8%8F-1-pull-request-para-cada-proyecto)
  * [🗓️ Fecha límite](#-fecha-límite)
  * [🚀 Siguientes pasos](#-siguientes-pasos)
  * [🛠️ ¿Qué puedes aprender en este reto?](#-qu--puedes-aprender-en-este-reto-)
  * [🤗 Mecenazgo](#-mecenazgo)


![DALL·E 2024-02-29 10 59 36 - Una escena de pixel art que muestre un podcast en grabación, con micrófonos, auriculares y una mesa  En la esquina superior derecha, un reloj grande m](https://github.com/webreactiva-devs/reto-tempopod/assets/1122071/74ada8c1-9793-4832-bc80-84815b5d5f55)

‎

## 🎧 Requisito funcional

> Crear una aplicación que tome los datos de un feed de un podcast (o de una lista de vídeos) y le ofrezca al usuario una lista de títulos basados en el tiempo que tiene disponible.

Criterios de aceptación:
- El tiempo se llama “selectedTempo” y se acepta como parámetro en minutos
- El feed es una URL accesible en formato XML y es un parámetro opcional
- Los items ofrecidos deben seleccionarse de forma aleatoria
- Los items ofrecidos al usuario tienen que sumar una duración menor a la del selectedTempo
- Basta con mostrar los títulos (`title`) de los items seleccionados

Los feeds en formato XML (RSS) tienen una gran cantidad de información: títulos, descripciones, enlace, duración…

Puedes usar el de la carpeta `feed` de este repositorio. Esta es la URL del feed a la que puedes llamar directamente: 
```html
https://raw.githubusercontent.com/webreactiva-devs/reto-tempopod/main/feed/webreactiva.xml
```

‎

### 👀 Ojo, que ya está resuelto

El código es tan sencillo que ya lo tienes resuelto en la carpeta [examples](https://github.com/webreactiva-devs/reto-tempopod/tree/main/examples) en varios lenguajes:
- JavaScript
- PHP
- Python
- Java (testeado ok)

He usado ChatGPT para generarlo, [mira la conversación completa](https://chat.openai.com/share/e4c4964b-473c-464c-a527-98fb55ead0e0).

Entonces, Dani, ¿de qué va el reto?

‎

## 📋 Requisitos del reto

> La IA nos puede ayudar, pero no es tan eficiente como para quitarnos del medio a lo terminator.

El código que “resuelve” el reto está “bien”, pero no es genial. Admite mejoras, muchas. 

Te invito a ponerte el traje de faena y darle al coco.

📝 Tienes que presentar 5 mejoras al código (como mínimo).

Te planteo algunas preguntas para encontrar esas mejoras, pero cualquier otra es bienvenida:

1. ¿Qué pasaría si el feed no está disponible?
2. ¿Y si el feed no tiene items?
3. ¿Cómo resolverías si el tiempo elegido por el usuario es menor que el más corto de los episodios?
4. ¿Qué pasaría si el campo “duration” no estuviera presente? ¿O si no está en la etiqueta “itunes:duration”?
5. ¿Crees que sería interesante integrar una librería externa para alguna parte del código?
6. ¿Cómo integrarías una salida de formato extra seleccionable por el usuario? Por ejemplo, en formato JSON.
7. ¿Qué se te ocurre para no generar peticiones infinitas a un feed que cambia solo una vez a la semana?
8. 🔥 ¿Te animarías a incorporar tests?
9. 🔥 ¿Sabrías [separar por carpetas](https://premium.danielprimo.io/podcast/premium/arquitectura-de-software-estructura-de-carpetas) y capas de responsabilidad el código? Dominio, Use Cases, Controllers, Infraestructure…
10. ¿Te gustaría fliparte introduciendo Arquitectura Hexagonal o DDD?

🤖 Puedes usar la IA para ayudarte, no está prohibido.

👉 **Utiliza el lenguaje de programación que más te guste**. Usa el de los ejemplos de la carpeta `examples` o créalo por tu cuenta, pero siempre con la premisa de partir de algo muy simple para mejorarlo.

❌ Las mejoras que NO estamos buscando por ahora:
- Cambiar la forma de seleccionar el feed (nada de llamadas a una API o cosas así de momento)
- Persistencia en base de datos (lo haremos en la siguiente fase del reto)
- Interfaz gráfica (también, más adelante)
- En general no buscamos ampliar la funcionalidad más allá de lo racional, solo afinar al máximo lo que ya tenemos

‎

## 👩‍💻 ¿Cómo participas en el reto?

✉️ En cuanto empieces a tener la solución, [añades una issue](https://github.com/webreactiva-devs/reto-tempopod/issues/new/choose) en este mismo repositorio y nos cuentas lo que has hecho y cuáles han sido tus principales aprendizajes y dificultades, ¡a la comunidad le encantará saberlo!

👉 Hay que compartir el código.  
👉 Puedes hacer un fork de este repositorio y trabajar sobre él (no es obligatorio)

🧡 Comparte tus avances y preguntas en el topic “Retos” de nuestro grupo privado de Telegram.

‎

## ↗️ 1 Pull Request para cada proyecto

Todos los que participéis en el reto tendréis asegurado al menos un Pull Request por mi parte (Dani) solicitando algún cambio o mejora en vuestro código.

> ¿Qué es un Pull Request? Te lo cuento en [vídeo](https://www.youtube.com/watch?v=h9J-2wK8FVQ) y en [podcast](https://www.webreactiva.com/podcast/haz-la-primera-pull-request-de-tu-vida)

📝 Es una buena oportunidad para entender cómo funciona el flujo de los PR, no solo desde el punto de vista técnico, también de feedback y comunicación

🙌  Y si alguien más se anima, pues estupendo ;)

## 🗓️ Fecha límite

Nos juntaremos en directo el 21 de Marzo de 2024 (Jueves, a las 19:00) para poner nuestra experiencia en común. 

Esa es la fecha límite. Y sí, algún regalito habrá ;)

‎


## 🚀 Siguientes pasos

Si el reto os gusta seguiremos ampliándolo. La idea inicial es añadir persistencia (y funcionalidades de Backend), un Frontend, herramientas de despliegue, testing, monitorización…

TempoPod se convertirá en nuestro “campo base” o “campo de minas” ;)


‎


## 🛠️ ¿Qué puedes aprender en este reto?


1. **Resolución de Problemas y Creatividad**: El desafío impulsa a pensar de manera creativa para resolver problemas complejos y mejorar el código existente.
2. **Colaboración y Aprendizaje Compartido**: Fomenta la colaboración y el intercambio de conocimientos a través de la comunidad, especialmente en el grupo privado de Telegram y mediante el uso de issues y pull requests (PR).
3. **Gestión de Proyectos de Software y Flujo de Trabajo con Git**: La inclusión de Pull Requests introduce a los participantes en prácticas reales de desarrollo colaborativo y les enseña a gestionar cambios y contribuciones en proyectos de software usando Git.
4. **Manejo de Datos y Excepciones en Aplicaciones Web**: Profundiza en el manejo eficiente de datos de fuentes externas (como feeds XML) y enseña a gestionar posibles excepciones, como feeds no disponibles o sin ítems.
5. **Optimización y Eficiencia en el Código**: Motiva a buscar maneras de optimizar el código, por ejemplo, minimizando las peticiones a un feed que raramente cambia, lo que introduce conceptos de caching y eficiencia de red.
6. **Pruebas de Software y Calidad del Código**: La posibilidad de incorporar tests subraya la importancia de la calidad del código y la fiabilidad de las aplicaciones, promoviendo buenas prácticas en el testing de software.
7. **Arquitectura de Software y Organización del Código**: Incentiva a pensar en estructuras de código avanzadas, como la Arquitectura Hexagonal o DDD (Domain-Driven Design), para mejorar la escalabilidad y mantenibilidad del proyecto.
8. **Integración de Librerías y Herramientas Externas**: Abre la posibilidad de integrar librerías externas para extender funcionalidades o mejorar partes del código, lo que enseña sobre la evaluación y selección de herramientas adicionales.
9. **Desarrollo de Interfaces y Formatos de Salida Flexibles**: Al contemplar la integración de diferentes formatos de salida, como JSON, se promueve la adaptabilidad y la capacidad de diseñar interfaces de usuario o APIs más flexibles.
10. **Comunicación Efectiva y Feedback Constructivo**: A través del proceso de revisión de Pull Requests y el intercambio de feedback, se aprende sobre la importancia de comunicar eficazmente ideas y sugerencias constructivas.

‎

## 🤗 Mecenazgo
Este reto se realiza por y para la [Comunidad Malandriner](https://webreactiva.com/comunidad)
