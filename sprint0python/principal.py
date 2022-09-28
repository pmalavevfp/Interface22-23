from fibonacci import funcion_fibonacci

from fibonacci2 import funcion_fibonacci2
import time


print ("Para calcular el valor de la posición la serie de fibonacci")
print ("debes escoger el método a aplicar y el numero de la posición de su elección")
print ("a.- De modo recursivo")
print ("b.- De modo directo")
select=input ("Qué modo se va aplicar? ---> ")

numbFine = int (input ("Qué posición de la serie de fibonacci quieres ver  -->  "))

if select =="a":
    start_time = time.time()
    scr = funcion_fibonacci (numbFine)
    end_time = time.time()
    elapsed_time = end_time - start_time
else:
    start_time = time.time()
    scr = funcion_fibonacci2 (numbFine)
    end_time = time.time()
    elapsed_time = end_time - start_time

print ("El número de fibonacci para la posición "+ str(numbFine) + " es ==> " + str(scr))
print('El tiempo de ejecución ha sido :' + str(elapsed_time) + ' seg')