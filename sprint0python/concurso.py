print ("Concurso de Preguntas")
print ()
print ("Pregunta No. 1")
print ("")
print ("¿Cúal es el segundo país con más campos de golf?")
print ("Las opciones son :")
print ()
print ("a.- Estados Unidos")
print ("b.- Japon")
print ("c.- Inglatera")
print ()
ans=input ("Introduce tu respuesta = ??")

if ans != "b":
	scr=-5
else :
	scr=10

print ("Pregunta No. 2")
print ("")
print ("¿Las células humanas son del tipo?")
print ("Las opciones son :")
print ()
print ("a.- Eucariota")
print ("b.- Procariota")
print ("c.- Ninguna de las Anteriores")
print ()
ans=input ("Introduce tu respuesta = ??")

if ans != "a":
	scr+=+5
else :
	scr+=10
	
print ("Pregunta No. 3")
print ("")
print ("¿La Provincia de A Coruña se encuentra en ?")
print ("Las opciones son :")
print ()
print ("a.- Madrid")
print ("b.- Andalucia")
print ("c.- Galicia")
print ()
ans=input ("Introduce tu respuesta = ??")

if ans != "c":
	scr+=-5
else :
	scr+=10

print ()
print ("Tu puntuación en el cuestionario es " + str(scr))
