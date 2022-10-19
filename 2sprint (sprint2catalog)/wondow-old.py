import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from cell import Cell


class MainWindow(Gtk.Window):
    flowbox = Gtk.FlowBox()

    def __init__(self):
        super().__init__(title="Catálogo de Cartoon")
        self.connect("destroy", Gtk.main_quit)
        self.add(self.flowbox)
        cell_one = Cell("Robin", Gtk.Image.new_from_file("data/edited/robin.png"))
        self.flowbox.add(cell_one)
        cell_two = Cell("Mickey", Gtk.Image.new_from_file("data/edited/Mickey-Mouse.png"))
        self.flowbox.add(cell_two)
        cell_three = Cell("Aventure", Gtk.Image.new_from_file("data/edited/adventuretime-200x200.png"))
        self.flowbox.add(cell_three)
        cell_four = Cell("Tom&Jerry", Gtk.Image.new_from_file("data/edited/tom&Jerry.jpg"))
        self.flowbox.add(cell_four)
        cell_five = Cell("Bob", Gtk.Image.new_from_file("data/edited/Bob.png"))
        self.flowbox.add(cell_five)
