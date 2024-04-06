number = 0
while number < 10:
    if number == 5:
        break
    number += 1
    print(number)  # 1 2 3 4 5

number = 0
while number < 10:
    number += 1
    if number < 5:
        continue
    print(number)  # 5 6 7 8 9 10

for n in [1, 2, 3, 4, 5]:
    if n < 5:
        continue
    print(n)  # 5

for n in [1, 2, 3, 4, 5]:
    if n is 5:
        break
    print(n)  # 1 2 3 4
