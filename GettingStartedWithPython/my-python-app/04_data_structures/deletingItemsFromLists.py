numbers = [1, 2, 3, 4, -1, -20]
print(numbers)  # [1, 2, 3, 4, -1, -20]

numbers.remove(1)  # remove by value
print(numbers)  # [2, 3, 4, -1, -20]

numbers = [1, 1, 2, 3, 4, -1, -20]
numbers.remove(1)  # remove first instance
print(numbers)  # [1, 2, 3, 4, -1, -20]

numbers.pop()
print(numbers)  # [1, 2, 3, 4, -1]
numbers.pop()
print(numbers)  # [1, 2, 3, 4]

del numbers[0]
print(numbers)  # [2, 3, 4]

del numbers[1]
print(numbers)  # [2, 4]

numbers = [1, 2, 3, 4, -1, -20]
del numbers[0:3]  # del range, exclusive
print(numbers)  # [4, -1, -20]

