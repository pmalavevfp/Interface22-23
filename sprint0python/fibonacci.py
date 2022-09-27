
def funcion_fibonacci (n):
	
	if n>1:
		return funcion_fibonacci (n-1)+ funcion_fibonacci (n-2)
	elif n==1:
		return 1
	elif n==0:
		return 0
	
