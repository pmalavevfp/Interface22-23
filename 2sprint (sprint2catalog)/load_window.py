# Generando la class de LoanWindow para generar la ventana del proyecto

import gi

gi.require_version("Gtk","3.0")
from gi.repository import Gtk, GLib


class LoadWindow (Gtk.Window):
    label = Gtk.Label("Cargando elementos ...")
    spinner=Gtk.Spinner()
    box=Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=20)


    """Se crea un constructor para general la vetava con el titulo
    con la activacion del cierre de ventana y programa que la llama 
    por el destroy, y se genera el spinner para mostrar que se esta cargando 
    las imagenes"""
    def __init__ (self):
        super().__init__(title="Cargando")
        self.connect("destroy", Gtk.main_quit)
        self.set_border_width(60)
        self.set_resizable(False)
        self.spinner.props.active =True

        self.box.pack_start(self.label, False, False, 0)
        self.box.pack_start(self.spinner, False, False, 0)
        self.add(self.box)
