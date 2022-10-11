import gi
gi.require_version("Gtk", "3.0")
from detail_window import Detail
from gi.repository import Gtk, GdkPixbuf

class Cell(Gtk.EventBox):
    name = None
    image = Gtk.Image()
    descrip=None

    def __init__(self, name, image):
        super().__init__()
        self.name = name
        box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL)
        box.pack_start(Gtk.Label(label=name), False, False, 0)
        box.pack_start(image, True, True, 0)
        self.add(box)
        self.connect("button_release_event", self.on_click)

    def on_click(self, widget, event):
        print(self.name)
        print (self.image)
        print ("---------------")
        img = self.GetImage(self.name)
        print ("estoy aqui")

        self.GetDescrip(self.name)
        winD = Detail(img, self.name, self.descrip)
        winD.show_all()
        Gtk.main()

    def GetImage (self, name):
        imagen=Gtk.Image()
        pixbuf1 = None
        if self.name == "goku":
            imagen.set_from_pixbuf(self.image.get_pixbuf())
            print(imagen)
            #pixbuf1 = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/Goku.jfif", 200, 200, False)
            #imagen.set_from_pixbuf(pixbuf1)
        elif self.name == "loqui":
            pixbuf1 = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/images.jfif", 200, 200, False)
            #imagen.set_from_pixbuf(pixbuf1)
        elif self.name=="bat":
            pixbuf1 = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/images (1).jfif", 200, 200, False)
            #imagen.set_from_pixbuf(pixbuf1)
        elif self.name =="gok":
            pixbuf1 = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/cojin-3d-goku-dragon-ball.jpg", 200, 200,
                                                            False)
            #imagen.set_from_pixbuf(pixbuf1)
        elif self.name =="naru":
            pixbuf1 = GdkPixbuf.Pixbuf.new_from_file_at_scale("data/unedited/naruto.jpg", 200, 200, False)
            #imagen.set_from_pixbuf(pixbuf1)
        #imagen.set_from_pixbuf(pixbuf1)
        return imagen

    def GetDescrip(self, name):
        self.descrip = Gtk.Label()

        if self.name == "goku":
            self.descrip = Gtk.Label("111111111")
        elif self.name == "loqui":
            self.descrip ="222222222"
        elif self.name == "bat":
            self.descrip="333333333"
        elif self.name == "gok":
            self.descrip="4444444444"
        elif self.name == "naru":
            self.descrip="55555555"
        print("gD", self.descrip)
        return self.descrip




