# Generando la class de LoanWindow para generar la ventana del proyecto

import gi
import requests, threading, shutil
gi.require_version("Gtk","3.0")
from gi.repository import Gtk, GLib
from window import MainWindow

class LoadWindow (Gtk.Window):
    label = Gtk.Label("Cargando elementos ...")
    spinner=Gtk.Spinner()
    box=Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=10)


    #Se crea un constructor para general la vetava con el titulo
    # con la activacion del cierre de ventana y programa que la llama
    # por el destroy, y se genera el spinner para mostrar que se esta cargando
    # las imagenes"""
    def __init__ (self):
        super().__init__(title="Cargando")
        self.connect("destroy", Gtk.main_quit)
        self.set_border_width(60)
        self.set_resizable(False)
        self.spinner.props.active =True
        self.set_position(Gtk.WindowPosition.CENTER)
        self.box.pack_start(self.label, False, False, 0)
        self.box.pack_start(self.spinner, False, False, 0)
        self.add(self.box)

        self.launch_load ()

    def start_main_window(self, loaded_items_list):
        win = MainWindow(loaded_items_list)
        win.show_all()

        self.disconnect_by_func(Gtk.main_quit)
        self.close()

    #Para la petición HTTP desde un hilo secundario. Para esto Usamos la librería
    # “threading” para ello

    def launch_load (self):
        thread=threading.Thread(target=self.load_json, args=())
        thread.start()

    #para obtener el archivo JSON de la URL del API-Rest. basta para enviar la petición GET,
    # que se encapsula a través de esta función """
    def load_json (self):
        response=requests.get ("https://raw.githubusercontent.com/pmalavevfp/Interface22-23/main/API-REST/catalog.json")
        json_list=response.json()

        #Se crea esta rutina para crear una nueva lista con los datos de URL de la imagen
        # la descripción y el nombre de la figura obtenidos del API_Rest

        #se crea una lista
        result =[]

        for json_item in json_list:
            name=json_item.get ("name")
            description=json_item.get ("description")
            image_url= json_item.get("image_url")
            r=requests.get(image_url,stream=True)
            with open ("temp.png", "wb") as f:
                shutil.copyfileobj(r.raw,f)
            image=Gtk.Image.new_from_file ("temp.png")
            result.append({"name":name, "description":description, "gtk_image":image})

            #pasando la lista de resultado al hilo ppal


        GLib.idle_add(self.start_main_window, result)

