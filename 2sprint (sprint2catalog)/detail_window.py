import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk


class Detail (Gtk.Window):

    #Constructor para la creacion de la ventada nueva individual con los datos de nombre, descripion e imagen
    # enviado desde el archivo cell una vez se ha clickeado en la figira mostrada en la ventana ppal"""
    def __init__(self, image, name, descrip):
        super().__init__(title=name)
        box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL)
        self.add(box)
        box.pack_start(image, True, True, 0)
        box.pack_start(Gtk.Label(descrip), True, True, 0)
        self.set_position(Gtk.WindowPosition.CENTER)  #En esta linea se centra la posición de la ventana en la pantalla
        self.connect("destroy", Gtk.main_quit) #se activa esta propiedad para poder eliminar la ventana cuando se desee









