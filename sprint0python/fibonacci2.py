
def funcion_fibonacci2(n):
    a = (1 + (5 ** 0.5)) / 2
    b = (1 - (5 ** 0.5)) / 2

    n= ((a**n)-(b**n))/(5**0.5)

    return n