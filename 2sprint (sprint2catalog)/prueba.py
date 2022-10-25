import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from menu_items import MenuItems


class PyApp(Gtk.Window):

    def __init__(self):
        super(PyApp, self).__init__()

        self.set_title("Simple menu")

        #self.modify_bg(Gtk.STATE_NORMAL, Gtk.gdk.Color(6400, 6400, 6440))
        self.set_border_width(15)
        self.set_default_size(400, 300)
        self.set_position(Gtk.WindowPosition.CENTER)

        mb = Gtk.MenuBar()

        filemenu = Gtk.Menu()
        filem = Gtk.MenuItem("Help")
        filem.set_submenu(filemenu)

        info = Gtk.MenuItem("Author")
        info.connect("activate", self.information_Author)
        filemenu.append(info)

        mb.append(filem)

        vbox = Gtk.VBox(False, 2)
        vbox.pack_start(mb, False, False, 0)

        self.add(vbox)

        self.connect("destroy", Gtk.main_quit)
        self.show_all()

    def information_Author (self, widget):
        win = MenuItems ()
        win.show_all()


PyApp()
Gtk.main()