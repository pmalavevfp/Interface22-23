from fibonacci import funcion_fibonacci

numbFine = int (input ("Qué posición de la serie de fibonacci quieres ver  -->  "))

scr = funcion_fibonacci (numbFine)

print ("El número de fibonacci para la posición "+ str(numbFine) + " es ==> " + str(scr))
