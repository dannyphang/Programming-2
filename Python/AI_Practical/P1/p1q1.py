r = int(input("Enter the radius: "))
h = int(input("Enter the height: "))

def volume(r, h):
    PI = 3.1412
    v = PI * r * r * h
    print("Volume is ", v)
    
volume(r, h)