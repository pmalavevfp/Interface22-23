# Creando un nuevo main para este sprint para tratarlo como un proyecto.
# procedo a importar el packege con el vamos a trabajar en este proyecto
import gi
gi.require_version ("Gtk", "3.0")
from gi.repository import Gtk
from load_window import LoadWindow

win=LoadWindow()
win.show_all()
# para mantener en Gtk corriendo miestra se ejecuta la app.
if __name__ == '__main__':
    Gtk.main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
