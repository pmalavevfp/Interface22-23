
exit = True

def max (a,b):
    if a>b:
        return a
    else:
        return b



def intro_data (self):
    a=int(input ("Cúal es el valor de 'a'"))
    print ("")
    b=int(input ("Cúal es el valor de 'b'"))
    print ("")
    return a,b



def select1(a=None, b=None):

    print("El número mayor es ", max(a, b))

while exit:

    print ("*********** Menú ***********")
    print ("")
    print("1.- Calcular el valor mayor de dos números dados")
    print("")
    print("2.- Calcular el valor mayor de tres números dados")
    print("")
    print ("teclee 666 para salir")
    print ("")
    z=int(input ("Cúal es tu selección -->"))

    if z==666:
        exit=False
    elif z>0 & z<3:
        if z==1:
            a = int(input("Cúal es el valor de 'a'"))
            print("")
            b = int(input("Cúal es el valor de 'b'"))
            print("")
            print(a)
            print(b)
            select1(a,b)
        elif z==2:

            """max_de_tres ()"""




