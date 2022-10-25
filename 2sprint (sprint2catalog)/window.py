import gi

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from cell import Cell
from menu_items import MenuItems


class MainWindow(Gtk.Window):



    def __init__(self, data_source):
        super().__init__(title="Catálogo de Cartoon")
        self.connect("destroy", Gtk.main_quit)
        self.set_border_width(15)
        self.set_default_size(400, 300)
        self.set_position(Gtk.WindowPosition.CENTER)  #En esta linea se centra la posición de la ventana en la pantalla

        header = Gtk.HeaderBar(title="Cartoon muestra No.2")
        header.set_subtitle("Catalogo para el ejercicio 2")
        header.props.show_close_button = True

        self.set_titlebar(header)


        # Implementación de menu

        menu_bar = Gtk.MenuBar()  # se establece el widget de menu-bar

        filemenu = Gtk.Menu()
        filem = Gtk.MenuItem("Ayuda")
        filem.set_submenu(filemenu)

        info = Gtk.MenuItem("Acerca de ...")
        info.connect("activate", self.information_Author)
        filemenu.append(info)

        menu_bar.append(filem)

        #agregamos el menu a la Vbox

        vbox=Gtk.VBox (False,2)
        vbox.pack_start(menu_bar, False, False, 0)
        self.add(vbox)

        #implementamos el flowbox para cargar las imagenes
        flowbox = Gtk.FlowBox()


        #se implementa el scroll lateral de la ventana y se inabilita el
        # inferior que mueve de izquiersa a derecha

        scrolled = Gtk.ScrolledWindow()
        scrolled.set_policy(Gtk.PolicyType.NEVER, Gtk.PolicyType.AUTOMATIC)
        scrolled.add(flowbox)   #aqui se agregan el flow al scroll y el scroll a la vbox y la vbox al constructor
                                # para que se pueda ver
        vbox.add(scrolled)
        self.add(vbox)



        #lectura de la data recuperada del API-Rest para leer una a una la informacion para crear la ventana ppal
        #que se envía a Cell para la conformacion del las imagenes en flowbox
        for item in data_source:
            cell_xx = Cell(item.get("name"), item.get("gtk_image"), item.get("description"))
            flowbox.add(cell_xx)


    def information_Author (self, widget):
        win = MenuItems ()
        win.show_all()




