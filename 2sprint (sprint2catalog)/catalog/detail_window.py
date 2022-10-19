import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk


class Detail (Gtk.Window):

    def __init__(self, image, name, descrip):
        super().__init__(title=name)
        print (name)
        print (descrip)
        print (image)

        box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL)
        self.add(box)
        box.pack_start(image, True, True, 0)
        box.pack_start(Gtk.Label(descrip), True, True, 0)

        self.connect("destroy", Gtk.main_quit)









