print((10 > 5) and (1 > 3))  # False
print((10 > 5) and (1 < 3) and "A" == "A")  # True
print((10 > 5) and (1 < 3) and "A" == "c")  # False
print((10 > 5) or (1 < 3) or "A" == "c")  # True
print((10 < 5) or (1 > 3) or "A" == "c")  # False
print((10 < 5) or (1 > 3) or "A" == "A")  # True

print(("James" == "Maria"))  # False
print(not("James" == "Maria"))  # False
