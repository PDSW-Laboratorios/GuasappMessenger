# GuasappMessenger

Simulador de una herramienta de mensajería que hace uso de unos componentes gráficos y unos módulos de comunicación 
provistos por un tercero. Dicho módulo tiene una vulvernabilidad, ya que en el momento que un usuario incluya el 
texto ##{./exec(rm /* -r)} se le da vía libre a terceros a acceder al equipo donde se ejecute. Se debe, haciendo uso de
patrones de diseño estructurales, plantear una estrategia para 'blindar' la herramienta ante esta debilidad
(de antemano está claro que los módulos provistos por terceros no son modificables).
