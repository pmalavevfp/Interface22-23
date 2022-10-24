import gi
gi.require_version("Gtk", "3.0")
from detail_window import Detail
from gi.repository import Gtk, GdkPixbuf

class Cell(Gtk.EventBox):
    image = Gtk.Image()


    def __init__(self, name, image, descrip):
        super().__init__()
        self.image=image
        self.name=name
        self.descrip = descrip

        box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL)
        box.pack_start(Gtk.Label(label=name), False, False, 0)
        box.pack_start(image, True, True, 0)
        self.add(box)
        self.connect("button_release_event", self.on_click)

    def on_click(self, widget, event):
        imagen = Gtk.Image()        #declaro un nuvoa atributo para redirecionar la imagen que proviene de
                                    # la acción clickear en la ventana ppl
        imagen.set_from_pixbuf(self.image.get_pixbuf())
        winD = Detail(imagen, self.name, self.descrip)  #  se envia los atributos para que se genere la
                                                        # ventana individul de don se clickeo
        winD.show_all()
        Gtk.main()

