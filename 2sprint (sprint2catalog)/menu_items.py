import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk

class MenuItems (Gtk.Window):

    def __init__ (self):
        super().__init__(title="Acerca del Desarrollador")

        descrip = "Es un estudiante de DAM2 en el CPR Afundacion en A Coruña, sin estar \n" \
                  "estar 100% seguro de lo que esta haciendo"

        self.set_border_width(15)
        self.set_default_size(100, 100)
        box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL)
        self.add(box)
        box.pack_start(Gtk.Label(descrip), True, True, 0)
        self.set_position(Gtk.WindowPosition.CENTER)  # En esta linea se centra la posición de la ventana en la pantalla
        #self.connect("destroy", Gtk.main_quit)