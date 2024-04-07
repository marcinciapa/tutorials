import calculator

print(calculator.divide(4, 4))  # 1
print(calculator.multiply(4, 4))  # 16
print(calculator.add(4, 4))  # 8
print(calculator.subtract(4, 4))  # 0

from calculator import add, subtract, divide, multiply

print(divide(4, 4))  # 1
print(multiply(4, 4))  # 16
print(add(4, 4))  # 8
print(subtract(4, 4))  # 1
