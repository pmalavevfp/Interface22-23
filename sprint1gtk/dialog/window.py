import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from yes_window import YesWin
from no_window import NoWin

class MainWindow(Gtk.Window):
    box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL)
    box2 = Gtk.Box(orientation=Gtk.Orientation.HORIZONTAL)
    box3 = Gtk.Box (orientation=Gtk.Orientation.VERTICAL)
    label = Gtk.Label("Entiendes lo que estas haciendo?????")
    button1 = Gtk.Button(label="SI")
    button2 = Gtk.Button(label="NO")

    def __init__ (self):
        super ().__init__(title="Main")
        self.connect ("destroy",  Gtk.main_quit)
        #self.button1.connect("clicked", self.on_button_clicked)
        self.add(self.box)
        self.box.pack_start(self.label, True, True, 0)
        self.box.pack_start(self.box2, True, True, 0)
        self.box2.pack_start(self.button1, True, True, 0)
        self.button1.connect("clicked", self.on_button1_clicked)
        self.box2.pack_start(self.button2, True, True, 0)
        self.button2.connect("clicked", self.on_button2_clicked)

    def on_button1_clicked (self, widget):
        win = YesWin()
        win.show_all()
        #labelY = Gtk.Label("Presionaste si")
        #self.box2.pack_start(self.box3, True, True, 0)
        #self.box3.pack_start(self.labelY, True, True, 0)
        #print ("SI")
    def on_button2_clicked (self, widget):
        win=NoWin ()
        win.show_all()
        self.box2.pack_start(self.box3, True, True, 0)
        print("NO")


