number = 15
if number > 0:
    print(f"number {number} is positive")  # will be printed

number = -1
if number > 0:
    print(f"number {number} is positive")  # will not be printed
else:
    print(f"{number} is negative")  # will be printed


number = 0
if number > 0:
    print(f"number {number} is positive")  # will not be printed
elif number == 0:
    print(f"number {number} is Zero")  # will be printed
else:
    print(f"number {number} is negative")  # will not be printed