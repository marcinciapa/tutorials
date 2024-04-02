numbers = [1, 2, 3, 4, -1, -20]

numbers.sort()
print(numbers)  # -20, -1, 1, 2, 3, 4

numbers.reverse()
print(numbers)  # 4, 3, 2, 1, -1, -20

numbers.append(1000)
print(numbers)  # 4, 3, 2, 1, -1, -20, 1000

print(len(numbers))  # 7

numbers.clear()
print(numbers)  # []

numbers = [1, 2, 3, 4, -1, -20]
print(5 in numbers)  # False
print(5 not in numbers)  # True
print(-20 in numbers)  # True
