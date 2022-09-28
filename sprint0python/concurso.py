from random import randrange

print ("Concurso de Preguntas")
print ()
scr=0


qst1 = randrange(1, 4)
qst2 =qst1

while (qst2==qst1):
	qst2=randrange (1,4)

if (qst1==1) | (qst2==1):

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
		print("Tu respuesta ha sido Incorrecta")
		scr += -5
	else:
		print("Tu respuesta ha sido Correcta")
		scr += 10

if (qst1==2) | (qst2==2):
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
		print("Tu respuesta ha sido Incorrecta")
		scr += -5
	else:
		print("Tu respuesta ha sido Correcta")
		scr += 10

if (qst1==3) | (qst2==3):
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
		print ("Tu respuesta ha sido Incorrecta")
		scr+=-5
	else :
		print("Tu respuesta ha sido Correcta")
		scr+=10

print ()
print ("Tu puntuación en el cuestionario es de " + str(scr)+" ptos-")
