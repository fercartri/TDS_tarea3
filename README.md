# Test en Aislamiento para Domótica - Tarea 3

> **Asignatura:** Tecnologías para el Desarrollo de Software  
> **Grado:** Ingeniería Informática (Mención en Ingeniería del Software)  
> **Universidad:** Universidad de Valladolid  

Este proyecto tiene como objetivo realizar pruebas en aislamiento de la clase **Domotica**, utilizando la técnica **EasyMock** para simular el comportamiento de la interfaz **DomoticaService**. Además, se aplican técnicas como la Caja Negra, la Partición en Clases de Equivalencia, el Análisis de Valores Límite y pruebas de estado, garantizando una cobertura del 100%.

---

## Funcionalidades principales

El sistema incluye:

- Pruebas de las funcionalidades de la clase **Domotica** mediante el uso de EasyMock.
- Simulación de la interfaz **DomoticaService** sin modificar su implementación.
- Aplicación de técnicas de prueba para validar los casos posibles:
  - Partición en Clases de Equivalencia.
  - Análisis de Valores Límite.
  - Pruebas de estado.
- Asegurar una cobertura total del código probado.

El desarrollo sigue un enfoque sistemático con un énfasis en pruebas unitarias y buenas prácticas de diseño.

---

## Requisitos técnicos

El proyecto está diseñado como un proyecto **Maven** compatible con **JDK 17**. La estructura del código cumple con las especificaciones del arquetipo `maven-archetype-quickstart`.

---

## Metodología

El desarrollo de las pruebas se realiza en aislamiento con EasyMock. Las clases y sus pruebas están organizadas en paquetes coherentes y se documentan utilizando **Javadoc**.

Se busca alcanzar una cobertura de prueba del 100% para garantizar la robustez y fiabilidad del sistema.
