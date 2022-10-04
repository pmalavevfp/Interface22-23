import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk


class NoWin(Gtk.Window):
    box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL)
    label = Gtk.Label("Has clickado un NO")

    def __init__(self):
        super().__init__(title="Respuesta")
        self.add(self.box)
        self.box.pack_start(self.label, True, True, 0)
