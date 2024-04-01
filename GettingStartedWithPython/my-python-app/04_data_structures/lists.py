print(type([]))  # list

number = 1
number_two = 2
number_three = 3

numbers = [1, 2, 3, 4, -1, -20]
print(numbers[0])  # 1
print(numbers[5])  # -20
# print(number[8])  # list index out of range

numbers = [1, 2, 3, 4, -1, -20, ["A", "B"]]
print(numbers)
print(numbers[6][0])  # A

