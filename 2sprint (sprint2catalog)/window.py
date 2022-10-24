import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from cell import Cell



class MainWindow(Gtk.Window):
    flowbox = Gtk.FlowBox()

    def __init__(self, data_source):
        super().__init__(title="Catálogo de Cartoon")
        self.connect("destroy", Gtk.main_quit)
        self.set_border_width(15)
        self.set_default_size(400, 400)

        header = Gtk.HeaderBar(title="Cartoon muestra No.2")
        header.set_subtitle("Catalogo para el ejercicio 2")
        header.props.show_close_button = True

        self.set_titlebar(header)

        scrolled = Gtk.ScrolledWindow()
        scrolled.set_policy(Gtk.PolicyType.NEVER, Gtk.PolicyType.AUTOMATIC)
        scrolled.add(self.flowbox)
        self.add(scrolled)

        for item in data_source:
            cell_xx = Cell(item.get("name"), item.get("gtk_image"), item.get("description"))
            self.flowbox.add(cell_xx)


