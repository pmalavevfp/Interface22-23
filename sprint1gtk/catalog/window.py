import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from cell import Cell
from gi.repository import GdkPixbuf



class MainWindow(Gtk.Window):
    flowbox = Gtk.FlowBox()

    def __init__(self):
        super().__init__(title="Catálogo de Cartoon")
        self.connect("destroy", Gtk.main_quit)
        self.set_border_width(15)
        self.set_default_size(400, 400)

        header = Gtk.HeaderBar(title="Cartoon muestra")
        header.set_subtitle("Catalogo para el ejercicio")
        header.props.show_close_button = True

        self.set_titlebar(header)

        scrolled = Gtk.ScrolledWindow()
        scrolled.set_policy(Gtk.PolicyType.NEVER, Gtk.PolicyType.AUTOMATIC)
        scrolled.add(self.flowbox)
        self.add(scrolled)

        #cell_one = Cell("Goku", Gtk.Image.new_from_file("data/unedited/Goku.jfif"))
        goku = Gtk.Image()
        pixbuf = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/Goku.jfif", 200, 200, False)
        goku.set_from_pixbuf(pixbuf)
        cell_one=Cell("GoKuu", goku)
        self.flowbox.add(cell_one)


        #cell_two = Cell("Loquillo", Gtk.Image.new_from_file("data/unedited/images.jfif"))
        loqui = Gtk.Image()
        pixbuf = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/images.jfif", 200, 200, False)
        loqui.set_from_pixbuf(pixbuf)
        cell_two=Cell("Loquillo", loqui)
        self.flowbox.add(cell_two)


        #cell_three = Cell("Batman", Gtk.Image.new_from_file("data/unedited/images (1).jfif"))
        bat = Gtk.Image()
        pixbuf = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/images (1).jfif", 200, 200, False)
        bat.set_from_pixbuf(pixbuf)
        cell_three = Cell("Batman", bat)
        self.flowbox.add(cell_three)


        #cell_four = Cell("Goku", Gtk.Image.new_from_file("data/unedited/cojin-3d-goku-dragon-ball.jpg"))
        gok = Gtk.Image()
        pixbuf = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/cojin-3d-goku-dragon-ball.jpg", 200, 200, False)
        gok.set_from_pixbuf(pixbuf)
        cell_four = Cell("GoKu", gok)
        self.flowbox.add(cell_four)


        #cell_five = Cell("Natuto", Gtk.Image.new_from_file("data/unedited/naruto.jpg"))
        naru = Gtk.Image()
        pixbuf = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/naruto.jpg", 200, 200, False)
        naru.set_from_pixbuf(pixbuf)
        cell_five = Cell("Naruto", naru)
        self.flowbox.add(cell_five)
